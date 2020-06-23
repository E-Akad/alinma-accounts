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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponse   {
//  @JsonProperty("StmtDtlsInqRs")
  private AccountStatementInquiryResponseStmtDtlsInqRs stmtDtlsInqRs = null;

  public AccountStatementInquiryResponse stmtDtlsInqRs(AccountStatementInquiryResponseStmtDtlsInqRs stmtDtlsInqRs) {
    this.stmtDtlsInqRs = stmtDtlsInqRs;
    return this;
  }

  /**
   * Get stmtDtlsInqRs
   * @return stmtDtlsInqRs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementInquiryResponseStmtDtlsInqRs getStmtDtlsInqRs() {
    return stmtDtlsInqRs;
  }

  public void setStmtDtlsInqRs(AccountStatementInquiryResponseStmtDtlsInqRs stmtDtlsInqRs) {
    this.stmtDtlsInqRs = stmtDtlsInqRs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponse accountStatementInquiryResponse = (AccountStatementInquiryResponse) o;
    return Objects.equals(this.stmtDtlsInqRs, accountStatementInquiryResponse.stmtDtlsInqRs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stmtDtlsInqRs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponse {\n");
    
    sb.append("    stmtDtlsInqRs: ").append(toIndentedString(stmtDtlsInqRs)).append("\n");
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

