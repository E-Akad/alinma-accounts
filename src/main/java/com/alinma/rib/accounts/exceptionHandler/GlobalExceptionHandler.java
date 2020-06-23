/**
 * 
 */
package com.alinma.rib.accounts.exceptionHandler;

import java.util.Locale;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.EmptyContentException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.response.FEBaseResponse;
import com.alinma.rib.service.user.UserService;

/**
 * @author Omnya Alaa
 * @since 2-1-2020
 * @apiNote This will catch any thrown exception by any controller through
 *          Transfer-management microservice
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	@Qualifier("errorMsg")
	MessageSource errorMessageSource;

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("customErrorMsg")
	MessageSource customErrorMessageSource;
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ESBException.class)
	public ResponseEntity<FEBaseResponse> handleESBException(ESBException exception) {

		FEBaseResponse response = new FEBaseResponse();

		if (exception.getStatusCode() != null && !exception.getStatusCode().trim().equals("") && !exception.getStatusCode().isEmpty()) {
			response.setStatusCode(exception.getStatusCode());
			try {
				response.setStatusDesc(errorMessageSource.getMessage(exception.getStatusCode(), null, new Locale(userService.getCurLang())));
			} catch (Exception ex) {
				response.setStatusDesc("");
			}
		} else {

			// Will send common error code and common message in case of no error
			// code has been sent
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
			response.setStatusDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		return new ResponseEntity<FEBaseResponse>(response, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(InputException.class)
	public ResponseEntity<FEBaseResponse> handleInputException(InputException exception) {
		FEBaseResponse response = new FEBaseResponse();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value() + "");
		
			if(exception.getExceptionMessage() != null && !exception.getExceptionMessage().isEmpty()) {
			response.setStatusDesc(exception.getExceptionMessage());
			}
			else {
				response.setStatusDesc(customErrorMessageSource.getMessage("BAD_REQUEST", null, new Locale(userService.getCurLang())));
			}

		return new ResponseEntity<FEBaseResponse>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * this in case of javax.validation
	 */
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<FEBaseResponse> handleValidationException(ValidationException exception) {

		FEBaseResponse response = new FEBaseResponse();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value() + "");
		String exceptionMessage = exception.getLocalizedMessage() != null ? exception.getLocalizedMessage() : exception.getMessage();
		response.setStatusDesc(exceptionMessage);
		return new ResponseEntity<FEBaseResponse>(response, HttpStatus.BAD_REQUEST);
	}
	/** Handle ESB empty body response 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(EmptyContentException.class)
	public ResponseEntity<FEBaseResponse> handleEmptyContentException(EmptyContentException exception) {

		FEBaseResponse response = new FEBaseResponse();
		response.setStatusCode(exception.getStatusCode());
		if (exception.getStatusCode() != null && !exception.getStatusCode().trim().equals("") && !exception.getStatusCode().isEmpty() && userService.getCurLang() != null) {
			response.setStatusCode(exception.getStatusCode());
			try {
				response.setStatusDesc(errorMessageSource.getMessage(exception.getStatusCode(), null, new Locale(userService.getCurLang())));
			} catch (Exception ex) {
				response.setStatusDesc("");
				
			}
		} else {
			// Will send common error code and common message in case of no error
			// code has been sent
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
			response.setStatusDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		return new ResponseEntity<FEBaseResponse>(response, HttpStatus.NO_CONTENT);
	}
}
