package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountTransactionInquiryResponseAccountTransactionInquiryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionInquiryResponseAccountTransactionInquiryResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  @JsonProperty("customer_name")
  private String customerName = null;

  @JsonProperty("customer_address")
  private String customerAddress = null;

  @JsonProperty("record_ctrl_out")
  private AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut recordCtrlOut = null;

  @JsonProperty("transactionList")
  private AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList transactionList = null;

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse statusCode(String statusCode) {
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

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse statusDesc(String statusDesc) {
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

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Get customerName
   * @return customerName
  **/
  @ApiModelProperty(value = "")


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse customerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
    return this;
  }

  /**
   * Get customerAddress
   * @return customerAddress
  **/
  @ApiModelProperty(value = "")


  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse recordCtrlOut(AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut recordCtrlOut) {
    this.recordCtrlOut = recordCtrlOut;
    return this;
  }

  /**
   * Get recordCtrlOut
   * @return recordCtrlOut
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut getRecordCtrlOut() {
    return recordCtrlOut;
  }

  public void setRecordCtrlOut(AccountTransactionInquiryResponseAccountTransactionInquiryResponseRecordCtrlOut recordCtrlOut) {
    this.recordCtrlOut = recordCtrlOut;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse transactionList(AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList transactionList) {
    this.transactionList = transactionList;
    return this;
  }

  /**
   * Get transactionList
   * @return transactionList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList getTransactionList() {
    return transactionList;
  }

  public void setTransactionList(AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionList transactionList) {
    this.transactionList = transactionList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryResponseAccountTransactionInquiryResponse accountTransactionInquiryResponseAccountTransactionInquiryResponse = (AccountTransactionInquiryResponseAccountTransactionInquiryResponse) o;
    return Objects.equals(this.statusCode, accountTransactionInquiryResponseAccountTransactionInquiryResponse.statusCode) &&
        Objects.equals(this.statusDesc, accountTransactionInquiryResponseAccountTransactionInquiryResponse.statusDesc) &&
        Objects.equals(this.customerName, accountTransactionInquiryResponseAccountTransactionInquiryResponse.customerName) &&
        Objects.equals(this.customerAddress, accountTransactionInquiryResponseAccountTransactionInquiryResponse.customerAddress) &&
        Objects.equals(this.recordCtrlOut, accountTransactionInquiryResponseAccountTransactionInquiryResponse.recordCtrlOut) &&
        Objects.equals(this.transactionList, accountTransactionInquiryResponseAccountTransactionInquiryResponse.transactionList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, customerName, customerAddress, recordCtrlOut, transactionList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryResponseAccountTransactionInquiryResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    customerAddress: ").append(toIndentedString(customerAddress)).append("\n");
    sb.append("    recordCtrlOut: ").append(toIndentedString(recordCtrlOut)).append("\n");
    sb.append("    transactionList: ").append(toIndentedString(transactionList)).append("\n");
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

