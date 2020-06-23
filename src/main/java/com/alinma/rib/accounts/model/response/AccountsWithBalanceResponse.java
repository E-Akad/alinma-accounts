package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-10T14:54:03.592Z")

public class AccountsWithBalanceResponse   {
  @JsonProperty("customerAccountsInquiryResponse")
  private CustomerAccountsInquiryResponse customerAccountsInquiryResponse = null;

  public AccountsWithBalanceResponse customerAccountsInquiryResponse(CustomerAccountsInquiryResponse customerAccountsInquiryResponse) {
    this.customerAccountsInquiryResponse = customerAccountsInquiryResponse;
    return this;
  }

  /**
   * Get customerAccountsInquiryResponse
   * @return customerAccountsInquiryResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CustomerAccountsInquiryResponse getCustomerAccountsInquiryResponse() {
    return customerAccountsInquiryResponse;
  }

  public void setCustomerAccountsInquiryResponse(CustomerAccountsInquiryResponse customerAccountsInquiryResponse) {
    this.customerAccountsInquiryResponse = customerAccountsInquiryResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithBalanceResponse accountsWithBalanceResponse = (AccountsWithBalanceResponse) o;
    return Objects.equals(this.customerAccountsInquiryResponse, accountsWithBalanceResponse.customerAccountsInquiryResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerAccountsInquiryResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceResponse {\n");
    
    sb.append("    customerAccountsInquiryResponse: ").append(toIndentedString(customerAccountsInquiryResponse)).append("\n");
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

