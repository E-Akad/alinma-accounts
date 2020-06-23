package com.alinma.rib.accounts.model.request;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:15:07.433Z")

public class AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn   {
  @JsonProperty("max_records")
  private String maxRecords = null;

  @JsonProperty("offset")
  private String offset = null;

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn maxRecords(String maxRecords) {
    this.maxRecords = maxRecords;
    return this;
  }

  /**
   * Get maxRecords
   * @return maxRecords
  **/
  @ApiModelProperty(value = "")


  public String getMaxRecords() {
    return maxRecords;
  }

  public void setMaxRecords(String maxRecords) {
    this.maxRecords = maxRecords;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn offset(String offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")


  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn accountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn = (AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn) o;
    return Objects.equals(this.maxRecords, accountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn.maxRecords) &&
        Objects.equals(this.offset, accountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxRecords, offset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn {\n");
    
    sb.append("    maxRecords: ").append(toIndentedString(maxRecords)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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

