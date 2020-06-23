package com.alinma.rib.accounts.model.request;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ActivateAccountRequestActivateAccountRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T09:50:57.529Z")

public class ActivateAccountRequestActivateAccountRequest   {
  @JsonProperty("activation_type")
  private String activationType = null;

  public ActivateAccountRequestActivateAccountRequest activationType(String activationType) {
    this.activationType = activationType;
    return this;
  }

  /**
   * Get activationType
   * @return activationType
  **/
  @ApiModelProperty(value = "")


  public String getActivationType() {
    return activationType;
  }

  public void setActivationType(String activationType) {
    this.activationType = activationType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivateAccountRequestActivateAccountRequest activateAccountRequestActivateAccountRequest = (ActivateAccountRequestActivateAccountRequest) o;
    return Objects.equals(this.activationType, activateAccountRequestActivateAccountRequest.activationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivateAccountRequestActivateAccountRequest {\n");
    
    sb.append("    activationType: ").append(toIndentedString(activationType)).append("\n");
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

