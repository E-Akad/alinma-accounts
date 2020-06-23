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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:49:50.479Z")

public class CustomerDepositResponse   {
  @JsonProperty("customer_deposit_response")
  private CustomerDepositResponseCustomerDepositResponse customerDepositResponse = null;

  public CustomerDepositResponse customerDepositResponse(CustomerDepositResponseCustomerDepositResponse customerDepositResponse) {
    this.customerDepositResponse = customerDepositResponse;
    return this;
  }

  /**
   * Get customerDepositResponse
   * @return customerDepositResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CustomerDepositResponseCustomerDepositResponse getCustomerDepositResponse() {
    return customerDepositResponse;
  }

  public void setCustomerDepositResponse(CustomerDepositResponseCustomerDepositResponse customerDepositResponse) {
    this.customerDepositResponse = customerDepositResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDepositResponse customerDepositResponse = (CustomerDepositResponse) o;
    return Objects.equals(this.customerDepositResponse, customerDepositResponse.customerDepositResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerDepositResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDepositResponse {\n");
    
    sb.append("    customerDepositResponse: ").append(toIndentedString(customerDepositResponse)).append("\n");
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

