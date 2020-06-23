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
 * AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn   {
  @JsonProperty("max_records")
  private String maxRecords = null;

  @JsonProperty("offset")
  private String offset = null;

  public AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn maxRecords(String maxRecords) {
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

  public AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn offset(String offset) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn accountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn = (AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn) o;
    return Objects.equals(this.maxRecords, accountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn.maxRecords) &&
        Objects.equals(this.offset, accountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxRecords, offset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn {\n");
    
    sb.append("    maxRecords: ").append(toIndentedString(maxRecords)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

