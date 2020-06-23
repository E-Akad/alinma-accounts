package com.alinma.rib.accounts.model.response;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:49:50.479Z")

public class CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo   {
  @JsonProperty("sub_req_number")
  private String subReqNumber = null;

  @JsonProperty("main_inv_amount")
  private String mainInvAmount = null;

  @JsonProperty("sub_start_date")
  private LocalDate subStartDate = null;

  @JsonProperty("sub_end_date")
  private LocalDate subEndDate = null;

  @JsonProperty("sub_period")
  private String subPeriod = null;

  @JsonProperty("ant_rate")
  private String antRate = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("profit_realized")
  private String profitRealized = null;

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo subReqNumber(String subReqNumber) {
    this.subReqNumber = subReqNumber;
    return this;
  }

  /**
   * Get subReqNumber
   * @return subReqNumber
  **/
  @ApiModelProperty(value = "")


  public String getSubReqNumber() {
    return subReqNumber;
  }

  public void setSubReqNumber(String subReqNumber) {
    this.subReqNumber = subReqNumber;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo mainInvAmount(String mainInvAmount) {
    this.mainInvAmount = mainInvAmount;
    return this;
  }

  /**
   * Get mainInvAmount
   * @return mainInvAmount
  **/
  @ApiModelProperty(value = "")


  public String getMainInvAmount() {
    return mainInvAmount;
  }

  public void setMainInvAmount(String mainInvAmount) {
    this.mainInvAmount = mainInvAmount;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo subStartDate(LocalDate subStartDate) {
    this.subStartDate = subStartDate;
    return this;
  }

  /**
   * Get subStartDate
   * @return subStartDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getSubStartDate() {
    return subStartDate;
  }

  public void setSubStartDate(LocalDate subStartDate) {
    this.subStartDate = subStartDate;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo subEndDate(LocalDate subEndDate) {
    this.subEndDate = subEndDate;
    return this;
  }

  /**
   * Get subEndDate
   * @return subEndDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getSubEndDate() {
    return subEndDate;
  }

  public void setSubEndDate(LocalDate subEndDate) {
    this.subEndDate = subEndDate;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo subPeriod(String subPeriod) {
    this.subPeriod = subPeriod;
    return this;
  }

  /**
   * Get subPeriod
   * @return subPeriod
  **/
  @ApiModelProperty(value = "")


  public String getSubPeriod() {
    return subPeriod;
  }

  public void setSubPeriod(String subPeriod) {
    this.subPeriod = subPeriod;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo antRate(String antRate) {
    this.antRate = antRate;
    return this;
  }

  /**
   * Get antRate
   * @return antRate
  **/
  @ApiModelProperty(value = "")


  public String getAntRate() {
    return antRate;
  }

  public void setAntRate(String antRate) {
    this.antRate = antRate;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo profitRealized(String profitRealized) {
    this.profitRealized = profitRealized;
    return this;
  }

  /**
   * Get profitRealized
   * @return profitRealized
  **/
  @ApiModelProperty(value = "")


  public String getProfitRealized() {
    return profitRealized;
  }

  public void setProfitRealized(String profitRealized) {
    this.profitRealized = profitRealized;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo = (CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo) o;
    return Objects.equals(this.subReqNumber, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.subReqNumber) &&
        Objects.equals(this.mainInvAmount, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.mainInvAmount) &&
        Objects.equals(this.subStartDate, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.subStartDate) &&
        Objects.equals(this.subEndDate, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.subEndDate) &&
        Objects.equals(this.subPeriod, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.subPeriod) &&
        Objects.equals(this.antRate, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.antRate) &&
        Objects.equals(this.status, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.status) &&
        Objects.equals(this.profitRealized, customerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo.profitRealized);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subReqNumber, mainInvAmount, subStartDate, subEndDate, subPeriod, antRate, status, profitRealized);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo {\n");
    
    sb.append("    subReqNumber: ").append(toIndentedString(subReqNumber)).append("\n");
    sb.append("    mainInvAmount: ").append(toIndentedString(mainInvAmount)).append("\n");
    sb.append("    subStartDate: ").append(toIndentedString(subStartDate)).append("\n");
    sb.append("    subEndDate: ").append(toIndentedString(subEndDate)).append("\n");
    sb.append("    subPeriod: ").append(toIndentedString(subPeriod)).append("\n");
    sb.append("    antRate: ").append(toIndentedString(antRate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    profitRealized: ").append(toIndentedString(profitRealized)).append("\n");
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

