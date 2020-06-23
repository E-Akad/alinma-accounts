package com.alinma.rib.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.AccountDetailsSearchCriteriaDTO;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountTransactionReportInquiryResponse;
import com.alinma.rib.accounts.service.ViewAccountTransactionListService;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;

@RestController
public class ViewAccountTransactionListController {

	@Autowired
	ViewAccountTransactionListService viewAccountTransactionListService;
	
	private static Logger logger = LoggerFactory.getLogger(ViewAccountTransactionListController.class);
	
	@GetMapping("/v1/accounts/{account-number}/transactions")
	public AccountTransactionInquiryResponse getAccountTransactions(
	@PathVariable("account-number") Long accountNumber,
	@RequestParam(name = "from-date") String fromDate,
	@RequestParam(name = "to-date") String toDate,
	@RequestParam(name = "from-date-hijri", required = false) String fromDateHijri,
	@RequestParam(name = "to-date-hijri", required = false) String toDateHijri,
	@RequestParam(name = "from-amount", required = false) String fromAmount,
	@RequestParam(name = "to-amount", required = false) String toAmount,
	@RequestParam(name = "transaction-ref-number", required = false) String transactionRefNum,
	@RequestParam(name = "transaction-type", required = false) String transactionType,
	@RequestParam(name = "max-records", required = true) Integer maxRecords,
	@RequestParam(name = "offset", required = true) Integer offset)
	throws CustomServiceUnavailableException {

		AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO = new AccountDetailsSearchCriteriaDTO();
		accountDetailsSearchCriteriaDTO.setAccountNumber(accountNumber);
		accountDetailsSearchCriteriaDTO.setFromDate(fromDate);
		accountDetailsSearchCriteriaDTO.setToDate(toDate);
		accountDetailsSearchCriteriaDTO.setFromDateHijri(fromDateHijri);
		accountDetailsSearchCriteriaDTO.setToDateHijri(toDateHijri);
		accountDetailsSearchCriteriaDTO.setMaxRecords(maxRecords);
		accountDetailsSearchCriteriaDTO.setOffset(offset);
		accountDetailsSearchCriteriaDTO.setTransactionRefNum(transactionRefNum);
		accountDetailsSearchCriteriaDTO.setTransactionType(transactionType);
		accountDetailsSearchCriteriaDTO.setFromAmount(fromAmount);
		accountDetailsSearchCriteriaDTO.setToAmount(toAmount);

		return viewAccountTransactionListService.getAccountTransactions(accountDetailsSearchCriteriaDTO);
	}

	@GetMapping("/v1/accounts/{account-number}/transactions/report")
	public AccountTransactionReportInquiryResponse exportTransactionReport(
	@PathVariable("account-number") Long accountNumber,
	@RequestParam(name = "from-date") String fromDate,
	@RequestParam(name = "to-date") String toDate,
	@RequestParam(name = "from-date-hijri", required = false) String fromDateHijri,
	@RequestParam(name = "to-date-hijri", required = false) String toDateHijri,
	@RequestParam(name = "from-amount", required = false) String fromAmount,
	@RequestParam(name = "to-amount", required = false) String toAmount,
	@RequestParam(name = "transaction-ref-number") String transactionRefNum,
	@RequestParam(name = "transaction-type", required = false) String transactionType,
	@RequestParam(name = "max-records") Integer maxRecords,
	@RequestParam(name = "offset") Integer offset,
	@RequestParam(name = "extension") String extension)
	throws CustomServiceUnavailableException {

		logger.info("transactionRefNum : "+transactionRefNum);
		
		if(transactionRefNum == null || transactionRefNum.length() == 0) {
			AccountTransactionReportInquiryResponse transactionReportResponse = new AccountTransactionReportInquiryResponse();
			transactionReportResponse.setStatusCode(ResponseStatusCode.TRANSACTION_REF_NUM_REQUIRED);
			transactionReportResponse.setStatusDesc(ResponseStatusDesc.TRANSACTION_REF_NUM_REQUIRED);
			return transactionReportResponse;
		}
		
		AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO = new AccountDetailsSearchCriteriaDTO();
		accountDetailsSearchCriteriaDTO.setAccountNumber(accountNumber);
		accountDetailsSearchCriteriaDTO.setFromDate(fromDate);
		accountDetailsSearchCriteriaDTO.setToDate(toDate);
		accountDetailsSearchCriteriaDTO.setFromDateHijri(fromDateHijri);
		accountDetailsSearchCriteriaDTO.setToDateHijri(toDateHijri);
		accountDetailsSearchCriteriaDTO.setMaxRecords(maxRecords);
		accountDetailsSearchCriteriaDTO.setOffset(offset);
		accountDetailsSearchCriteriaDTO.setTransactionRefNum(transactionRefNum);
		accountDetailsSearchCriteriaDTO.setTransactionType(transactionType);
		accountDetailsSearchCriteriaDTO.setFromAmount(fromAmount);
		accountDetailsSearchCriteriaDTO.setToAmount(toAmount);
		accountDetailsSearchCriteriaDTO.setExtension(extension);
		
		return viewAccountTransactionListService.exportTransactionReport(accountDetailsSearchCriteriaDTO);

	}
}
