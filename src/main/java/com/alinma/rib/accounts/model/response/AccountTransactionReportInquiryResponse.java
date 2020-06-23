package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionReportInquiryResponse   {

	private String statusCode = null;

  private String statusDesc = null;

  @JsonProperty("report")
  private String report = null;

  public AccountTransactionReportInquiryResponse statusCode(String statusCode) {
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

  public AccountTransactionReportInquiryResponse statusDesc(String statusDesc) {
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

  public AccountTransactionReportInquiryResponse report(String report) {
    this.report = report;
    return this;
  }

  /**
   * Get report
   * @return report
  **/
  @ApiModelProperty(value = "")


  public String getReport() {
    return report;
  }

  public void setReport(String report) {
    this.report = report;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionReportInquiryResponse accountTransactionReportInquiryResponse = (AccountTransactionReportInquiryResponse) o;
    return Objects.equals(this.statusCode, accountTransactionReportInquiryResponse.statusCode) &&
        Objects.equals(this.statusDesc, accountTransactionReportInquiryResponse.statusDesc) &&
        Objects.equals(this.report, accountTransactionReportInquiryResponse.report);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, report);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionReportInquiryResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
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

