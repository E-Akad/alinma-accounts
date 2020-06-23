package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo
 */
@Getter
@Setter
@ToString
public class VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo   {
  private String value1 = null;

  private String value2 = null;

  private String value3 = null;

  private String value4 = null;

  private String value5 = null;

  private String value6 = null;


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo = (VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo) o;
    return Objects.equals(this.value1, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value1) &&
        Objects.equals(this.value2, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value2) &&
        Objects.equals(this.value3, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value3) &&
        Objects.equals(this.value4, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value4) &&
        Objects.equals(this.value5, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value5) &&
        Objects.equals(this.value6, vatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo.value6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value1, value2, value3, value4, value5, value6);
  }

}

