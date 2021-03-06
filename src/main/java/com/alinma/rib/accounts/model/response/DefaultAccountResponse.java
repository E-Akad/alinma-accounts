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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-18T11:06:19.764Z")

public class DefaultAccountResponse   {
  @JsonProperty("defaultAccountRs")
  private DefaultAccountResponseDefaultAccountRs defaultAccountRs = null;

  public DefaultAccountResponse defaultAccountRs(DefaultAccountResponseDefaultAccountRs defaultAccountRs) {
    this.defaultAccountRs = defaultAccountRs;
    return this;
  }

  /**
   * Get defaultAccountRs
   * @return defaultAccountRs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DefaultAccountResponseDefaultAccountRs getDefaultAccountRs() {
    return defaultAccountRs;
  }

  public void setDefaultAccountRs(DefaultAccountResponseDefaultAccountRs defaultAccountRs) {
    this.defaultAccountRs = defaultAccountRs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultAccountResponse defaultAccountResponse = (DefaultAccountResponse) o;
    return Objects.equals(this.defaultAccountRs, defaultAccountResponse.defaultAccountRs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultAccountRs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultAccountResponse {\n");
    
    sb.append("    defaultAccountRs: ").append(toIndentedString(defaultAccountRs)).append("\n");
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

