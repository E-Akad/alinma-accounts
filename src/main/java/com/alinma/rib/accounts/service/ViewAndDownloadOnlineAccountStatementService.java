package com.alinma.rib.accounts.service;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.request.AccountDetailsSearchCriteriaDTO;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRs;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo.TransactionTypeEnum;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo;
import com.alinma.rib.accounts.model.response.AccountStatementResponse;
import com.alinma.rib.accounts.model.response.AccountStatementResponseStatementCyclesInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList;
import com.alinma.rib.accounts.model.response.AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo;
import com.alinma.rib.accounts.model.response.AccountStatmentReportResponse;
import com.alinma.rib.accounts.model.response.Amount;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.AcctId;
import com.alinma.rib.models.system.common.LOVInfo;
import com.alinma.rib.models.system.common.RecCtrlIn;
import com.alinma.rib.models.system.common.RecCtrlOut;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.LOVInquiry30020000.LovInquiryReqBody;
import com.alinma.rib.models.system.request.StmtCyclesInq52010000.StmtCyclesInqRq;
import com.alinma.rib.models.system.request.StmtCyclesInq52010000.StmtCyclesInqRqBody;
import com.alinma.rib.models.system.request.StmtDtlsInq52000000.StmtDtlsInqRq;
import com.alinma.rib.models.system.request.StmtDtlsInq52000000.StmtDtlsInqRqBody;
import com.alinma.rib.models.system.response.LOVInquiry30020000.LovInquiryRes;
import com.alinma.rib.models.system.response.StmtCyclesInq52010000.StmtCycleInfo;
import com.alinma.rib.models.system.response.StmtCyclesInq52010000.StmtCyclesInqRs;
import com.alinma.rib.models.system.response.StmtCyclesInq52010000.StmtCyclesInqRsBody;
import com.alinma.rib.models.system.response.StmtDtlsInq52000000.CustInfo;
import com.alinma.rib.models.system.response.StmtDtlsInq52000000.StmtDtlsInqRs;
import com.alinma.rib.models.system.response.StmtDtlsInq52000000.StmtDtlsInqRsBody;
import com.alinma.rib.models.system.response.StmtDtlsInq52000000.StmtTrnInfo;
import com.alinma.rib.models.system.response.StmtDtlsInq52000000.TrnsList;
import com.alinma.rib.service.IInmaLOVService;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;
import com.google.gson.Gson;

/**
 * This use case contains the following methods - CustAcctsInq :: 26021000
 * getAccountsWithBalance - StmtCyclesInq :: 52010000 accountStatementCycle -
 * StmtDtlsInq :: 52000000 accountStatementDetails
 */

@Service
public class ViewAndDownloadOnlineAccountStatementService {
	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;

	@Autowired
	ReportingService reportingService;
	
	@Autowired
	IInmaLOVService inmaLOVService;
	
	private final static int TRANS_CODE_DESC_LOV = 84;
	private final static int CHANNEL_DESC_LOV = 16;

	private static Logger logger = LoggerFactory.getLogger(ViewAndDownloadOnlineAccountStatementService.class);

	// StmtCyclesInq :: 52010000 accountStatementCycle
	public AccountStatementResponse getAccountStatementCycle(Long accountNumber) {

		AccountStatementResponse response = new AccountStatementResponse();

		/**
		 * Filling header
		 */
		StmtCyclesInqRq esbStmtCyclesInqRq = new StmtCyclesInqRq();
		esbStmtCyclesInqRq.setMsgRqHdr(
				middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountStatementCycle.getValue()));

		StmtCyclesInqRqBody stmtCyclesInqRqBody = new StmtCyclesInqRqBody();
		AcctId acctId = new AcctId();
		acctId.setAcctNum(accountNumber);
		stmtCyclesInqRqBody.setAcctId(acctId);
		// according to Nour el sirisi this value is constant and represent 12 cycle
		stmtCyclesInqRqBody.setStmtPeriod(12);
		esbStmtCyclesInqRq.setBody(stmtCyclesInqRqBody);
		/**
		 * Calling JMS service here
		 */
		StmtCyclesInqRs esbStmtDtlsInqRs = null;
		try {
			esbStmtDtlsInqRs = (StmtCyclesInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(
					esbStmtCyclesInqRq, MQSendDestination.StmtCyclesInqRq.getValue(),
					MQReceiveDestination.StmtCyclesInqRs.getValue(), StmtCyclesInqRs.class);

			if (esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				StmtCyclesInqRsBody responseBody = esbStmtDtlsInqRs.getBody();
				/**
				 * Filling model response
				 */
				if (responseBody != null) {
					List<StmtCycleInfo> infoList = responseBody.getStmtCyclesList().getStmtCycleInfo();

					List<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo> list = new ArrayList<>();
					for (int i = 0; i < responseBody.getStmtCyclesList().getStmtCycleInfo().size(); i++) {
						list.get(i).setStatementCycleIndex(infoList.get(i).getStmtCycleType());
						list.get(i).setStatementCycle(infoList.get(i).getStmtCycleType());
						list.get(i).setStartDate(infoList.get(i).getStartDt().toString());
						list.get(i).setEndDate(infoList.get(i).getEndDt().toString());
					}
					AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList statementCycleList = new AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList();
					statementCycleList.setStatementCycleInfo(list);

					AccountStatementResponseStatementCyclesInquiryResponse inquiryResponse = new AccountStatementResponseStatementCyclesInquiryResponse();
					// inquiryResponse.setStatusDesc(esbStmtDtlsInqRs.getMsgRsHdr().getOverrideStatus().getDesc());
					inquiryResponse.setStatusCode(esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode());
					inquiryResponse.setStatementCycleList(statementCycleList);

					response.setStatementCyclesInquiryResponse(inquiryResponse);

				} else {
					// Body is null, set log here
				}
			}

		} catch (Exception e) {
			throw new CustomServiceUnavailableException("getAccountTransactions Exception", e);
		}

		return response;
	}

	private HashMap<String, Double> getTranscationCodeAndTotalAmout(
			AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO) throws ParseException {
		logger.info("->get all transcation for precentage");
		HashMap<String, Double> transCodeAmoutMap = new HashMap<String, Double>();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StmtDtlsInqRq esbStmtDtlsInqRq = new StmtDtlsInqRq();
		esbStmtDtlsInqRq.setMsgRqHdr(
				middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountStatementDetails.getValue()));

		StmtDtlsInqRqBody stmtDtlsInqRqBody = new StmtDtlsInqRqBody();
		AcctId acctId = new AcctId();
		acctId.setAcctNum(accountDetailsSearchCriteriaDTO.getAccountNumber());
//		acctId.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode()); nour el sirisi said not mandatory
		stmtDtlsInqRqBody.setAcctId(acctId);

		if (accountDetailsSearchCriteriaDTO.getFromDate() != null) {
			stmtDtlsInqRqBody.setFromDt(accountDetailsSearchCriteriaDTO.getFromDate());

			if (accountDetailsSearchCriteriaDTO.getToDate() != null) {
				stmtDtlsInqRqBody.setToDt(accountDetailsSearchCriteriaDTO.getToDate());
			} else {
				// set toDate = fromDate + 1
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(simpleDateFormat.parse(accountDetailsSearchCriteriaDTO.getFromDate()));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				stmtDtlsInqRqBody.setToDt(simpleDateFormat.format(calendar.getTime()));
			}
		} else if (accountDetailsSearchCriteriaDTO.getFromDateHijri() != null) {
			// so Gregorian date is null so consider using Hijri date
			stmtDtlsInqRqBody.setFromDtHjr(accountDetailsSearchCriteriaDTO.getFromDateHijri());
			if (accountDetailsSearchCriteriaDTO.getToDateHijri() != null) {
				stmtDtlsInqRqBody.setToDtHjr(accountDetailsSearchCriteriaDTO.getToDateHijri());
			} else {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(simpleDateFormat.parse(accountDetailsSearchCriteriaDTO.getFromDateHijri()));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				stmtDtlsInqRqBody.setToDtHjr(simpleDateFormat.format(calendar.getTime()));
			}
		} else {
			throw new CustomServiceUnavailableException("Gregorian Date or Hijri Date Can not set null",
					new Exception());
		}

		RecCtrlIn recCtrlIn = new RecCtrlIn();
		recCtrlIn.setMaxRecs(99999);
		recCtrlIn.setOffset(0);
		stmtDtlsInqRqBody.setRecCtrlIn(recCtrlIn);
		esbStmtDtlsInqRq.setBody(stmtDtlsInqRqBody);
		/**
		 * Calling JMS service here
		 */
		StmtDtlsInqRs esbStmtDtlsInqRs = null;
//
		esbStmtDtlsInqRs = (StmtDtlsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esbStmtDtlsInqRq,
				MQSendDestination.StmtDtlsInqRq.getValue(), MQReceiveDestination.StmtDtlsInqRs.getValue(),
				StmtDtlsInqRs.class);

//		esbStmtDtlsInqRs = esbStatmentMockResponse();

		/**
		 * Filling model response
		 */
		if (esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
			StmtDtlsInqRsBody responseBody = esbStmtDtlsInqRs.getBody();
			if (responseBody != null) {
				if (responseBody.getTrnsList() != null && responseBody.getTrnsList().getStmtTrnInfo()!=null) {
					RecCtrlOut recCtrlOut = responseBody.getRecCtrlOut();

					TrnsList trnsList = responseBody.getTrnsList();
					List<StmtTrnInfo> esbTransListInfo = trnsList.getStmtTrnInfo();
					AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut recordControlOut = new AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut();
					recordControlOut.setMatchedRecords(recCtrlOut.getMatchedRecs());
					recordControlOut.setSentRecords(recCtrlOut.getSentRecs());

					// int count=0;
					double totalCR = 0.0;
					double totalDR = 0.0;
					for (int i = 0; i < esbTransListInfo.size(); i++) {
						String transCode = esbTransListInfo.get(i).getTrnCode();
						logger.info("->get all trans:trncde" + transCode);
						Double transAmout = esbTransListInfo.get(i).getCurAmt().getAmt();
						if (transCodeAmoutMap.containsKey(transCode)) {
							Double newAmout = transCodeAmoutMap.get(transCode) + transAmout;
							transCodeAmoutMap.put(transCode, newAmout);
						} else// if(count<=6)
						{
							transCodeAmoutMap.put(transCode, transAmout);
							// count++;
						}

						if ("CR".equalsIgnoreCase(esbTransListInfo.get(i).getTrnType())) {
							totalCR = totalCR + esbTransListInfo.get(i).getCurAmt().getAmt();

						} else if ("DR".equalsIgnoreCase(esbTransListInfo.get(i).getTrnType())) {
							totalDR = totalDR + esbTransListInfo.get(i).getCurAmt().getAmt();
						}
					} // end loop
					transCodeAmoutMap.put("CR", totalCR);
					transCodeAmoutMap.put("DR", totalDR);
				} else {
					logger.info(
							"ViewAndDownloadOnlineAccountStatementService:getTranscationCodeAndTotalAmout -> response TrnsList is null from ESB");
					return transCodeAmoutMap;
				}
			} else {
				logger.info(
						"ViewAndDownloadOnlineAccountStatementService:getTranscationCodeAndTotalAmout -> response Body is null from ESB");
			}
		}

		logger.info("->get all trans:trncde done-<<");
		return transCodeAmoutMap;

	}

	// StmtDtlsInq :: 52000000 accountStatementDetails
	public AccountStatementInquiryResponse getAccountStatementDetails(
			AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO) {

		logger.info("You reached the internal service");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		logger.info("accountDetailsSearchCriteriaDTO : " + accountDetailsSearchCriteriaDTO);

		AccountStatementInquiryResponse response = new AccountStatementInquiryResponse();
		try {
			HashMap<String, Double> transCodeAmoutMap = getTranscationCodeAndTotalAmout(
					accountDetailsSearchCriteriaDTO);
		
			HashMap<String, String> transCodeDescMap=getLovHashMap(TRANS_CODE_DESC_LOV);
			HashMap<String, String> chanelCodeDescMap=getLovHashMap(CHANNEL_DESC_LOV);
			HashMap<String, AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> stmntGraphInfoMap= new HashMap<String, AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo>();
			/**
			 * Filling header
			 */
			StmtDtlsInqRq esbStmtDtlsInqRq = new StmtDtlsInqRq();
			esbStmtDtlsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountStatementDetails.getValue()));

			StmtDtlsInqRqBody stmtDtlsInqRqBody = new StmtDtlsInqRqBody();
			AcctId acctId = new AcctId();
			acctId.setAcctNum(accountDetailsSearchCriteriaDTO.getAccountNumber());
//			acctId.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode()); nour el sirisi said not mandatory
			stmtDtlsInqRqBody.setAcctId(acctId);

			if (accountDetailsSearchCriteriaDTO.getFromDate() != null) {
				stmtDtlsInqRqBody.setFromDt(accountDetailsSearchCriteriaDTO.getFromDate());

				if (accountDetailsSearchCriteriaDTO.getToDate() != null) {
					stmtDtlsInqRqBody.setToDt(accountDetailsSearchCriteriaDTO.getToDate());
				} else {
					// set toDate = fromDate + 1
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(simpleDateFormat.parse(accountDetailsSearchCriteriaDTO.getFromDate()));
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					stmtDtlsInqRqBody.setToDt(simpleDateFormat.format(calendar.getTime()));
				}
			} else if (accountDetailsSearchCriteriaDTO.getFromDateHijri() != null) {
				// so Gregorian date is null so consider using Hijri date
				stmtDtlsInqRqBody.setFromDtHjr(accountDetailsSearchCriteriaDTO.getFromDateHijri());
				if (accountDetailsSearchCriteriaDTO.getToDateHijri() != null) {
					stmtDtlsInqRqBody.setToDtHjr(accountDetailsSearchCriteriaDTO.getToDateHijri());
				} else {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(simpleDateFormat.parse(accountDetailsSearchCriteriaDTO.getFromDateHijri()));
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					stmtDtlsInqRqBody.setToDtHjr(simpleDateFormat.format(calendar.getTime()));
				}
			} else {
				throw new CustomServiceUnavailableException("Gregorian Date or Hijri Date Can not set null",
						new Exception());
			}

			RecCtrlIn recCtrlIn = new RecCtrlIn();
			recCtrlIn.setMaxRecs(accountDetailsSearchCriteriaDTO.getMaxRecords());
			recCtrlIn.setOffset(accountDetailsSearchCriteriaDTO.getOffset());
			stmtDtlsInqRqBody.setRecCtrlIn(recCtrlIn);
			esbStmtDtlsInqRq.setBody(stmtDtlsInqRqBody);
			/**
			 * Calling JMS service here
			 */
			StmtDtlsInqRs esbStmtDtlsInqRs = null;
			esbStmtDtlsInqRs = (StmtDtlsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esbStmtDtlsInqRq,
					MQSendDestination.StmtDtlsInqRq.getValue(), MQReceiveDestination.StmtDtlsInqRs.getValue(),
					StmtDtlsInqRs.class);

	//		esbStmtDtlsInqRs = esbStatmentMockResponse();
			/**
			 * Filling model response
			 */
			AccountStatementInquiryResponseStmtDtlsInqRs responseStmtDtlsInqRs = new AccountStatementInquiryResponseStmtDtlsInqRs();
			if (esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				StmtDtlsInqRsBody responseBody = esbStmtDtlsInqRs.getBody();
				if (responseBody != null) {
					if (responseBody.getTrnsList() != null && responseBody.getTrnsList().getStmtTrnInfo()!=null) {
						RecCtrlOut recCtrlOut = responseBody.getRecCtrlOut();
						AcctId response_acctId = responseBody.getAcctId();
						CustInfo custInfo = responseBody.getCustInfo();
						TrnsList trnsList = responseBody.getTrnsList();
						List<StmtTrnInfo> esbTransListInfo = trnsList.getStmtTrnInfo();
						AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut recordControlOut = new AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut();
						recordControlOut.setMatchedRecords(recCtrlOut.getMatchedRecs());
						recordControlOut.setSentRecords(recCtrlOut.getSentRecs());
						// prepare statementGraphList
						List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph> statementGraph = new ArrayList<>();
						int creditTransCount = 0;
						int debitTransCount = 0;

						List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> statmentGraphListInfoList = new ArrayList<>();
						// prepare statementTransactionList
						List<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo> statementTransactionInfoList = new ArrayList<>();

						
						//add map for grouping statmentGraphinfo
						
						for (int i = 0; i < esbTransListInfo.size(); i++) {
							AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo statmtGrphInfo = new AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo();

							AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo statmtTransInfo = new AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo();
							// TO_DO to be calulcated as per nour calulations later
							//String transDesc=inmaLOVService.getTransactionCodeDesc(esbTransListInfo.get(i).getTrnCode(),userService.islocalLanguageEnglish());
							String transDesc=transCodeDescMap.get(esbTransListInfo.get(i).getTrnCode());
							
							statmtGrphInfo.setTransactionTypeAmount(esbTransListInfo.get(i).getCurAmt().getAmt());
							statmtGrphInfo.setTransactionCodeDesc(transDesc);
							String trnType = esbTransListInfo.get(i).getTrnType();

							double totalAmtType = 0;

							if (trnType.equalsIgnoreCase(TransactionTypeEnum.CR.toString())) {
								statmtGrphInfo.setTransactionType(TransactionTypeEnum.CR);
								statmtTransInfo.setDebit(0.0);
								statmtTransInfo.setCredit(esbTransListInfo.get(i).getCurAmt().getAmt());
								creditTransCount++;
								totalAmtType = transCodeAmoutMap.get("CR");

							} else if (trnType.equalsIgnoreCase(TransactionTypeEnum.DR.toString())) {

								statmtGrphInfo.setTransactionType(TransactionTypeEnum.DR);
								statmtTransInfo.setDebit(esbTransListInfo.get(i).getCurAmt().getAmt());
								statmtTransInfo.setCredit(0.0);
								debitTransCount++;
								totalAmtType = transCodeAmoutMap.get("DR");

							}
							statmtTransInfo.setTransType(
									com.alinma.rib.accounts.model.response.TransactionType.getByCode(trnType));

							// work on percentage and total amout type

							if (totalAmtType == 0) {
								statmtGrphInfo.setPercentage(0.0);
								statmtGrphInfo.setTransactionTypeAmount(0.0);
							} else {
								Double totalTypeAmout = transCodeAmoutMap.get(esbTransListInfo.get(i).getTrnCode());
								if (totalTypeAmout != null && totalTypeAmout != 0) {
									double percentage = ((Math.abs(totalTypeAmout) / Math.abs(totalAmtType)) * 100.0);
									percentage = Math.round((percentage) * 10.0) / 10.0;
									statmtGrphInfo.setPercentage(percentage);
									statmtGrphInfo.setTransactionTypeAmount(totalTypeAmout);
								} else {
									statmtGrphInfo.setPercentage(0.0);
									statmtGrphInfo.setTransactionTypeAmount(0.0);
								}
							}
							// end of work on percentage and total amout type

				//			statmentGraphListInfoList.add(statmtGrphInfo);
							stmntGraphInfoMap.put(esbTransListInfo.get(i).getTrnCode(), statmtGrphInfo);
							
							// prepare statementTransactionList
							Amount amount = new Amount();
							amount.setAmount("" + esbTransListInfo.get(i).getCurAmt().getAmt());
							amount.setLocalAmount("" + esbTransListInfo.get(i).getCurAmt().getAmtLcl());
							amount.setCurrencyCode(esbTransListInfo.get(i).getCurAmt().getCurCode());

							statmtTransInfo.setAmount(amount);
							statmtTransInfo.setBalance(esbTransListInfo.get(i).getAvailBal());
							// statmtTransInfo.setDebit(debit);
							// statmtTransInfo.setCredit(credit);
							statmtTransInfo.setDescription((!esbTransListInfo.get(i).getTrnNarr().isEmpty())
									? esbTransListInfo.get(i).getTrnNarr()
									: null);

							statmtTransInfo.setReferenceNumber(esbTransListInfo.get(i).getTrnRefNum());

						
							statmtTransInfo.setTransactionCodeDesc(transDesc);
					//		statmtTransInfo.setTransactionCodeDesc("CRD DEBT PAY");

							statmtTransInfo.setTransDate(
									LocalDate.parse(simpleDateFormat.format(esbTransListInfo.get(i).getTrnDt())));

							//String channelDesc=inmaLOVService.getChannelDesc(esbTransListInfo.get(i).getChanId(),userService.islocalLanguageEnglish());
							String channelDesc=chanelCodeDescMap.get(esbTransListInfo.get(i).getChanId());
							
							statmtTransInfo.setChannelDesc(channelDesc);
					//		statmtTransInfo.setChannelDesc("chnl mk resp");
							statementTransactionInfoList.add(statmtTransInfo);
						}//end of transListLoop

						//add graphListInfo elements
						for (Map.Entry<String, AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> entry : stmntGraphInfoMap.entrySet()) {
						    statmentGraphListInfoList.add(entry.getValue());
						}
						
						AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList statmentGraphList = new AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList();
						statmentGraphList.setStatementGraphInfo(statmentGraphListInfoList);
						// end -statementGraphList
						AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList statmentTransList = new AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList();
						statmentTransList.setStatementTransactionInfo(statementTransactionInfoList);
						// end-statementTransactionList

						// start appending the response
						responseStmtDtlsInqRs.setStatusCode(esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode());
						responseStmtDtlsInqRs.setStatusDesc(esbStmtDtlsInqRs.getMsgRsHdr().getMsgRecDt());
						responseStmtDtlsInqRs.setFromDate(
								LocalDate.parse(simpleDateFormat.format(esbStmtDtlsInqRs.getBody().getFromDt())));
						responseStmtDtlsInqRs.setToDate(
								LocalDate.parse(simpleDateFormat.format(esbStmtDtlsInqRs.getBody().getToDt())));
						responseStmtDtlsInqRs.setOpeningBalance(esbStmtDtlsInqRs.getBody().getOpeningBal());
						responseStmtDtlsInqRs.setClosingBalance(esbStmtDtlsInqRs.getBody().getClosingBal());
						responseStmtDtlsInqRs.setAccountCurrency(esbStmtDtlsInqRs.getBody().getAcctCur());
						responseStmtDtlsInqRs.setTotalDebitAmount(esbStmtDtlsInqRs.getBody().getTotalDebitAmt());
						responseStmtDtlsInqRs.setTotalCreditAmount(esbStmtDtlsInqRs.getBody().getTotalCreditAmt());
						responseStmtDtlsInqRs.setNumberOfDeposits(creditTransCount);
						responseStmtDtlsInqRs.setNumberOfWithdraws(debitTransCount);
						// TO_DO image need to be set
//						responseStmtDtlsInqRs.setMarketingImage(esbStmtDtlsInqRs.getBody().get);
//						

						responseStmtDtlsInqRs.setStatementGraphList(statmentGraphList);
						responseStmtDtlsInqRs.setStatementTransactionList(statmentTransList);

						AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo customerInfo = new AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo();
						customerInfo.setAlinmaId(custInfo.getAlinmaId());
						customerInfo.setBranchId(custInfo.getBranchId());
						customerInfo.setFullName(userService.getUser().getCustomerName());
						customerInfo.setAddress((custInfo.getAddr().size() != 0) ? custInfo.getAddr().get(0) : null);

						responseStmtDtlsInqRs.setCustomerInfo(customerInfo);
						responseStmtDtlsInqRs.setRecordControlOut(recordControlOut);

						response.setStmtDtlsInqRs(responseStmtDtlsInqRs);
					} else {
						logger.info(
								"ViewAndDownloadOnlineAccountStatementService:getAccountTransactions -> response TrnsList is null from ESB");
						responseStmtDtlsInqRs.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
						responseStmtDtlsInqRs
								.setStatusDesc("there is body found but TrnsList is null from return ESB code: "
										+ esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode());
						response.setStmtDtlsInqRs(responseStmtDtlsInqRs);
					}
				} else {
					logger.info(
							"ViewAndDownloadOnlineAccountStatementService:getAccountTransactions -> response Body is null from ESB");
					responseStmtDtlsInqRs.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
					responseStmtDtlsInqRs.setStatusDesc("No body found (null) to return ESB code: "
							+ esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode());
					response.setStmtDtlsInqRs(responseStmtDtlsInqRs);
				}
			} else {
				logger.info(
						"ViewAndDownloadOnlineAccountStatementService:getAccountTransactions -> something went wrong with code: "
								+ esbStmtDtlsInqRs.getMsgRsHdr().getStatusCode());
				responseStmtDtlsInqRs.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				responseStmtDtlsInqRs.setStatusDesc("No Results Avaiable");
				response.setStmtDtlsInqRs(responseStmtDtlsInqRs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomServiceUnavailableException("getAccountTransactions Exception", e);
		}

		return response;
	}

	public AccountStatmentReportResponse exportReport(AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO,
			String extension,Long accountNumber) {
		AccountStatementInquiryResponse accountStatementInquiryResponse = new AccountStatementInquiryResponse();
		String fileData = null;
		AccountStatmentReportResponse resp = new AccountStatmentReportResponse();

		try {
			// accountStatementInquiryResponse = getStatmentsResponse();
			accountStatementInquiryResponse = getAccountStatementDetails(accountDetailsSearchCriteriaDTO);

		} catch (Exception e1) {
			e1.printStackTrace();
			resp.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
			resp.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
		}
		try {
			if(accountStatementInquiryResponse==null || accountStatementInquiryResponse.getStmtDtlsInqRs().getStatusCode().equalsIgnoreCase(ResponseStatusCode.JMS_NO_DATA))
			{
				resp.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				resp.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
			}
			else
			{
				fileData = reportingService.generateReport(extension, accountStatementInquiryResponse,accountNumber);
				resp.setStatusCode(ResponseStatusCode.SUCCESS);
				resp.setStatusDesc(ResponseStatusDesc.SUCCESS);
			}
		} catch (IOException e) {
			e.printStackTrace();
			resp.setStatusCode(ResponseStatusCode.CAN_NOT_REPORT_OPEN);
			resp.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
		}
		logger.info("return message: " + fileData);
		logger.info("export status code:" + resp.getStatusCode());
		resp.setReport(fileData);
		return resp;
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

	private StmtDtlsInqRs esbStatmentMockResponse() {
		StmtDtlsInqRs esbStatmtRes = null;
		File file = new File(ViewAndDownloadOnlineAccountStatementService.class.getClassLoader()
				.getResource("espStatmentsResponseMock.xml").getFile());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StmtDtlsInqRs.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			esbStatmtRes = (StmtDtlsInqRs) jaxbUnmarshaller.unmarshal(file);
			System.out.println("response= " + esbStatmtRes.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return esbStatmtRes;
	}
public HashMap<String, String> getLovHashMap(int lOVType) {
		HashMap<String, String> rslt= new HashMap<String, String>();
		try {
			LovInquiryReqBody  lovRequest = new LovInquiryReqBody();
			lovRequest.setLOVType(String.valueOf(lOVType));
		
			 LovInquiryRes lovResponse = inmaLOVService.getInmaLOV(lovRequest);
		if(ESBStatusCode.SUCCESS.getValue().equals(lovResponse.getMsgRsHdr().getStatusCode()))
		{	 if (!lovResponse.getBody().getLOVList().getLOVInfo().isEmpty()) {
				List<LOVInfo> lovInfoList = lovResponse.getBody().getLOVList().getLOVInfo();
				for(int i=0;i<lovInfoList.size();i++)
				{
					rslt.put(lovInfoList.get(i).getRecTypeCode(), lovInfoList.get(i).getRecDesc());
				}
			}
		}}catch (Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}
}
