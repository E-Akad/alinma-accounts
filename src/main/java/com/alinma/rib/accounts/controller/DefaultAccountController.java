package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.DefaultAccountRequest;
import com.alinma.rib.accounts.model.response.DefaultAccountResponse;
import com.alinma.rib.accounts.service.DefaultAccountsService;

@RestController
public class DefaultAccountController {

	@Autowired
	DefaultAccountsService defaultAccountsService;
	
	@PutMapping("/v1/accounts/{account-index}/set-default")
	public DefaultAccountResponse setDefaultAccount(@RequestBody DefaultAccountRequest defaultAccountRequest,
																	@PathVariable(name = "account-index", required = true) String accountIndex) throws Exception {
		
		return defaultAccountsService.setDefaultAccount(defaultAccountRequest, accountIndex);
	}
}
