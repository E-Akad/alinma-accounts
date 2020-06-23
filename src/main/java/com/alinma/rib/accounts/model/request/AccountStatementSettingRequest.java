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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T13:41:04.061Z")

public class AccountStatementSettingRequest   {
  @JsonProperty("update_account_statement_setting_request")
  private AccountStatementSettingRequestUpdateAccountStatementSettingRequest updateAccountStatementSettingRequest = null;

  public AccountStatementSettingRequest updateAccountStatementSettingRequest(AccountStatementSettingRequestUpdateAccountStatementSettingRequest updateAccountStatementSettingRequest) {
    this.updateAccountStatementSettingRequest = updateAccountStatementSettingRequest;
    return this;
  }

  /**
   * Get updateAccountStatementSettingRequest
   * @return updateAccountStatementSettingRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementSettingRequestUpdateAccountStatementSettingRequest getUpdateAccountStatementSettingRequest() {
    return updateAccountStatementSettingRequest;
  }

  public void setUpdateAccountStatementSettingRequest(AccountStatementSettingRequestUpdateAccountStatementSettingRequest updateAccountStatementSettingRequest) {
    this.updateAccountStatementSettingRequest = updateAccountStatementSettingRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementSettingRequest accountStatementSettingRequest = (AccountStatementSettingRequest) o;
    return Objects.equals(this.updateAccountStatementSettingRequest, accountStatementSettingRequest.updateAccountStatementSettingRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateAccountStatementSettingRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementSettingRequest {\n");
    
    sb.append("    updateAccountStatementSettingRequest: ").append(toIndentedString(updateAccountStatementSettingRequest)).append("\n");
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

