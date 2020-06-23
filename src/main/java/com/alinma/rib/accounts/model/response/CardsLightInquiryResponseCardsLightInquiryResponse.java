package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CardsLightInquiryResponseCardsLightInquiryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T14:29:06.910Z")

public class CardsLightInquiryResponseCardsLightInquiryResponse   {
  @JsonProperty("status_code")
  private String statusCode = null;

  @JsonProperty("status_desc")
  private String statusDesc = null;

  @JsonProperty("cards_list")
  private CardsLightInquiryResponseCardsLightInquiryResponseCardsList cardsList = null;

  public CardsLightInquiryResponseCardsLightInquiryResponse statusCode(String statusCode) {
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

  public CardsLightInquiryResponseCardsLightInquiryResponse statusDesc(String statusDesc) {
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

  public CardsLightInquiryResponseCardsLightInquiryResponse cardsList(CardsLightInquiryResponseCardsLightInquiryResponseCardsList cardsList) {
    this.cardsList = cardsList;
    return this;
  }

  /**
   * Get cardsList
   * @return cardsList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsList getCardsList() {
    return cardsList;
  }

  public void setCardsList(CardsLightInquiryResponseCardsLightInquiryResponseCardsList cardsList) {
    this.cardsList = cardsList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsLightInquiryResponseCardsLightInquiryResponse cardsLightInquiryResponseCardsLightInquiryResponse = (CardsLightInquiryResponseCardsLightInquiryResponse) o;
    return Objects.equals(this.statusCode, cardsLightInquiryResponseCardsLightInquiryResponse.statusCode) &&
        Objects.equals(this.statusDesc, cardsLightInquiryResponseCardsLightInquiryResponse.statusDesc) &&
        Objects.equals(this.cardsList, cardsLightInquiryResponseCardsLightInquiryResponse.cardsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusDesc, cardsList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsLightInquiryResponseCardsLightInquiryResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
    sb.append("    cardsList: ").append(toIndentedString(cardsList)).append("\n");
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

