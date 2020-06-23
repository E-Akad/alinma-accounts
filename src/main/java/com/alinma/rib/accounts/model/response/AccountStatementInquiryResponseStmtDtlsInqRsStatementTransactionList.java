package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList   {
 // @JsonProperty("statement_transaction_info")
  @Valid
  private List<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo> statementTransactionInfo = null;

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList statementTransactionInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo> statementTransactionInfo) {
    this.statementTransactionInfo = statementTransactionInfo;
    return this;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList addStatementTransactionInfoItem(AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo statementTransactionInfoItem) {
    if (this.statementTransactionInfo == null) {
      this.statementTransactionInfo = new ArrayList<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo>();
    }
    this.statementTransactionInfo.add(statementTransactionInfoItem);
    return this;
  }

  /**
   * Get statementTransactionInfo
   * @return statementTransactionInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo> getStatementTransactionInfo() {
    return statementTransactionInfo;
  }

  public void setStatementTransactionInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo> statementTransactionInfo) {
    this.statementTransactionInfo = statementTransactionInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList = (AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList) o;
    return Objects.equals(this.statementTransactionInfo, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList.statementTransactionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statementTransactionInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList {\n");
    
    sb.append("    statementTransactionInfo: ").append(toIndentedString(statementTransactionInfo)).append("\n");
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

