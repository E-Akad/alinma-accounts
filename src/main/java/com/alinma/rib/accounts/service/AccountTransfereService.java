package com.alinma.rib.accounts.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.EmptyContentException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.request.AccountTransfereDTO;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsResponse;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsResponseRs;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsRsTransferTransactionList;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsTransferTransactionInfo;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.AcctId;
import com.alinma.rib.models.system.common.RecCtrlIn;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.common.enums.TransactionType;
import com.alinma.rib.models.system.request.AcctTrnsInq52020000.AcctTrnsInqRq;
import com.alinma.rib.models.system.request.AcctTrnsInq52020000.AcctTrnsInqRqBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRs;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRsBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.TrnInfo;
import com.alinma.rib.service.IInmaLOVService;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;
@Service
public class AccountTransfereService {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;
	
	@Autowired
	IInmaLOVService inmaLOVService;
	
	private static Logger logger = LoggerFactory.getLogger(ViewAccountTransactionListService.class);


	/**
	 * @param accountNumber
	 * @return all transactions to this accountNumber
	 * @throws ESBException 
	 * @throws EmptyContentException 
	 * @throws InputException 
	 * @throws Exception
	 */
	public AccountTransferTransactionsResponse getAccountTransactions(
			AccountTransfereDTO accountTransfereDto) throws CustomServiceUnavailableException, ESBException, EmptyContentException, InputException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		AccountTransferTransactionsResponse response = new AccountTransferTransactionsResponse();
		AccountTransferTransactionsResponseRs accountTransferTranscationResponse = new AccountTransferTransactionsResponseRs();
		

			AcctTrnsInqRq esb_AcctTrnsInqRq = new AcctTrnsInqRq();

			/*
			 * start fill Header
			 */
			esb_AcctTrnsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountTransferTransactions.getValue()));

			/*
			 * Start filling ESB Request Body
			 */
			AcctTrnsInqRqBody rqBody = new AcctTrnsInqRqBody();
			AcctId acctId = new AcctId();
			acctId.setAcctNum(accountTransfereDto.getAccountIndex());
			// acctId.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode()); nour el
			// sirisi said not mandatory
			rqBody.setAcctId(acctId);

			if (accountTransfereDto.getFromDate() != null) {
				rqBody.setFromDt(accountTransfereDto.getFromDate());

				if (accountTransfereDto.getToDate() != null) {
					rqBody.setToDt(accountTransfereDto.getToDate());
				} else {
					// set toDate = fromDate + 1
					Calendar calendar = Calendar.getInstance();
					try {
						calendar.setTime(dateFormat.parse(accountTransfereDto.getFromDate()));
					} catch (ParseException e) {
						InputException inputEx = new InputException();
						inputEx.setExceptionMessage("In correct date formate");
						throw inputEx;
					}
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					rqBody.setToDt(dateFormat.format(calendar.getTime()));
				}
			} else {
				
				
				InputException inputEx = new InputException();
				inputEx.setExceptionMessage(ResponseStatusDesc.DATE_REQUIRED);
				throw inputEx;
				
			}
			
			if (accountTransfereDto.getFromAmount()!=null) {
				 BigDecimal fromAmoutbd = new BigDecimal(accountTransfereDto.getFromAmount(), new MathContext(0));
				rqBody.setFromAmt(fromAmoutbd);
			}

			if (accountTransfereDto.getToAmount()!=null) {
				 BigDecimal toAmoutbd = new BigDecimal(accountTransfereDto.getToAmount(), new MathContext(0));
				rqBody.setToAmt(toAmoutbd);
			}

			if (accountTransfereDto.getTransactionRefNum() != null)
				rqBody.setTrnRefNum(accountTransfereDto.getTransactionRefNum());

			RecCtrlIn recCtrlIn = new RecCtrlIn();
			recCtrlIn.setMaxRecs(accountTransfereDto.getMaxRecords());
			recCtrlIn.setOffset(accountTransfereDto.getOffset());
			rqBody.setRecCtrlIn(recCtrlIn);

			esb_AcctTrnsInqRq.setBody(rqBody);

			/*
			 * Start Calling JMS Service
			 */
			AcctTrnsInqRs esb_AcctTrnsInqRs = null;
			esb_AcctTrnsInqRs = (AcctTrnsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctTrnsInqRq,
					MQSendDestination.AcctTrnsInqRq.getValue(), MQReceiveDestination.AcctTrnsInqRs.getValue(),
					AcctTrnsInqRs.class);

			/*
			 * fill swagger response
			 */
			if (esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				AcctTrnsInqRsBody rsBody = esb_AcctTrnsInqRs.getBody();
				if (rsBody != null) {

					if (rsBody.getRecCtrlOut() != null) {
						AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut recordCtrlOut = new AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut();
						recordCtrlOut.setMatchedRecs(rsBody.getRecCtrlOut().getMatchedRecs());
						recordCtrlOut.setSentRecs(rsBody.getRecCtrlOut().getSentRecs());
						
						accountTransferTranscationResponse.setRecCtrlOut(recordCtrlOut);
					}

					if (rsBody.getTrnsList() != null
							&& GeneralUtil.isListValid(rsBody.getTrnsList().getTrnInfoList())) {

						AccountTransferTransactionsRsTransferTransactionList transactionList = new AccountTransferTransactionsRsTransferTransactionList();

						List<TrnInfo> trnInfoList = rsBody.getTrnsList().getTrnInfoList();
						AccountTransferTransactionsTransferTransactionInfo transTransactionInfo = null;

						for (TrnInfo esb_trnsInfo : trnInfoList) {
							transTransactionInfo = new AccountTransferTransactionsTransferTransactionInfo();

							
							transTransactionInfo.setDescription(GeneralUtil.listToString(esb_trnsInfo.getTrnNarr()));
							transTransactionInfo.setMemo(GeneralUtil.listToString(esb_trnsInfo.getMemo()));
							String transactionCodeDesc =inmaLOVService.getTransactionCodeDesc( esb_trnsInfo.getTrnCode(),userService.islocalLanguageEnglish());
							if(transactionCodeDesc != null)
								transTransactionInfo.setType(transactionCodeDesc);
							else
								transTransactionInfo.setType(esb_trnsInfo.getTrnCode());

							if (esb_trnsInfo.getTrnDt() != null) {
								LocalDate transactionDate = LocalDate.parse(esb_trnsInfo.getTrnDt());
								transTransactionInfo.setTransactionDate(transactionDate);
								if(esb_trnsInfo.getTrnTm() != null) {
									transTransactionInfo.setTransactionTime(transactionDate.toString()+" "+esb_trnsInfo.getTrnTm());
								}
							}
							transTransactionInfo.setTrnRefNum(esb_trnsInfo.getTrnRefNum());

							if (esb_trnsInfo.getCurAmt() != null) {
								String currency = inmaLOVService.getCurrencyDesc(esb_trnsInfo.getCurAmt().getCurCode(),userService.islocalLanguageEnglish());
								if(currency!=null)
									transTransactionInfo.setCurrency(currency);
								else
									transTransactionInfo.setCurrency(esb_trnsInfo.getCurAmt().getCurCode());


								if (TransactionType.CREDIT.getCode().equals(esb_trnsInfo.getTrnType())) {
									transTransactionInfo.setCredit(esb_trnsInfo.getCurAmt().getAmt());
								} else {
									transTransactionInfo.setDebit(esb_trnsInfo.getCurAmt().getAmt());
								}
								transTransactionInfo.setAmount(esb_trnsInfo.getCurAmt().getAmt());
							}
							transactionList.addTransferTransactionInfoItem(transTransactionInfo);
						}
						accountTransferTranscationResponse.setTransferTransactionList(transactionList);
					
						response.setAccountTransferTransactionsRs(accountTransferTranscationResponse);

						accountTransferTranscationResponse
								.setStatusCode(esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
						accountTransferTranscationResponse.setStatusDesc(ResponseStatusDesc.SUCCESS);
						response.setAccountTransferTransactionsRs(accountTransferTranscationResponse);
						return response;
					} else {
						logger.info("there is body but no transaction list found - ESB Status Code "
								+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
						throw new EmptyContentException(esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
					}
				} else {
					logger.info("Response Body Is Empty - ESB Status Code "
							+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
					
					throw new EmptyContentException(esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
				}
			} else {
				logger.info(
						"ViewAccountTransactionsListService:getAccountTransactions -> something went wrong with code: "
								+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
				throw new ESBException(esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
				
			}
	
	}
}
