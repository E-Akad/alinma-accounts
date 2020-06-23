package com.alinma.rib.accounts.model.response;

import com.alinma.rib.authentication.model.system.CombinedDate;

public class TransactionModelDownloadReport {

	private CombinedDate transactionDateTime;

	private String description;

	private Double runningBalance;
	
	private EntityKey channelId;
	
	private TransactionType transactionType;

	private Amount amount;
	
	private String transactionReferenceNumber;
	
	public CombinedDate getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(CombinedDate transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRunningBalance() {
		return runningBalance;
	}

	public void setRunningBalance(Double runningBalance) {
		this.runningBalance = runningBalance;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}

	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}

	public EntityKey getChannelId() {
		return channelId;
	}

	public void setChannelId(EntityKey channelId) {
		this.channelId = channelId;
	}

	
}
