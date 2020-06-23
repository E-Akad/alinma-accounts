package com.alinma.rib.accounts.service;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.cache.ViewCardsListCacheHelper;
import com.alinma.rib.accounts.cache.model.CardModel;
import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.EmptyContentException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.response.AccountInfo;
import com.alinma.rib.accounts.model.response.AccountNicknameResponse;
import com.alinma.rib.accounts.model.response.AccountNicknameResponseUpdateAccountNicknameResponse;
import com.alinma.rib.accounts.model.response.AccountsList;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponse;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo;
import com.alinma.rib.accounts.model.response.AccountsWithBalanceResponse;
import com.alinma.rib.accounts.model.response.CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo;
import com.alinma.rib.accounts.model.response.CustomerAccountsInquiryResponse;
import com.alinma.rib.accounts.model.response.CustomerDepositResponse;
import com.alinma.rib.accounts.model.response.CustomerDepositResponseCustomerDepositResponse;
import com.alinma.rib.accounts.model.response.CustomerDepositResponseCustomerDepositResponseInvestmentAccountList;
import com.alinma.rib.accounts.model.response.CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo;
import com.alinma.rib.accounts.model.response.HasDormantAccountResponse;
import com.alinma.rib.accounts.model.response.HasDormantAccountRs;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.models.business.ResponseStatusCode;
import com.alinma.rib.models.business.ResponseStatusDesc;
import com.alinma.rib.models.business.common.Model500InternalServererror;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;
import com.alinma.rib.models.system.common.AcctIdType;
import com.alinma.rib.models.system.common.CustId;
import com.alinma.rib.models.system.common.CustIdType;
import com.alinma.rib.models.system.common.MsgRqHdrType;
import com.alinma.rib.models.system.common.enums.AccountTypeEnum;
import com.alinma.rib.models.system.common.enums.CardStatusEnum;
import com.alinma.rib.models.system.common.enums.CardTypeEnum;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.CustAcctsInq26021000.CustAcctsInqRq;
import com.alinma.rib.models.system.request.CustAcctsInq26021000.CustAcctsInqRqBody;
import com.alinma.rib.models.system.request.CustDepsInq44100000.CustDepsInqRq;
import com.alinma.rib.models.system.request.acctmng.AcctMngBodyRqType;
import com.alinma.rib.models.system.request.acctmng.AcctMngRqType;
import com.alinma.rib.models.system.request.cardsinq.CardsInqBodyRqType;
import com.alinma.rib.models.system.request.cardsinq.CardsInqRqType;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctDtls;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.AcctInfo;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.CustAcctsInqRs;
import com.alinma.rib.models.system.response.CustAcctsInq26021000.CustAcctsInqRsBody;
import com.alinma.rib.models.system.response.CustDepsInq44100000.CustDepsInqRs;
import com.alinma.rib.models.system.response.CustDepsInq44100000.CustDepsInqRsBody;
import com.alinma.rib.models.system.response.CustDepsInq44100000.DepInfo;
import com.alinma.rib.models.system.response.LOVInquiry30020000.LovInquiryRes;
import com.alinma.rib.models.system.response.acctmng.AcctMngRsType;
import com.alinma.rib.models.system.response.cardsinq.CardsInqRsType;
import com.alinma.rib.service.IInmaLOVService;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;

@Service
public class ViewAccountsListService {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("errorMsg")
	MessageSource errorMessageSource;

	@Autowired
	IInmaLOVService inmaLOVService;
	
	@Autowired
	ViewCardsListCacheHelper viewCardsListCacheHelper;
	
	private static Logger logger = LoggerFactory.getLogger(ViewAccountsListService.class);

	public AccountsWithBalanceAndCardsResponse getAccountsWithBalanceAndCards()
			throws CustomServiceUnavailableException {

		AccountsWithBalanceAndCardsResponse response = new AccountsWithBalanceAndCardsResponse();
		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsWithBalanceResponse = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse();

		/*
		 * start mapping model Rq to esb Rq
		 */
		CustAcctsInqRq esb_AcctsInqRq = new CustAcctsInqRq();
		/*
		 * fill req Header
		 */
		esb_AcctsInqRq
				.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountsWithBalance.getValue()));

		/*
		 * fill req Body
		 */
		CustAcctsInqRqBody esb_RqBody = new CustAcctsInqRqBody();
		esb_RqBody.setFuncId(FuncIdEnum.getAccountsWithBalance.getValue());
		esb_RqBody.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode());
		esb_RqBody.setCIF(userService.getUserCifNumber());
		esb_RqBody.setUsrId(userService.getUserId());
		esb_AcctsInqRq.setBody(esb_RqBody);

		/*
		 * start Calling JMS Service
		 */
		CustAcctsInqRs esb_AcctsInqRs = null;
		try {
			esb_AcctsInqRs = (CustAcctsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctsInqRq,
					MQSendDestination.CustAcctsInqRq.getValue(), MQReceiveDestination.CustAcctsInqRs.getValue(),
					CustAcctsInqRs.class);

			logger.info("esb_AcctsInqRs: " + esb_AcctsInqRs);
			/*
			 * start fill model response
			 */
			if (esb_AcctsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustAcctsInqRsBody rsBody = esb_AcctsInqRs.getBody();
				if (rsBody.getAcctsList() != null && GeneralUtil.isListValid(rsBody.getAcctsList().getAcctInfo())) {

					List<AcctInfo> esb_acctInfoList = rsBody.getAcctsList().getAcctInfo();
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList();
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo model_accountInfo = null;

					for (AcctInfo esb_accountInfo : esb_acctInfoList) {

						AcctDtls esb_acctDtls = esb_accountInfo.getAcctDtls();
						if (esb_acctDtls != null) {
							model_accountInfo = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo();
							if (esb_acctDtls.getAcctId() != null) {
								Long acctNum = esb_acctDtls.getAcctId().getAcctNum();
								model_accountInfo.setAccountNumber(acctNum != null ? acctNum : 0L);
								
								String accountType = accountTypeBothLang(esb_acctDtls.getAcctId().getAcctType());
								model_accountInfo.setAccountType(accountType);
							
							}

							model_accountInfo.setAccountNickName(esb_acctDtls.getAcctNickname());
							model_accountInfo.setAccountStatus(inmaLOVService.getAccountStatusDesc(esb_acctDtls.getAcctStatus(),userService.islocalLanguageEnglish()));
							String availBalance = getAvailableBalance(esb_acctDtls.getAvailBal());
							model_accountInfo.setAvailableBalance(availBalance);
							model_accountInfo.setCurrency(inmaLOVService.getCurrencyDesc(esb_acctDtls.getAcctCur(),userService.islocalLanguageEnglish()));
							model_accountInfo.setIban(esb_acctDtls.getIBAN());
							model_accountInfo.setDormant(Boolean.FALSE);
							accountsList.addAccountInfoItem(model_accountInfo);
						}

					}

					/*
					 * retrieve all cards and link them with each account
					 */
					List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> model_cardsLightInquiry = getCardsLightInquiry();
					Map<Long, List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo>> linkedCardsMap = getLinkedCards(
							model_cardsLightInquiry);
					List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo> accountInfoList = accountsList
							.getAccountInfo();
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList model_AccountInfoCardList = null;
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo model_CardInfo = null;
					List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo> cardInfoList = null;
					for (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo model_AccountInfo : accountInfoList) {
						if (linkedCardsMap != null && !linkedCardsMap.isEmpty()) {
							List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> cardsList = linkedCardsMap
									.get(model_AccountInfo.getAccountNumber());
							logger.info(
									"model_AccountInfo.getAccountNumber() : " + model_AccountInfo.getAccountNumber());
							if (cardsList != null && !cardsList.isEmpty()) {
								logger.info("cardsList Size : " + cardsList.size());
								cardInfoList = new ArrayList<>();
								for (CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo model_Card : cardsList) {
									model_CardInfo = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo();
									model_CardInfo.setCardNumber(model_Card.getCardNumber());
									model_CardInfo.setMaskedCardNumber(model_Card.getMaskedCardNumber());
									model_CardInfo.setImagesPath(model_Card.getCardClassId());
									cardInfoList.add(model_CardInfo);
								}
								model_AccountInfoCardList = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList();
								model_AccountInfoCardList.setCardInfo(cardInfoList);
								model_AccountInfo.setCardCount(String.valueOf(cardInfoList.size()));
								model_AccountInfo.setCardList(model_AccountInfoCardList);
							} else {
								logger.info("cardsList Is Null or Empty");
							}
						} else {
							logger.info("linkedCardsMap Is Null or Empty");
						}
					}

					/*
					 * retrieve list of dormant account then add it to the hash for merging with
					 * active accounts
					 */
					logger.info("start call getDormantAccounts()");
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList dormantAccountsList = getDormantAccounts();
					if (dormantAccountsList != null && GeneralUtil.isListValid(dormantAccountsList.getAccountInfo())) {
						/*
						 * create hashSet as a container for both active and dormant account then start
						 * add active one to it
						 */
						Set<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo> allAccountsHshSet = new HashSet<>();
						allAccountsHshSet.addAll(accountsList.getAccountInfo());

						/*
						 * add dormant accounts to hashSet
						 */
						allAccountsHshSet.addAll(dormantAccountsList.getAccountInfo());

						AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList allAccountsList = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList();
						allAccountsList.setAccountInfo(new ArrayList<>(allAccountsHshSet));
						accountsWithBalanceResponse.setAccountsList(allAccountsList);
					} else {
						/*
						 * No dormant accounts found to this user
						 */
						accountsWithBalanceResponse.setAccountsList(accountsList);
					}
					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS);
					accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS);
					response.setAccountsWithBalanceAndCardsResponse(accountsWithBalanceResponse);
				} else {
					logger.info("there is body but no accounts list found - ESB Status Code "
							+ esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY);
					accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_BODY_EMPTY);
					response.setAccountsWithBalanceAndCardsResponse(accountsWithBalanceResponse);
				}
			} else {
				logger.info("Response Body Is Empty - ESB Status Code " + esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_NO_BODY_FOUND);
				response.setAccountsWithBalanceAndCardsResponse(accountsWithBalanceResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccountsWithBalance - Error : " + e);
			if (e instanceof NullPointerException) {
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				response.setAccountsWithBalanceAndCardsResponse(accountsWithBalanceResponse);
				return response;
			} else {
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setAccountsWithBalanceAndCardsResponse(accountsWithBalanceResponse);
				return response;
			}
		}
		return response;
	}

	public CustomerDepositResponse customerDeposistsInquiry() throws CustomServiceUnavailableException {

		CustomerDepositResponse model_Response = new CustomerDepositResponse();
		/*
		 * start mapping model Rq to esb Rq
		 */
		CustDepsInqRq esb_CustDepsInqRq = new CustDepsInqRq();
		esb_CustDepsInqRq.setMsgRqHdr(
				middlewareCommunicator.createRequestHeader(FuncIdEnum.customerDeposistsInquiry.getValue()));

		/*
		 * start Calling JMS Service
		 */
		CustDepsInqRs esb_CustDepsInqRs = null;
		try {
			esb_CustDepsInqRs = (CustDepsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_CustDepsInqRq,
					MQSendDestination.CustDepsInqRq.getValue(), MQReceiveDestination.CustDepsInqRs.getValue(),
					CustDepsInqRs.class);
			/*
			 * start fill model response
			 */
			if (esb_CustDepsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustDepsInqRsBody rsBody = esb_CustDepsInqRs.getBody();
				if (rsBody.getDepsList() != null && GeneralUtil.isListValid(rsBody.getDepsList().getDepInfo())) {

					List<DepInfo> esb_DepInfoList = rsBody.getDepsList().getDepInfo();
					CustomerDepositResponseCustomerDepositResponseInvestmentAccountList model_AccountList = new CustomerDepositResponseCustomerDepositResponseInvestmentAccountList();
					CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo model_AccountInfo = null;
					for (DepInfo esb_DepInfo : esb_DepInfoList) {
						model_AccountInfo = new CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo();
						if (esb_DepInfo.getAccruedProfitCurAmt() != null)
							model_AccountInfo
									.setProfitRealized(Double.toString(esb_DepInfo.getAccruedProfitCurAmt().getAmt()));

						model_AccountInfo.setStatus(esb_DepInfo.getStatus());

						if (esb_DepInfo.getProfitRate() != 0)
							model_AccountInfo.setAntRate(Double.toString(esb_DepInfo.getProfitRate()));

						if (esb_DepInfo.getPrincipleCurAmt() != null) {
							model_AccountInfo.setMainInvAmount(esb_DepInfo.getPrincipleCurAmt().getAmt() + " "
									+ esb_DepInfo.getPrincipleCurAmt().getCurCode());
						}

						model_AccountInfo.setSubPeriod(inmaLOVService.getDepositPeriodDesc(esb_DepInfo.getPeriod() + "",userService.islocalLanguageEnglish()));

						if (esb_DepInfo.getMatDt() != null) {
							Instant instant = Instant.ofEpochMilli(esb_DepInfo.getMatDt().getTime());
							LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
							LocalDate localDate_MatDt = localDateTime.toLocalDate();
							model_AccountInfo.setSubEndDate(localDate_MatDt);
						}

						if (esb_DepInfo.getValDt() != null) {
							Instant instant = Instant.ofEpochMilli(esb_DepInfo.getValDt().getTime());
							LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
							LocalDate localDate_ValDt = localDateTime.toLocalDate();
							model_AccountInfo.setSubStartDate(localDate_ValDt);
						}

						if (esb_DepInfo.getPrincipleCurAmt() != null)
							model_AccountInfo.setMainInvAmount(esb_DepInfo.getPrincipleCurAmt().getAmt()
									+ esb_DepInfo.getPrincipleCurAmt().getCurCode());

						model_AccountInfo.setSubReqNumber(esb_DepInfo.getLDRefNum());

						model_AccountList.addInvestmentAccountInfoItem(model_AccountInfo);
					}
					CustomerDepositResponseCustomerDepositResponse model_CustomerDepositResponse = new CustomerDepositResponseCustomerDepositResponse();
					model_CustomerDepositResponse.setInvestmentAccountList(model_AccountList);
					model_Response.setCustomerDepositResponse(model_CustomerDepositResponse);
				}
			} else {
				logger.info("esb_CustDepsInqRs.getMsgRsHdr().getStatusCode() Is Not Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("customerDeposistsInquiry - Error : " + e);
			if (e instanceof NullPointerException) {
				// i didn't have a status code to add as in previous function
				// as the yaml of this function has not those fields
				throw new CustomServiceUnavailableException(ResponseStatusCode.JMS_NO_DATA,
						ResponseStatusDesc.JMS_ERROR_DESC, e);
			} else {
				throw new CustomServiceUnavailableException(ResponseStatusCode.SYSTEM_ERROR,
						"customerDeposistsInquiry Exception", e);
			}
		}
		return model_Response;
	}

	public List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> getCardsLightInquiry() throws Exception {

		// Get cards from cache
		List<CardModel> cardModels = viewCardsListCacheHelper.getCachedCards(userService.getUserCifNumber(), FuncIdEnum.getCardsLightInquiry.getValue(), null, CardTypeEnum.DEBIT_CARD.getCode());
		boolean cacheCards = false;

		// If no cards found, call CardsInq
		if (cardModels == null || cardModels.isEmpty()) {
			cacheCards = true;
			CardsInqRqType cardsInqRqType = new CardsInqRqType();
			cardsInqRqType.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.getCardsLightInquiry.getValue()));
			CardsInqBodyRqType bodyRqType = new CardsInqBodyRqType();
			bodyRqType.setCardType(CardTypeEnum.DEBIT_CARD.getCode());
			bodyRqType.setFuncId(FuncIdEnum.getCardsLightInquiry.getValue());
			bodyRqType.setLnkdCIF(userService.getUserCifNumber());
			cardsInqRqType.setBody(bodyRqType);

			CardsInqRsType cardsInqRsType = (CardsInqRsType) middlewareCommunicator.sendRequestAndRecieveResponse(cardsInqRqType, MQSendDestination.CardsInqRq.getValue(), MQReceiveDestination.CardsInqRs.getValue(), CardsInqRsType.class);

			if (!ESBStatusCode.SUCCESS.getValue().equals(cardsInqRsType.getMsgRsHdr().getStatusCode())) {
				throw new ESBException(cardsInqRsType.getMsgRsHdr().getStatusCode());
			}

			// Map CardsInq response to card model
			cardModels = new ArrayList<>();
			viewCardsListCacheHelper.mapCardsInqRsToCardModels(cardsInqRsType, cardModels);
		}

		if (cacheCards) {
			viewCardsListCacheHelper.cacheCards(cardModels, userService.getUserCifNumber(), FuncIdEnum.getCardsLightInquiry.getValue(), null, CardTypeEnum.DEBIT_CARD.getCode());
			cardModels = viewCardsListCacheHelper.getCachedCards(userService.getUserCifNumber(), FuncIdEnum.getCardsLightInquiry.getValue(), null, CardTypeEnum.DEBIT_CARD.getCode());
		}

		List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> model_CardInfoList = new ArrayList<>();

		try {
			CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo model_CardInfo = null;
			for (CardModel cardModel : cardModels) {
				logger.info("cardModel: " + cardModel);
				model_CardInfo = new CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo();
				model_CardInfo.setCardClassId(cardModel.getCardClassId());
				model_CardInfo.setCardNickName(cardModel.getCardNickName());
				model_CardInfo.setCardNumber(Long.valueOf(cardModel.getCardIndex()));
				model_CardInfo.setCardStatus(cardModel.getCardStatus());
				model_CardInfo.setCardType(cardModel.getCardType());

				if (cardModel.getExpiryDate() != null) {
					Instant instant = Instant.ofEpochMilli(cardModel.getExpiryDate().getTime());
					LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					LocalDate localDate_ExpDt = localDateTime.toLocalDate();
					model_CardInfo.setExpiryDate(localDate_ExpDt);
				}

				if (cardModel.getIssueDate() != null) {
					Instant instant = Instant.ofEpochMilli(cardModel.getIssueDate().getTime());
					LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					LocalDate localDate_IssueDt = localDateTime.toLocalDate();
					model_CardInfo.setIssueDate(localDate_IssueDt);
				}

				model_CardInfo.setMaskedCardNumber(cardModel.getMaskedCardNumber());
				model_CardInfo.setLnkdAccountNumber(cardModel.getLnkdAcctNum() != null ? Long.parseLong(cardModel.getLnkdAcctNum()) : 0L);
				model_CardInfo.setIsPrimaryCard(cardModel.getIsPrimaryCard());
				model_CardInfoList.add(model_CardInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getCardsLightInquiry - Error : " + e);
			if (e instanceof NullPointerException) {
				throw new CustomServiceUnavailableException(ResponseStatusCode.JMS_NO_DATA, ResponseStatusDesc.JMS_ERROR_DESC, e);
			} else {
				throw new CustomServiceUnavailableException(ResponseStatusCode.SYSTEM_ERROR, ResponseStatusDesc.SYSTEM_ERROR_MSG, e);
			}
		}

		return model_CardInfoList;
	}

	// public CardsChargesAndFeesResponse
	// listCardsChargesAndFees(CardsChargesAndFeesRequest
	// model_ChargesAndFeesRequest) {
	//
	// CardsChargesAndFeesResponse model_response = new
	// CardsChargesAndFeesResponse();
	// CardsChargesAndFeesResponseCardsChargesAndFeesResponse model_FeesResponse
	// =
	// new CardsChargesAndFeesResponseCardsChargesAndFeesResponse();
	// if (model_ChargesAndFeesRequest != null) {
	// CardsChargesAndFeesRequestCardsChargesAndFeesRequest model_FeesRequest =
	// model_ChargesAndFeesRequest.getCardsChargesAndFeesRequest();
	// if (model_FeesRequest != null && model_FeesRequest.getCardType() != null)
	// {
	//
	// Map<String, Object> cardsChargesAndFeesMap =
	// inmaRepository.findCardsChargesAndFeesForDialog(model_FeesRequest.getCardType());
	// String errorCode = (String) cardsChargesAndFeesMap.get("p_ERROR_CODE");
	// if (errorCode.equals(ESBStatusCode.SUCCESS.getValue())) {
	// List<CardFeeFieldDialog> returned_CardFeesList =
	// (List<CardFeeFieldDialog>)
	// cardsChargesAndFeesMap.get("p_RESULT");
	// CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList
	// model_ResponseFeeList = new
	// CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList();
	// CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo
	// model_FeeInfo = null;
	// for(CardFeeFieldDialog cardFee : returned_CardFeesList) {
	// model_FeeInfo = new
	// CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo();
	// model_FeeInfo.setFeeFieldLabel(cardFee.getLabel());
	// model_FeeInfo.setFeeFieldValue(cardFee.getValue());
	// model_ResponseFeeList.addFeeInfoItem(model_FeeInfo);
	// }
	// model_FeesResponse.setFeeList(model_ResponseFeeList);
	// model_response.setCardsChargesAndFeesResponse(model_FeesResponse);
	// return model_response;
	// }else {
	// System.out.println("errorCode : "+errorCode);
	// }
	// } else {
	// model_FeesResponse.setStatusCode("E99999");
	// model_FeesResponse.setStatusDesc("You Have To Enter Card Type");
	// return model_response;
	// }
	// }
	// model_FeesResponse.setStatusCode("E99999");
	// model_FeesResponse.setStatusDesc("Invalid Request");
	// return model_response;
	// }

	/**
	 * @param accountsWithBalanceRequest
	 * @return all Balance Information to this account number
	 * @throws Exception
	 */
	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList getDormantAccounts()
			throws Exception {

		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList();

		/*
		 * start Calling JMS Service
		 */
		CustAcctsInqRs esb_AcctsInqRs = null;
		try {

			esb_AcctsInqRs = retrieveDormantAccounts();
			/*
			 * start fill model response
			 */
			if (esb_AcctsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustAcctsInqRsBody rsBody = esb_AcctsInqRs.getBody();
				if (rsBody.getAcctsList() != null && GeneralUtil.isListValid(rsBody.getAcctsList().getAcctInfo())) {

					List<AcctInfo> esb_acctInfoList = rsBody.getAcctsList().getAcctInfo();
					AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo model_accountInfo = null;
					for (AcctInfo esb_accountInfo : esb_acctInfoList) {

						AcctDtls esb_acctDtls = esb_accountInfo.getAcctDtls();
						if (esb_acctDtls != null) {
							model_accountInfo = new AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo();
							if (esb_acctDtls.getAcctId() != null) {
								Long acctNum = esb_acctDtls.getAcctId().getAcctNum();
								model_accountInfo.setAccountNumber(acctNum != null ? acctNum : 0L);
								String accountType = accountTypeBothLang(esb_acctDtls.getAcctId().getAcctType());
								model_accountInfo.setAccountType(accountType);
								
							}
							model_accountInfo.setAccountNickName(esb_acctDtls.getAcctNickname());
							model_accountInfo.setAccountStatus(inmaLOVService.getAccountStatusDesc(esb_acctDtls.getAcctStatus(),userService.islocalLanguageEnglish()));
							String availBalance = getAvailableBalance(esb_acctDtls.getAvailBal());
							model_accountInfo.setAvailableBalance(availBalance);
							model_accountInfo.setCurrency(inmaLOVService.getCurrencyDesc(esb_acctDtls.getAcctCur(),userService.islocalLanguageEnglish()));
							model_accountInfo.setDormant(Boolean.TRUE);
							model_accountInfo.setIban(esb_acctDtls.getIBAN());
							accountsList.addAccountInfoItem(model_accountInfo);
						}
					}
				} else {
					logger.info("there is body but no dormant accounts list found - ESB Status Code "
							+ esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
				}
			} else {
				logger.info("Dormant Response Body Is Empty - ESB Status Code "
						+ esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getDormantAccounts - Error : " + e);
			if (e instanceof NullPointerException) {
				throw new CustomServiceUnavailableException(ResponseStatusCode.JMS_NO_DATA,
						ResponseStatusDesc.JMS_ERROR_DESC, e);
			} else {
				throw new CustomServiceUnavailableException(ResponseStatusCode.SYSTEM_ERROR,
						ResponseStatusDesc.SYSTEM_ERROR_MSG, e);
			}
		}
		return accountsList;
	}

	private Long getMaskedCardNumber(Long cardNum) {
		String cardNumber = String.valueOf(cardNum);
		if (cardNumber != null) {
			int len = cardNumber.length();
			String last_4_digitsOfAccNum = cardNumber.substring(len - 4, len);
			return Long.parseLong(last_4_digitsOfAccNum);
		} else {
			return 0L;
		}
	}

	private Map<Long, List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo>> getLinkedCards(
			List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> model_CardInfoList) {

		Map<Long, List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo>> map = new HashMap<>();
		List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> linkedCardList = null;
		for (CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo model_CardInfo : model_CardInfoList) {
			if (model_CardInfo.getCardStatus() != null && isCardNotActive(model_CardInfo.getCardStatus())) {
				continue;
			}

			if (map.containsKey(model_CardInfo.getLnkdAccountNumber())) {
				map.get(model_CardInfo.getLnkdAccountNumber()).add(model_CardInfo);
			} else {
				linkedCardList = new ArrayList<>();
				linkedCardList.add(model_CardInfo);
				map.put(model_CardInfo.getLnkdAccountNumber(), linkedCardList);
			}
		}
		return map;
	}

	private boolean isCardNotActive(String status) {
		CardStatusEnum cardStatus = CardStatusEnum.getByCode(status);
		return cardStatus != null && !cardStatus.isActive();
	}
	
	private String accountTypeBothLang(String accountTypeCode) {
		String status="";
		try{
			LovInquiryRes lovResponse=inmaLOVService.getAccountTypeLov(accountTypeCode);
		if(ESBStatusCode.SUCCESS.getValue().equals(lovResponse.getMsgRsHdr().getStatusCode()))
		{
			status=lovResponse.getBody().getLOVList().getLOVInfo().get(0).getRecDesc()+ "|" + lovResponse.getBody().getLOVList().getLOVInfo().get(0).getAttribute1();
		}
		}catch (Exception e) {
			logger.error("Lov request for Account Type failed"+e.getMessage());
		}
		return status;
	}

	public AccountNicknameResponse updateAccountNickname(String account_number, String account_nickname)
			throws ESBException, EmptyContentException {
		// front-end response
		AccountNicknameResponse accountNicknameResponse = new AccountNicknameResponse();

		// esb request
		// esb msg header
		MsgRqHdrType msgRqHdr = new MsgRqHdrType();
		msgRqHdr.setFuncId(FuncIdEnum.updateAccountNames.getValue());
		msgRqHdr.setCustLangPref(userService.getLanguagePrefered());
		logger.info("getLanguagePrefered: " + userService.getLanguagePrefered());

		msgRqHdr.setUsrId(userService.getUserId());
		CustIdType custId = new CustIdType();
		custId.setCIF(userService.getUserCifNumber());
		custId.setAlinmaId(userService.getUserInmaId());
		msgRqHdr.setCustId(custId);
		logger.info("msgRqHdr: " + userService.getLanguagePrefered());

		// esb body
		AcctIdType acctIdType = new AcctIdType();
		acctIdType.setAcctNum(account_number);
		AcctMngBodyRqType esb_acctMngBodyRq = new AcctMngBodyRqType();
		esb_acctMngBodyRq.setAcctId(acctIdType);
		esb_acctMngBodyRq.setAcctNickname(account_nickname == null || account_nickname.isEmpty() || account_nickname.equals("null") || account_nickname.equals("undefined") || account_nickname.equals(" ") ? "" : account_nickname);
		// esb_acctMngBodyRq.setCurrAcctNum(account_number);

		AcctMngRqType esb_acctMngRq = new AcctMngRqType();
		esb_acctMngRq.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.updateAccountNames.getValue()));
		esb_acctMngRq.setBody(esb_acctMngBodyRq);

		// esb response
		AcctMngRsType esb_acctMngRs = new AcctMngRsType();


			// esb call
			esb_acctMngRs = (AcctMngRsType) middlewareCommunicator.sendRequestAndRecieveResponse(esb_acctMngRq,
					MQSendDestination.AcctMngRq.getValue(), MQReceiveDestination.AcctMngRs.getValue(),
					AcctMngRsType.class);
			
			if (!isSuccess(esb_acctMngRs.getMsgRsHdr().getStatusCode())) {
				throw new ESBException(esb_acctMngRs.getMsgRsHdr().getStatusCode());
			}
			if (isSuccess(esb_acctMngRs.getMsgRsHdr().getStatusCode()) && esb_acctMngRs.getBody() == null) {
				throw new EmptyContentException(esb_acctMngRs.getMsgRsHdr().getStatusCode());
			}

			logger.info("esb_AcctsInqRs : " + esb_acctMngRs);

			AccountNicknameResponseUpdateAccountNicknameResponse accountNicknameResponseUpdateAccountNicknameResponse = new AccountNicknameResponseUpdateAccountNicknameResponse();
			// map esb response to front-end response
			if (esb_acctMngRs != null
					&& esb_acctMngRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				accountNicknameResponseUpdateAccountNicknameResponse
				.setStatusCode(esb_acctMngRs.getMsgRsHdr().getStatusCode());
				accountNicknameResponseUpdateAccountNicknameResponse.setStatusDesc(esb_acctMngRs.getMsgRsHdr().getStatusCode());
		
				accountNicknameResponse
						.setUpdateAccountNicknameResponse(accountNicknameResponseUpdateAccountNicknameResponse);
			}

		return accountNicknameResponse;
	}

	/**
	 * @param accountsWithBalanceRequest
	 * @return all Balance Information to this account number
	 * @throws Exception
	 */
	public AccountsWithBalanceResponse getAccountsWithBalance() throws Exception {

		AccountsWithBalanceResponse response = new AccountsWithBalanceResponse();
		CustomerAccountsInquiryResponse accountsWithBalanceResponse = new CustomerAccountsInquiryResponse();

		/*
		 * start mapping model Rq to esb Rq
		 */
		CustAcctsInqRq esb_AcctsInqRq = new CustAcctsInqRq();
		CustId custId = new CustId();
		custId.setCIF(userService.getUserCifNumber());
		custId.setAlinmaId(userService.getUserInmaId());

		/*
		 * fill req Body
		 */
		CustAcctsInqRqBody esb_RqBody = new CustAcctsInqRqBody();
		esb_RqBody.setFuncId(FuncIdEnum.getAccountsWithBalance.getValue());
		esb_RqBody.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode());
		esb_AcctsInqRq.setBody(esb_RqBody);

		/*
		 * start Calling JMS Service
		 */
		CustAcctsInqRs esb_AcctsInqRs = null;
		try {

			esb_AcctsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountsWithBalance.getValue()));
			esb_AcctsInqRs = (CustAcctsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctsInqRq,
					MQSendDestination.CustAcctsInqRq.getValue(), MQReceiveDestination.CustAcctsInqRs.getValue(),
					CustAcctsInqRs.class);

			logger.info("esb_AcctsInqRs: " + esb_AcctsInqRs);

			/*
			 * start fill model response
			 */
			if (esb_AcctsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustAcctsInqRsBody rsBody = esb_AcctsInqRs.getBody();
				if (rsBody.getAcctsList() != null && GeneralUtil.isListValid(rsBody.getAcctsList().getAcctInfo())) {

					List<AcctInfo> esb_acctInfoList = rsBody.getAcctsList().getAcctInfo();
					AccountsList accountsList = new AccountsList();
					AccountInfo model_accountInfo = null;
					for (AcctInfo esb_accountInfo : esb_acctInfoList) {

						AcctDtls esb_acctDtls = esb_accountInfo.getAcctDtls();
						if (esb_acctDtls != null) {
							model_accountInfo = new AccountInfo();
							if (esb_acctDtls.getAcctId() != null) {
								model_accountInfo.setAccountNumber(esb_acctDtls.getAcctId().getAcctNum().toString());
							}
							String label = getAccountLabel(esb_acctDtls,inmaLOVService.getCurrencyDesc(esb_acctDtls.getAcctCur(),userService.islocalLanguageEnglish()));
							logger.info("Label : " + label);
							model_accountInfo.setAccountLabel(label);
							
							model_accountInfo.setCurrencyCode(esb_acctDtls.getAcctCur());
							model_accountInfo.setCurrencyDesc(inmaLOVService.getCurrencyDesc(esb_acctDtls.getAcctCur(),userService.islocalLanguageEnglish()));
							model_accountInfo.setAccountNickName(esb_acctDtls.getAcctNickname());
							model_accountInfo.setAvailableBalance(esb_acctDtls.getAvailBal());
							accountsList.addAccountInfoItem(model_accountInfo);
						}
					}
					accountsWithBalanceResponse.setAccountsList(accountsList);
					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS);
					response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				} else {
					logger.info("there is body but no accounts list found - ESB Status Code "
							+ esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY);
					accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_BODY_EMPTY);
					response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				}
			} else {
				logger.info("Response Body Is Empty - ESB Status Code " + esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_NO_BODY_FOUND);
				response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccountsWithBalance - Error : " + e);
			if (e instanceof NullPointerException) {
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.JMS_NO_DATA);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.JMS_ERROR_DESC);
				response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				return response;
			} else {
				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SYSTEM_ERROR);
				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SYSTEM_ERROR_MSG);
				response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				return response;
			}
		}
		return response;
	}

	/**
	 * @param accountsWithBalanceRequest
	 * @return all Balance Information to this account number
	 * @throws InputException 
	 * @throws EmptyContentException 
	 * @throws ESBException 
	 * @throws Exception
	 */
	public AccountsWithBalanceResponse getAccountsWithBalanceV2(String functionId) throws InputException, EmptyContentException, ESBException  {

		AccountsWithBalanceResponse response = new AccountsWithBalanceResponse();
		CustomerAccountsInquiryResponse accountsWithBalanceResponse = new CustomerAccountsInquiryResponse();
		String functionIdESB = null;
		try {
			functionIdESB = (FuncIdEnum.valueOf(functionId) != null) ? FuncIdEnum.valueOf(functionId).getValue() : null;
			if (functionIdESB == null) {
				logger.info("getgetAccountsWithBalanceV2 fuctionID " + functionId + " not supported");
//				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.FUNCTION_ID_NOT_SUPPORTED);
//				accountsWithBalanceResponse.setStatusDesc("function ID sent is not supported ");
//				response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
//				return response;
				
				InputException inputEx = new InputException();
				inputEx.setExceptionMessage("function ID sent is not supported ");
				throw inputEx;
			}
		} catch (Exception e) {
			logger.info("getgetAccountsWithBalanceV2 fuctionID " + functionId + " not supported");
//			accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.FUNCTION_ID_NOT_SUPPORTED);
//			accountsWithBalanceResponse.setStatusDesc("function ID sent is not supported ");
//			response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
//			return response;
			
			InputException inputEx = new InputException();
			inputEx.setExceptionMessage("function ID sent is not supported ");
			throw inputEx;
		}
		/*
		 * start mapping model Rq to esb Rq
		 */
		CustAcctsInqRq esb_AcctsInqRq = new CustAcctsInqRq();

		/*
		 * fill req Body
		 */
		CustAcctsInqRqBody esb_RqBody = new CustAcctsInqRqBody();
		esb_RqBody.setFuncId(functionIdESB);
		esb_RqBody.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode());
		esb_AcctsInqRq.setBody(esb_RqBody);

		/*
		 * start Calling JMS Service
		 */
		CustAcctsInqRs esb_AcctsInqRs = null;
	

			esb_AcctsInqRq.setMsgRqHdr(
					middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountsWithBalance.getValue()));

			esb_AcctsInqRs = (CustAcctsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctsInqRq,
					MQSendDestination.CustAcctsInqRq.getValue(), MQReceiveDestination.CustAcctsInqRs.getValue(),
					CustAcctsInqRs.class);

			logger.info("esb_AcctsInqRs: " + esb_AcctsInqRs);

			/*
			 * start fill model response
			 */
			if (esb_AcctsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
				CustAcctsInqRsBody rsBody = esb_AcctsInqRs.getBody();
				if (rsBody != null && rsBody.getAcctsList() != null
						&& GeneralUtil.isListValid(rsBody.getAcctsList().getAcctInfo())) {

					List<AcctInfo> esb_acctInfoList = rsBody.getAcctsList().getAcctInfo();
					AccountsList accountsList = new AccountsList();
					AccountInfo model_accountInfo = null;
					for (AcctInfo esb_accountInfo : esb_acctInfoList) {

						AcctDtls esb_acctDtls = esb_accountInfo.getAcctDtls();
						if (esb_acctDtls != null) {
							model_accountInfo = new AccountInfo();
							if (esb_acctDtls.getAcctId() != null) {
								model_accountInfo.setAccountNumber(esb_acctDtls.getAcctId().getAcctNum().toString());
							}
							model_accountInfo.setCurrencyCode(esb_acctDtls.getAcctCur());
							model_accountInfo.setCurrencyDesc(inmaLOVService.getCurrencyDesc(esb_acctDtls.getAcctCur(),userService.islocalLanguageEnglish()));
							String label = getAccountLabel(esb_acctDtls,model_accountInfo.getCurrencyDesc());
							logger.info("Label : " + label);
							model_accountInfo.setAccountLabel(label);
							model_accountInfo.setAccountNickName(esb_acctDtls.getAcctNickname());
							model_accountInfo.setAvailableBalance(esb_acctDtls.getAvailBal());
						accountsList.addAccountInfoItem(model_accountInfo);
						}
					}
					accountsWithBalanceResponse.setAccountsList(accountsList);
					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS);
					response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				} else {
					logger.info("there is body but no accounts list found - ESB Status Code "
							+ esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
//					accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_BODY_EMPTY);
//					accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_BODY_EMPTY);
//					response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
					throw new EmptyContentException(esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
		
				}
			} else {
				logger.info("Response Body Is Empty - ESB Status Code " + esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
//				accountsWithBalanceResponse.setStatusCode(ResponseStatusCode.SUCCESS_BUT_NO_BODY_FOUND);
//				accountsWithBalanceResponse.setStatusDesc(ResponseStatusDesc.SUCCESS_BUT_NO_BODY_FOUND);
//				response.setCustomerAccountsInquiryResponse(accountsWithBalanceResponse);
				throw new ESBException(esb_AcctsInqRs.getMsgRsHdr().getStatusCode());
			}
	
		return response;
	}

	private String getAccountLabel(AcctDtls esb_acctDtls,String currency) {

		String name = esb_acctDtls.getAcctNickname() != null ? esb_acctDtls.getAcctNickname()
				: esb_acctDtls.getAcctName();
		String balance = getAvailableBalance(esb_acctDtls.getAvailBal());
				
		return name + " - " + balance + " - " + currency;
	}

	private String getAvailableBalance(double availBal) {

		DecimalFormat f = new DecimalFormat(",###.00");
		String balance = "0.00";
		if (availBal != 0) {
			try {
				balance = f.format(availBal);
				logger.info("balance : " + balance);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				logger.error("getAvailableBalance - failed to format available balance " + availBal + " error " + e);
			}
		} else {
			balance = String.format("%.2f", availBal);
		}
		return balance;
	}

	private CustAcctsInqRs retrieveDormantAccounts() throws Exception {

		/*
		 * start mapping model Rq to esb Rq
		 */
		CustAcctsInqRq esb_AcctsInqRq = new CustAcctsInqRq();
		/*
		 * fill req Header
		 */
		esb_AcctsInqRq
				.setMsgRqHdr(middlewareCommunicator.createRequestHeader(FuncIdEnum.getAccountsWithBalance.getValue()));

		/*
		 * fill req Body
		 */
		CustAcctsInqRqBody esb_RqBody = new CustAcctsInqRqBody();
		esb_RqBody.setFuncId(FuncIdEnum.getDormantAccounts.getValue());
		esb_RqBody.setAcctType(AccountTypeEnum.DEPOSIT_ACCOUNT.getCode());
		esb_RqBody.setCIF(userService.getUserCifNumber());
		esb_RqBody.setUsrId(userService.getUserId());
		esb_AcctsInqRq.setBody(esb_RqBody);

		/*
		 * start Calling JMS Service
		 */
		return (CustAcctsInqRs) middlewareCommunicator.sendRequestAndRecieveResponse(esb_AcctsInqRq,
				MQSendDestination.CustAcctsInqRq.getValue(), MQReceiveDestination.CustAcctsInqRs.getValue(),
				CustAcctsInqRs.class);
	}

	public HasDormantAccountResponse hasDormantAccounts() throws Exception {
		HasDormantAccountResponse response = new HasDormantAccountResponse();
		response.hasDormantAccountRs(new HasDormantAccountRs().hasDormantAccounts(false));
		CustAcctsInqRs acctsInqRs = retrieveDormantAccounts();
		if (acctsInqRs != null) {
			response.getHasDormantAccountRs().setStatusCode(acctsInqRs.getMsgRsHdr().getStatusCode());
		} else {
			throw new Model500InternalServererror("500", "hasDormantAccounts Exception", null);
		}
		if (acctsInqRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
			response.getHasDormantAccountRs()
					.setHasDormantAccounts(acctsInqRs.getBody() != null && acctsInqRs.getBody().getAcctsList() != null
							&& !acctsInqRs.getBody().getAcctsList().getAcctInfo().isEmpty()
							&& acctsInqRs.getBody().getAcctsList().getAcctInfo().size() > 0);
		} else {
			response.getHasDormantAccountRs().setStatusDesc(errorMessageSource.getMessage(
					response.getHasDormantAccountRs().getStatusCode(), null, new Locale(userService.getCurLang())));
		}
		return response;
	}
	
	public boolean isSuccess(String statusCode) {
		if (statusCode.trim().equalsIgnoreCase("I000000")) {
			return true;
		} else {
			return false;
		}
	}

}
