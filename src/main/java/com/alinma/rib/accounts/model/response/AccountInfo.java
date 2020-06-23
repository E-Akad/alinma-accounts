package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-22T07:22:54.680Z")

public class AccountInfo {
	@JsonProperty("accountNumber")
	private String accountNumber = null;

	@JsonProperty("accountLabel")
	private String accountLabel = null;

	@JsonProperty("currencyCode")
	private String currencyCode = null;

	@JsonProperty("currencyDesc")
	private String currencyDesc = null;
	
	@JsonProperty("availableBalance")
	private Double availableBalance = null;

	@JsonProperty("accountNickName")
	private String accountNickName = null;
	
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCurrencyDesc(String currenctDesc) {
		this.currencyDesc = currenctDesc;
	}

	public AccountInfo accountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	/**
	 * Get accountNumber
	 * 
	 * @return accountNumber
	 **/
	@ApiModelProperty(value = "")

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountInfo accountLabel(String accountLabel) {
		this.accountLabel = accountLabel;
		return this;
	}

	/**
	 * Get accountLabel
	 * 
	 * @return accountLabel
	 **/
	@ApiModelProperty(value = "")

	public String getAccountLabel() {
		return accountLabel;
	}

	public void setAccountLabel(String accountLabel) {
		this.accountLabel = accountLabel;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountInfo accountInfo = (AccountInfo) o;
		return Objects.equals(this.accountNumber, accountInfo.accountNumber) && Objects.equals(this.currencyCode, accountInfo.currencyCode)
				&& Objects.equals(this.currencyDesc, accountInfo.currencyDesc)&&Objects.equals(this.availableBalance, accountInfo.availableBalance)&&Objects.equals(this.accountNickName, accountInfo.accountNickName) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, currencyDesc, currencyCode,availableBalance,accountNickName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccountInfo {\n");

		sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
		sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
		sb.append("    accountNickName: ").append(toIndentedString(accountNickName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getAccountNickName() {
		return accountNickName;
	}

	public void setAccountNickName(String accountNickName) {
		this.accountNickName = accountNickName;
	}
}
