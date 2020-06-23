package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CardsLightInquiryResponseCardsLightInquiryResponseCardsList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T14:29:06.910Z")

public class CardsLightInquiryResponseCardsLightInquiryResponseCardsList   {
  @JsonProperty("card_info")
  @Valid
  private List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> cardInfo = null;

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsList cardInfo(List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> cardInfo) {
    this.cardInfo = cardInfo;
    return this;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsList addCardInfoItem(CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardInfoItem) {
    if (this.cardInfo == null) {
      this.cardInfo = new ArrayList<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo>();
    }
    this.cardInfo.add(cardInfoItem);
    return this;
  }

  /**
   * Get cardInfo
   * @return cardInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> getCardInfo() {
    return cardInfo;
  }

  public void setCardInfo(List<CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo> cardInfo) {
    this.cardInfo = cardInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsLightInquiryResponseCardsLightInquiryResponseCardsList cardsLightInquiryResponseCardsLightInquiryResponseCardsList = (CardsLightInquiryResponseCardsLightInquiryResponseCardsList) o;
    return Objects.equals(this.cardInfo, cardsLightInquiryResponseCardsLightInquiryResponseCardsList.cardInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsLightInquiryResponseCardsLightInquiryResponseCardsList {\n");
    
    sb.append("    cardInfo: ").append(toIndentedString(cardInfo)).append("\n");
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

