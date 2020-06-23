package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.EmptyContentException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.request.AccountDetailsSearchCriteriaDTO;
import com.alinma.rib.accounts.model.request.AccountTransfereDTO;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsResponse;
import com.alinma.rib.accounts.service.AccountTransfereService;
import com.alinma.rib.accounts.service.ViewAccountTransactionListService;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;


@CrossOrigin
@RestController
@RequestMapping("/transfer")
public class AccountTransfereTranscationController {
	

	@Autowired
	AccountTransfereService accountTransfereService;
	
	@GetMapping("/v1/accounts/{account-index}/transfers")
	public  AccountTransferTransactionsResponse getAccountTransactions (
			@PathVariable("account-index") Long accountIndex,
			@RequestParam(name = "from-date") String fromDate,
			@RequestParam(name = "to-date") String toDate,
			@RequestParam(name = "from-amount", required = false) Double fromAmount,
			@RequestParam(name = "to-amount", required = false) Double toAmount,
			@RequestParam(name = "transaction-ref-number", required = false) String transactionRefNum,
			@RequestParam(name = "max-records", required = true) Integer maxRecords,
			@RequestParam(name = "offset", required = true) Integer offset) throws CustomServiceUnavailableException, ESBException, EmptyContentException, InputException {
	
		
		AccountTransfereDTO accountTransfereDTO = new AccountTransfereDTO();
		accountTransfereDTO.setFromDate(fromDate);
		accountTransfereDTO.setToDate(toDate);
		accountTransfereDTO.setMaxRecords(maxRecords);
		accountTransfereDTO.setOffset(offset);
		accountTransfereDTO.setTransactionRefNum(transactionRefNum);
		accountTransfereDTO.setFromAmount(fromAmount);
		accountTransfereDTO.setToAmount(toAmount);
		accountTransfereDTO.setAccountIndex(accountIndex);

		return accountTransfereService.getAccountTransactions(accountTransfereDTO);
	} 
	
	
	
}
