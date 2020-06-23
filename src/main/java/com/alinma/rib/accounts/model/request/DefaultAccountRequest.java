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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-18T11:06:19.764Z")

public class DefaultAccountRequest   {
  @JsonProperty("defaultAccountRq")
  private DefaultAccountRequestDefaultAccountRq defaultAccountRq = null;

  public DefaultAccountRequest defaultAccountRq(DefaultAccountRequestDefaultAccountRq defaultAccountRq) {
    this.defaultAccountRq = defaultAccountRq;
    return this;
  }

  /**
   * Get defaultAccountRq
   * @return defaultAccountRq
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DefaultAccountRequestDefaultAccountRq getDefaultAccountRq() {
    return defaultAccountRq;
  }

  public void setDefaultAccountRq(DefaultAccountRequestDefaultAccountRq defaultAccountRq) {
    this.defaultAccountRq = defaultAccountRq;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultAccountRequest defaultAccountRequest = (DefaultAccountRequest) o;
    return Objects.equals(this.defaultAccountRq, defaultAccountRequest.defaultAccountRq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultAccountRq);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultAccountRequest {\n");
    
    sb.append("    defaultAccountRq: ").append(toIndentedString(defaultAccountRq)).append("\n");
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

