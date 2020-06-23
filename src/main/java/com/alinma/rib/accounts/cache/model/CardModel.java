package com.alinma.rib.accounts.cache.model;

import java.sql.Timestamp;

public class CardModel {

	private Integer cardIndex;
	private String cif;
	private String esbFuncId;
	private String esbLnkdAcctNum;
	private String esbCardType;
	private String cardNumber;
	private Integer matchedRecs;
	private Integer sentRecs;
	private String alinmaIdSplitMasked;
	private String gregorianMonthYear;
	private String maskedCardNumber;
	private String cardType;
	private String cardTypeDescAr;
	private String cardTypeDescEn;
	private String cardStatus;
	private String cardStatusDescAr;
	private String cardStatusDescEn;
	private String cardClassId;
	private String cardClassIdDescriptionAr;
	private String cardClassIdDescriptionEn;
	private String cardNickName;
	private Timestamp expiryDate;
	private Timestamp issueDate;
	private String imageUrl;
	private String paymentDueDate;
	private Double cashAvailableBalance;
	private Double totalOutstanding;
	private Timestamp statamentIssueDate;
	private Double dueAmount;
	private Timestamp dueDate;
	private String title;
	private String embossingName;
	private Double availablebalance;
	private Double availableCashWithdrawAmount;
	private Double availableExtraAmount;
	private Double outstandBalance;
	private Double creditLimit;
	private Double cashLimit;
	private Double cashWithdrawLimit;
	private Timestamp billingDate;
	private Timestamp nextAnnualFreeDate;
	private String currentAccount;
	private String lnkdAcctNum;
	private String isPrimaryCard;

	@Override
	public String toString() {
		return "CardModel [cardIndex=" + cardIndex + ", cif=" + cif + ", esbFuncId=" + esbFuncId + ", esbLnkdAcctNum=" + esbLnkdAcctNum + ", esbCardType=" + esbCardType + ", cardNumber=" + cardNumber + ", matchedRecs=" + matchedRecs + ", sentRecs=" + sentRecs + ", alinmaIdSplitMasked="
				+ alinmaIdSplitMasked + ", gregorianMonthYear=" + gregorianMonthYear + ", maskedCardNumber=" + maskedCardNumber + ", cardType=" + cardType + ", cardTypeDescAr=" + cardTypeDescAr + ", cardTypeDescEn=" + cardTypeDescEn + ", cardStatus=" + cardStatus + ", cardStatusDescAr="
				+ cardStatusDescAr + ", cardStatusDescEn=" + cardStatusDescEn + ", cardClassId=" + cardClassId + ", cardClassIdDescriptionAr=" + cardClassIdDescriptionAr + ", cardClassIdDescriptionEn=" + cardClassIdDescriptionEn + ", cardNickName=" + cardNickName + ", expiryDate=" + expiryDate
				+ ", issueDate=" + issueDate + ", imageUrl=" + imageUrl + ", paymentDueDate=" + paymentDueDate + ", cashAvailableBalance=" + cashAvailableBalance + ", totalOutstanding=" + totalOutstanding + ", statamentIssueDate=" + statamentIssueDate + ", dueAmount=" + dueAmount + ", dueDate="
				+ dueDate + ", title=" + title + ", embossingName=" + embossingName + ", availablebalance=" + availablebalance + ", availableCashWithdrawAmount=" + availableCashWithdrawAmount + ", availableExtraAmount=" + availableExtraAmount + ", outstandBalance=" + outstandBalance + ", creditLimit="
				+ creditLimit + ", cashLimit=" + cashLimit + ", cashWithdrawLimit=" + cashWithdrawLimit + ", billingDate=" + billingDate + ", nextAnnualFreeDate=" + nextAnnualFreeDate + ", currentAccount=" + currentAccount + "]";
	}

	public Integer getCardIndex() {
		return cardIndex;
	}

	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getEsbFuncId() {
		return esbFuncId;
	}

	public void setEsbFuncId(String esbFuncId) {
		this.esbFuncId = esbFuncId;
	}

	public String getEsbLnkdAcctNum() {
		return esbLnkdAcctNum;
	}

	public void setEsbLnkdAcctNum(String esbLnkdAcctNum) {
		this.esbLnkdAcctNum = esbLnkdAcctNum;
	}

	public String getEsbCardType() {
		return esbCardType;
	}

	public void setEsbCardType(String esbCardType) {
		this.esbCardType = esbCardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getMatchedRecs() {
		return matchedRecs;
	}

	public void setMatchedRecs(Integer matchedRecs) {
		this.matchedRecs = matchedRecs;
	}

	public Integer getSentRecs() {
		return sentRecs;
	}

	public void setSentRecs(Integer sentRecs) {
		this.sentRecs = sentRecs;
	}

	public String getAlinmaIdSplitMasked() {
		return alinmaIdSplitMasked;
	}

	public void setAlinmaIdSplitMasked(String alinmaIdSplitMasked) {
		this.alinmaIdSplitMasked = alinmaIdSplitMasked;
	}

	public String getGregorianMonthYear() {
		return gregorianMonthYear;
	}

	public void setGregorianMonthYear(String gregorianMonthYear) {
		this.gregorianMonthYear = gregorianMonthYear;
	}

	public String getMaskedCardNumber() {
		return maskedCardNumber;
	}

	public void setMaskedCardNumber(String maskedCardNumber) {
		this.maskedCardNumber = maskedCardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getCardNickName() {
		return cardNickName;
	}

	public void setCardNickName(String cardNickName) {
		this.cardNickName = cardNickName;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String image_url) {
		this.imageUrl = image_url;
	}

	public String getCardClassId() {
		return cardClassId;
	}

	public void setCardClassId(String cardClassId) {
		this.cardClassId = cardClassId;
	}

	public String getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Double getCashAvailableBalance() {
		return cashAvailableBalance;
	}

	public void setCashAvailableBalance(Double cashAvailableBalance) {
		this.cashAvailableBalance = cashAvailableBalance;
	}

	public Double getTotalOutstanding() {
		return totalOutstanding;
	}

	public void setTotalOutstanding(Double totalOutstanding) {
		this.totalOutstanding = totalOutstanding;
	}

	public Timestamp getStatamentIssueDate() {
		return statamentIssueDate;
	}

	public void setStatamentIssueDate(Timestamp statamentIssueDate) {
		this.statamentIssueDate = statamentIssueDate;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmbossingName() {
		return embossingName;
	}

	public void setEmbossingName(String embossingName) {
		this.embossingName = embossingName;
	}

	public Double getAvailablebalance() {
		return availablebalance;
	}

	public void setAvailablebalance(Double availablebalance) {
		this.availablebalance = availablebalance;
	}

	public Double getAvailableCashWithdrawAmount() {
		return availableCashWithdrawAmount;
	}

	public void setAvailableCashWithdrawAmount(Double availableCashWithdrawAmount) {
		this.availableCashWithdrawAmount = availableCashWithdrawAmount;
	}

	public Double getAvailableExtraAmount() {
		return availableExtraAmount;
	}

	public void setAvailableExtraAmount(Double availableExtraAmount) {
		this.availableExtraAmount = availableExtraAmount;
	}

	public Double getOutstandBalance() {
		return outstandBalance;
	}

	public void setOutstandBalance(Double outstandBalance) {
		this.outstandBalance = outstandBalance;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setCashLimit(Double cashLimit) {
		this.cashLimit = cashLimit;
	}

	public Double getCashLimit() {
		return cashLimit;
	}

	public Double getCashWithdrawLimit() {
		return cashWithdrawLimit;
	}

	public void setCashWithdrawLimit(Double cashWithdrawLimit) {
		this.cashWithdrawLimit = cashWithdrawLimit;
	}

	public Timestamp getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Timestamp billingDate) {
		this.billingDate = billingDate;
	}

	public Timestamp getNextAnnualFreeDate() {
		return nextAnnualFreeDate;
	}

	public void setNextAnnualFreeDate(Timestamp nextAnnualFreeDate) {
		this.nextAnnualFreeDate = nextAnnualFreeDate;
	}

	public String getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(String currentAccount) {
		this.currentAccount = currentAccount;
	}

	public String getCardTypeDescAr() {
		return cardTypeDescAr;
	}

	public void setCardTypeDescAr(String cardTypeDescAr) {
		this.cardTypeDescAr = cardTypeDescAr;
	}

	public String getCardTypeDescEn() {
		return cardTypeDescEn;
	}

	public void setCardTypeDescEn(String cardTypeDescEn) {
		this.cardTypeDescEn = cardTypeDescEn;
	}

	public String getCardStatusDescAr() {
		return cardStatusDescAr;
	}

	public void setCardStatusDescAr(String cardStatusDescAr) {
		this.cardStatusDescAr = cardStatusDescAr;
	}

	public String getCardStatusDescEn() {
		return cardStatusDescEn;
	}

	public void setCardStatusDescEn(String cardStatusDescEn) {
		this.cardStatusDescEn = cardStatusDescEn;
	}

	public String getCardClassIdDescriptionAr() {
		return cardClassIdDescriptionAr;
	}

	public void setCardClassIdDescriptionAr(String cardClassIdDescriptionAr) {
		this.cardClassIdDescriptionAr = cardClassIdDescriptionAr;
	}

	public String getCardClassIdDescriptionEn() {
		return cardClassIdDescriptionEn;
	}

	public void setCardClassIdDescriptionEn(String cardClassIdDescriptionEn) {
		this.cardClassIdDescriptionEn = cardClassIdDescriptionEn;
	}

	public String getLnkdAcctNum() {
		return lnkdAcctNum;
	}

	public void setLnkdAcctNum(String lnkdAcctNum) {
		this.lnkdAcctNum = lnkdAcctNum;
	}

	public String getIsPrimaryCard() {
		return isPrimaryCard;
	}

	public void setIsPrimaryCard(String isPrimaryCard) {
		this.isPrimaryCard = isPrimaryCard;
	}

}
