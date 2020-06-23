package com.alinma.rib.accounts.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T08:51:33.014Z")

public class CheckIdNumberResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  @JsonProperty("authentication_method_List")
  @Valid
  private List<String> authenticationMethodList = null;

  public CheckIdNumberResponse statusCode(String statusCode) {
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

  public CheckIdNumberResponse statusDesc(String statusDesc) {
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

  public CheckIdNumberResponse authenticationMethodList(List<String> authenticationMethodList) {
    this.authenticationMethodList = authenticationMethodList;
    return this;
  }

  public CheckIdNumberResponse addAuthenticationMethodListItem(String authenticationMethodListItem) {
    if (this.authenticationMethodList == null) {
      this.authenticationMethodList = new ArrayList<String>();
    }
    this.authenticationMethodList.add(authenticationMethodListItem);
    return this;
  }

  /**
   * Get authenticationMethodList
   * @return authenticationMethodList
  **/
  @ApiModelProperty(value = "")


  public List<String> getAuthenticationMethodList() {
    return authenticationMethodList;
  }

  public void setAuthenticationMethodList(List<String> authenticationMethodList) {
    this.authenticationMethodList = authenticationMethodList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckIdNumberResponse checkIdNumberResponse = (CheckIdNumberResponse) o;
    return Objects.equals(this.statusCode, checkIdNumberResponse.statusCode) &&
        Objects.equals(this.statusDesc, checkIdNumberResponse.statusDesc) &&
        Objects.equals(this.authenticationMethodList, checkIdNumberResponse.authenticationMethodList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, authenticationMethodList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckIdNumberResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    authenticationMethodList: ").append(toIndentedString(authenticationMethodList)).append("\n");
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

