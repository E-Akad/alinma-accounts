package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.response.AccountNicknameResponse;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponse;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceResponse;
import com.alinma.rib.accounts.model.response.CustomerDepositResponse;
import com.alinma.rib.accounts.model.response.HasDormantAccountResponse;
import com.alinma.rib.accounts.service.ViewAccountsListService;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;

@CrossOrigin
@RestController
public class ViewAccountsListsController {

	@Autowired
	ViewAccountsListService viewAccountsListService;

	@GetMapping("/v1/accounts/cards")
	public AccountsWithBalanceAndCardsResponse getAccountsWithBalanceAndCards() throws CustomServiceUnavailableException {
		return viewAccountsListService.getAccountsWithBalanceAndCards();
	}

	@GetMapping("/v1/accounts/customer-deposit")
	public CustomerDepositResponse customerDeposistsInquiry() throws CustomServiceUnavailableException, Model500InternalServererror {
		return viewAccountsListService.customerDeposistsInquiry();
	}

	// public CardsChargesAndFeesResponse
	// listCardsChargesAndFees(CardsChargesAndFeesRequest
	// model_CardsChargesAndFeesRequest) {
	// return
	// viewAccountsListService.listCardsChargesAndFees(model_CardsChargesAndFeesRequest);
	// }

	@PutMapping("/v1/accounts/{account-number}/{account-nickname}")
	public AccountNicknameResponse updateAccountNickname(@PathVariable(name = "account-number") String account_number, @PathVariable(name = "account-nickname") String account_nickname) throws Exception {
		return viewAccountsListService.updateAccountNickname(account_number, account_nickname);
	}

	@GetMapping("/v1/accounts/balance")
	public AccountsWithBalanceResponse getAccountsWithBalance() throws Exception {
		// return getAccountsWithBalanceResponse();
		return viewAccountsListService.getAccountsWithBalance();
	}
	@GetMapping("/account-management/v2/accounts/balance")
	public AccountsWithBalanceResponse getAccountsWithBalance(@RequestParam(name = "function-id",required = true) String functionId) throws Exception{

		return viewAccountsListService.getAccountsWithBalanceV2(functionId);
	} 
	
	@GetMapping("/account-management/v1/accounts/has-dormant")
	public HasDormantAccountResponse hasDormantAccount() throws Exception{

		return viewAccountsListService.hasDormantAccounts();
	} 
	
}
