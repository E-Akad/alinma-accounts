package com.alinma.rib.accounts.controller;

import com.alinma.rib.accounts.model.response.AccountStatementSettingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.AccountStatementSettingRequest;
import com.alinma.rib.accounts.service.ManageAccountEStatementService;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;

@RestController
@RequestMapping("/v1/accounts")
@CrossOrigin
public class ManageAccountEStatementController {

	@Autowired
	ManageAccountEStatementService manageAccountEStatementService;

	/*
	 * i should reuse the created one
	 */
//	@GetMapping("") 
//	public void getAccountWithoutBalance(Request request) {}

	@PostMapping("/{account-number}/statement/stop-mail")
	public AccountStatementSettingResponse updateAccountStatementSetting(@PathVariable(name = "account-number") Long accountNumber) throws CustomServiceUnavailableException{
		return manageAccountEStatementService.updateAccountStatementSetting(accountNumber);
	}

}
