package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SendIbanRs
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-02T15:53:51.379Z")

public class SendIbanRs   {
  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("statusDesc")
  private String statusDesc = null;

  @JsonProperty("maskedMobileNumber")
  private String maskedMobileNumber = null;

  @JsonProperty("iban")
  private String iban = null;

  public SendIbanRs statusCode(String statusCode) {
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

  public SendIbanRs statusDesc(String statusDesc) {
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

  public SendIbanRs maskedMobileNumber(String maskedMobileNumber) {
    this.maskedMobileNumber = maskedMobileNumber;
    return this;
  }

  /**
   * Get maskedMobileNumber
   * @return maskedMobileNumber
  **/
  @ApiModelProperty(value = "")


  public String getMaskedMobileNumber() {
    return maskedMobileNumber;
  }

  public void setMaskedMobileNumber(String maskedMobileNumber) {
    this.maskedMobileNumber = maskedMobileNumber;
  }

  public SendIbanRs iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  **/
  @ApiModelProperty(value = "")


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendIbanRs SendIbanRs = (SendIbanRs) o;
    return Objects.equals(this.statusCode, SendIbanRs.statusCode) &&
        Objects.equals(this.statusDesc, SendIbanRs.statusDesc) &&
        Objects.equals(this.maskedMobileNumber, SendIbanRs.maskedMobileNumber) &&
        Objects.equals(this.iban, SendIbanRs.iban);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, maskedMobileNumber, iban);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendIbanRs {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    maskedMobileNumber: ").append(toIndentedString(maskedMobileNumber)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
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

