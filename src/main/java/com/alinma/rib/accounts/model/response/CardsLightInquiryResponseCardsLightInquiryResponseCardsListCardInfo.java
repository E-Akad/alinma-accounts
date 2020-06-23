package com.alinma.rib.accounts.model.response;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.alinma.rib.models.system.common.enums.CardCategoryEnum;
import com.alinma.rib.models.system.common.enums.CardStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T14:29:06.910Z")

public class CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo   {
  @JsonProperty("card_number")
  private Long cardNumber = null;

  @JsonProperty("masked_card_number")
  private String maskedCardNumber = null;

  @JsonProperty("card_status")
  private String cardStatus = null;

  @JsonProperty("card_class_id")
  private String cardClassId = null;

  @JsonProperty("card_class_id_desc")
  private String cardClassIdDesc = null;

  @JsonProperty("card_type")
  private String cardType = null;

  @JsonProperty("card_type_desc")
  private String cardTypeDesc = null;

  @JsonProperty("card_nick_name")
  private String cardNickName = null;

  @JsonProperty("expiry_date")
  private LocalDate expiryDate = null;

  @JsonProperty("issue_date")
  private LocalDate issueDate = null;

  @JsonProperty("lnkd_account_number")
  private Long lnkdAccountNumber = null;
  
  @JsonProperty("is_primary_card")
  private String isPrimaryCard;
  
  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardNumber(Long cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Get cardNumber
   * @return cardNumber
  **/
  @ApiModelProperty(value = "")


  public Long getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(Long cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo maskedCardNumber(String maskedCardNumber) {
    this.maskedCardNumber = maskedCardNumber;
    return this;
  }

  /**
   * Get maskedCardNumber
   * @return maskedCardNumber
  **/
  @ApiModelProperty(value = "")


  public String getMaskedCardNumber() {
    return maskedCardNumber;
  }

  public void setMaskedCardNumber(String maskedCardNumber) {
    this.maskedCardNumber = maskedCardNumber;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
    return this;
  }

  /**
   * Get cardStatus
   * @return cardStatus
  **/
  @ApiModelProperty(value = "")


  public String getCardStatus() {
    return cardStatus;
  }

  public void setCardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardClassId(String cardClassId) {
    this.cardClassId = cardClassId;
    return this;
  }

  /**
   * Get cardClassId
   * @return cardClassId
  **/
  @ApiModelProperty(value = "")


  public String getCardClassId() {
    return cardClassId;
  }

  public void setCardClassId(String cardClassId) {
    this.cardClassId = cardClassId;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardClassIdDesc(String cardClassIdDesc) {
    this.cardClassIdDesc = cardClassIdDesc;
    return this;
  }

  /**
   * Get cardClassIdDesc
   * @return cardClassIdDesc
  **/
  @ApiModelProperty(value = "")


  public String getCardClassIdDesc() {
    return cardClassIdDesc;
  }

  public void setCardClassIdDesc(String cardClassIdDesc) {
    this.cardClassIdDesc = cardClassIdDesc;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardType(String cardType) {
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

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardTypeDesc(String cardTypeDesc) {
    this.cardTypeDesc = cardTypeDesc;
    return this;
  }

  /**
   * Get cardTypeDesc
   * @return cardTypeDesc
  **/
  @ApiModelProperty(value = "")


  public String getCardTypeDesc() {
    return cardTypeDesc;
  }

  public void setCardTypeDesc(String cardTypeDesc) {
    this.cardTypeDesc = cardTypeDesc;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardNickName(String cardNickName) {
    this.cardNickName = cardNickName;
    return this;
  }

  /**
   * Get cardNickName
   * @return cardNickName
  **/
  @ApiModelProperty(value = "")


  public String getCardNickName() {
    return cardNickName;
  }

  public void setCardNickName(String cardNickName) {
    this.cardNickName = cardNickName;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo expiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   * @return expiryDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo issueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Get issueDate
   * @return issueDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getIssueDate() {
    return issueDate;
  }

	public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public Long getLnkdAccountNumber() {
		return lnkdAccountNumber;
	}

	public void setLnkdAccountNumber(Long lnkdAccountNumber) {
		this.lnkdAccountNumber = lnkdAccountNumber;
	}

  public String getIsPrimaryCard() {
		return isPrimaryCard;
	}

	public void setIsPrimaryCard(String isPrimaryCard) {
		this.isPrimaryCard = isPrimaryCard;
	}

	@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo = (CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo) o;
    return Objects.equals(this.cardNumber, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardNumber) &&
        Objects.equals(this.maskedCardNumber, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.maskedCardNumber) &&
        Objects.equals(this.cardStatus, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardStatus) &&
        Objects.equals(this.cardClassId, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardClassId) &&
        Objects.equals(this.cardClassIdDesc, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardClassIdDesc) &&
        Objects.equals(this.cardType, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardType) &&
        Objects.equals(this.cardTypeDesc, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardTypeDesc) &&
        Objects.equals(this.cardNickName, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.cardNickName) &&
        Objects.equals(this.expiryDate, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.expiryDate) &&
        Objects.equals(this.issueDate, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.issueDate) &&
        Objects.equals(this.lnkdAccountNumber, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.lnkdAccountNumber) &&
        Objects.equals(this.isPrimaryCard, cardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo.isPrimaryCard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNumber, maskedCardNumber, cardStatus, cardClassId, cardClassIdDesc, cardType, cardTypeDesc, cardNickName, expiryDate, issueDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardsLightInquiryResponseCardsLightInquiryResponseCardsListCardInfo {\n");
    
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    maskedCardNumber: ").append(toIndentedString(maskedCardNumber)).append("\n");
    sb.append("    cardStatus: ").append(toIndentedString(cardStatus)).append("\n");
    sb.append("    cardClassId: ").append(toIndentedString(cardClassId)).append("\n");
    sb.append("    cardClassIdDesc: ").append(toIndentedString(cardClassIdDesc)).append("\n");
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    cardTypeDesc: ").append(toIndentedString(cardTypeDesc)).append("\n");
    sb.append("    cardNickName: ").append(toIndentedString(cardNickName)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    lnkdAccountNumber: ").append(toIndentedString(lnkdAccountNumber)).append("\n");
    sb.append("    isPrimaryCard: ").append(toIndentedString(isPrimaryCard)).append("\n");
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
  
	public boolean isActive(String cardStatus){
		if(cardStatus != null) {
			CardStatusEnum cardStatusEnum = CardStatusEnum.getByCode(cardStatus);
			return cardStatusEnum != null && cardStatusEnum.isActive();
		}
		return false;
	}
	
	public boolean isCredit(String cardType){
		return Boolean.TRUE.equals(this.getCreditCard(cardType));
	}

	public Boolean getCreditCard(String cardType) {
		if(cardType != null) {
			CardCategoryEnum cardCategory = CardCategoryEnum.getByCardType(cardType);
			if(cardCategory != null) {
				boolean creditCard = cardCategory.isCredit();
				return creditCard;
			}
		}
		return false;
	}

}

