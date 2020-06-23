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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T14:45:24.476Z")

public class HasDormantAccountResponse   {
  @JsonProperty("hasDormantAccountRs")
  private HasDormantAccountRs hasDormantAccountRs = null;

  public HasDormantAccountResponse hasDormantAccountRs(HasDormantAccountRs hasDormantAccountRs) {
    this.hasDormantAccountRs = hasDormantAccountRs;
    return this;
  }

  /**
   * Get hasDormantAccountRs
   * @return hasDormantAccountRs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public HasDormantAccountRs getHasDormantAccountRs() {
    return hasDormantAccountRs;
  }

  public void setHasDormantAccountRs(HasDormantAccountRs hasDormantAccountRs) {
    this.hasDormantAccountRs = hasDormantAccountRs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HasDormantAccountResponse hasDormantAccountResponse = (HasDormantAccountResponse) o;
    return Objects.equals(this.hasDormantAccountRs, hasDormantAccountResponse.hasDormantAccountRs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hasDormantAccountRs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HasDormantAccountResponse {\n");
    
    sb.append("    hasDormantAccountRs: ").append(toIndentedString(hasDormantAccountRs)).append("\n");
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

