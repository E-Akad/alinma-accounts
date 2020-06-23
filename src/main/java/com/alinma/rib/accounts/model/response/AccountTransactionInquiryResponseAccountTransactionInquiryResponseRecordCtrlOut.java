package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut   {
  @JsonProperty("matched_records")
  private Integer matchedRecords = null;

  @JsonProperty("sent_records")
  private Integer sentRecords = null;

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut matchedRecords(Integer matchedRecords) {
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

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut sentRecords(Integer sentRecords) {
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
    AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut accountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut = (AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut) o;
    return Objects.equals(this.matchedRecords, accountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut.matchedRecords) &&
        Objects.equals(this.sentRecords, accountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut.sentRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchedRecords, sentRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut {\n");
    
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

