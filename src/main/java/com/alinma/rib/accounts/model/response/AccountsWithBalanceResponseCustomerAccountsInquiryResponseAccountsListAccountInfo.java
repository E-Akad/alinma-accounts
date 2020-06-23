package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-10T14:54:03.592Z")

public class AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo   {
  @JsonProperty("account_number")
  private Long accountNumber = null;

  @JsonProperty("account_label")
  private String accountLabel = null;

  @JsonProperty("currency_code")
  private String currencyCode = null;

  @JsonProperty("currency_desc")
  private String currencyDesc = null;

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo accountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")


  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo accountLabel(String accountLabel) {
    this.accountLabel = accountLabel;
    return this;
  }

  /**
   * Get accountLabel
   * @return accountLabel
  **/
  @ApiModelProperty(value = "")


  public String getAccountLabel() {
    return accountLabel;
  }

  public void setAccountLabel(String accountLabel) {
    this.accountLabel = accountLabel;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * Get currencyCode
   * @return currencyCode
  **/
  @ApiModelProperty(value = "")


  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo currencyDesc(String currencyDesc) {
    this.currencyDesc = currencyDesc;
    return this;
  }

  /**
   * Get currencyDesc
   * @return currencyDesc
  **/
  @ApiModelProperty(value = "")


  public String getCurrencyDesc() {
    return currencyDesc;
  }

  public void setCurrencyDesc(String currencyDesc) {
    this.currencyDesc = currencyDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo = (AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo) o;
    return Objects.equals(this.accountNumber, accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo.accountNumber) &&
        Objects.equals(this.accountLabel, accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo.accountLabel) &&
        Objects.equals(this.currencyCode, accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo.currencyCode) &&
        Objects.equals(this.currencyDesc, accountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo.currencyDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, accountLabel, currencyCode, currencyDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceResponseCustomerAccountsInquiryResponseAccountsListAccountInfo {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountLabel: ").append(toIndentedString(accountLabel)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    currencyDesc: ").append(toIndentedString(currencyDesc)).append("\n");
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

