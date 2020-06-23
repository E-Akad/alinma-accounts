package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-22T07:22:54.680Z")

public class AccountsList {
	@JsonProperty("accountInfo")
	@Valid
	private List<AccountInfo> accountInfo = null;

	public AccountsList accountInfo(List<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
		return this;
	}

	public AccountsList addAccountInfoItem(AccountInfo accountInfoItem) {
		if (this.accountInfo == null) {
			this.accountInfo = new ArrayList<AccountInfo>();
		}
		this.accountInfo.add(accountInfoItem);
		return this;
	}

	/**
	 * Get accountInfo
	 * 
	 * @return accountInfo
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<AccountInfo> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountsList accountsList = (AccountsList) o;
		return Objects.equals(this.accountInfo, accountsList.accountInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountInfo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccountsList {\n");

		sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
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
