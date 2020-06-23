package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-21T11:04:33.447Z")

public class VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs   {
  @JsonProperty("StatusCode")
  private String statusCode = null;

  @JsonProperty("StatusDesc")
  private String statusDesc = null;

  @JsonProperty("VatInvoiceDetailsList")
  private VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatInvoiceDetailsList = null;

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs statusCode(String statusCode) {
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

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs statusDesc(String statusDesc) {
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

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs vatInvoiceDetailsList(VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatInvoiceDetailsList) {
    this.vatInvoiceDetailsList = vatInvoiceDetailsList;
    return this;
  }

  /**
   * Get vatInvoiceDetailsList
   * @return vatInvoiceDetailsList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList getVatInvoiceDetailsList() {
    return vatInvoiceDetailsList;
  }

  public void setVatInvoiceDetailsList(VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatInvoiceDetailsList) {
    this.vatInvoiceDetailsList = vatInvoiceDetailsList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs vatinvoicedetailsresponseVatInvoiceDetailsInquiryRs = (VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs) o;
    return Objects.equals(this.statusCode, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRs.statusCode) &&
        Objects.equals(this.statusDesc, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRs.statusDesc) &&
        Objects.equals(this.vatInvoiceDetailsList, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRs.vatInvoiceDetailsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, vatInvoiceDetailsList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VatinvoicedetailsresponseVatInvoiceDetailsInquiryRs {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    vatInvoiceDetailsList: ").append(toIndentedString(vatInvoiceDetailsList)).append("\n");
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

