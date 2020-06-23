package com.alinma.rib.accounts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alinma.rib.accounts.model.response.AccountNicknameResponse;
import com.alinma.rib.accounts.model.response.AccountNicknameResponseUpdateAccountNicknameResponse;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo;
import com.alinma.rib.authentication.business.enums.StatusDesc;
import com.alinma.rib.models.system.common.AcctIdType;
import com.alinma.rib.models.system.common.CustId;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.MsgRqHdrType;
import com.alinma.rib.models.system.common.MsgRsHdr;
import com.alinma.rib.models.system.common.MsgRsHdrType;
import com.alinma.rib.models.system.common.enums.CardTypeEnum;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.request.CardsInq16050300.CardsInqRq;
import com.alinma.rib.models.system.request.CardsInq16050300.CardsInqRqBody;
import com.alinma.rib.models.system.request.acctmng.AcctMngBodyRqType;
import com.alinma.rib.models.system.request.acctmng.AcctMngRqType;
import com.alinma.rib.models.system.response.CardsInq16050300.CardInfo;
import com.alinma.rib.models.system.response.CardsInq16050300.CardsInqRs;
import com.alinma.rib.models.system.response.CardsInq16050300.CardsInqRsBody;
import com.alinma.rib.models.system.response.CardsInq16050300.CardsList;
import com.alinma.rib.models.system.response.acctmng.AcctMngBodyRsType;
import com.alinma.rib.models.system.response.acctmng.AcctMngRsType;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ViewAccountsListServiceTest {
	@Autowired
	@InjectMocks
	ViewAccountsListService viewAccountsListService;

	@Mock
	private MiddlewareCommunicator middlewareCommunicator;

	private String account_number;
	private String account_nickname;
	AcctMngRqType esb_acctMngRq;
	private MsgRqHdrType msgRqHdrType;
	private AcctMngBodyRqType esb_acctMngBodyRq;
	private AccountNicknameResponse accountNicknameResponse;

	private CardsInqRq esb_CardsInqRq;
	private CardsInqRs esb_CardsInqRs;
	private MsgRqHdr msgRqHdr;
	private CardsInqRqBody esb_RqBody;
	private MsgRsHdr msgRsHdr;
	private CardsInqRsBody cardsInqRsBody;

	@Autowired
	@Mock
	private UserService userService;

	@Before
	public void setup() {
		// front-end request
		account_number = "12345";
		account_nickname = "new nickname";

		// esb request
		// esb msg header
		msgRqHdrType = new MsgRqHdrType();
		msgRqHdrType.setFuncId(FuncIdEnum.updateAccountNames.getValue());

		// esb body
		AcctIdType acctIdType = new AcctIdType();
		acctIdType.setAcctNum(account_number);

	}

	@Test
	public void updateAccountNicknameTest() {
		// front-end response
		AccountNicknameResponse accountNicknameResponse = new AccountNicknameResponse();
		AccountNicknameResponseUpdateAccountNicknameResponse accountNicknameResponseUpdateAccountNicknameResponse = new AccountNicknameResponseUpdateAccountNicknameResponse();
		accountNicknameResponse.setUpdateAccountNicknameResponse(accountNicknameResponseUpdateAccountNicknameResponse);

		// esb response
		// esb msg header
		MsgRsHdr msgRsHdrType = new MsgRsHdr();
		msgRsHdrType.setStatusCode(ESBStatusCode.SUCCESS.getValue());

		AcctIdType acctIdType = new AcctIdType();
		acctIdType.setAcctNum(account_number);
		AcctMngBodyRsType acctMngBodyRsType = new AcctMngBodyRsType();
		acctMngBodyRsType.setAcctId(acctIdType);

		AcctMngRsType esb_acctMngRs = new AcctMngRsType();
		esb_acctMngRs.setMsgRsHdr(msgRsHdrType);
		esb_acctMngRs.setBody(acctMngBodyRsType);

		// test update nick-name service
		try {
			// mock middlewareCommunicatorMock
			System.out.println(middlewareCommunicator);
			Mockito.when(middlewareCommunicator.sendRequestAndRecieveResponse(Mockito.isA(AcctMngRqType.class),
					Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(esb_acctMngRs);

			accountNicknameResponse = viewAccountsListService.updateAccountNickname(account_number, account_nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// assertion
		assertNotNull(accountNicknameResponse);
		assertEquals(accountNicknameResponse.getUpdateAccountNicknameResponse().getStatusCode(),
				ESBStatusCode.SUCCESS.getValue());
		assertEquals(accountNicknameResponse.getUpdateAccountNicknameResponse().getStatusDesc(),
				StatusDesc.SUCCESS.getDesc());
	}

	@Test
	public void testRetrieveAllCardAndLinkedThemWithEachAccount() {
		esb_CardsInqRs = new CardsInqRs();
		msgRsHdr = new MsgRsHdr();
		msgRsHdr.setStatusCode(ESBStatusCode.SUCCESS.getValue());
		esb_CardsInqRs.setMsgRsHdr(msgRsHdr);

		cardsInqRsBody = new CardsInqRsBody();
		CardsList cardsList = new CardsList();
		List<CardInfo> cardInfoListMock = new ArrayList<CardInfo>();

		CardInfo cardInfo = new CardInfo();
		cardInfo.setCardClassId("ClassId123");
		cardInfo.setCardNickname("NickNameTest");
		cardInfo.setCardNum("102030");
		cardInfo.setCardStatus("StatusSuccess");
		cardInfo.setCardType("CardTypeDebit");
		cardInfo.setLnkdAcctNum("787878");

		Calendar calendar = Calendar.getInstance();
		cardInfo.setExpDt(calendar.getTime());
		cardInfo.setIssueDt(calendar.getTime());

		CardInfo cardInfo2 = new CardInfo();
		cardInfo2.setCardClassId("ClassId123");
		cardInfo2.setCardNickname("NickNameTest");
		cardInfo2.setCardNum("405060");
		cardInfo2.setCardStatus("StatusSuccess");
		cardInfo2.setCardType("CardTypeDebit");
		cardInfo2.setLnkdAcctNum("787878");

		cardInfo2.setExpDt(calendar.getTime());
		cardInfo2.setIssueDt(calendar.getTime());

		CardInfo cardInfo3 = new CardInfo();
		cardInfo3.setCardClassId("ClassId123");
		cardInfo3.setCardNickname("NickNameTest");
		cardInfo3.setCardNum("708090");
		cardInfo3.setCardStatus("StatusSuccess");
		cardInfo3.setCardType("CardTypeDebit");
		cardInfo3.setLnkdAcctNum("898989");

		cardInfo3.setExpDt(calendar.getTime());
		cardInfo3.setIssueDt(calendar.getTime());

		cardInfoListMock.add(cardInfo);
		cardInfoListMock.add(cardInfo2);
		cardInfoListMock.add(cardInfo3);

		cardsList.setCardInfo(cardInfoListMock);
		cardsInqRsBody.setCardsList(cardsList);
		esb_CardsInqRs.setBody(cardsInqRsBody);
		try {
			Mockito.when(middlewareCommunicator.sendRequestAndRecieveResponse(Mockito.isA(CardsInqRq.class),
					Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(esb_CardsInqRs);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList resList = viewAccountsListService
//				.retrieveAllCardAndLinkedThemWithEachAccount(getAccountInfoList());
//		Assert.assertNotNull(resList);
//		Assert.assertEquals(2, resList.getAccountInfo().size());
//		for (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo account_info : resList
//				.getAccountInfo()) {
//			if (account_info.getAccountNumber() ==  Long.valueOf("898989")) {
//				Assert.assertEquals(1, account_info.getCardList().getCardInfo().size());
//			} else if (account_info.getAccountNumber() == Long.valueOf("787878")) {
//				// Assert.assertNull(account_info.getCardList());
//				Assert.assertEquals(2, account_info.getCardList().getCardInfo().size());
//			}
//		}
	}

	private AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList getAccountInfoList() {
		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList();
		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo model_accountInfo = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo();
		model_accountInfo.setAccountNumber(Long.getLong("898989"));
		model_accountInfo.setAccountType("DA");
		// nick name will be concatenated with IBAN
		model_accountInfo.setAccountNickName("68200032420000");
		model_accountInfo.setAccountStatus("0");
		model_accountInfo.setAvailableBalance("18000284950.35");
		model_accountInfo.setCurrency("SAR");
		model_accountInfo.setIban("SA3405000068200032420000");

		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo model_accountInfo2 = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo();
		model_accountInfo2.setAccountNumber(Long.getLong("787878"));
		model_accountInfo2.setAccountType("DA");
		// nick name will be concatenated with IBAN
		model_accountInfo2.setAccountNickName("68200032420000");
		model_accountInfo2.setAccountStatus("0");
		model_accountInfo2.setAvailableBalance("18000284950.35");
		model_accountInfo2.setCurrency("SAR");
		model_accountInfo2.setIban("SA3405000068200032420000");
		accountsList.addAccountInfoItem(model_accountInfo);
		accountsList.addAccountInfoItem(model_accountInfo2);

		return accountsList;

	}
}