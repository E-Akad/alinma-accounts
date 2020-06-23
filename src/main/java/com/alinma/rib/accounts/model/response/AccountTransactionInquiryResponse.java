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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T18:15:42.647Z")

public class AccountTransactionInquiryResponse   {
  @JsonProperty("account_transaction_inquiry_response")
  private AccountTransactionInquiryResponseAccountTransactionInquiryResponse accountTransactionInquiryResponse = null;

  public AccountTransactionInquiryResponse accountTransactionInquiryResponse(AccountTransactionInquiryResponseAccountTransactionInquiryResponse accountTransactionInquiryResponse) {
    this.accountTransactionInquiryResponse = accountTransactionInquiryResponse;
    return this;
  }

  /**
   * Get accountTransactionInquiryResponse
   * @return accountTransactionInquiryResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryResponseAccountTransactionInquiryResponse getAccountTransactionInquiryResponse() {
    return accountTransactionInquiryResponse;
  }

  public void setAccountTransactionInquiryResponse(AccountTransactionInquiryResponseAccountTransactionInquiryResponse accountTransactionInquiryResponse) {
    this.accountTransactionInquiryResponse = accountTransactionInquiryResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryResponse accountTransactionInquiryResponse = (AccountTransactionInquiryResponse) o;
    return Objects.equals(this.accountTransactionInquiryResponse, accountTransactionInquiryResponse.accountTransactionInquiryResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTransactionInquiryResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryResponse {\n");
    
    sb.append("    accountTransactionInquiryResponse: ").append(toIndentedString(accountTransactionInquiryResponse)).append("\n");
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

