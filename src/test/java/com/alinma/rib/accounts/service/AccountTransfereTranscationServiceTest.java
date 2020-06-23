package com.alinma.rib.accounts.service;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.EmptyContentException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.request.AccountTransfereDTO;
import com.alinma.rib.accounts.model.response.AccountTransferTransactionsResponse;
import com.alinma.rib.models.TransactionSerialNumber;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.AcctId;
import com.alinma.rib.models.system.common.CustId;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.RecCtrlIn;
import com.alinma.rib.models.system.common.RecCtrlOut;
import com.alinma.rib.models.system.common.enums.ESBConstant;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.AcctTrnsInq52020000.AcctTrnsInqRq;
import com.alinma.rib.models.system.request.AcctTrnsInq52020000.AcctTrnsInqRqBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRs;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.AcctTrnsInqRsBody;
import com.alinma.rib.models.system.response.AcctTrnsInq52020000.TrnsList;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountTransfereTranscationServiceTest {

	@Mock
	private MiddlewareCommunicator middlewareCommunicator;

	@InjectMocks
	AccountTransfereService accountTransfereService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAccountTransactions() throws CustomServiceUnavailableException, ESBException, EmptyContentException, InputException {

		AccountTransfereDTO accountTransfereDto = new AccountTransfereDTO();
		accountTransfereDto.setAccountIndex(123123l);
		accountTransfereDto.setFromAmount(123.123);
		accountTransfereDto.setToAmount(444343.34);

		AcctTrnsInqRq esb_AcctTrnsInqRq = new AcctTrnsInqRq();
		MsgRqHdr msgRqHdr = new MsgRqHdr();
		msgRqHdr.setFuncId(FuncIdEnum.getAccountTransferTransactions.getValue());
		msgRqHdr.setSCId(ESBConstant.SERVICE_CHANNEL_IB.getValue());
		msgRqHdr.setUsrId("234234234");
		msgRqHdr.setRqUID("IB" + UUID.randomUUID().toString().replace("-", ""));
		CustId custId = new CustId();
		custId.setCIF("123123");
		custId.setAlinmaId("5555555");
		msgRqHdr.setCustId(custId);
		msgRqHdr.setEchoData(TransactionSerialNumber.getUniqueSerialNumber());
		msgRqHdr.setCustLangPref("en");
		esb_AcctTrnsInqRq.setMsgRqHdr(msgRqHdr);

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
			}
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
		recCtrlIn.setMaxRecs(2344);
		recCtrlIn.setOffset(3);
		rqBody.setRecCtrlIn(recCtrlIn);

		esb_AcctTrnsInqRq.setBody(rqBody);

		AcctTrnsInqRs esb_AcctTrnsInqRs = new AcctTrnsInqRs();
		AcctTrnsInqRsBody rsBody = new AcctTrnsInqRsBody();

		TrnsList tllist = new TrnsList();

		rsBody.setTrnsList(tllist);
		RecCtrlOut rectrlout = new RecCtrlOut();
		rectrlout.setMatchedRecs(122);
		rectrlout.setSentRecs(33);
		rsBody.setRecCtrlOut(rectrlout);
		esb_AcctTrnsInqRs.setBody(rsBody);

		Mockito.when(middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctTrnsInqRq, MQSendDestination.AcctTrnsInqRq.getValue(), MQReceiveDestination.AcctTrnsInqRs.getValue(), AcctTrnsInqRs.class)).thenReturn(esb_AcctTrnsInqRs);

		AccountTransferTransactionsResponse AccountTransferTransactionsResponse = accountTransfereService.getAccountTransactions(accountTransfereDto);
		assertNotNull(AccountTransferTransactionsResponse);
	}

}
