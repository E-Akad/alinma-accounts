package com.alinma.rib.accounts.model.response;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo   {
  @JsonProperty("transaction_ref_number")
  private String transactionRefNumber = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("transaction_date")
  private LocalDate transactionDate = null;

  @JsonProperty("transaction_code_desc")
  private String transactionCodeDesc = null;

  @JsonProperty("amount_with_currency")
  private String amountWithCurrency = null;

  @JsonProperty("transaction_datetime")
  private String transactionDatetime = null;

  @JsonProperty("debit_amount")
  private Double debitAmount = null;

  @JsonProperty("credit_amount")
  private Double creditAmount = null;

  @JsonProperty("channel_desc")
  private String channelDesc = null;

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionRefNumber(String transactionRefNumber) {
    this.transactionRefNumber = transactionRefNumber;
    return this;
  }

  /**
   * Get transactionRefNumber
   * @return transactionRefNumber
  **/
  @ApiModelProperty(value = "")


  public String getTransactionRefNumber() {
    return transactionRefNumber;
  }

  public void setTransactionRefNumber(String transactionRefNumber) {
    this.transactionRefNumber = transactionRefNumber;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * Get memo
   * @return memo
  **/
  @ApiModelProperty(value = "")


  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
    return this;
  }

  /**
   * Get transactionDate
   * @return transactionDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionCodeDesc(String transactionCodeDesc) {
    this.transactionCodeDesc = transactionCodeDesc;
    return this;
  }

  /**
   * Get transactionCodeDesc
   * @return transactionCodeDesc
  **/
  @ApiModelProperty(value = "")


  public String getTransactionCodeDesc() {
    return transactionCodeDesc;
  }

  public void setTransactionCodeDesc(String transactionCodeDesc) {
    this.transactionCodeDesc = transactionCodeDesc;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo amountWithCurrency(String amountWithCurrency) {
    this.amountWithCurrency = amountWithCurrency;
    return this;
  }

  /**
   * Get amountWithCurrency
   * @return amountWithCurrency
  **/
  @ApiModelProperty(value = "")


  public String getAmountWithCurrency() {
    return amountWithCurrency;
  }

  public void setAmountWithCurrency(String amountWithCurrency) {
    this.amountWithCurrency = amountWithCurrency;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionDatetime(String transactionDatetime) {
    this.transactionDatetime = transactionDatetime;
    return this;
  }

  /**
   * Get transactionDatetime
   * @return transactionDatetime
  **/
  @ApiModelProperty(value = "")


  public String getTransactionDatetime() {
    return transactionDatetime;
  }

  public void setTransactionDatetime(String transactionDatetime) {
    this.transactionDatetime = transactionDatetime;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo debitAmount(Double debitAmount) {
    this.debitAmount = debitAmount;
    return this;
  }

  /**
   * Get debitAmount
   * @return debitAmount
  **/
  @ApiModelProperty(value = "")


  public Double getDebitAmount() {
    return debitAmount;
  }

  public void setDebitAmount(Double debitAmount) {
    this.debitAmount = debitAmount;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo creditAmount(Double creditAmount) {
    this.creditAmount = creditAmount;
    return this;
  }

  /**
   * Get creditAmount
   * @return creditAmount
  **/
  @ApiModelProperty(value = "")


  public Double getCreditAmount() {
    return creditAmount;
  }

  public void setCreditAmount(Double creditAmount) {
    this.creditAmount = creditAmount;
  }

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo channelDesc(String channelDesc) {
    this.channelDesc = channelDesc;
    return this;
  }

  /**
   * Get channelDesc
   * @return channelDesc
  **/
  @ApiModelProperty(value = "")


  public String getChannelDesc() {
    return channelDesc;
  }

  public void setChannelDesc(String channelDesc) {
    this.channelDesc = channelDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo = (AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo) o;
    return Objects.equals(this.transactionRefNumber, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.transactionRefNumber) &&
        Objects.equals(this.description, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.description) &&
        Objects.equals(this.memo, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.memo) &&
        Objects.equals(this.transactionDate, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.transactionDate) &&
        Objects.equals(this.transactionCodeDesc, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.transactionCodeDesc) &&
        Objects.equals(this.amountWithCurrency, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.amountWithCurrency) &&
        Objects.equals(this.transactionDatetime, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.transactionDatetime) &&
        Objects.equals(this.debitAmount, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.debitAmount) &&
        Objects.equals(this.creditAmount, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.creditAmount) &&
        Objects.equals(this.channelDesc, accountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo.channelDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionRefNumber, description, memo, transactionDate, transactionCodeDesc, amountWithCurrency, transactionDatetime, debitAmount, creditAmount, channelDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo {\n");
    
    sb.append("    transactionRefNumber: ").append(toIndentedString(transactionRefNumber)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
    sb.append("    transactionCodeDesc: ").append(toIndentedString(transactionCodeDesc)).append("\n");
    sb.append("    amountWithCurrency: ").append(toIndentedString(amountWithCurrency)).append("\n");
    sb.append("    transactionDatetime: ").append(toIndentedString(transactionDatetime)).append("\n");
    sb.append("    debitAmount: ").append(toIndentedString(debitAmount)).append("\n");
    sb.append("    creditAmount: ").append(toIndentedString(creditAmount)).append("\n");
    sb.append("    channelDesc: ").append(toIndentedString(channelDesc)).append("\n");
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

