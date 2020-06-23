package com.alinma.rib.accounts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alinma.rib.accounts.model.request.CheckAccountNumRequest;
import com.alinma.rib.accounts.model.request.CheckAccountNumRq;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceResponse;
import com.alinma.rib.accounts.model.response.CheckAccountNumResponse;
import com.alinma.rib.accounts.model.system.request.CustAcctDtlsInqRqType;
import com.alinma.rib.accounts.model.system.response.CustAcctDtlsInqBodyRsType;
import com.alinma.rib.accounts.model.system.response.CustAcctDtlsInqRsType;
import com.alinma.rib.models.system.common.CustId;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.MsgRsHdr;
import com.alinma.rib.models.system.common.RecCtrlOut;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctDtls;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctInfo;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctsList;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.CustAcctsInqRs;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.CustAcctsInqRsBody;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;

/*
 *  Implementing BDD Style(behaviour) driven development)
 *  GIVEN WHEN THEN
*/
@RunWith(MockitoJUnitRunner.class)
//@RunWith(Parameterized.class) // to do 
@SpringBootTest
public class AccountWithBalanceServiceTest {
	
	@Autowired
	@InjectMocks
	ViewAccountsListService makeMoiPaymentService;

	
	@Mock
	private MiddlewareCommunicator middlewareCommunicatorMock;	
	@Autowired
	@InjectMocks
	CheckAccountNumberService checkAccountNumberService;
	
	CustAcctsInqRs custAcctsInqRs= new CustAcctsInqRs();
	CustAcctsInqRsBody CustAcctsInqRsBody = new CustAcctsInqRsBody();
	RecCtrlOut recCtrlOut = new RecCtrlOut();
	AcctsList acctsList = new AcctsList();
	List<AcctInfo> acctInfos = new ArrayList<AcctInfo>();
	AcctInfo acctInfo = new AcctInfo();  
	AcctDtls acctDtls = new AcctDtls();
	MsgRsHdr mrsHeader = new MsgRsHdr();
	CheckAccountNumRequest checkAccountNumRequest;
	public AccountWithBalanceServiceTest(){}
	
	@Before
	  public void setup(){

		acctDtls.setAcctCur("dfddfgfgg");
		acctDtls.setAcctNickname("mohamed");
		acctInfo.setAcctDtls(acctDtls);
		acctInfo.setAcctFuncsAccess("dddfdffg");
		acctInfo.setIsSubUsrEnabled("is sub");
		acctInfos.add(acctInfo);
		acctsList.setAcctInfo(acctInfos);
		recCtrlOut.setMatchedRecs(5);
		recCtrlOut.setSentRecs(4);
		CustAcctsInqRsBody.setRecCtrlOut(recCtrlOut);
		CustAcctsInqRsBody.setAcctsList(acctsList);
		
		
    	MsgRqHdr hdr =  new MsgRqHdr();
		// front-end request
		// check account
		checkAccountNumRequest = new CheckAccountNumRequest();
		CheckAccountNumRq checkAccountNumRq = new CheckAccountNumRq();
		checkAccountNumRq.setIBAN("12345");
		checkAccountNumRequest.setCheckAccountNumRq(checkAccountNumRq);
    	
    	
    //	UserNameAvailabilityRequestCustomerId customerId= new UserNameAvailabilityRequestCustomerId();
//    	customerId.setAlinmaId("00000103549");
//    	customerId.setCif("33040");
//    	
//		hdr = getMsgRqHdr(customerId.getCif(),customerId.getAlinmaId(),FuncIdEnum.getBillers.getValue());
//		
		
	}
    @Test
    public void getAccountWithBalanceTest() throws Exception{
    /********given*************/
		mrsHeader.setStatusCode(ESBStatusCode.SUCCESS.getValue());
		custAcctsInqRs.setMsgRsHdr(mrsHeader);
		
		//calling  mock  for jms instead of the real communicator object		
		given(middlewareCommunicatorMock.sendRequestAndRecieveResponse("", MQSendDestination.BillersInquiryReq.getValue(), MQReceiveDestination.BillersInquiryRes.getValue(), CustAcctsInqRs.class)).willReturn(custAcctsInqRs);
		

		
		//set the jmsRequest that will be sent to the mock
		AccountsWithBalanceResponse accountsWithBalanceResponse= new AccountsWithBalanceResponse();
		/*******when***********/
    	
		accountsWithBalanceResponse = makeMoiPaymentService.getAccountsWithBalance();
    	/**********then**********/ 
    	assertNotNull(accountsWithBalanceResponse);
    }
    
	private MsgRqHdr getMsgRqHdr(String cif, String alinmaId, String funcId) {
		MsgRqHdr hdr = new MsgRqHdr();
		hdr.setRqUID(UUID.randomUUID().toString());
		hdr.setSCId("IB"); 
		hdr.setFuncId(funcId);
		hdr.setCustLangPref("En");
		hdr.setTerminalId("10.0.2.1");
		hdr.setUsrId("10011495");
		CustId custId = new CustId();
		custId.setCIF(cif);
		custId.setAlinmaId(alinmaId);
		hdr.setCustId(custId);
		return hdr;
	}
	
	
	@Test
	public void checkAccountNumber() throws Exception {

		CheckAccountNumResponse checkAccountNumResponse = new CheckAccountNumResponse();
		CustAcctDtlsInqRsType esb_custAccDtls_res = new CustAcctDtlsInqRsType();
        
		mrsHeader.setStatusCode(ESBStatusCode.SUCCESS.getValue());
		esb_custAccDtls_res.setMsgRsHdr(mrsHeader);
		CustAcctDtlsInqBodyRsType body = new CustAcctDtlsInqBodyRsType();
		body.setAcctName("a_test");
		esb_custAccDtls_res.setBody(body);
		
		try { //
			Mockito.when(middlewareCommunicatorMock.sendRequestAndRecieveResponse(Mockito.isA(CustAcctDtlsInqRqType.class),
					Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(esb_custAccDtls_res);
			checkAccountNumResponse = checkAccountNumberService.checkAccountNumber(checkAccountNumRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" CheckAccountNumRs  " + checkAccountNumResponse.getCheckAccountNumRs()); // assertion
		assertNotNull(checkAccountNumResponse);
		assertEquals(checkAccountNumResponse.getCheckAccountNumRs().getStatusCode(), ESBStatusCode.SUCCESS.getValue());
	}

	@Test
	public void checkAccountNumberTestFailer() throws Exception {
		CheckAccountNumResponse checkAccountNumResponse = new CheckAccountNumResponse();
		CustAcctDtlsInqRsType esb_custAccDtls_res = new CustAcctDtlsInqRsType();
		mrsHeader.setStatusCode(ESBStatusCode.ERROR.getValue());
		esb_custAccDtls_res.setMsgRsHdr(mrsHeader); // body
		CustAcctDtlsInqBodyRsType body = new CustAcctDtlsInqBodyRsType();
		body.setAcctName("a_test");
		esb_custAccDtls_res.setBody(body);
		try { //
			Mockito.when(middlewareCommunicatorMock.sendRequestAndRecieveResponse(Mockito.isA(CustAcctDtlsInqRqType.class),
					Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(esb_custAccDtls_res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" CheckAccountNumRs  " + checkAccountNumResponse.getCheckAccountNumRs()); // assertion
		assertNotNull(checkAccountNumResponse);
		assertEquals(checkAccountNumResponse.getCheckAccountNumRs().getStatusCode(), ESBStatusCode.ERROR.getValue());

	}
    

}
