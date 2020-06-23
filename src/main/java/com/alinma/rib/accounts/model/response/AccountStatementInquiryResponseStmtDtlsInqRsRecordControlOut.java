package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut   {
  @JsonProperty("matched_records")
  private Integer matchedRecords = null;

  @JsonProperty("sent_records")
  private Integer sentRecords = null;

  public AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut matchedRecords(Integer matchedRecords) {
    this.matchedRecords = matchedRecords;
    return this;
  }

  /**
   * Get matchedRecords
   * @return matchedRecords
  **/
  @ApiModelProperty(value = "")


  public Integer getMatchedRecords() {
    return matchedRecords;
  }

  public void setMatchedRecords(Integer matchedRecords) {
    this.matchedRecords = matchedRecords;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut sentRecords(Integer sentRecords) {
    this.sentRecords = sentRecords;
    return this;
  }

  /**
   * Get sentRecords
   * @return sentRecords
  **/
  @ApiModelProperty(value = "")


  public Integer getSentRecords() {
    return sentRecords;
  }

  public void setSentRecords(Integer sentRecords) {
    this.sentRecords = sentRecords;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut accountStatementInquiryResponseStmtDtlsInqRsRecordControlOut = (AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut) o;
    return Objects.equals(this.matchedRecords, accountStatementInquiryResponseStmtDtlsInqRsRecordControlOut.matchedRecords) &&
        Objects.equals(this.sentRecords, accountStatementInquiryResponseStmtDtlsInqRsRecordControlOut.sentRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchedRecords, sentRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut {\n");
    
    sb.append("    matchedRecords: ").append(toIndentedString(matchedRecords)).append("\n");
    sb.append("    sentRecords: ").append(toIndentedString(sentRecords)).append("\n");
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

