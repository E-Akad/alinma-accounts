package com.alinma.rib.accounts.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.request.AccountDetailsSearchCriteriaDTO;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponseAccountTransactionInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo;
import com.alinma.rib.accounts.model.response.AccountTransactionReportInquiryResponse;
import com.alinma.rib.accounts.model.response.VatInvoiceDetailsResponse;
import com.alinma.rib.accounts.model.response.VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs;
import com.alinma.rib.accounts.model.response.VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList;
import com.alinma.rib.accounts.model.response.VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.IBUser;
import com.alinma.rib.models.business.ResponseStatusCode;
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
import com.alinma.rib.models.system.request.vatInvoice52070000.VATInvoiceDtlsInqRq;
import com.alinma.rib.models.system.request.vatInvoice52070000.VATInvoiceDtlsInqRqBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRs;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRsBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.TrnInfo;
import com.alinma.rib.models.system.response.vatInvoice52070000.InvoiceInfo;
import com.alinma.rib.models.system.response.vatInvoice52070000.InvoiceItemInfo;
import com.alinma.rib.models.system.response.vatInvoice52070000.VATInvoiceDtlsInqRs;
import com.alinma.rib.models.system.response.vatInvoice52070000.VATInvoiceDtlsInqRsBody;
import com.alinma.rib.report.ReportField;
import com.alinma.rib.report.ReportFormat;
import com.alinma.rib.report.ReportRecord;
import com.alinma.rib.report.ReportTitle;
import com.alinma.rib.service.IInmaLOVService;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.report.InmaReportService;
import com.alinma.rib.service.user.UserService;

import net.sf.jasperreports.engine.JRException;

@Service
public class ViewAccountTransactionListService {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;
	 
	@Autowired
  @Qualifier("reportMsg")
  MessageSource messageSource;
	@Autowired
	InmaReportService inmaReportService;
	@Autowired
	IInmaLOVService inmaLOVService;
	 private String trnType;

	private static Logger logger = LoggerFactory.getLogger(ViewAccountTransactionListService.class);

	/**
	 * @param accountNumber
	 * @return all transactions to this accountNumber
	 * @throws Exception
	 */
	public AccountTransactionInquiryResponse getAccountTransactions(
			AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO) throws CustomServiceUnavailableException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		AccountTransactionInquiryResponse response = new AccountTransactionInquiryResponse();
		AccountTransactionInquiryResponseAccountTransactionInquiryResponse accountTransactionInquiryResponse = new AccountTransactionInquiryResponseAccountTransactionInquiryResponse();
		try {

			AcctTrnsInqRq esb_AcctTrnsInqRq = new AcctTrnsInqRq();

			/*
			 * start fill Header
			 */
			esb_AcctTrnsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountTransactions.getValue()));

			/*
			 * Start filling ESB Request Body
			 */
			AcctTrnsInqRqBody rqBody = new AcctTrnsInqRqBody();
			AcctId acctId = new AcctId();
			acctId.setAcctNum(accountDetailsSearchCriteriaDTO.getAccountNumber());
			// acctId.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode()); nour el
			// sirisi said not mandatory
			rqBody.setAcctId(acctId);

			if (accountDetailsSearchCriteriaDTO.getFromDate() != null) {
				rqBody.setFromDt(accountDetailsSearchCriteriaDTO.getFromDate());

				if (accountDetailsSearchCriteriaDTO.getToDate() != null) {
					rqBody.setToDt(accountDetailsSearchCriteriaDTO.getToDate());
				} else {
					// set toDate = fromDate + 1
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dateFormat.parse(accountDetailsSearchCriteriaDTO.getFromDate()));
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					rqBody.setToDt(dateFormat.format(calendar.getTime()));
				}
			} else {
				accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.DATE_REQUIRED);
				accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.DATE_REQUIRED);
				response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
				return response;
			}

			if (GeneralUtil.isValidString(accountDetailsSearchCriteriaDTO.getFromAmount())) {
				 BigDecimal fromAmoutbd = new BigDecimal(Double.parseDouble(accountDetailsSearchCriteriaDTO.getFromAmount()), new MathContext(0));

				rqBody.setFromAmt(fromAmoutbd);
			}

			if (GeneralUtil.isValidString(accountDetailsSearchCriteriaDTO.getToAmount())) {
				 BigDecimal toAmoutbd = new BigDecimal(Double.parseDouble(accountDetailsSearchCriteriaDTO.getToAmount()), new MathContext(0));

				rqBody.setToAmt(toAmoutbd);
			}

			if (accountDetailsSearchCriteriaDTO.getTransactionRefNum() != null)
				rqBody.setTrnRefNum(accountDetailsSearchCriteriaDTO.getTransactionRefNum());

			if (accountDetailsSearchCriteriaDTO.getTransactionType() != null)
				rqBody.setTrnType(accountDetailsSearchCriteriaDTO.getTransactionType());

			RecCtrlIn recCtrlIn = new RecCtrlIn();
			recCtrlIn.setMaxRecs(accountDetailsSearchCriteriaDTO.getMaxRecords());
			recCtrlIn.setOffset(accountDetailsSearchCriteriaDTO.getOffset());
			rqBody.setRecCtrlIn(recCtrlIn);

			esb_AcctTrnsInqRq.setBody(rqBody);

			/*
			 * Start Calling JMS Service
			 */
			AcctTrnsInqRs esb_AcctTrnsInqRs = null;
			esb_AcctTrnsInqRs = (AcctTrnsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctTrnsInqRq,
					MQSendDestination.AcctTrnsInqRq.getValue(), MQReceiveDestination.AcctTrnsInqRs.getValue(),
					AcctTrnsInqRs.class);

//			esb_AcctTrnsInqRs = getAccountTransactionsMockResponse();

			/*
			 * fill swagger response
			 */
			if (esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				AcctTrnsInqRsBody rsBody = esb_AcctTrnsInqRs.getBody();
				if (rsBody != null) {

					if (rsBody.getRecCtrlOut() != null) {
						AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut recordCtrlOut = new AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut();
						recordCtrlOut.setMatchedRecords(rsBody.getRecCtrlOut().getMatchedRecs());
						recordCtrlOut.setSentRecords(rsBody.getRecCtrlOut().getSentRecs());
					}

					if (rsBody.getTrnsList() != null
							&& GeneralUtil.isListValid(rsBody.getTrnsList().getTrnInfoList())) {

						AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList transactionList = new AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList();

						List<TrnInfo> trnInfoList = rsBody.getTrnsList().getTrnInfoList();
						AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo model_TransactionInfo = null;

						for (TrnInfo esb_trnsInfo : trnInfoList) {
							model_TransactionInfo = new AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo();
							String channelDesc = inmaLOVService.getChannelDesc(esb_trnsInfo.getChanId(),userService.islocalLanguageEnglish());
							if(channelDesc != null)
								model_TransactionInfo.setChannelDesc(channelDesc);
							else
								model_TransactionInfo.setChannelDesc(esb_trnsInfo.getChanId());
							
							model_TransactionInfo.setDescription(GeneralUtil.listToString(esb_trnsInfo.getTrnNarr()));
							model_TransactionInfo.setMemo(GeneralUtil.listToString(esb_trnsInfo.getMemo()));
							String transactionCodeDesc =inmaLOVService.getTransactionCodeDesc(esb_trnsInfo.getTrnCode(),userService.islocalLanguageEnglish());
							if(transactionCodeDesc != null)
								model_TransactionInfo.setTransactionCodeDesc(transactionCodeDesc);
							else
								model_TransactionInfo.setTransactionCodeDesc(esb_trnsInfo.getTrnCode());

							if (esb_trnsInfo.getTrnDt() != null) {
								LocalDate transactionDate = LocalDate.parse(esb_trnsInfo.getTrnDt());
								model_TransactionInfo.setTransactionDate(transactionDate);
								if(esb_trnsInfo.getTrnTm() != null) {
									model_TransactionInfo.setTransactionDatetime(transactionDate.toString()+" "+esb_trnsInfo.getTrnTm());
								}
							}
							model_TransactionInfo.setTransactionRefNumber(esb_trnsInfo.getTrnRefNum());

							if (esb_trnsInfo.getCurAmt() != null) {
								String currency = inmaLOVService.getCurrencyDesc(esb_trnsInfo.getCurAmt().getCurCode(),userService.islocalLanguageEnglish());
								if(currency!=null)
									model_TransactionInfo.setAmountWithCurrency(esb_trnsInfo.getCurAmt().getAmt() + " " + currency);
								else
									model_TransactionInfo.setAmountWithCurrency(esb_trnsInfo.getCurAmt().getAmt()+" "+esb_trnsInfo.getCurAmt().getCurCode());

//							String lovRecDescType = filterLOVbyValue(esb_trnsInfo.getTrnCode(),LOVTypeEnum.TRANSACTION_CODE.getValue());
								trnType=esb_trnsInfo.getTrnType();
								if (TransactionType.CREDIT.getCode().equals(esb_trnsInfo.getTrnType())) {
									model_TransactionInfo.setCreditAmount(esb_trnsInfo.getCurAmt().getAmt());
								} else {
									model_TransactionInfo.setDebitAmount(esb_trnsInfo.getCurAmt().getAmt());
								}
							}
							transactionList.addTransactionInfoItem(model_TransactionInfo);
						}
						accountTransactionInquiryResponse.setTransactionList(transactionList);
						response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);

						accountTransactionInquiryResponse
								.setStatusCode(esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
						accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS);
						response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
						return response;
					} else {
						logger.info("there is body but no transaction list found - ESB Status Code "
								+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
						accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY);
						accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_BODY_EMPTY);
						response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
						return response;
					}
				} else {
					logger.info("Response Body Is Empty - ESB Status Code "
							+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
					accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND);
					accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_NO_BODY_FOUND);
					response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
					return response;
				}
			} else {
				logger.info(
						"ViewAccountTransactionsListService:getAccountTransactions -> something went wrong with code: "
								+ esb_AcctTrnsInqRs.getMsgRsHdr().getStatusCode());
				accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccountTransactions - Error : " + e);
			if (e instanceof NullPointerException) {
				accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
				return response;
			} else {
				accountTransactionInquiryResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				accountTransactionInquiryResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setAccountTransactionInquiryResponse(accountTransactionInquiryResponse);
				return response;
			}
		}
	}

	public AccountTransactionReportInquiryResponse exportTransactionReport(
			AccountDetailsSearchCriteriaDTO accountDetailsSearchCriteriaDTO) {

		AccountTransactionReportInquiryResponse accountTransactionReportInquiryResponse = new AccountTransactionReportInquiryResponse();
		AccountTransactionInquiryResponse accountTransactionInquiryResponse = new AccountTransactionInquiryResponse();
		String fileData = null;

		try {
			accountTransactionInquiryResponse = getAccountTransactions(accountDetailsSearchCriteriaDTO);
			AccountTransactionInquiryResponseAccountTransactionInquiryResponse transactionInquiryResponse = accountTransactionInquiryResponse
					.getAccountTransactionInquiryResponse();

			if (transactionInquiryResponse.getStatusCode().equals(ResponseStatusCode.JMS_NO_DATA)) {
				logger.info("getAccountTransactions has No data at JMS side");
				accountTransactionReportInquiryResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				accountTransactionReportInquiryResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				return accountTransactionReportInquiryResponse;
			} else if (transactionInquiryResponse.getStatusCode().equals(ResponseStatusCode.SYSTEM_ERROR)) {
				logger.info("getAccountTransactions has system failure");
				accountTransactionReportInquiryResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				accountTransactionReportInquiryResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				return accountTransactionReportInquiryResponse;
			} else if (transactionInquiryResponse.getStatusCode().equals(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY) || 
							transactionInquiryResponse.getStatusCode().equals(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND)){
				logger.info("getAccountTransactions has No Transaction List to generate report");
				accountTransactionReportInquiryResponse.setStatusCode(ResponseStatusCode.ACCOUNT_NUMBER_HAS_NO_TRANSACTION);
				accountTransactionReportInquiryResponse.setStatusDesc(ResponseStatusDesc.ACCOUNT_NUMBER_HAS_NO_TRANSACTION);
				return accountTransactionReportInquiryResponse;
			}else {
				logger.info("Surprise !!! there is a data retrieved and report generation under processing");
				AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionInfo = accountTransactionInquiryResponse
						.getAccountTransactionInquiryResponse().getTransactionList().getTransactionInfo().get(0);
				IBUser user = userService.getUser();
				String customerName=user.getCustomerName();
				String customerAddress = ( user.getUserAddress()!=null&&!user.getUserAddress().isEmpty())?user.getUserAddress():"";
				Date transactionDate = Date
						.from(transactionInfo.getTransactionDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
				logger.info("transactionInfo.getTransactionDate() : " + transactionInfo.getTransactionDate());
				String formatTransactionDate = new SimpleDateFormat("yyyy-MM-dd").format(transactionDate);
				logger.info("formatTransactionDate : " + formatTransactionDate);

				/*
				 * start calling vatInvoiceDetailsInquiry for this #transactionRefNumber
				 */
				VATInvoiceDtlsInqRs vatInvoiceDetailsInquiry = vatInvoiceDetailsInquiryESB(
						transactionInfo.getTransactionRefNumber(), formatTransactionDate);

				/*
				 * start calling report service
				 */
				fileData = generateTransactionReport(
						accountDetailsSearchCriteriaDTO.getAccountNumber(),
						accountDetailsSearchCriteriaDTO.getExtension(), transactionInfo, vatInvoiceDetailsInquiry,customerName,customerAddress);
				logger.info("return message: " + fileData);
				accountTransactionReportInquiryResponse.setReport(fileData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exportTransactionReport - Error : " + e);
			accountTransactionReportInquiryResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
			accountTransactionReportInquiryResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
			return accountTransactionReportInquiryResponse;
		}
		accountTransactionReportInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS);
		accountTransactionReportInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS);
		return accountTransactionReportInquiryResponse;
	}

	public VatInvoiceDetailsResponse vatInvoiceDetailsInquiry(String trnacationRefNum, String trnsactionDate) {

		VatInvoiceDetailsResponse response = new VatInvoiceDetailsResponse();
		VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs vatInvoiceDetailsInquiryRs = new VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs();

		try {

			/*
			 * Start filling ESB Request Body
			 */
		
			/*
			 * Start Calling JMS Service
			 */
			VATInvoiceDtlsInqRs vatInvoiceDtlsInqRs = vatInvoiceDetailsInquiryESB(trnacationRefNum, trnsactionDate);
		
			if (vatInvoiceDtlsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {

				if (vatInvoiceDtlsInqRs.getBody() != null) {
					VATInvoiceDtlsInqRsBody vatInvoiceDtlsInqRsBody = vatInvoiceDtlsInqRs.getBody();
					VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatInvoiceDetailsList = new VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList();
					if (GeneralUtil.isListValid(vatInvoiceDtlsInqRsBody.getInvoiceInfo())) {
						List<InvoiceInfo> invoiceInfoList = vatInvoiceDtlsInqRsBody.getInvoiceInfo();
						for (InvoiceInfo invoiceInfo : invoiceInfoList) {

							if (GeneralUtil.isListValid(invoiceInfo.getInvoiceItemInfo())) {

								List<InvoiceItemInfo> invoiceItemInfoList = invoiceInfo.getInvoiceItemInfo();
								VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo model_VatInvoiceDetailsInfo = null;

								for (InvoiceItemInfo invoiceItemInfo : invoiceItemInfoList) {
									model_VatInvoiceDetailsInfo = new VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo();
									model_VatInvoiceDetailsInfo.setValue1(invoiceInfo.getInvoiceNum());
									model_VatInvoiceDetailsInfo.setValue2(
											userService.islocalLanguageEnglish() ? invoiceItemInfo.getChargeDescEn()
													: invoiceItemInfo.getChargeDescAr() != null
															? invoiceItemInfo.getChargeDescAr()
															: "N/A");
									model_VatInvoiceDetailsInfo.setValue3(invoiceInfo.getTaxDt());
									model_VatInvoiceDetailsInfo
											.setValue4(String.valueOf(invoiceItemInfo.getChargeAmt()));
									model_VatInvoiceDetailsInfo.setValue5(String.valueOf(invoiceItemInfo.getTaxAmt()));
									model_VatInvoiceDetailsInfo.setValue6(invoiceItemInfo.getTaxPercen());

									vatInvoiceDetailsList.addVatInvoiceDetailsInfoItem(model_VatInvoiceDetailsInfo);
								}
							}
						}
						vatInvoiceDetailsInquiryRs.setVatInvoiceDetailsList(vatInvoiceDetailsList);
					} else {
						logger.info("There IS a Response But Body Is Empty "
								+ vatInvoiceDtlsInqRs.getMsgRsHdr().getStatusCode());
					}
				} else {
					logger.info(
							"There IS a Response But Body Is null" + vatInvoiceDtlsInqRs.getMsgRsHdr().getStatusCode());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccountTransactions - Error : " + e);
			if (e instanceof NullPointerException) {
				vatInvoiceDetailsInquiryRs.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				vatInvoiceDetailsInquiryRs.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				response.setVatInvoiceDetailsInquiryRs(vatInvoiceDetailsInquiryRs);
				return response;
			} else {
				vatInvoiceDetailsInquiryRs.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				vatInvoiceDetailsInquiryRs.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setVatInvoiceDetailsInquiryRs(vatInvoiceDetailsInquiryRs);
				return response;
			}
		}
		vatInvoiceDetailsInquiryRs.setStatusCode(ResponseStatusCode.SUCCESS);
		vatInvoiceDetailsInquiryRs.setStatusDesc(ResponseStatusDesc.SUCCESS);
		response.setVatInvoiceDetailsInquiryRs(vatInvoiceDetailsInquiryRs);
		return response;

	}


//	public AcctTrnsInqRs getAccountTransactionsMockResponse() {
//		AcctTrnsInqRs esbStatmtRes = null;
//		File file = new File(ViewAccountTransactionListService.class.getClassLoader()
//				.getResource("esbTransactionsResponseMock.xml").getFile());
//		try {
//			JAXBContext jaxbContext = JAXBContext.newInstance(AcctTrnsInqRs.class);
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			esbStatmtRes = (AcctTrnsInqRs) jaxbUnmarshaller.unmarshal(file);
//			System.out.println("response= " + esbStatmtRes.toString());
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		return esbStatmtRes;
//	}
//
//	private static String readLineByLineJava8(String filePath) {
//		StringBuilder contentBuilder = new StringBuilder();
//		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
//			stream.forEach(s -> contentBuilder.append(s).append("\n"));
//		} catch (java.io.IOException e) {
//			e.printStackTrace();
//		}
//		return contentBuilder.toString();
//	}
	public VATInvoiceDtlsInqRs vatInvoiceDetailsInquiryESB(String trnacationRefNum, String trnsactionDate) {
			/*
			 * Start filling ESB Request Body
			 */
			VATInvoiceDtlsInqRq vatInvoiceDtlsInqRq = new VATInvoiceDtlsInqRq();

			vatInvoiceDtlsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.vatInvoiceDetailsInquiry.getValue()));

			VATInvoiceDtlsInqRqBody vatInvoiceDtlsInqRqBody = new VATInvoiceDtlsInqRqBody();
			vatInvoiceDtlsInqRqBody.setTrnId(trnacationRefNum);
			vatInvoiceDtlsInqRqBody.setTaxDt(trnsactionDate);

			vatInvoiceDtlsInqRq.setBody(vatInvoiceDtlsInqRqBody);

			/*
			 * Start Calling JMS Service
			 */
			VATInvoiceDtlsInqRs vatInvoiceDtlsInqRs = null;
			vatInvoiceDtlsInqRs = (VATInvoiceDtlsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(
					vatInvoiceDtlsInqRq, MQSendDestination.VATInvoiceDtlsInqRq.getValue(),
					MQReceiveDestination.VATInvoiceDtlsInqRs.getValue(), VATInvoiceDtlsInqRs.class);

		return vatInvoiceDtlsInqRs;
		}
	
	public String generateTransactionReport(Long accountNumber, String extension, 
	AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionInfo,
	VATInvoiceDtlsInqRs vatInvoiceDetailsInquiry, String customerName, String customerAddress) throws IOException {
			try {
				ArrayList<ReportField> headerFields = new ArrayList<ReportField>();
				ArrayList<ReportField> reportFields = new ArrayList<ReportField>();
				ReportTitle 	reportTitle = new ReportTitle();
				reportTitle.setArabicTitle(messageSource.getMessage("navigationRule.ACCOUNTTRANSACTIONS_PAGE.transactionDetailsPrint",null,new Locale("ar")));
				reportTitle.setEnglishTitle(messageSource.getMessage("navigationRule.ACCOUNTTRANSACTIONS_PAGE.transactionDetailsPrint",null,new Locale("en")));
				
				//header fields
				
				/**************************************************** header fields ********************************************************************/
				
				ReportField reportFeild1=new ReportField();
				reportFeild1.setArabicLabel(messageSource.getMessage("VAT.labels.issueDate",null,new Locale("ar")));
				reportFeild1.setEnglishLabel(messageSource.getMessage("VAT.labels.issueDate",null,new Locale("en")));
				reportFeild1.setValue(transactionInfo.getTransactionDatetime());
				headerFields.add(reportFeild1);
				ReportField reportFeild2=new ReportField();
				reportFeild2.setArabicLabel(messageSource.getMessage("VAT.labels.clientName",null,new Locale("ar")));
				reportFeild2.setEnglishLabel(messageSource.getMessage("VAT.labels.clientName",null,new Locale("en")));
				reportFeild2.setValue(customerName);
				headerFields.add(reportFeild2);
				ReportField reportFeild3=new ReportField();
				reportFeild3.setArabicLabel(messageSource.getMessage("VAT.labels.address",null,new Locale("ar")));
				reportFeild3.setEnglishLabel(messageSource.getMessage("VAT.labels.address",null,new Locale("en")));
				reportFeild3.setValue(customerAddress);
				headerFields.add(reportFeild3);
				
				/****************************************************end of header fields********************************************************************/
				
			
				/**************************************************** report fields ************************************************************************/
				ReportField reportFeild4=new ReportField();
				reportFeild4.setArabicLabel(messageSource.getMessage("fundTransfer.labels.fromAccount",null,new Locale("ar")));
				reportFeild4.setEnglishLabel(messageSource.getMessage("fundTransfer.labels.fromAccount",null,new Locale("en")));
				reportFeild4.setValue(accountNumber+"");
				reportFields.add(reportFeild4);
//				reportFields.add(new ReportField("accountTransactions.label.date", accountTransactionDetail.getTransactionDateTime().getGregorianString()));
				ReportField reportFeild5=new ReportField();
				reportFeild5.setArabicLabel(messageSource.getMessage("accountTransactions.label.ref",null,new Locale("ar")));
				reportFeild5.setEnglishLabel(messageSource.getMessage("accountTransactions.label.ref",null,new Locale("en")));
				reportFeild5.setValue(transactionInfo.getTransactionRefNumber());
				reportFields.add(reportFeild5);
				
				ReportField reportFeild6=new ReportField();
				reportFeild6.setArabicLabel(messageSource.getMessage("accountTransactions.label.channel",null,new Locale("ar")));
				reportFeild6.setEnglishLabel(messageSource.getMessage("accountTransactions.label.channel",null,new Locale("en")));
				reportFeild6.setValue((transactionInfo.getChannelDesc()!=null&&!transactionInfo.getChannelDesc().isEmpty())?transactionInfo.getChannelDesc():"N/A");
				reportFields.add(reportFeild6);
				
				//TODO type
				ReportField reportFeild7=new ReportField();
				reportFeild7.setArabicLabel(messageSource.getMessage("accountTransactions.label.type",null,new Locale("ar")));
				reportFeild7.setEnglishLabel(messageSource.getMessage("accountTransactions.label.type",null,new Locale("en")));
				reportFeild7.setValue((transactionInfo.getTransactionCodeDesc()!=null&&!transactionInfo.getTransactionCodeDesc().isEmpty())?transactionInfo.getTransactionCodeDesc():"N/A");
				reportFields.add(reportFeild7);
				
				String debitAmount = "0", creditAmount = "0";
				if (transactionInfo.getDebitAmount()!=null&&TransactionType.DEBIT.getCode().equals(trnType)) {
					debitAmount = transactionInfo.getDebitAmount()+"";
				}else if (transactionInfo.getCreditAmount()!=null&&TransactionType.CREDIT.getCode().equals(trnType)){
					creditAmount = transactionInfo.getCreditAmount()+"";
				}
				ReportField reportFeild8=new ReportField();
				reportFeild8.setArabicLabel(messageSource.getMessage("accountTransactions.label.debit",null,new Locale("ar")));
				reportFeild8.setEnglishLabel(messageSource.getMessage("accountTransactions.label.debit",null,new Locale("en")));
				reportFeild8.setValue(debitAmount);
				reportFields.add(reportFeild8);
				
				ReportField reportFeild9=new ReportField();
				reportFeild9.setArabicLabel(messageSource.getMessage("accountTransactions.label.credit",null,new Locale("ar")));
				reportFeild9.setEnglishLabel(messageSource.getMessage("accountTransactions.label.credit",null,new Locale("en")));
				reportFeild9.setValue(creditAmount);
				reportFields.add(reportFeild9);
				
				ReportField reportFeild10=new ReportField();
				reportFeild10.setArabicLabel(messageSource.getMessage("accountTransactions.label.description",null,new Locale("ar")));
				reportFeild10.setEnglishLabel(messageSource.getMessage("accountTransactions.label.description",null,new Locale("en")));
				reportFeild10.setValue(transactionInfo.getDescription());
				reportFields.add(reportFeild10);
			
				ReportField reportFeild11=new ReportField();
				reportFeild11.setArabicLabel(messageSource.getMessage("accountTransactions.label.memo",null,new Locale("ar")));
				reportFeild11.setEnglishLabel(messageSource.getMessage("accountTransactions.label.memo",null,new Locale("en")));
				reportFeild11.setValue((transactionInfo.getMemo()!=null&&!transactionInfo.getMemo().isEmpty())?transactionInfo.getMemo():"N/A");
				
				reportFields.add(reportFeild11);
				
				/**************************************************** end report fields ************************************************************************/

				
				/**************************************************** table ************************************************************************/
			
			
			
				List<ReportRecord> recs = new ArrayList<ReportRecord>();
				if (vatInvoiceDetailsInquiry != null) {
					if (vatInvoiceDetailsInquiry.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {

						if (vatInvoiceDetailsInquiry.getBody() != null) {
							VATInvoiceDtlsInqRsBody vatInvoiceDtlsInqRsBody = vatInvoiceDetailsInquiry.getBody();

					List<InvoiceInfo> vatInvoiceInfoList = vatInvoiceDetailsInquiry.getBody().getInvoiceInfo();
					for (InvoiceInfo vatInvoiceInfo : vatInvoiceInfoList) {
						
						List<InvoiceItemInfo> invoiceItemList = vatInvoiceInfo.getInvoiceItemInfo();
						
						for (InvoiceItemInfo vatInvoiceItemInfo : invoiceItemList) {
							ReportRecord rec = new ReportRecord();
							rec.setArabicLabel1(messageSource.getMessage("VAT.labels.invoiceNumber",null,new Locale("ar")));
							rec.setEnglishLabel1(messageSource.getMessage("VAT.labels.invoiceNumber",null,new Locale("en")));
							rec.setValue1((vatInvoiceInfo.getInvoiceNum()!=null&&!vatInvoiceInfo.getInvoiceNum().isEmpty())?vatInvoiceInfo.getInvoiceNum():"N/A" );
							
							rec.setArabicLabel2(messageSource.getMessage("VAT.labels.chargeDescription",null,new Locale("ar")));
							rec.setEnglishLabel2(messageSource.getMessage("VAT.labels.chargeDescription",null,new Locale("en")));
							String description = userService.getCurLang().equalsIgnoreCase("ar")? vatInvoiceItemInfo.getChargeDescAr(): vatInvoiceItemInfo.getChargeDescEn();
							
							rec.setValue2((description!=null&&!description.isEmpty())?description:"N/A");
								
							rec.setArabicLabel3(messageSource.getMessage("VAT.labels.issueDate",null,new Locale("ar")));
							rec.setEnglishLabel3(messageSource.getMessage("VAT.labels.issueDate",null,new Locale("en")));
						
							rec.setValue3((vatInvoiceInfo.getTaxDt()!= null&&!vatInvoiceInfo.getTaxDt().isEmpty())? vatInvoiceInfo.getTaxDt():"N/A");
							
							rec.setArabicLabel4(messageSource.getMessage("VAT.labels.chargeAmount",null,new Locale("ar")));
							rec.setEnglishLabel4(messageSource.getMessage("VAT.labels.chargeAmount",null,new Locale("en")));
						
							rec.setValue4(vatInvoiceItemInfo.getChargeAmt()+"");
							
							rec.setArabicLabel5(messageSource.getMessage("VAT.labels.amount",null,new Locale("ar")));
							rec.setEnglishLabel5(messageSource.getMessage("VAT.labels.amount",null,new Locale("en")));
						
							rec.setValue5(vatInvoiceItemInfo.getTaxAmt()+"");
							
							rec.setArabicLabel6(messageSource.getMessage("VAT.labels.percentage",null,new Locale("ar")));
							rec.setEnglishLabel6(messageSource.getMessage("VAT.labels.percentage",null,new Locale("en")));
							rec.setValue6(vatInvoiceItemInfo.getTaxPercen() + " %");
							
							recs.add(rec);
						}
					}}
				}}

				/**************************************************** end table ************************************************************************/
					return	inmaReportService.prepareReport(recs, reportTitle, headerFields, reportFields,ReportFormat.getByCode(extension.toUpperCase()), "/reports/invoicePrintReport.jasper", "/reports/invoicePrintReport.jasper");
					} catch (JRException e) {
						e.printStackTrace();
						logger.error("return Error: " + e.getMessage());
						return null;

					} catch (ParserConfigurationException e) {
						e.printStackTrace();
						logger.error("return Error: " + e.getMessage());
						return null;

						} catch (IOException e) {
						e.printStackTrace();
						logger.error("return Error: " + e.getMessage());
					
						return null;
						}
		}
}
