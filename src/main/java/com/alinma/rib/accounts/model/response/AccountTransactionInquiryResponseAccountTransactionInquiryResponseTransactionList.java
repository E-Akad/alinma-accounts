package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList   {
  @JsonProperty("transaction_info")
  @Valid
  private List<AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo> transactionInfo = null;

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList transactionInfo(List<AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo> transactionInfo) {
    this.transactionInfo = transactionInfo;
    return this;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList addTransactionInfoItem(AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionInfoItem) {
    if (this.transactionInfo == null) {
      this.transactionInfo = new ArrayList<AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo>();
    }
    this.transactionInfo.add(transactionInfoItem);
    return this;
  }

  /**
   * Get transactionInfo
   * @return transactionInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo> getTransactionInfo() {
    return transactionInfo;
  }

  public void setTransactionInfo(List<AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo> transactionInfo) {
    this.transactionInfo = transactionInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList = (AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList) o;
    return Objects.equals(this.transactionInfo, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList.transactionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList {\n");
    
    sb.append("    transactionInfo: ").append(toIndentedString(transactionInfo)).append("\n");
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

