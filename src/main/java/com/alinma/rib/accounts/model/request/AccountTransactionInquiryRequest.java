package com.alinma.rib.accounts.model.request;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:15:07.433Z")

public class AccountTransactionInquiryRequest   {
  @JsonProperty("account_transaction_inquiry_request")
  private AccountTransactionInquiryRequestAccountTransactionInquiryRequest accountTransactionInquiryRequest = null;

  public AccountTransactionInquiryRequest accountTransactionInquiryRequest(AccountTransactionInquiryRequestAccountTransactionInquiryRequest accountTransactionInquiryRequest) {
    this.accountTransactionInquiryRequest = accountTransactionInquiryRequest;
    return this;
  }

  /**
   * Get accountTransactionInquiryRequest
   * @return accountTransactionInquiryRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequest getAccountTransactionInquiryRequest() {
    return accountTransactionInquiryRequest;
  }

  public void setAccountTransactionInquiryRequest(AccountTransactionInquiryRequestAccountTransactionInquiryRequest accountTransactionInquiryRequest) {
    this.accountTransactionInquiryRequest = accountTransactionInquiryRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryRequest accountTransactionInquiryRequest = (AccountTransactionInquiryRequest) o;
    return Objects.equals(this.accountTransactionInquiryRequest, accountTransactionInquiryRequest.accountTransactionInquiryRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTransactionInquiryRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryRequest {\n");
    
    sb.append("    accountTransactionInquiryRequest: ").append(toIndentedString(accountTransactionInquiryRequest)).append("\n");
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

