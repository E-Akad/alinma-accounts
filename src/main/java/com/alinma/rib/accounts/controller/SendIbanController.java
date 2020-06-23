package com.alinma.rib.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.response.SendIbanResponse;
import com.alinma.rib.accounts.service.ISendIbanService;

/**
 * 
 * This controller is called for sending IBAN via SMS or Mobile Wallet.
 * 
 * @author habdelhalim
 *
 */
@RestController
public class SendIbanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendIbanController.class);
	
	@Autowired
	ISendIbanService sendIbanService;
	
	/**
	 * 
	 * This method sends IBAN via SMS or Mobile Wallet for a specific account based on sharingMethod.
	 * 
	 * @param accountIndex
	 * @param sharingMethod
	 * @return
	 */
	@RequestMapping(value = "/v1/send-iban/{account-index}", method = RequestMethod.POST)
	public SendIbanResponse sendIban(@PathVariable(value = "account-index", required = true) String accountIndex,
			@RequestParam(name = "sharing-method", required = true) String sharingMethod) {
		
		LOGGER.info("SendIbanController::sendIban - accountIndex: " + accountIndex + " sharingMethod: " + sharingMethod);
		
		return sendIbanService.sendIban(accountIndex, sharingMethod);
	}

}
