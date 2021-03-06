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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T12:45:32.659Z")

public class AccountStatementSettingResponse   {
  @JsonProperty("update_account_statement_setting_response")
  private AccountStatementSettingResponseUpdateAccountStatementSettingResponse updateAccountStatementSettingResponse = null;

  public AccountStatementSettingResponse updateAccountStatementSettingResponse(AccountStatementSettingResponseUpdateAccountStatementSettingResponse updateAccountStatementSettingResponse) {
    this.updateAccountStatementSettingResponse = updateAccountStatementSettingResponse;
    return this;
  }

  /**
   * Get updateAccountStatementSettingResponse
   * @return updateAccountStatementSettingResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountStatementSettingResponseUpdateAccountStatementSettingResponse getUpdateAccountStatementSettingResponse() {
    return updateAccountStatementSettingResponse;
  }

  public void setUpdateAccountStatementSettingResponse(AccountStatementSettingResponseUpdateAccountStatementSettingResponse updateAccountStatementSettingResponse) {
    this.updateAccountStatementSettingResponse = updateAccountStatementSettingResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementSettingResponse accountStatementSettingResponse = (AccountStatementSettingResponse) o;
    return Objects.equals(this.updateAccountStatementSettingResponse, accountStatementSettingResponse.updateAccountStatementSettingResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateAccountStatementSettingResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementSettingResponse {\n");
    
    sb.append("    updateAccountStatementSettingResponse: ").append(toIndentedString(updateAccountStatementSettingResponse)).append("\n");
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

