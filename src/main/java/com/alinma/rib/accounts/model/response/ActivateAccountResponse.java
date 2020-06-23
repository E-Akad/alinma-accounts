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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:08:51.838Z")

public class ActivateAccountResponse   {
  @JsonProperty("activate_account_response")
  private ActivateAccountResponseActivateAccountResponse activateAccountResponse = null;

  public ActivateAccountResponse activateAccountResponse(ActivateAccountResponseActivateAccountResponse activateAccountResponse) {
    this.activateAccountResponse = activateAccountResponse;
    return this;
  }

  /**
   * Get activateAccountResponse
   * @return activateAccountResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ActivateAccountResponseActivateAccountResponse getActivateAccountResponse() {
    return activateAccountResponse;
  }

  public void setActivateAccountResponse(ActivateAccountResponseActivateAccountResponse activateAccountResponse) {
    this.activateAccountResponse = activateAccountResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivateAccountResponse activateAccountResponse = (ActivateAccountResponse) o;
    return Objects.equals(this.activateAccountResponse, activateAccountResponse.activateAccountResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activateAccountResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivateAccountResponse {\n");
    
    sb.append("    activateAccountResponse: ").append(toIndentedString(activateAccountResponse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

