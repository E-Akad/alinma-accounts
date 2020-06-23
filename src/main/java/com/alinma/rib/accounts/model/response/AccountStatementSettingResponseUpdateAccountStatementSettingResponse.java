package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountStatementSettingResponseUpdateAccountStatementSettingResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T12:45:32.659Z")

public class AccountStatementSettingResponseUpdateAccountStatementSettingResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  public AccountStatementSettingResponseUpdateAccountStatementSettingResponse statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  **/
  @ApiModelProperty(value = "")


  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public AccountStatementSettingResponseUpdateAccountStatementSettingResponse statusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
    return this;
  }

  /**
   * Get statusDesc
   * @return statusDesc
  **/
  @ApiModelProperty(value = "")


  public String getStatusDesc() {
    return statusDesc;
  }

  public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementSettingResponseUpdateAccountStatementSettingResponse accountStatementSettingResponseUpdateAccountStatementSettingResponse = (AccountStatementSettingResponseUpdateAccountStatementSettingResponse) o;
    return Objects.equals(this.statusCode, accountStatementSettingResponseUpdateAccountStatementSettingResponse.statusCode) &&
        Objects.equals(this.statusDesc, accountStatementSettingResponseUpdateAccountStatementSettingResponse.statusDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementSettingResponseUpdateAccountStatementSettingResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
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

