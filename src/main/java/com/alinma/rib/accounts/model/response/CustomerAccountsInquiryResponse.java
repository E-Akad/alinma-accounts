package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerAccountsInquiryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-22T07:22:54.680Z")

public class CustomerAccountsInquiryResponse {
	@JsonProperty("statusCode")
	private String statusCode = null;

	@JsonProperty("statusDesc")
	private String statusDesc = null;

	@JsonProperty("accountsList")
	private AccountsList accountsList = null;

	public CustomerAccountsInquiryResponse statusCode(String statusCode) {
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

	public CustomerAccountsInquiryResponse statusDesc(String statusDesc) {
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

	public CustomerAccountsInquiryResponse accountsList(AccountsList accountsList) {
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

	public AccountsList getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(AccountsList accountsList) {
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
		CustomerAccountsInquiryResponse customerAccountsInquiryResponse = (CustomerAccountsInquiryResponse) o;
		return Objects.equals(this.statusCode, customerAccountsInquiryResponse.statusCode) && Objects.equals(this.statusDesc, customerAccountsInquiryResponse.statusDesc)
				&& Objects.equals(this.accountsList, customerAccountsInquiryResponse.accountsList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusCode, statusDesc, accountsList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CustomerAccountsInquiryResponse {\n");

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
