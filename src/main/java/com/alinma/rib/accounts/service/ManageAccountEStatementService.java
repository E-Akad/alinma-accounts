package com.alinma.rib.accounts.service;

import java.util.UUID;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.response.AccountStatementSettingResponse;
import com.alinma.rib.accounts.model.response.AccountStatementSettingResponseUpdateAccountStatementSettingResponse;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.AcctId;
import com.alinma.rib.models.system.common.CustId;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.enums.AccountTypeEnum;
import com.alinma.rib.models.system.common.enums.ESBConstant;
import com.alinma.rib.models.system.common.enums.ESBConstant;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.LOVTypeEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.AcctMng27002000.AcctMngRq;
import com.alinma.rib.models.system.request.AcctMng27002000.AcctMngRqBody;
import com.alinma.rib.models.system.request.CustAccDtlsInq26011000.CustAcctDtlsInqRq;
import com.alinma.rib.models.system.request.CustAccDtlsInq26011000.CustAcctDtlsInqRqBody;
import com.alinma.rib.models.system.response.AcctMng27002000.AcctMngRs;
import com.alinma.rib.models.system.response.AcctMng27002000.AcctMngRsBody;
import com.alinma.rib.models.system.response.CustAccDtlsInq26011000.CustAcctDtlsInqRs;
import com.alinma.rib.models.system.response.CustAccDtlsInq26011000.CustAcctDtlsInqRsBody;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctDtls;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctInfo;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

@Service
public class ManageAccountEStatementService {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;
	
	@Autowired
	UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(ViewAccountsListService.class);

	public AccountStatementSettingResponse updateAccountStatementSetting(Long accountNumber) throws CustomServiceUnavailableException {

		AccountStatementSettingResponse response = new AccountStatementSettingResponse();

		AcctMngRq esb_Rq = new AcctMngRq();
		/*
		 * fill Header
		 */
		esb_Rq.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.UPDATE_ACCOUNT_STATEMENT_SETTING.getValue()));

		/*
		 * fill Body
		 */
		AcctMngRqBody esb_RqBody = new AcctMngRqBody();
		AcctId acctId = new AcctId();
		acctId.setAcctNum(accountNumber);
//		acctId.setAcctType(AccountTypeEnum.CURRENT_ACCOUNT.getCode());
		esb_RqBody.setAcctId(acctId);
		esb_RqBody.setStmtDeliveryOpt(ESBConstant.SERVICE_CHANNEL_IB.getValue());
		esb_Rq.setBody(esb_RqBody);
		/*
		 * fill JMS Service
		 */
		AcctMngRs esb_AcctMngRs = null;
		try {
			
			AccountStatementSettingResponseUpdateAccountStatementSettingResponse model_AccountStatementSettingResponse = new AccountStatementSettingResponseUpdateAccountStatementSettingResponse();
			/*
			 * call this function to validate if mail stopped already or not
			 * if #stmtDeliveryOpt = "IB" then mail stopped otherwise NOT stopped
			 */
			String stmtDeliveryOpt = getAccountWithoutBalance(accountNumber);
			
			if(stmtDeliveryOpt.equalsIgnoreCase(ESBConstant.SERVICE_CHANNEL_IB.getValue())) {
				model_AccountStatementSettingResponse.setStatusCode(ResponseStatusCode.MAIL_SERVICE_STOPPED);
				model_AccountStatementSettingResponse.setStatusDesc(ResponseStatusDesc.MAIL_SERVICE_STOPPED);
				response.setUpdateAccountStatementSettingResponse(model_AccountStatementSettingResponse);
				return response;
			}
			
			esb_AcctMngRs = (AcctMngRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_Rq,
					MQSendDestination.ACCT_MNG_RQ.getValue(), MQReceiveDestination.ACCT_MNG_RS.getValue(),
					AcctMngRs.class);

			/*
			 * start fill Model Response
			 */

			if (esb_AcctMngRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				AcctMngRsBody rsBody = esb_AcctMngRs.getBody();
				if (rsBody != null) {
					AcctId esb_AcctId = rsBody.getAcctId();
					if (esb_AcctId != null) {
						model_AccountStatementSettingResponse
								.setStatusCode(esb_AcctMngRs.getMsgRsHdr().getStatusCode());
						response.setUpdateAccountStatementSettingResponse(model_AccountStatementSettingResponse);
					} else {
						logger.info("no Account_id info returned");
					}
				} else {
					logger.info(
							"ManageAccountEStatementService:updateAccountStatementSetting No body returned with status code "
									+ esb_AcctMngRs.getMsgRsHdr().getStatusCode());
					model_AccountStatementSettingResponse.setStatusCode(esb_AcctMngRs.getMsgRsHdr().getStatusCode());
					model_AccountStatementSettingResponse.setStatusDesc("No body returned => Null");
				}
			} else {
				logger.info("esb_AcctMngRs.getMsgRsHdr().getStatusCode() Is Not Success");
				logger.info("esb_AcctMngRs : " + esb_AcctMngRs);
				model_AccountStatementSettingResponse.setStatusCode(esb_AcctMngRs.getMsgRsHdr().getStatusCode());
				model_AccountStatementSettingResponse.setStatusDesc("No body returned => Null");
				response.setUpdateAccountStatementSettingResponse(model_AccountStatementSettingResponse);
			}
		} catch (Exception e) {
			throw new CustomServiceUnavailableException("updateAccountStatementSetting has an Exception", e);
		}
		return response;
	}
	
	public String getAccountWithoutBalance(Long accountNumber) throws Exception {

		/*
		 * start mapping model Rq to esb Rq
		 */
		CustAcctDtlsInqRq esb_AcctsDtlsInqRq = new CustAcctDtlsInqRq();
		/*
		 * fill req Header
		 */
		esb_AcctsDtlsInqRq.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountWithoutBalance.getValue()));

		/*
		 * fill req Body
		 */
		CustAcctDtlsInqRqBody esb_RqBody = new CustAcctDtlsInqRqBody();
		AcctId acctId = new AcctId();
		acctId.setAcctNum(accountNumber);
		esb_RqBody.setAcctId(acctId);
		esb_AcctsDtlsInqRq.setBody(esb_RqBody);

		/*
		 * start Calling JMS Service
		 */
		String stmtDeliveryOpt = "";
		try {

			CustAcctDtlsInqRs response = (CustAcctDtlsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctsDtlsInqRq,
					MQSendDestination.CustAcctDtlsInqRq.getValue(), MQReceiveDestination.CustAcctDtlsInqRs.getValue(),
					CustAcctDtlsInqRs.class);
			/*
			 * start fill model response
			 */
			if (response.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustAcctDtlsInqRsBody rsBody = response.getBody();
				
				if(GeneralUtil.isValidString(rsBody.getStmtDeliveryOpt())) {
					stmtDeliveryOpt = rsBody.getStmtDeliveryOpt();
				}else {
					logger.info("there is body but no StmtDeliveryOpt found - ESB Status Code "
							+ response.getMsgRsHdr().getStatusCode());
				}
			} else {
				logger.info("getAccountWithoutBalance Response Body Is Empty - ESB Status Code " + response.getMsgRsHdr().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getDormantAccounts - Error : " + e);
			if (e instanceof NullPointerException) {
				throw new CustomServiceUnavailableException(ResponseStatusCode.JMS_NO_DATA,ResponseStatusDesc.JMS_ERROR_DESC, e);
			}else {
				throw new CustomServiceUnavailableException(ResponseStatusCode.SYSTEM_ERROR,ResponseStatusDesc.SYSTEM_ERROR_MSG, e);
			}
		}
		return stmtDeliveryOpt;
	}	

	
}
