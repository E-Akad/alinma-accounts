package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * HasDormantAccountRs
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T14:45:24.476Z")

public class HasDormantAccountRs   {
  @JsonProperty("hasDormantAccounts")
  private Boolean hasDormantAccounts = null;

  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("statusDesc")
  private String statusDesc = null;

  public HasDormantAccountRs hasDormantAccounts(Boolean hasDormantAccounts) {
    this.hasDormantAccounts = hasDormantAccounts;
    return this;
  }

  /**
   * Get hasDormantAccounts
   * @return hasDormantAccounts
  **/
  @ApiModelProperty(value = "")


  public Boolean isHasDormantAccounts() {
    return hasDormantAccounts;
  }

  public void setHasDormantAccounts(Boolean hasDormantAccounts) {
    this.hasDormantAccounts = hasDormantAccounts;
  }

  public HasDormantAccountRs statusCode(String statusCode) {
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

  public HasDormantAccountRs statusDesc(String statusDesc) {
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
    HasDormantAccountRs hasDormantAccountRs = (HasDormantAccountRs) o;
    return Objects.equals(this.hasDormantAccounts, hasDormantAccountRs.hasDormantAccounts) &&
        Objects.equals(this.statusCode, hasDormantAccountRs.statusCode) &&
        Objects.equals(this.statusDesc, hasDormantAccountRs.statusDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hasDormantAccounts, statusCode, statusDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HasDormantAccountRs {\n");
    
    sb.append("    hasDormantAccounts: ").append(toIndentedString(hasDormantAccounts)).append("\n");
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

