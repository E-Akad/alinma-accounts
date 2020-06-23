package com.alinma.rib.accounts.model.request;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesRequest   {
  @JsonProperty("cards_charges_and_fees_request")
  private CardsChargesAndFeesRequestCardsChargesAndFeesRequest cardsChargesAndFeesRequest = null;

  public CardsChargesAndFeesRequest cardsChargesAndFeesRequest(CardsChargesAndFeesRequestCardsChargesAndFeesRequest cardsChargesAndFeesRequest) {
    this.cardsChargesAndFeesRequest = cardsChargesAndFeesRequest;
    return this;
  }

  /**
   * Get cardsChargesAndFeesRequest
   * @return cardsChargesAndFeesRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CardsChargesAndFeesRequestCardsChargesAndFeesRequest getCardsChargesAndFeesRequest() {
    return cardsChargesAndFeesRequest;
  }

  public void setCardsChargesAndFeesRequest(CardsChargesAndFeesRequestCardsChargesAndFeesRequest cardsChargesAndFeesRequest) {
    this.cardsChargesAndFeesRequest = cardsChargesAndFeesRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesRequest cardsChargesAndFeesRequest = (CardsChargesAndFeesRequest) o;
    return Objects.equals(this.cardsChargesAndFeesRequest, cardsChargesAndFeesRequest.cardsChargesAndFeesRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardsChargesAndFeesRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesRequest {\n");
    
    sb.append("    cardsChargesAndFeesRequest: ").append(toIndentedString(cardsChargesAndFeesRequest)).append("\n");
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

