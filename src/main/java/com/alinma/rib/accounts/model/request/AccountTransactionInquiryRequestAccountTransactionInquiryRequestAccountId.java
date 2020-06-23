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
 * AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:15:07.433Z")

public class AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId   {
  @JsonProperty("account_number")
  private String accountNumber = null;

  @JsonProperty("account_type")
  private String accountType = null;

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  **/
  @ApiModelProperty(value = "")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId accountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId = (AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId) o;
    return Objects.equals(this.accountNumber, accountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId.accountNumber) &&
        Objects.equals(this.accountType, accountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId.accountType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, accountType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionInquiryRequestAccountTransactionInquiryRequestAccountId {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
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

