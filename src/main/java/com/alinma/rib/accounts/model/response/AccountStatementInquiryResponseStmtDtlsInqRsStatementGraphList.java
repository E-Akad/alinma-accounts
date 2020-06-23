package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList   {
 // @JsonProperty("statement_graph_info")
  @Valid
  private List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> statementGraphInfo = null;

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList statementGraphInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> statementGraphInfo) {
    this.statementGraphInfo = statementGraphInfo;
    return this;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList addStatementGraphInfoItem(AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo statementGraphInfoItem) {
    if (this.statementGraphInfo == null) {
      this.statementGraphInfo = new ArrayList<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo>();
    }
    this.statementGraphInfo.add(statementGraphInfoItem);
    return this;
  }

  /**
   * Get statementGraphInfo
   * @return statementGraphInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> getStatementGraphInfo() {
    return statementGraphInfo;
  }

  public void setStatementGraphInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo> statementGraphInfo) {
    this.statementGraphInfo = statementGraphInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList accountStatementInquiryResponseStmtDtlsInqRsStatementGraphList = (AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList) o;
    return Objects.equals(this.statementGraphInfo, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphList.statementGraphInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statementGraphInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList {\n");
    
    sb.append("    statementGraphInfo: ").append(toIndentedString(statementGraphInfo)).append("\n");
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

