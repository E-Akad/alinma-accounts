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
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesResponse   {
  @JsonProperty("cards_charges_and_fees_response")
  private CardsChargesAndFeesResponseCardsChargesAndFeesResponse cardsChargesAndFeesResponse = null;

  public CardsChargesAndFeesResponse cardsChargesAndFeesResponse(CardsChargesAndFeesResponseCardsChargesAndFeesResponse cardsChargesAndFeesResponse) {
    this.cardsChargesAndFeesResponse = cardsChargesAndFeesResponse;
    return this;
  }

  /**
   * Get cardsChargesAndFeesResponse
   * @return cardsChargesAndFeesResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CardsChargesAndFeesResponseCardsChargesAndFeesResponse getCardsChargesAndFeesResponse() {
    return cardsChargesAndFeesResponse;
  }

  public void setCardsChargesAndFeesResponse(CardsChargesAndFeesResponseCardsChargesAndFeesResponse cardsChargesAndFeesResponse) {
    this.cardsChargesAndFeesResponse = cardsChargesAndFeesResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesResponse cardsChargesAndFeesResponse = (CardsChargesAndFeesResponse) o;
    return Objects.equals(this.cardsChargesAndFeesResponse, cardsChargesAndFeesResponse.cardsChargesAndFeesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardsChargesAndFeesResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesResponse {\n");
    
    sb.append("    cardsChargesAndFeesResponse: ").append(toIndentedString(cardsChargesAndFeesResponse)).append("\n");
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

