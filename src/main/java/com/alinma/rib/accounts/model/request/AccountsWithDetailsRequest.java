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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:28:08.667Z")

public class AccountsWithDetailsRequest   {
  @JsonProperty("function_id")
  private String functionId = null;

  public AccountsWithDetailsRequest functionId(String functionId) {
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
    AccountsWithDetailsRequest accountsWithDetailsRequest = (AccountsWithDetailsRequest) o;
    return Objects.equals(this.functionId, accountsWithDetailsRequest.functionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(functionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithDetailsRequest {\n");
    
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

