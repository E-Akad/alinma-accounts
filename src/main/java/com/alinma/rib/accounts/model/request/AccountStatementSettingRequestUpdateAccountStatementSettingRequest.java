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
 * AccountStatementSettingRequestUpdateAccountStatementSettingRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T13:41:04.061Z")

public class AccountStatementSettingRequestUpdateAccountStatementSettingRequest   {
  @JsonProperty("account_id")
  private AccountStatementSettingRequestUpdateAccountStatementSettingRequestAccountId accountId = null;

  @JsonProperty("statement_delivery_opt")
  private String statementDeliveryOpt = null;

  public AccountStatementSettingRequestUpdateAccountStatementSettingRequest accountId(AccountStatementSettingRequestUpdateAccountStatementSettingRequestAccountId accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementSettingRequestUpdateAccountStatementSettingRequestAccountId getAccountId() {
    return accountId;
  }

  public void setAccountId(AccountStatementSettingRequestUpdateAccountStatementSettingRequestAccountId accountId) {
    this.accountId = accountId;
  }

  public AccountStatementSettingRequestUpdateAccountStatementSettingRequest statementDeliveryOpt(String statementDeliveryOpt) {
    this.statementDeliveryOpt = statementDeliveryOpt;
    return this;
  }

  /**
   * Get statementDeliveryOpt
   * @return statementDeliveryOpt
  **/
  @ApiModelProperty(value = "")


  public String getStatementDeliveryOpt() {
    return statementDeliveryOpt;
  }

  public void setStatementDeliveryOpt(String statementDeliveryOpt) {
    this.statementDeliveryOpt = statementDeliveryOpt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementSettingRequestUpdateAccountStatementSettingRequest accountStatementSettingRequestUpdateAccountStatementSettingRequest = (AccountStatementSettingRequestUpdateAccountStatementSettingRequest) o;
    return Objects.equals(this.accountId, accountStatementSettingRequestUpdateAccountStatementSettingRequest.accountId) &&
        Objects.equals(this.statementDeliveryOpt, accountStatementSettingRequestUpdateAccountStatementSettingRequest.statementDeliveryOpt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, statementDeliveryOpt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementSettingRequestUpdateAccountStatementSettingRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    statementDeliveryOpt: ").append(toIndentedString(statementDeliveryOpt)).append("\n");
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

