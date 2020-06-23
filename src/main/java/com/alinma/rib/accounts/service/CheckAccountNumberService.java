package com.alinma.rib.accounts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.AcctIdType;
import com.alinma.rib.accounts.model.request.CheckAccountNumRequest;
import com.alinma.rib.accounts.model.response.CheckAccountNumResponse;
import com.alinma.rib.accounts.model.response.CheckAccountNumRs;
import com.alinma.rib.accounts.model.system.request.CustAcctDtlsInqBodyRqType;
import com.alinma.rib.accounts.model.system.request.CustAcctDtlsInqRqType;
import com.alinma.rib.accounts.model.system.response.CustAcctDtlsInqRsType;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

@Service
public class CheckAccountNumberService {
	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;

	private static Logger logger = LoggerFactory.getLogger(ViewAccountsListService.class);

	public CheckAccountNumResponse checkAccountNumber(CheckAccountNumRequest checkAccountNumRequest) throws Exception {
		CheckAccountNumResponse checkAccountNumResponse = new CheckAccountNumResponse();
		// esb request
		// esb msg header
		CustAcctDtlsInqRqType esb_custAccDtls_req = new CustAcctDtlsInqRqType();
		esb_custAccDtls_req.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.CHECK_ACCOUNT_NUMBER.getValue()));

		// esb body
		CustAcctDtlsInqBodyRqType custAcctDtlsInqBodyRqType = new CustAcctDtlsInqBodyRqType();

		if (checkAccountNumRequest.getCheckAccountNumRq().getAccountNumber() != null) {
			AcctIdType acctIdType = new AcctIdType();
			acctIdType.setAcctNum(String.valueOf(checkAccountNumRequest.getCheckAccountNumRq().getAccountNumber()));
			custAcctDtlsInqBodyRqType.setAcctId(acctIdType);
		}

		if (checkAccountNumRequest.getCheckAccountNumRq().getIBAN() != null) {
			custAcctDtlsInqBodyRqType.setIBAN(checkAccountNumRequest.getCheckAccountNumRq().getIBAN());
		}
		esb_custAccDtls_req.setBody(custAcctDtlsInqBodyRqType);
		// esb response
		CustAcctDtlsInqRsType esb_custAccDtls_res = new CustAcctDtlsInqRsType();

		try {
			// esb call
			esb_custAccDtls_res = (CustAcctDtlsInqRsType) middlewareCommunicator.sendRequestAndRecieveResponse(esb_custAccDtls_req, MQSendDestination.CUST_ACCT_DTLS_INQ_RQ.getValue(), MQReceiveDestination.CUST_ACCT_DTLS_INQ_RS.getValue(), CustAcctDtlsInqRsType.class);
			// Resource resource = new
			// ClassPathResource("response/CustAcctDtlsInqRs.xml");
			// File xmlFile = resource.getFile();
			// JAXBContext jaxbContext =
			// JAXBContext.newInstance(CustAcctDtlsInqRsType.class);
			// Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// esb_custAccDtls_res = (CustAcctDtlsInqRsType)
			// jaxbUnmarshaller.unmarshal(xmlFile);
			// logger.info("esb_custAccDtls_res : " + esb_custAccDtls_res);
			CheckAccountNumRs CheckAccountNumResponse = new CheckAccountNumRs();
			// map esb response to front-end response
			if (esb_custAccDtls_res != null && esb_custAccDtls_res.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CheckAccountNumResponse.setStatusCode(esb_custAccDtls_res.getMsgRsHdr().getStatusCode());
				CheckAccountNumResponse.setAccountName(esb_custAccDtls_res.getBody().getAcctName());
				checkAccountNumResponse.setCheckAccountNumRs(CheckAccountNumResponse);

				// will add some values here tha will be returned from nosql TODO
				// checkAccountNumResponse.setStatusDesc(StatusDesc.SUCCESS.getDesc());
			} else if (esb_custAccDtls_res != null && esb_custAccDtls_res.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.ERROR.getValue())) {
				CheckAccountNumResponse.setBmsErrorShow(true);
				CheckAccountNumResponse.setStatusCode(esb_custAccDtls_res.getMsgRsHdr().getStatusCode());
				// CheckAccountNumResponse.setAccountName(esb_custAccDtls_res.getBody().getAcctName());
				checkAccountNumResponse.setCheckAccountNumRs(CheckAccountNumResponse);
				logger.info("checkAccountNumResponse.getMsgRsHdr().getStatusCode() Is Not Success");
			} else {
				CheckAccountNumResponse.setStatusCode(esb_custAccDtls_res.getMsgRsHdr().getStatusCode());
				checkAccountNumResponse.setCheckAccountNumRs(CheckAccountNumResponse);
				logger.info("checkAccountNumResponse.getMsgRsHdr().getStatusCode() Is Not Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Model500InternalServererror("500", "checkAccountNumResponse Exception", e.getMessage());
		}
		return checkAccountNumResponse;
	}
}
