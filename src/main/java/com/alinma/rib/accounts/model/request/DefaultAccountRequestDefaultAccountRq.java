package com.alinma.rib.accounts.model.request;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DefaultAccountRequestDefaultAccountRq
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-18T11:06:19.764Z")

public class DefaultAccountRequestDefaultAccountRq   {
  @JsonProperty("setDefault")
  private Boolean setDefault = null;

  public DefaultAccountRequestDefaultAccountRq setDefault(Boolean setDefault) {
    this.setDefault = setDefault;
    return this;
  }

  /**
   * Get setDefault
   * @return setDefault
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isSetDefault() {
    return setDefault;
  }

  public void setSetDefault(Boolean setDefault) {
    this.setDefault = setDefault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultAccountRequestDefaultAccountRq defaultAccountRequestDefaultAccountRq = (DefaultAccountRequestDefaultAccountRq) o;
    return Objects.equals(this.setDefault, defaultAccountRequestDefaultAccountRq.setDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(setDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultAccountRequestDefaultAccountRq {\n");
    
    sb.append("    setDefault: ").append(toIndentedString(setDefault)).append("\n");
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

