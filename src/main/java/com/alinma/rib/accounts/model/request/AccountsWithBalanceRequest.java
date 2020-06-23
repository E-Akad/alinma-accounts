package com.alinma.rib.accounts.model.request;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-22T07:22:54.680Z")

public class AccountsWithBalanceRequest   {
  @JsonProperty("function_id")
  private String functionId = null;

  public AccountsWithBalanceRequest functionId(String functionId) {
    this.functionId = functionId;
    return this;
  }

  /**
   * Get functionId
   * @return functionId
  **/
  @ApiModelProperty(value = "")


  public String getFunctionId() {
    return functionId;
  }

  public void setFunctionId(String functionId) {
    this.functionId = functionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithBalanceRequest accountsWithBalanceRequest = (AccountsWithBalanceRequest) o;
    return Objects.equals(this.functionId, accountsWithBalanceRequest.functionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(functionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceRequest {\n");
    
    sb.append("    functionId: ").append(toIndentedString(functionId)).append("\n");
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

