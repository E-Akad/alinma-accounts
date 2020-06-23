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
 * CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList   {
  @JsonProperty("fee_info")
  @Valid
  private List<CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo> feeInfo = null;

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList feeInfo(List<CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo> feeInfo) {
    this.feeInfo = feeInfo;
    return this;
  }

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList addFeeInfoItem(CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo feeInfoItem) {
    if (this.feeInfo == null) {
      this.feeInfo = new ArrayList<CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo>();
    }
    this.feeInfo.add(feeInfoItem);
    return this;
  }

  /**
   * Get feeInfo
   * @return feeInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo> getFeeInfo() {
    return feeInfo;
  }

  public void setFeeInfo(List<CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo> feeInfo) {
    this.feeInfo = feeInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList cardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList = (CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList) o;
    return Objects.equals(this.feeInfo, cardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList.feeInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeList {\n");
    
    sb.append("    feeInfo: ").append(toIndentedString(feeInfo)).append("\n");
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

