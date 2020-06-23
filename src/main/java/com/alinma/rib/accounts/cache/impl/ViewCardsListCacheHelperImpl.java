package com.alinma.rib.accounts.cache.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.cache.ViewCardsListCacheHelper;
import com.alinma.rib.accounts.cache.model.CardModel;
import com.alinma.rib.accounts.nosql.NoSQLCardsList;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.system.common.CardInfoType;
import com.alinma.rib.models.system.common.enums.LOVTypeEnum;
import com.alinma.rib.models.system.request.LOVInquiry30020000.LovInquiryReqBody;
import com.alinma.rib.models.system.response.LOVInquiry30020000.LovInquiryRes;
import com.alinma.rib.models.system.response.cardsinq.CardsInqRsType;
import com.alinma.rib.service.IInmaLOVService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ViewCardsListCacheHelperImpl implements ViewCardsListCacheHelper {

	private final static Logger LOGGER = LoggerFactory.getLogger(ViewCardsListCacheHelperImpl.class);
	private static final DateTimeFormatter CARDS_INQ_DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private NoSQLCardsList noSQLCardsList;

	@Autowired
	private IInmaLOVService inmaLOVService;

	@Override
	public void cacheCards(List<CardModel> cardModels, String userCifNumber, String funcId, String lnkdAcctNum, String cardType) {
		try {
			noSQLCardsList.insertOrUpdateCards(cardModels, userCifNumber, funcId, lnkdAcctNum, cardType);
		} catch (JsonProcessingException | Model500InternalServererror e) {
			LOGGER.error("{}.cacheCards(...) : couldn't cache values", this.getClass().getName());
		}
	}

	@Override
	public List<CardModel> getCachedCards(String userCifNumber, String funcId, String lnkdAcctNum, String cardType) {
		try {
			return noSQLCardsList.getCards(userCifNumber, funcId, lnkdAcctNum, cardType);
		} catch (Model500InternalServererror | IOException e) {
			LOGGER.error("{}.getCachedCards(...) : couldn't get from cache", this.getClass().getName());
			return null;
		}
	}

	@Override
	public void mapCardsInqRsToCardModels(CardsInqRsType cardsInqRsType, List<CardModel> cardModels) {
		if (cardsInqRsType != null && cardsInqRsType.getBody() != null && cardsInqRsType.getBody().getCardsList() != null && cardsInqRsType.getBody().getCardsList().getCardInfo() != null) {
			for (CardInfoType cardInfo : cardsInqRsType.getBody().getCardsList().getCardInfo()) {
				CardModel cardModel = new CardModel();

				if (cardInfo.getCardNum() != null) {
					cardModel.setCardNumber(cardInfo.getCardNum());
					cardModel.setMaskedCardNumber(GeneralUtil.getMaskedCardNumber(cardInfo.getCardNum()));
				}
				cardModel.setCardType(cardInfo.getCardTypeId());
				LovInquiryRes lovInquiryRes = callLov(String.valueOf(LOVTypeEnum.CARD_TYPE.getValue()), cardInfo.getCardTypeId(), null, null, null);
				cardModel.setCardTypeDescEn(lovInquiryRes.getBody().getLOVList().getLOVInfo().get(0).getRecDesc());
				cardModel.setCardTypeDescAr(lovInquiryRes.getBody().getLOVList().getLOVInfo().get(0).getAttribute1());
				if (cardInfo.getCardNickname() != null) {
					cardModel.setCardNickName(cardInfo.getCardNickname());
				}
				if (cardInfo.getCardStatus() != null) {
					cardModel.setCardStatus(cardInfo.getCardStatus());
				}
				lovInquiryRes = callLov(String.valueOf(LOVTypeEnum.CARD_STATUS.getValue()), cardInfo.getCardStatus(), null, null, null);
				cardModel.setCardStatusDescEn(lovInquiryRes.getBody().getLOVList().getLOVInfo().get(0).getRecDesc());
				cardModel.setCardStatusDescAr(lovInquiryRes.getBody().getLOVList().getLOVInfo().get(0).getAttribute1());
				if (cardInfo.getExpDt() != null) {
					cardModel.setExpiryDate(Timestamp.valueOf(LocalDate.parse(cardInfo.getExpDt(), CARDS_INQ_DATETIME_FORMAT).atStartOfDay()));
				}
				if (cardInfo.getIssueDt() != null) {
					cardModel.setIssueDate(Timestamp.valueOf(LocalDate.parse(cardInfo.getIssueDt(), CARDS_INQ_DATETIME_FORMAT).atStartOfDay()));
				}
				cardModel.setLnkdAcctNum(cardInfo.getLnkdAcctNum());
				cardModel.setIsPrimaryCard(cardInfo.getIsPrimaryCard());

				cardModels.add(cardModel);
			}
		}
	}

	private LovInquiryRes callLov(String lovType, String lovCode1, String lovCode2, String lovCode3, String lovCode4) {
		LovInquiryReqBody lovRq = new LovInquiryReqBody();
		lovRq.setLOVType(lovType);
		lovRq.setLOVCode1(lovCode1);
		lovRq.setLOVCode2(lovCode2);
		lovRq.setLOVCode3(lovCode3);
		lovRq.setLOVCode4(lovCode4);
		return inmaLOVService.getInmaLOV(lovRq);
	}

}
