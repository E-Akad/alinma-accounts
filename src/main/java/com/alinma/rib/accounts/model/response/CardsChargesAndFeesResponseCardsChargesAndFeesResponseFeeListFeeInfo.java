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
 * CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo   {
  @JsonProperty("fee_field_label")
  @Valid
  private List<String> feeFieldLabel = null;

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo feeFieldLabel(List<String> feeFieldLabel) {
    this.feeFieldLabel = feeFieldLabel;
    return this;
  }

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo addFeeFieldLabelItem(String feeFieldLabelItem) {
    if (this.feeFieldLabel == null) {
      this.feeFieldLabel = new ArrayList<String>();
    }
    this.feeFieldLabel.add(feeFieldLabelItem);
    return this;
  }

  /**
   * Get feeFieldLabel
   * @return feeFieldLabel
  **/
  @ApiModelProperty(value = "")


  public List<String> getFeeFieldLabel() {
    return feeFieldLabel;
  }

  public void setFeeFieldLabel(List<String> feeFieldLabel) {
    this.feeFieldLabel = feeFieldLabel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo cardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo = (CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo) o;
    return Objects.equals(this.feeFieldLabel, cardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo.feeFieldLabel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeFieldLabel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesResponseCardsChargesAndFeesResponseFeeListFeeInfo {\n");
    
    sb.append("    feeFieldLabel: ").append(toIndentedString(feeFieldLabel)).append("\n");
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

