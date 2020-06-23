package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.ActivateAccountRequest;
import com.alinma.rib.accounts.model.response.ActivateAccountResponse;
import com.alinma.rib.accounts.model.response.CheckIdNumberResponse;
import com.alinma.rib.accounts.service.ActivateDormantAccountService;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;

@RestController
public class ActivateDormantAccountController {

	@Autowired
	ActivateDormantAccountService service;

	@RequestMapping(value = "/v1/accounts/{account-number}/activation", method = RequestMethod.GET)
	public ActivateAccountResponse activateDormantAccount(@PathVariable(name = "account-number") Long accountNumber,
			@RequestParam(name = "sec-info") String secInfo, @RequestParam(name = "sec-info-type") String secInfoType)
			throws CustomServiceUnavailableException {
		return service.activateAccount(accountNumber, secInfo, secInfoType);
	}

	@RequestMapping(value = "/v1/accounts/check-id/{id}", method = RequestMethod.GET)
	public CheckIdNumberResponse checkIdNumber(@PathVariable(name = "id") String id)
			throws Model500InternalServererror {
		return service.checkIdNumber(id);
	}
}
