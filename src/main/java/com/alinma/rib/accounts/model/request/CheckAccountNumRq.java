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
 * CheckAccountNumRequestCheckAccountNumRq
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T08:37:02.592Z")

public class CheckAccountNumRq   {
  @JsonProperty("IBAN")
  private String IBAN = null;

  @JsonProperty("AccountNumber")
  private String accountNumber = null;

  public CheckAccountNumRq IBAN(String IBAN) {
    this.IBAN = IBAN;
    return this;
  }

  /**
   * Get IBAN
   * @return IBAN
  **/
  @ApiModelProperty(value = "")

@Size(max=35) 
  public String getIBAN() {
    return IBAN;
  }

  public void setIBAN(String IBAN) {
    this.IBAN = IBAN;
  }

  public CheckAccountNumRq accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")

@Size(max=14) 
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckAccountNumRq checkAccountNumRequestCheckAccountNumRq = (CheckAccountNumRq) o;
    return Objects.equals(this.IBAN, checkAccountNumRequestCheckAccountNumRq.IBAN) &&
        Objects.equals(this.accountNumber, checkAccountNumRequestCheckAccountNumRq.accountNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(IBAN, accountNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckAccountNumRequestCheckAccountNumRq {\n");
    
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
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

