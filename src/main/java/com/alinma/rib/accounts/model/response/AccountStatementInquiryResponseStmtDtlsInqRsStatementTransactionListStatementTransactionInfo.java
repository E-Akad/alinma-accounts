package com.alinma.rib.accounts.model.response;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo   {
//  @JsonProperty("trans_date")
  private LocalDate transDate = null;

//  @JsonProperty("channel_desc")
  private String channelDesc = null;

//  @JsonProperty("transaction_code_desc")
  private String transactionCodeDesc = null;

 // @JsonProperty("referenceNumber")
  private String referenceNumber = null;

 // @JsonProperty("description")
  private String description = null;

//  @JsonProperty("debit")
  private Double debit = null;

//  @JsonProperty("credit")
  private Double credit = null;

 // @JsonProperty("balance")
  private Double balance = null;
  
//  @JsonProperty("amount")
  private Amount amount = null;
  
  private TransactionType transactionType =null;

  
  
  
  public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo transDate(LocalDate transDate) {
    this.transDate = transDate;
    return this;
  }

  /**
   * Get transDate
   * @return transDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getTransDate() {
    return transDate;
  }

  public void setTransDate(LocalDate transDate) {
    this.transDate = transDate;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo channelDesc(String channelDesc) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo transactionCodeDesc(String transactionCodeDesc) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo referenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
    return this;
  }

  /**
   * Get referenceNumber
   * @return referenceNumber
  **/
  @ApiModelProperty(value = "")


  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo description(String description) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo debit(Double debit) {
    this.debit = debit;
    return this;
  }

  /**
   * Get debit
   * @return debit
  **/
  @ApiModelProperty(value = "")


  public Double getDebit() {
    return debit;
  }

  public void setDebit(Double debit) {
    this.debit = debit;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo credit(Double credit) {
    this.credit = credit;
    return this;
  }

  /**
   * Get credit
   * @return credit
  **/
  @ApiModelProperty(value = "")


  public Double getCredit() {
    return credit;
  }

  public void setCredit(Double credit) {
    this.credit = credit;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(value = "")


  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo = (AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo) o;
    return Objects.equals(this.transDate, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.transDate) &&
        Objects.equals(this.channelDesc, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.channelDesc) &&
        Objects.equals(this.transactionCodeDesc, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.transactionCodeDesc) &&
        Objects.equals(this.referenceNumber, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.referenceNumber) &&
        Objects.equals(this.description, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.description) &&
        Objects.equals(this.debit, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.debit) &&
        Objects.equals(this.credit, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.credit) &&
        Objects.equals(this.balance, accountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transDate, channelDesc, transactionCodeDesc, referenceNumber, description, debit, credit, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo {\n");
    
    sb.append("    transDate: ").append(toIndentedString(transDate)).append("\n");
    sb.append("    channelDesc: ").append(toIndentedString(channelDesc)).append("\n");
    sb.append("    transactionCodeDesc: ").append(toIndentedString(transactionCodeDesc)).append("\n");
    sb.append("    referenceNumber: ").append(toIndentedString(referenceNumber)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    debit: ").append(toIndentedString(debit)).append("\n");
    sb.append("    credit: ").append(toIndentedString(credit)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

public TransactionType getTransType() {
	return transactionType;
}

public void setTransType(TransactionType transType) {
	this.transactionType = transType;
}
}

