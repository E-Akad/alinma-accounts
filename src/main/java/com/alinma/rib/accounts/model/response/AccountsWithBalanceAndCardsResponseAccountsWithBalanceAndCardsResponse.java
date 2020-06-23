package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:30:07.745Z")

public class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse {
	@JsonProperty("statusCode")
	private String statusCode = null;

	@JsonProperty("statusDesc")
	private String statusDesc = null;

	@JsonProperty("accountsList")
	private AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList = null;

	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse statusCode(String statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	/**
	 * Get statusCode
	 * 
	 * @return statusCode
	 **/
	@ApiModelProperty(value = "")

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse statusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
		return this;
	}

	/**
	 * Get statusDesc
	 * 
	 * @return statusDesc
	 **/
	@ApiModelProperty(value = "")

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsList(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList) {
		this.accountsList = accountsList;
		return this;
	}

	/**
	 * Get accountsList
	 * 
	 * @return accountsList
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsList accountsList) {
		this.accountsList = accountsList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse = (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse) o;
		return Objects.equals(this.statusCode, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse.statusCode) && Objects.equals(this.statusDesc, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse.statusDesc)
				&& Objects.equals(this.accountsList, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse.accountsList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusCode, statusDesc, accountsList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse {\n");

		sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
		sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
		sb.append("    accountsList: ").append(toIndentedString(accountsList)).append("\n");
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
}
