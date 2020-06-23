package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.CheckAccountNumRequest;
import com.alinma.rib.accounts.model.response.CheckAccountNumResponse;
import com.alinma.rib.accounts.service.CheckAccountNumberService;

@CrossOrigin
@RestController
@RequestMapping(path = { "/retail/account-management/v1/accounts", "/account-management/v1/accounts" })
public class CheckAccountNumberController {
	@Autowired
	CheckAccountNumberService checkAccountNumberService;

	@PostMapping("/is-alinma")
	public CheckAccountNumResponse getAccountWithoutBalance(@RequestBody CheckAccountNumRequest checkAccountNumRequest) throws Exception {
		return checkAccountNumberService.checkAccountNumber(checkAccountNumRequest);
	}
}
