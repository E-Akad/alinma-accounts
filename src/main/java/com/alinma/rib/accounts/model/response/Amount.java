package com.alinma.rib.accounts.model.response;


public class Amount {
	private String currencyCode;
	private String currencyRate;
	private String amount;
	private EntityKey amountEntityKey;
	private String localAmount;

	public Amount() {

	}

	public Amount(String amount) {
		this.amount = amount;
		this.amountEntityKey = null;
	}



	public Amount(String amount, String currencyCode) {
		this.amount = amount;
		this.currencyCode = currencyCode;
		this.amountEntityKey = null;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmountEntityKey(EntityKey amount) {
		this.amountEntityKey = amount;		
		this.amount = amount != null?amount.getCode():null;
	}
	
	public EntityKey getAmountEntityKey() {
		return amountEntityKey;
	}
	
	
	public void setAmount(String amount) {
		this.amount = amount;
		this.amountEntityKey = null;
		
	}

	public String getLocalAmount() {
		return localAmount;
	}

	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}

	public void setCurrencyRate(String currencyRate) {
		this.currencyRate = currencyRate;
	}

	public String getCurrencyRate() {
		return currencyRate;
	}
	
}
