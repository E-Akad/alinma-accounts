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
 * CardsChargesAndFeesResponseCardsChargesAndFeesResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesResponseCardsChargesAndFeesResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  @JsonProperty("fee_list")
  private CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList feeList = null;

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponse statusCode(String statusCode) {
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

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponse statusDesc(String statusDesc) {
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

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponse feeList(CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList feeList) {
    this.feeList = feeList;
    return this;
  }

  /**
   * Get feeList
   * @return feeList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList getFeeList() {
    return feeList;
  }

  public void setFeeList(CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList feeList) {
    this.feeList = feeList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesResponseCardsChargesAndFeesResponse cardsChargesAndFeesResponseCardsChargesAndFeesResponse = (CardsChargesAndFeesResponseCardsChargesAndFeesResponse) o;
    return Objects.equals(this.statusCode, cardsChargesAndFeesResponseCardsChargesAndFeesResponse.statusCode) &&
        Objects.equals(this.statusDesc, cardsChargesAndFeesResponseCardsChargesAndFeesResponse.statusDesc) &&
        Objects.equals(this.feeList, cardsChargesAndFeesResponseCardsChargesAndFeesResponse.feeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, feeList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesResponseCardsChargesAndFeesResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    feeList: ").append(toIndentedString(feeList)).append("\n");
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

