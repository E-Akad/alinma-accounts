package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-10T14:54:03.592Z")

public class AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList   {
  @JsonProperty("account_info")
  @Valid
  private List<AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo> accountInfo = null;

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList accountInfo(List<AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo> accountInfo) {
    this.accountInfo = accountInfo;
    return this;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList addAccountInfoItem(AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo accountInfoItem) {
    if (this.accountInfo == null) {
      this.accountInfo = new ArrayList<AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo>();
    }
    this.accountInfo.add(accountInfoItem);
    return this;
  }

  /**
   * Get accountInfo
   * @return accountInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo> getAccountInfo() {
    return accountInfo;
  }

  public void setAccountInfo(List<AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo> accountInfo) {
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
    AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList = (AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList) o;
    return Objects.equals(this.accountInfo, accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList.accountInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList {\n");
    
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

