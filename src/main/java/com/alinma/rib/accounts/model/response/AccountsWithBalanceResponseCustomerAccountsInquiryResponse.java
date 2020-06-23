package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceResponseCustomerAccountsInquiryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-10T14:54:03.592Z")

public class AccountsWithBalanceResponseCustomerAccountsInquiryResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  @JsonProperty("accounts_list")
  private AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList accountsList = null;

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponse statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  **/
  @ApiModelProperty(value = "")


  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponse statusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
    return this;
  }

  /**
   * Get statusDesc
   * @return statusDesc
  **/
  @ApiModelProperty(value = "")


  public String getStatusDesc() {
    return statusDesc;
  }

  public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponse accountsList(AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList accountsList) {
    this.accountsList = accountsList;
    return this;
  }

  /**
   * Get accountsList
   * @return accountsList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList getAccountsList() {
    return accountsList;
  }

  public void setAccountsList(AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsList accountsList) {
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
    AccountsWithBalanceResponseCustomerAccountsInquiryResponse accountsWithBalanceResponseCustomerAccountsInquiryResponse = (AccountsWithBalanceResponseCustomerAccountsInquiryResponse) o;
    return Objects.equals(this.statusCode, accountsWithBalanceResponseCustomerAccountsInquiryResponse.statusCode) &&
        Objects.equals(this.statusDesc, accountsWithBalanceResponseCustomerAccountsInquiryResponse.statusDesc) &&
        Objects.equals(this.accountsList, accountsWithBalanceResponseCustomerAccountsInquiryResponse.accountsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, accountsList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceResponseCustomerAccountsInquiryResponse {\n");
    
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

