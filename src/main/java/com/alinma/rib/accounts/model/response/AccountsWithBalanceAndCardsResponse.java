package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:30:07.745Z")

public class AccountsWithBalanceAndCardsResponse {
	@JsonProperty("accountsWithBalanceAndCardsResponse")
	private AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponse = null;

	public AccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponse(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponse) {
		this.accountsWithBalanceAndCardsResponse = accountsWithBalanceAndCardsResponse;
		return this;
	}

	/**
	 * Get accountsWithBalanceAndCardsResponse
	 * 
	 * @return accountsWithBalanceAndCardsResponse
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse getAccountsWithBalanceAndCardsResponse() {
		return accountsWithBalanceAndCardsResponse;
	}

	public void setAccountsWithBalanceAndCardsResponse(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponse) {
		this.accountsWithBalanceAndCardsResponse = accountsWithBalanceAndCardsResponse;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountsWithBalanceAndCardsResponse accountsWithBalanceAndCardsResponse = (AccountsWithBalanceAndCardsResponse) o;
		return Objects.equals(this.accountsWithBalanceAndCardsResponse, accountsWithBalanceAndCardsResponse.accountsWithBalanceAndCardsResponse);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountsWithBalanceAndCardsResponse);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccountsWithBalanceAndCardsResponse {\n");

		sb.append("    accountsWithBalanceAndCardsResponse: ").append(toIndentedString(accountsWithBalanceAndCardsResponse)).append("\n");
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
