package com.alinma.rib.accounts.cache;

import java.util.List;

import com.alinma.rib.accounts.cache.model.CardModel;
import com.alinma.rib.models.system.response.cardsinq.CardsInqRsType;

public interface ViewCardsListCacheHelper {

	List<CardModel> getCachedCards(String userCifNumber, String funcId, String lnkdAcctNum, String cardType);

	void cacheCards(List<CardModel> cardModels, String userCifNumber, String funcId, String lnkdAcctNum, String cardType);

	void mapCardsInqRsToCardModels(CardsInqRsType cardsInqRsType, List<CardModel> cardModels);
}
