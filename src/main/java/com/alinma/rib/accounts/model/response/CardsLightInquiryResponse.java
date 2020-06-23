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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T14:29:06.910Z")

public class CardsLightInquiryResponse   {
  @JsonProperty("cards_light_inquiry_response")
  private CardsLightInquiryResponseCardsLightInquiryResponse cardsLightInquiryResponse = null;

  public CardsLightInquiryResponse cardsLightInquiryResponse(CardsLightInquiryResponseCardsLightInquiryResponse cardsLightInquiryResponse) {
    this.cardsLightInquiryResponse = cardsLightInquiryResponse;
    return this;
  }

  /**
   * Get cardsLightInquiryResponse
   * @return cardsLightInquiryResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CardsLightInquiryResponseCardsLightInquiryResponse getCardsLightInquiryResponse() {
    return cardsLightInquiryResponse;
  }

  public void setCardsLightInquiryResponse(CardsLightInquiryResponseCardsLightInquiryResponse cardsLightInquiryResponse) {
    this.cardsLightInquiryResponse = cardsLightInquiryResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsLightInquiryResponse cardsLightInquiryResponse = (CardsLightInquiryResponse) o;
    return Objects.equals(this.cardsLightInquiryResponse, cardsLightInquiryResponse.cardsLightInquiryResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardsLightInquiryResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsLightInquiryResponse {\n");
    
    sb.append("    cardsLightInquiryResponse: ").append(toIndentedString(cardsLightInquiryResponse)).append("\n");
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

