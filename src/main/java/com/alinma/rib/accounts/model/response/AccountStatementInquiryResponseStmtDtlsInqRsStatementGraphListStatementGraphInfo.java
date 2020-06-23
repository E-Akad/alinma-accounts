package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo   {
  /**
   * Gets or Sets transactionType
   */
  public enum TransactionTypeEnum {
    CR("CR"),
    
    DR("DR");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionTypeEnum fromValue(String text) {
      for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

 // @JsonProperty("transaction_type")
  private TransactionTypeEnum transactionType = null;

 // @JsonProperty("transaction_code_desc")
  private String transactionCodeDesc = null;

 // @JsonProperty("transaction_type_amount")
  private Double transactionTypeAmount = null;

 // @JsonProperty("percentage")
  private Double percentage = null;

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo transactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * Get transactionType
   * @return transactionType
  **/
  @ApiModelProperty(value = "")


  public TransactionTypeEnum getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo transactionCodeDesc(String transactionCodeDesc) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo transactionTypeAmount(Double transactionTypeAmount) {
    this.transactionTypeAmount = transactionTypeAmount;
    return this;
  }

  /**
   * Get transactionTypeAmount
   * @return transactionTypeAmount
  **/
  @ApiModelProperty(value = "")


  public Double getTransactionTypeAmount() {
    return transactionTypeAmount;
  }

  public void setTransactionTypeAmount(Double transactionTypeAmount) {
    this.transactionTypeAmount = transactionTypeAmount;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo percentage(Double percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
  **/
  @ApiModelProperty(value = "")


  public Double getPercentage() {
    return percentage;
  }

  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo = (AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo) o;
    return Objects.equals(this.transactionType, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo.transactionType) &&
        Objects.equals(this.transactionCodeDesc, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo.transactionCodeDesc) &&
        Objects.equals(this.transactionTypeAmount, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo.transactionTypeAmount) &&
        Objects.equals(this.percentage, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionType, transactionCodeDesc, transactionTypeAmount, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraphInfo {\n");
    
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    transactionCodeDesc: ").append(toIndentedString(transactionCodeDesc)).append("\n");
    sb.append("    transactionTypeAmount: ").append(toIndentedString(transactionTypeAmount)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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

