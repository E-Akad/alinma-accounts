package com.alinma.rib.accounts.controller;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.request.AccountDetailsSearchCriteriaDTO;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountStatementResponse;
import com.alinma.rib.accounts.model.response.AccountStatmentReportResponse;
import com.alinma.rib.accounts.service.ViewAndDownloadOnlineAccountStatementService;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.google.gson.Gson;

@RestController
public class ViewAndDownloadOnlineAccountStatementController {

	@Autowired
	ViewAndDownloadOnlineAccountStatementService service;

	private static Logger logger = LoggerFactory.getLogger(ViewAndDownloadOnlineAccountStatementController.class);

	@GetMapping("/v1/accounts/{account-number}/statement")
	public AccountStatementResponse getAccountStatementCycle(@PathVariable("account-number") Long accountNumber) {
		logger.info("Account number is: " + accountNumber);
		return service.getAccountStatementCycle(accountNumber);
	}

	@GetMapping("/v1/accounts/{account-number}/statements")
	public @ResponseBody AccountStatementInquiryResponse getAccountStatementDetails(
	@PathVariable("account-number") Long accountNumber,
	@RequestParam(name = "from-date",required = true) String fromDate,
	@RequestParam(name = "to-date",required = true) String toDate,
	@RequestParam(name = "from-date-hijri",required = false) String fromDateHijri,
	@RequestParam(name = "to-date-hijri",required = false) String toDateHijri,
	@RequestParam(name = "graph",required = false) Boolean graph,
	@RequestParam(name = "max-records", required = true) Integer maxRecords,
	@RequestParam(name = "offset", required = true) Integer offset) throws Exception {

		logger.info("Account number is: " + accountNumber);
		logger
		.info("From date:" + fromDate + "\nTo date:" + toDate + "\nFrom date Hijri:" + fromDateHijri
		+ "\nTo date Hijri:" + toDateHijri + "\nGraph:" + graph + "\nMax records:" + maxRecords + "\nOffset:"
		+ offset);
		
		/**
		 * AccountStatementDetailsRequest carrier object to carry request data to service layer
		 */
		AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO = new AccountDetailsSearchCriteriaDTO();
		accountDetailsSearchCriteriaDTO.setAccountNumber(accountNumber);
		accountDetailsSearchCriteriaDTO.setFromDate(fromDate);
		accountDetailsSearchCriteriaDTO.setToDate(toDate); 
		accountDetailsSearchCriteriaDTO.setFromDateHijri(fromDateHijri);
		accountDetailsSearchCriteriaDTO.setToDateHijri(toDateHijri);
		accountDetailsSearchCriteriaDTO.setGraph(graph);
		accountDetailsSearchCriteriaDTO.setMaxRecords(maxRecords);
		accountDetailsSearchCriteriaDTO.setOffset(offset);
		
		//return getStatmentsResponse();
		return service.getAccountStatementDetails(accountDetailsSearchCriteriaDTO);
	}
	
	 @GetMapping("/v1/accounts/{account-number}/statements/report")
 	public AccountStatmentReportResponse exportReport(	@PathVariable(name = "account-number") Long accountNumber,
 														 @RequestParam(name = "from-date",required = false) String fromDate,
 														 @RequestParam(name = "to-date",required = false) String toDate,
 														 @RequestParam(name = "from-date-hijri",required = false) String fromDateHijri,
 														 @RequestParam(name = "to-date-hijri",required = false) String toDateHijri,
 														 @RequestParam(name = "graph",required = false) Boolean graph,
 														 @RequestParam(name = "max-records", required = true) Integer maxRecords,
 														 @RequestParam(name = "offset", required = true) Integer offset,
 														 @RequestParam(name = "extension")String extension) throws CustomServiceUnavailableException{
						 AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO = new AccountDetailsSearchCriteriaDTO();
							accountDetailsSearchCriteriaDTO.setAccountNumber(accountNumber);
							accountDetailsSearchCriteriaDTO.setFromDate(fromDate);
							accountDetailsSearchCriteriaDTO.setToDate(toDate); 
							accountDetailsSearchCriteriaDTO.setFromDateHijri(fromDateHijri);
							accountDetailsSearchCriteriaDTO.setToDateHijri(toDateHijri);
							accountDetailsSearchCriteriaDTO.setGraph(graph);
							accountDetailsSearchCriteriaDTO.setMaxRecords(maxRecords);
							accountDetailsSearchCriteriaDTO.setOffset(offset);
							
         return service.exportReport(accountDetailsSearchCriteriaDTO, extension,accountNumber);
     }
	 
	 private AccountStatementInquiryResponse getStatmentsResponse() throws Exception {
			try {
				ClassPathResource resource = new ClassPathResource("statementRes.txt");
				File jsonFile = resource.getFile();
				String json = readLineByLineJava8(jsonFile.getAbsolutePath());
				Gson g = new Gson();
				AccountStatementInquiryResponse response = g.fromJson(json, AccountStatementInquiryResponse.class);
				System.out.println("RS : " + response);
				return response;
			} catch (Exception e) {
				e.printStackTrace();
				throw new Model500InternalServererror("500", "AccountStatementInquiryResponse Exception", e.getMessage());
			}
		}

		private static String readLineByLineJava8(String filePath) {
			StringBuilder contentBuilder = new StringBuilder();
			try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
				stream.forEach(s -> contentBuilder.append(s).append("\n"));
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
			return contentBuilder.toString();
		}

	 
	
}
