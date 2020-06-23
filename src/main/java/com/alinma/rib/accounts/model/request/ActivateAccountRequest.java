package com.alinma.rib.accounts.model.request;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T09:50:57.529Z")

public class ActivateAccountRequest   {
  @JsonProperty("activate_account_request")
  private ActivateAccountRequestActivateAccountRequest activateAccountRequest = null;

  public ActivateAccountRequest activateAccountRequest(ActivateAccountRequestActivateAccountRequest activateAccountRequest) {
    this.activateAccountRequest = activateAccountRequest;
    return this;
  }

  /**
   * Get activateAccountRequest
   * @return activateAccountRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ActivateAccountRequestActivateAccountRequest getActivateAccountRequest() {
    return activateAccountRequest;
  }

  public void setActivateAccountRequest(ActivateAccountRequestActivateAccountRequest activateAccountRequest) {
    this.activateAccountRequest = activateAccountRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivateAccountRequest activateAccountRequest = (ActivateAccountRequest) o;
    return Objects.equals(this.activateAccountRequest, activateAccountRequest.activateAccountRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activateAccountRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivateAccountRequest {\n");
    
    sb.append("    activateAccountRequest: ").append(toIndentedString(activateAccountRequest)).append("\n");
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

