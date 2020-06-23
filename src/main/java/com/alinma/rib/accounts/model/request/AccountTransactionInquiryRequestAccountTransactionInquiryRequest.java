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
 * AccountTransactionInquiryRequestAccountTransactionInquiryRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:15:07.433Z")

public class AccountTransactionInquiryRequestAccountTransactionInquiryRequest   {
  @JsonProperty("account_id")
  private AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountId = null;

  @JsonProperty("from_date")
  private String fromDate = null;

  @JsonProperty("to_date")
  private String toDate = null;

  @JsonProperty("from_date_hijri")
  private String fromDateHijri = null;

  @JsonProperty("to_date_hijri")
  private String toDateHijri = null;

  @JsonProperty("from_amount")
  private String fromAmount = null;

  @JsonProperty("to_amount")
  private String toAmount = null;

  @JsonProperty("transaction_code")
  private String transactionCode = null;

  @JsonProperty("transaction_type")
  private String transactionType = null;

  @JsonProperty("record_ctrl_in")
  private AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn recordCtrlIn = null;

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest accountId(AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId getAccountId() {
    return accountId;
  }

  public void setAccountId(AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountId) {
    this.accountId = accountId;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest fromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
  **/
  @ApiModelProperty(value = "")


  public String getFromDate() {
    return fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest toDate(String toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
  **/
  @ApiModelProperty(value = "")


  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest fromDateHijri(String fromDateHijri) {
    this.fromDateHijri = fromDateHijri;
    return this;
  }

  /**
   * Get fromDateHijri
   * @return fromDateHijri
  **/
  @ApiModelProperty(value = "")


  public String getFromDateHijri() {
    return fromDateHijri;
  }

  public void setFromDateHijri(String fromDateHijri) {
    this.fromDateHijri = fromDateHijri;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest toDateHijri(String toDateHijri) {
    this.toDateHijri = toDateHijri;
    return this;
  }

  /**
   * Get toDateHijri
   * @return toDateHijri
  **/
  @ApiModelProperty(value = "")


  public String getToDateHijri() {
    return toDateHijri;
  }

  public void setToDateHijri(String toDateHijri) {
    this.toDateHijri = toDateHijri;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest fromAmount(String fromAmount) {
    this.fromAmount = fromAmount;
    return this;
  }

  /**
   * Get fromAmount
   * @return fromAmount
  **/
  @ApiModelProperty(value = "")


  public String getFromAmount() {
    return fromAmount;
  }

  public void setFromAmount(String fromAmount) {
    this.fromAmount = fromAmount;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest toAmount(String toAmount) {
    this.toAmount = toAmount;
    return this;
  }

  /**
   * Get toAmount
   * @return toAmount
  **/
  @ApiModelProperty(value = "")


  public String getToAmount() {
    return toAmount;
  }

  public void setToAmount(String toAmount) {
    this.toAmount = toAmount;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest transactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
    return this;
  }

  /**
   * Get transactionCode
   * @return transactionCode
  **/
  @ApiModelProperty(value = "")


  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest transactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * Get transactionType
   * @return transactionType
  **/
  @ApiModelProperty(value = "")


  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest recordCtrlIn(AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn recordCtrlIn) {
    this.recordCtrlIn = recordCtrlIn;
    return this;
  }

  /**
   * Get recordCtrlIn
   * @return recordCtrlIn
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn getRecordCtrlIn() {
    return recordCtrlIn;
  }

  public void setRecordCtrlIn(AccountTransactionInquiryRequestAccountTransactionInquiryRequestRecordCtrlIn recordCtrlIn) {
    this.recordCtrlIn = recordCtrlIn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryRequestAccountTransactionInquiryRequest accountTransactionInquiryRequestAccountTransactionInquiryRequest = (AccountTransactionInquiryRequestAccountTransactionInquiryRequest) o;
    return Objects.equals(this.accountId, accountTransactionInquiryRequestAccountTransactionInquiryRequest.accountId) &&
        Objects.equals(this.fromDate, accountTransactionInquiryRequestAccountTransactionInquiryRequest.fromDate) &&
        Objects.equals(this.toDate, accountTransactionInquiryRequestAccountTransactionInquiryRequest.toDate) &&
        Objects.equals(this.fromDateHijri, accountTransactionInquiryRequestAccountTransactionInquiryRequest.fromDateHijri) &&
        Objects.equals(this.toDateHijri, accountTransactionInquiryRequestAccountTransactionInquiryRequest.toDateHijri) &&
        Objects.equals(this.fromAmount, accountTransactionInquiryRequestAccountTransactionInquiryRequest.fromAmount) &&
        Objects.equals(this.toAmount, accountTransactionInquiryRequestAccountTransactionInquiryRequest.toAmount) &&
        Objects.equals(this.transactionCode, accountTransactionInquiryRequestAccountTransactionInquiryRequest.transactionCode) &&
        Objects.equals(this.transactionType, accountTransactionInquiryRequestAccountTransactionInquiryRequest.transactionType) &&
        Objects.equals(this.recordCtrlIn, accountTransactionInquiryRequestAccountTransactionInquiryRequest.recordCtrlIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, fromDate, toDate, fromDateHijri, toDateHijri, fromAmount, toAmount, transactionCode, transactionType, recordCtrlIn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryRequestAccountTransactionInquiryRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    fromDateHijri: ").append(toIndentedString(fromDateHijri)).append("\n");
    sb.append("    toDateHijri: ").append(toIndentedString(toDateHijri)).append("\n");
    sb.append("    fromAmount: ").append(toIndentedString(fromAmount)).append("\n");
    sb.append("    toAmount: ").append(toIndentedString(toAmount)).append("\n");
    sb.append("    transactionCode: ").append(toIndentedString(transactionCode)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    recordCtrlIn: ").append(toIndentedString(recordCtrlIn)).append("\n");
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

