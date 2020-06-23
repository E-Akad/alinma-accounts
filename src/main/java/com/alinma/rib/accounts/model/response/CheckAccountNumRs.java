package com.alinma.rib.accounts.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CheckAccountNumResponseCheckAccountNumRs
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T08:37:02.592Z")

public class CheckAccountNumRs   {
  @JsonProperty("StatusCode")
  private String statusCode = null;

  @JsonProperty("StatusDesc")
  private String statusDesc = null;

  @JsonProperty("bmsErrorShow")
  private Boolean bmsErrorShow = null;

  @JsonProperty("accountName")
  private String accountName = null;

  public CheckAccountNumRs statusCode(String statusCode) {
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

  public CheckAccountNumRs statusDesc(String statusDesc) {
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

  public CheckAccountNumRs bmsErrorShow(Boolean bmsErrorShow) {
    this.bmsErrorShow = bmsErrorShow;
    return this;
  }

  /**
   * Get bmsErrorShow
   * @return bmsErrorShow
  **/
  @ApiModelProperty(value = "")


  public Boolean isBmsErrorShow() {
    return bmsErrorShow;
  }

  public void setBmsErrorShow(Boolean bmsErrorShow) {
    this.bmsErrorShow = bmsErrorShow;
  }

  public CheckAccountNumRs accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  /**
   * Get accountName
   * @return accountName
  **/
  @ApiModelProperty(value = "")


  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckAccountNumRs checkAccountNumResponseCheckAccountNumRs = (CheckAccountNumRs) o;
    return Objects.equals(this.statusCode, checkAccountNumResponseCheckAccountNumRs.statusCode) &&
        Objects.equals(this.statusDesc, checkAccountNumResponseCheckAccountNumRs.statusDesc) &&
        Objects.equals(this.bmsErrorShow, checkAccountNumResponseCheckAccountNumRs.bmsErrorShow) &&
        Objects.equals(this.accountName, checkAccountNumResponseCheckAccountNumRs.accountName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, bmsErrorShow, accountName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckAccountNumResponseCheckAccountNumRs {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    bmsErrorShow: ").append(toIndentedString(bmsErrorShow)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
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

