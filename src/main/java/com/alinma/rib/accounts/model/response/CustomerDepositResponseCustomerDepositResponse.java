package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerDepositResponseCustomerDepositResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:49:50.479Z")

public class CustomerDepositResponseCustomerDepositResponse   {
  @JsonProperty("investment_account_list")
  private CustomerDepositResponseCustomerDepositResponseInvestmentAccountList investmentAccountList = null;

  public CustomerDepositResponseCustomerDepositResponse investmentAccountList(CustomerDepositResponseCustomerDepositResponseInvestmentAccountList investmentAccountList) {
    this.investmentAccountList = investmentAccountList;
    return this;
  }

  /**
   * Get investmentAccountList
   * @return investmentAccountList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CustomerDepositResponseCustomerDepositResponseInvestmentAccountList getInvestmentAccountList() {
    return investmentAccountList;
  }

  public void setInvestmentAccountList(CustomerDepositResponseCustomerDepositResponseInvestmentAccountList investmentAccountList) {
    this.investmentAccountList = investmentAccountList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDepositResponseCustomerDepositResponse customerDepositResponseCustomerDepositResponse = (CustomerDepositResponseCustomerDepositResponse) o;
    return Objects.equals(this.investmentAccountList, customerDepositResponseCustomerDepositResponse.investmentAccountList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(investmentAccountList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDepositResponseCustomerDepositResponse {\n");
    
    sb.append("    investmentAccountList: ").append(toIndentedString(investmentAccountList)).append("\n");
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

