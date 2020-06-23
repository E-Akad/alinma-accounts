package com.alinma.rib.accounts.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.response.CardsLightInquiryResponse;
import com.alinma.rib.accounts.model.response.CardsLightInquiryResponseCardsLightInquiryResponse;
import com.alinma.rib.accounts.model.response.CardsLightInquiryResponseCardsLightInquiryResponseCardsList;
import com.alinma.rib.accounts.model.response.CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.CardsInq16050300.CardsInqRq;
import com.alinma.rib.models.system.request.CardsInq16050300.CardsInqRqBody;
import com.alinma.rib.models.system.response.CardsInq16050300.CardInfo;
import com.alinma.rib.models.system.response.CardsInq16050300.CardsInqRs;
import com.alinma.rib.models.system.response.CardsInq16050300.CardsInqRsBody;
import com.alinma.rib.service.IInmaLOVService;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

@Service
public class ViewActiveCreditCardListService {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;
	@Autowired
	IInmaLOVService inmaLOVService;

	
	private static Logger logger = LoggerFactory.getLogger(ViewAccountTransactionListService.class);

	/**
	 * This Function will be in Sprint 3 according to Nour El-Sirisi
	 * 
	 * public void updateCardNickName() {
	 * 
	 * }
	 * 
	 */

	public CardsLightInquiryResponse getCardsLightInquiry() throws CustomServiceUnavailableException {

		CardsLightInquiryResponse response = new CardsLightInquiryResponse();
		CardsLightInquiryResponseCardsLightInquiryResponse cardsLightInquiryResponse = new CardsLightInquiryResponseCardsLightInquiryResponse();

		CardsInqRq esb_CardsInqRq = new CardsInqRq();
		esb_CardsInqRq.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.getCardsLightInquiry.getValue()));

		/*
		 * start filling Body
		 */
		CardsInqRqBody esb_RqBody = new CardsInqRqBody();
		esb_RqBody.setFuncId(FuncIdEnum.getCardsLightInquiry.getValue());
		esb_RqBody.setLnkdCIF(userService.getUserCifNumber());
		esb_CardsInqRq.setBody(esb_RqBody);
		/*
		 * start Calling JMS Service
		 */
		CardsInqRs esb_CardsInqRs = null;
		try {
			esb_CardsInqRs = (CardsInqRs) middlewareCommunicator
			.sendRequestAndRecieveResponse(esb_CardsInqRq,
			MQSendDestination.CardsInqRq.getValue(), MQReceiveDestination.CardsInqRs.getValue(),
			CardsInqRs.class);
			/*
			 * start fill model response
			 */
			if (esb_CardsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CardsInqRsBody rsBody = esb_CardsInqRs.getBody();
				if (rsBody.getCardsList() != null && GeneralUtil.isListValid(rsBody.getCardsList().getCardInfo())) {

					CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo model_CardInfo = null;
					CardsLightInquiryResponseCardsLightInquiryResponseCardsList responseCardsList = new CardsLightInquiryResponseCardsLightInquiryResponseCardsList();
					List<CardInfo> cardInfoList = rsBody.getCardsList().getCardInfo();
					for (CardInfo esb_cardInfo : cardInfoList) {
						model_CardInfo = new CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo();
						/* 
						 * check if card is Active
						 */
						boolean active = model_CardInfo.isActive(esb_cardInfo.getCardStatus());
						logger.info("active : "+active);
						if(active) {

							/*
							 * check if card is Credit Card
							 */
							boolean credit = model_CardInfo.isCredit(esb_cardInfo.getCardTypeId());
							logger.info("credit : "+credit);
							if(credit) {
								
								model_CardInfo.setCardClassId(esb_cardInfo.getCardClassId());
								model_CardInfo.setCardNickName(esb_cardInfo.getCardNickname());
								model_CardInfo.setCardNumber(esb_cardInfo.getCardNum() != null ? Long.parseLong(esb_cardInfo.getCardNum()) : 0);						
								if(esb_cardInfo.getCardStatus() != null) {
									String cardStatus = inmaLOVService.getCardStatusDesc(esb_cardInfo.getCardStatus(),userService.islocalLanguageEnglish());
									model_CardInfo.setCardStatus(cardStatus);
								}
								
								if(esb_cardInfo.getCardType() != null) {
									String cardType = inmaLOVService.getCardTypeDesc(esb_cardInfo.getCardType(),userService.islocalLanguageEnglish());
									model_CardInfo.setCardType(cardType);
								}
								
								if (esb_cardInfo.getExpDt() != null) {
									Instant instant = Instant.ofEpochMilli(esb_cardInfo.getExpDt().getTime());
									LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
									LocalDate localDate_ExpDt = localDateTime.toLocalDate();
									model_CardInfo.setExpiryDate(localDate_ExpDt);
								}
								
								if (esb_cardInfo.getIssueDt() != null) {
									Instant instant = Instant.ofEpochMilli(esb_cardInfo.getIssueDt().getTime());
									LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
									LocalDate localDate_IssueDt = localDateTime.toLocalDate();
									model_CardInfo.setIssueDate(localDate_IssueDt);
								}
								
								if (esb_cardInfo.getCardNum() != null && esb_cardInfo.getCardNum().length() > 0)
									model_CardInfo.setMaskedCardNumber(getMaskedCardNumber(Long.parseLong(esb_cardInfo.getCardNum())).toString());
								
								model_CardInfo.setIsPrimaryCard(esb_cardInfo.getIsPrimaryCard()); 
								
								responseCardsList.addCardInfoItem(model_CardInfo);
							}
						}
					}
					cardsLightInquiryResponse.setCardsList(responseCardsList);
					cardsLightInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS);
					cardsLightInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS);
					response.setCardsLightInquiryResponse(cardsLightInquiryResponse);
				} else {
					logger.info("List Is Empty");
					logger.info("there is body but no cards list found - ESB Status Code "+esb_CardsInqRs.getMsgRsHdr().getStatusCode());
					cardsLightInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY);
					cardsLightInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_BODY_EMPTY);
					response.setCardsLightInquiryResponse(cardsLightInquiryResponse);
				}
			} else {
				logger.info("Response Body Is Empty - ESB Status Code "+esb_CardsInqRs.getMsgRsHdr().getStatusCode());
				cardsLightInquiryResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND);
				cardsLightInquiryResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_NO_BODY_FOUND);
				response.setCardsLightInquiryResponse(cardsLightInquiryResponse);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccountTransactions - Error : " + e);
			if (e instanceof NullPointerException) {
				cardsLightInquiryResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				cardsLightInquiryResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				response.setCardsLightInquiryResponse(cardsLightInquiryResponse);
				return response;
			} else {
				cardsLightInquiryResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				cardsLightInquiryResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setCardsLightInquiryResponse(cardsLightInquiryResponse);
				return response;
			}
		}

		return response;
	}


	private Long getMaskedCardNumber(Long cardNum) {
		String cardNumber = String.valueOf(cardNum);
		if (cardNumber != null) {
			int len = cardNumber.length();
			String last_4_digitsOfAccNum = cardNumber.substring(len - 4, len);
			if(last_4_digitsOfAccNum.length() < 4)
				last_4_digitsOfAccNum = "0"+last_4_digitsOfAccNum.length();
			return Long.parseLong(last_4_digitsOfAccNum);
		} else {
			return 0L;
		}
	}


}
