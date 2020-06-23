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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-02T15:53:51.379Z")

public class SendIbanResponse   {
  @JsonProperty("sendIbanRs")
  private SendIbanRs sendIbanRs = null;

  public SendIbanResponse sendIbanRs(SendIbanRs sendIbanRs) {
    this.sendIbanRs = sendIbanRs;
    return this;
  }

  /**
   * Get sendIbanRs
   * @return sendIbanRs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SendIbanRs getSendIbanRs() {
    return sendIbanRs;
  }

  public void setSendIbanRs(SendIbanRs sendIbanRs) {
    this.sendIbanRs = sendIbanRs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendIbanResponse sendIbanResponse = (SendIbanResponse) o;
    return Objects.equals(this.sendIbanRs, sendIbanResponse.sendIbanRs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sendIbanRs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendIbanResponse {\n");
    
    sb.append("    sendIbanRs: ").append(toIndentedString(sendIbanRs)).append("\n");
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

