package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerDepositResponseCustomerDepositResponseInvestmentAccountList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:49:50.479Z")

public class CustomerDepositResponseCustomerDepositResponseInvestmentAccountList   {
  @JsonProperty("investment_account_info")
  @Valid
  private List<CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo> investmentAccountInfo = null;

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountList investmentAccountInfo(List<CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo> investmentAccountInfo) {
    this.investmentAccountInfo = investmentAccountInfo;
    return this;
  }

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountList addInvestmentAccountInfoItem(CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo investmentAccountInfoItem) {
    if (this.investmentAccountInfo == null) {
      this.investmentAccountInfo = new ArrayList<CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo>();
    }
    this.investmentAccountInfo.add(investmentAccountInfoItem);
    return this;
  }

  /**
   * Get investmentAccountInfo
   * @return investmentAccountInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo> getInvestmentAccountInfo() {
    return investmentAccountInfo;
  }

  public void setInvestmentAccountInfo(List<CustomerDepositResponseCustomerDepositResponseInvestmentAccountListInvestmentAccountInfo> investmentAccountInfo) {
    this.investmentAccountInfo = investmentAccountInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDepositResponseCustomerDepositResponseInvestmentAccountList customerDepositResponseCustomerDepositResponseInvestmentAccountList = (CustomerDepositResponseCustomerDepositResponseInvestmentAccountList) o;
    return Objects.equals(this.investmentAccountInfo, customerDepositResponseCustomerDepositResponseInvestmentAccountList.investmentAccountInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(investmentAccountInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDepositResponseCustomerDepositResponseInvestmentAccountList {\n");
    
    sb.append("    investmentAccountInfo: ").append(toIndentedString(investmentAccountInfo)).append("\n");
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

