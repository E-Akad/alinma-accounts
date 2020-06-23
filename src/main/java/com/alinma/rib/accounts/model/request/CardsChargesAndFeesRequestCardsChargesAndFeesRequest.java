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
 * CardsChargesAndFeesRequestCardsChargesAndFeesRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:36:15.287Z")

public class CardsChargesAndFeesRequestCardsChargesAndFeesRequest   {
  @JsonProperty("card_type")
  private String cardType = null;

  public CardsChargesAndFeesRequestCardsChargesAndFeesRequest cardType(String cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * Get cardType
   * @return cardType
  **/
  @ApiModelProperty(value = "")


  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsChargesAndFeesRequestCardsChargesAndFeesRequest cardsChargesAndFeesRequestCardsChargesAndFeesRequest = (CardsChargesAndFeesRequestCardsChargesAndFeesRequest) o;
    return Objects.equals(this.cardType, cardsChargesAndFeesRequestCardsChargesAndFeesRequest.cardType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsChargesAndFeesRequestCardsChargesAndFeesRequest {\n");
    
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
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

