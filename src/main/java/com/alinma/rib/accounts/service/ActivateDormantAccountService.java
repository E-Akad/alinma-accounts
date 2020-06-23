package com.alinma.rib.accounts.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.response.ActivateAccountResponse;
import com.alinma.rib.accounts.model.response.ActivateAccountResponseActivateAccountResponse;
import com.alinma.rib.accounts.model.response.CheckIdNumberResponse;
import com.alinma.rib.authentication.business.enums.StatusDesc;
import com.alinma.rib.authentication.service.AbstractAuthenticationService;
import com.alinma.rib.authentication.util.Security;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.Sec;
import com.alinma.rib.models.system.common.enums.AccountTypeEnum;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.InfoTypeEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.AcctMng27002000.AcctMngRq;
import com.alinma.rib.models.system.request.AcctMng27002000.AcctMngRqBody;
import com.alinma.rib.models.system.response.AcctMng27002000.AcctMngRs;
import com.alinma.rib.models.system.response.AcctMng27002000.AcctMngRsBody;
import com.alinma.rib.models.system.response.PartyDtlsInq24020000.PartyDtlsInqRs;
import com.alinma.rib.models.system.common.PartyIdent;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

/**
 * This use case contains the following methods - CustAcctsInq :: 26021000
 * getAccountsWithBalance - UsrDtlsInq :: 54010000 getUserDetails -
 * FuncAuthentMethodInq :: 10000000 getFunctionAuthenticationMethod -
 * UsrCredensMng :: 11000200 generateOneTimeToken - UsrAuthent :: 10020000
 * transactionAuthenticate - AcctMng :: 27007000 activateAccount
 */

@Service
public class ActivateDormantAccountService extends AbstractAuthenticationService {

	@Autowired
	UserService userService;

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	private static Logger logger = LoggerFactory.getLogger(ActivateDormantAccountService.class);

	// Checking user ID availability
	public CheckIdNumberResponse checkIdNumber(String id) throws Model500InternalServererror {
		CheckIdNumberResponse response = new CheckIdNumberResponse();
		/**
		 * Mapping model request to ESB
		 */
		logger.info("checkIdNumber:" + getNationalId(id));
		if (id.equals(getNationalId(id))) {
			response.setStatusCode(ESBStatusCode.SUCCESS.getValue());
			response.setStatusDesc(StatusDesc.SUCCESS.getDesc());
		} else {
			response.setStatusCode(ESBStatusCode.USER_DOES_NOT_HAVE_NATIONAL_OR_IQAMA_ID.getValue());
			response.setStatusDesc(StatusDesc.USER_DOES_NOT_HAVE_NATIONAL_OR_IQAMA_ID.getDesc());
			logger.info("checkIdNumber:activateAccounts.validationMessage.idNo.NotCorrect");
		}
		return response;
	}

	// AcctMng :: 27007000 activateAccount
	// Activating user account
	public ActivateAccountResponse activateAccount(Long accountNumber, String otp, String authMethodUsed) {

		logger.info("ActivateDormantAccountService::activateAccount OTP:" + otp + " ,authMethodUsed:" + authMethodUsed);
		ActivateAccountResponse response = new ActivateAccountResponse();

		/**
		 * Mapping model request to ESB
		 */
		AcctMngRq esbAcctMngRq = new AcctMngRq();

		/*
		 * adding extra fields to MSG header
		 */
		MsgRqHdr msgRqHdr = middlewareCommunicator.createRequestHeader(FuncIdEnum.activateAccount.getValue());

		// Sending secInf & secType with header according to the new YAML update
		// provided by Nour and Hamed on 3 Nov, 2019
		Sec msgSec = new Sec();
		msgSec.setInfoType(authMethodUsed); // second auth method type which was
														// used in success second level auth

		if (authMethodUsed.equals(InfoTypeEnum.TOKEN.getValue())) {
			msgSec.setInfo(otp); // (token or Sms otp was used )
		} else if (authMethodUsed.equals(InfoTypeEnum.MOBILE_TOKEN.getValue())) {
			try {
				// Encrypting otp before sending it to ESB
				msgSec.setInfo(Security.byteToHex(Security.getHash(otp)));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				logger.error("ActivateDormantAccountService::activateAccount ", e);
			}
		} else if (authMethodUsed.equals(InfoTypeEnum.TOUCH_ID_HASH_KEY.getValue())) {
			// This condition needs to be revisited when touch ID is implemented
			logger.info("ActivateDormantAccountService::activateAccount Touch ID is triggered with OTP value:" + otp + " and authMethodUsed:" + authMethodUsed);
		} else {
			logger.error("ActivateDormantAccountService::activateAccount No such secInfoType for " + authMethodUsed);
		}

		msgRqHdr.setSec(msgSec);
		/*
		 * under confirmation about witch token to use new one or last one used
		 * with login operation
		 */
		// msgSec.setInfo("");
		// msgSec.setInfoType(InfoTypeEnum.MOBILE_TOKEN.getValue());

		esbAcctMngRq.setMsgRqHdr(msgRqHdr);

		AcctMngRqBody acctMngRqBody = new AcctMngRqBody();
		acctMngRqBody.setCurrAcctNum(String.valueOf(accountNumber));

		if (accountNumber != null && authMethodUsed != null && otp != null) {
			acctMngRqBody.setActivationType(AccountTypeEnum.DORMANT.getCode());
		} else {
			logger.error("ActivateDormantAccountService::activateAccount something is null => accountNumber:" + accountNumber + ",secInfo:" + otp + " ,secInfoType:" + authMethodUsed);
		}
		esbAcctMngRq.setBody(acctMngRqBody);

		/**
		 * Calling JMS service here
		 */
		AcctMngRs esbAcctMngRs = null;
		try {
			esbAcctMngRs = (AcctMngRs) middlewareCommunicator.sendRequestAndRecieveResponse(esbAcctMngRq, MQSendDestination.ActivateAccountRq.getValue(), MQReceiveDestination.ActivateAccountRs.getValue(), AcctMngRs.class);

			/**
			 * Filling model response
			 */
			if (esbAcctMngRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				AcctMngRsBody responseBody = esbAcctMngRs.getBody();
				ActivateAccountResponseActivateAccountResponse activateAccountResponse = new ActivateAccountResponseActivateAccountResponse();
				if (responseBody != null) {
					logger.info("responseBody : " + responseBody);
					if (responseBody.getAcctId() != null && responseBody.getIBAN() != null) {
						activateAccountResponse.setStatusDesc(ResponseStatusCode.SUCCESS);
						activateAccountResponse.setStatusCode(esbAcctMngRs.getMsgRsHdr().getStatusCode());
						response.setActivateAccountResponse(activateAccountResponse);
					} else {
						logger.info("Body exists but it's props are null");
						activateAccountResponse.setStatusDesc(ResponseStatusCode.SUCCESS);
						activateAccountResponse.setStatusCode(esbAcctMngRs.getMsgRsHdr().getStatusCode());
					}
				} else {
					logger.info("Body is null");// Body is null, set log here
					activateAccountResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
					activateAccountResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				}
			}
		} catch (Exception e) {
			throw new CustomServiceUnavailableException("activateAccount has an Exception", e);
		}

		return response;
	}

	// Getting user national ID or Iqama ID
	// These fields should be called from user cached session comming from login
	// THIS WILL HAPPEN AT SPRINT 2
	private String getNationalId(String id) throws Model500InternalServererror {

		String nationalIdNum = "";

		// These two variables used to check if the item has these two values
		// we should get it's IdentDoc variable and set it to nationalIdNum
		int rank = 0;
		String recStatusCode = "A";

		// Getting customer details from AbstractAuthenticationService class
		PartyDtlsInqRs dtlsInqRs = getCustomerDetails(userService.getUserCifNumber(), userService.getUserInmaId(), userService.getUserId());

		List<PartyIdent> PartyIdentList = dtlsInqRs.getBody().getParty().getPartyIdents().getPartyIdent();

		// Checking if the item has rank value == 0 && recStatusCode == A then
		// get it's it's IdentDoc variable and set it to nationalIdNum
		for (int i = 0; i < PartyIdentList.size(); i++) {
			// Check RecStatusCode is not null value from ESB as it's optional
			// field on the
			// interface file
			if (PartyIdentList.get(i).getRecStatusCode() != null && !PartyIdentList.get(i).getRecStatusCode().isEmpty() && PartyIdentList.get(i).getRecStatusCode().equals("A") && PartyIdentList.get(i).getRank() == 0 && PartyIdentList.get(i).getIdentDoc() != null
					&& !PartyIdentList.get(i).getIdentDoc().isEmpty() && PartyIdentList.get(i).getIdentDoc().equals(id)) {
				// if (rank == PartyIdentList.get(i).getRank()
				// &&
				// recStatusCode.equals(PartyIdentList.get(i).getRecStatusCode())) {
				// Check id number is not null value from ESB as it's optional field
				// on the
				// interface file
				// if (PartyIdentList.get(i).getIdentDoc() != null) {
				// Fill nationalIDNum from the response which came from ESB
				nationalIdNum = PartyIdentList.get(i).getIdentDoc();
				break;
				// } else {
				// // Leave an empty value as this value is returned null from ESB
				// nationalIdNum = "";
				// }
				// } else {
				// // Leave an empty value as this value is returned null from ESB
				// nationalIdNum = "";
				// }
			}

		}

		return nationalIdNum;
	}

}
