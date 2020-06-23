package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo   {
  @JsonProperty("alinma_id")
  private String alinmaId = null;

  @JsonProperty("full_name")
  private String fullName = null;

  @JsonProperty("branch_id")
  private String branchId = null;

  @JsonProperty("address")
  private String address = null;

  public AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo alinmaId(String alinmaId) {
    this.alinmaId = alinmaId;
    return this;
  }

  /**
   * Get alinmaId
   * @return alinmaId
  **/
  @ApiModelProperty(value = "")


  public String getAlinmaId() {
    return alinmaId;
  }

  public void setAlinmaId(String alinmaId) {
    this.alinmaId = alinmaId;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Get fullName
   * @return fullName
  **/
  @ApiModelProperty(value = "")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo branchId(String branchId) {
    this.branchId = branchId;
    return this;
  }

  /**
   * Get branchId
   * @return branchId
  **/
  @ApiModelProperty(value = "")


  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo accountStatementInquiryResponseStmtDtlsInqRsCustomerInfo = (AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo) o;
    return Objects.equals(this.alinmaId, accountStatementInquiryResponseStmtDtlsInqRsCustomerInfo.alinmaId) &&
        Objects.equals(this.fullName, accountStatementInquiryResponseStmtDtlsInqRsCustomerInfo.fullName) &&
        Objects.equals(this.branchId, accountStatementInquiryResponseStmtDtlsInqRsCustomerInfo.branchId) &&
        Objects.equals(this.address, accountStatementInquiryResponseStmtDtlsInqRsCustomerInfo.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alinmaId, fullName, branchId, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo {\n");
    
    sb.append("    alinmaId: ").append(toIndentedString(alinmaId)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

