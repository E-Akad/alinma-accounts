package com.alinma.rib.accounts.model.response;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRs
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-16T15:51:54.124Z")

public class AccountStatementInquiryResponseStmtDtlsInqRs   {
 // @JsonProperty("status_code")
  private String statusCode = null;

 // @JsonProperty("status_desc")
  private String statusDesc = null;

 // @JsonProperty("record_control_out")
  private AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut recordControlOut = null;

 // @JsonProperty("customer_info")
  private AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo customerInfo = null;

 // @JsonProperty("from_date")
  private LocalDate fromDate = null;

//  @JsonProperty("to_date")
  private LocalDate toDate = null;

 // @JsonProperty("opening_balance")
  private Double openingBalance = null;

//  @JsonProperty("closing_balance")
  private Double closingBalance = null;

 // @JsonProperty("account_currency")
  private String accountCurrency = null;

 // @JsonProperty("total_debit_amount")
  private Double totalDebitAmount = null;

//  @JsonProperty("total_credit_amount")
  private Double totalCreditAmount = null;

 // @JsonProperty("number_of_deposits")
  private Integer numberOfDeposits = null;

 // @JsonProperty("number_of_withdraws")
  private Integer numberOfWithdraws = null;

 // @JsonProperty("marketing_image")
  private String marketingImage = null;

 // @JsonProperty("statement_graph_list")
  private AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList statementGraphList = null;

//  @JsonProperty("statement_transaction_list")
  private AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList statementTransactionList = null;

  public AccountStatementInquiryResponseStmtDtlsInqRs statusCode(String statusCode) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRs statusDesc(String statusDesc) {
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

  public AccountStatementInquiryResponseStmtDtlsInqRs recordControlOut(AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut recordControlOut) {
    this.recordControlOut = recordControlOut;
    return this;
  }

  /**
   * Get recordControlOut
   * @return recordControlOut
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut getRecordControlOut() {
    return recordControlOut;
  }

  public void setRecordControlOut(AccountStatementInquiryResponseStmtDtlsInqRsRecordControlOut recordControlOut) {
    this.recordControlOut = recordControlOut;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs customerInfo(AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo customerInfo) {
    this.customerInfo = customerInfo;
    return this;
  }

  /**
   * Get customerInfo
   * @return customerInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo getCustomerInfo() {
    return customerInfo;
  }

  public void setCustomerInfo(AccountStatementInquiryResponseStmtDtlsInqRsCustomerInfo customerInfo) {
    this.customerInfo = customerInfo;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs fromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs toDate(LocalDate toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs openingBalance(Double openingBalance) {
    this.openingBalance = openingBalance;
    return this;
  }

  /**
   * Get openingBalance
   * @return openingBalance
  **/
  @ApiModelProperty(value = "")


  public Double getOpeningBalance() {
    return openingBalance;
  }

  public void setOpeningBalance(Double openingBalance) {
    this.openingBalance = openingBalance;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs closingBalance(Double closingBalance) {
    this.closingBalance = closingBalance;
    return this;
  }

  /**
   * Get closingBalance
   * @return closingBalance
  **/
  @ApiModelProperty(value = "")


  public Double getClosingBalance() {
    return closingBalance;
  }

  public void setClosingBalance(Double closingBalance) {
    this.closingBalance = closingBalance;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs accountCurrency(String accountCurrency) {
    this.accountCurrency = accountCurrency;
    return this;
  }

  /**
   * Get accountCurrency
   * @return accountCurrency
  **/
  @ApiModelProperty(value = "")


  public String getAccountCurrency() {
    return accountCurrency;
  }

  public void setAccountCurrency(String accountCurrency) {
    this.accountCurrency = accountCurrency;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs totalDebitAmount(Double totalDebitAmount) {
    this.totalDebitAmount = totalDebitAmount;
    return this;
  }

  /**
   * Get totalDebitAmount
   * @return totalDebitAmount
  **/
  @ApiModelProperty(value = "")


  public Double getTotalDebitAmount() {
    return totalDebitAmount;
  }

  public void setTotalDebitAmount(Double totalDebitAmount) {
    this.totalDebitAmount = totalDebitAmount;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs totalCreditAmount(Double totalCreditAmount) {
    this.totalCreditAmount = totalCreditAmount;
    return this;
  }

  /**
   * Get totalCreditAmount
   * @return totalCreditAmount
  **/
  @ApiModelProperty(value = "")


  public Double getTotalCreditAmount() {
    return totalCreditAmount;
  }

  public void setTotalCreditAmount(Double totalCreditAmount) {
    this.totalCreditAmount = totalCreditAmount;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs numberOfDeposits(Integer numberOfDeposits) {
    this.numberOfDeposits = numberOfDeposits;
    return this;
  }

  /**
   * Get numberOfDeposits
   * @return numberOfDeposits
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfDeposits() {
    return numberOfDeposits;
  }

  public void setNumberOfDeposits(Integer numberOfDeposits) {
    this.numberOfDeposits = numberOfDeposits;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs numberOfWithdraws(Integer numberOfWithdraws) {
    this.numberOfWithdraws = numberOfWithdraws;
    return this;
  }

  /**
   * Get numberOfWithdraws
   * @return numberOfWithdraws
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfWithdraws() {
    return numberOfWithdraws;
  }

  public void setNumberOfWithdraws(Integer numberOfWithdraws) {
    this.numberOfWithdraws = numberOfWithdraws;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs marketingImage(String marketingImage) {
    this.marketingImage = marketingImage;
    return this;
  }

  /**
   * Get marketingImage
   * @return marketingImage
  **/
  @ApiModelProperty(value = "")


  public String getMarketingImage() {
    return marketingImage;
  }

  public void setMarketingImage(String marketingImage) {
    this.marketingImage = marketingImage;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs statementGraphList(AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList statementGraphList) {
    this.statementGraphList = statementGraphList;
    return this;
  }

  /**
   * Get statementGraphList
   * @return statementGraphList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList getStatementGraphList() {
    return statementGraphList;
  }

  public void setStatementGraphList(AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphList statementGraphList) {
    this.statementGraphList = statementGraphList;
  }

  public AccountStatementInquiryResponseStmtDtlsInqRs statementTransactionList(AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList statementTransactionList) {
    this.statementTransactionList = statementTransactionList;
    return this;
  }

  /**
   * Get statementTransactionList
   * @return statementTransactionList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList getStatementTransactionList() {
    return statementTransactionList;
  }

  public void setStatementTransactionList(AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionList statementTransactionList) {
    this.statementTransactionList = statementTransactionList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementInquiryResponseStmtDtlsInqRs accountStatementInquiryResponseStmtDtlsInqRs = (AccountStatementInquiryResponseStmtDtlsInqRs) o;
    return Objects.equals(this.statusCode, accountStatementInquiryResponseStmtDtlsInqRs.statusCode) &&
        Objects.equals(this.statusDesc, accountStatementInquiryResponseStmtDtlsInqRs.statusDesc) &&
        Objects.equals(this.recordControlOut, accountStatementInquiryResponseStmtDtlsInqRs.recordControlOut) &&
        Objects.equals(this.customerInfo, accountStatementInquiryResponseStmtDtlsInqRs.customerInfo) &&
        Objects.equals(this.fromDate, accountStatementInquiryResponseStmtDtlsInqRs.fromDate) &&
        Objects.equals(this.toDate, accountStatementInquiryResponseStmtDtlsInqRs.toDate) &&
        Objects.equals(this.openingBalance, accountStatementInquiryResponseStmtDtlsInqRs.openingBalance) &&
        Objects.equals(this.closingBalance, accountStatementInquiryResponseStmtDtlsInqRs.closingBalance) &&
        Objects.equals(this.accountCurrency, accountStatementInquiryResponseStmtDtlsInqRs.accountCurrency) &&
        Objects.equals(this.totalDebitAmount, accountStatementInquiryResponseStmtDtlsInqRs.totalDebitAmount) &&
        Objects.equals(this.totalCreditAmount, accountStatementInquiryResponseStmtDtlsInqRs.totalCreditAmount) &&
        Objects.equals(this.numberOfDeposits, accountStatementInquiryResponseStmtDtlsInqRs.numberOfDeposits) &&
        Objects.equals(this.numberOfWithdraws, accountStatementInquiryResponseStmtDtlsInqRs.numberOfWithdraws) &&
        Objects.equals(this.marketingImage, accountStatementInquiryResponseStmtDtlsInqRs.marketingImage) &&
        Objects.equals(this.statementGraphList, accountStatementInquiryResponseStmtDtlsInqRs.statementGraphList) &&
        Objects.equals(this.statementTransactionList, accountStatementInquiryResponseStmtDtlsInqRs.statementTransactionList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, recordControlOut, customerInfo, fromDate, toDate, openingBalance, closingBalance, accountCurrency, totalDebitAmount, totalCreditAmount, numberOfDeposits, numberOfWithdraws, marketingImage, statementGraphList, statementTransactionList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementInquiryResponseStmtDtlsInqRs {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    recordControlOut: ").append(toIndentedString(recordControlOut)).append("\n");
    sb.append("    customerInfo: ").append(toIndentedString(customerInfo)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    openingBalance: ").append(toIndentedString(openingBalance)).append("\n");
    sb.append("    closingBalance: ").append(toIndentedString(closingBalance)).append("\n");
    sb.append("    accountCurrency: ").append(toIndentedString(accountCurrency)).append("\n");
    sb.append("    totalDebitAmount: ").append(toIndentedString(totalDebitAmount)).append("\n");
    sb.append("    totalCreditAmount: ").append(toIndentedString(totalCreditAmount)).append("\n");
    sb.append("    numberOfDeposits: ").append(toIndentedString(numberOfDeposits)).append("\n");
    sb.append("    numberOfWithdraws: ").append(toIndentedString(numberOfWithdraws)).append("\n");
    sb.append("    marketingImage: ").append(toIndentedString(marketingImage)).append("\n");
    sb.append("    statementGraphList: ").append(toIndentedString(statementGraphList)).append("\n");
    sb.append("    statementTransactionList: ").append(toIndentedString(statementTransactionList)).append("\n");
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

