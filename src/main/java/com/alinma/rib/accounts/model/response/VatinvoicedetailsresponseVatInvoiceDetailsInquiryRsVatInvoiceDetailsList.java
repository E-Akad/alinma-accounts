package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-21T11:04:33.447Z")

public class VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList   {
  @JsonProperty("VatInvoiceDetailsInfo")
  @Valid
  private List<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo> vatInvoiceDetailsInfo = null;

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatInvoiceDetailsInfo(List<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo> vatInvoiceDetailsInfo) {
    this.vatInvoiceDetailsInfo = vatInvoiceDetailsInfo;
    return this;
  }

  public VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList addVatInvoiceDetailsInfoItem(VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo vatInvoiceDetailsInfoItem) {
    if (this.vatInvoiceDetailsInfo == null) {
      this.vatInvoiceDetailsInfo = new ArrayList<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo>();
    }
    this.vatInvoiceDetailsInfo.add(vatInvoiceDetailsInfoItem);
    return this;
  }

  /**
   * Get vatInvoiceDetailsInfo
   * @return vatInvoiceDetailsInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo> getVatInvoiceDetailsInfo() {
    return vatInvoiceDetailsInfo;
  }

  public void setVatInvoiceDetailsInfo(List<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo> vatInvoiceDetailsInfo) {
    this.vatInvoiceDetailsInfo = vatInvoiceDetailsInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList = (VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList) o;
    return Objects.equals(this.vatInvoiceDetailsInfo, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList.vatInvoiceDetailsInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vatInvoiceDetailsInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsList {\n");
    
    sb.append("    vatInvoiceDetailsInfo: ").append(toIndentedString(vatInvoiceDetailsInfo)).append("\n");
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

