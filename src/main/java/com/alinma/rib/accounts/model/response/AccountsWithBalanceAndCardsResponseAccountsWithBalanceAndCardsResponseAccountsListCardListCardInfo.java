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
 * AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:30:07.745Z")

public class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo   {
  @JsonProperty("card_number")
  private Long cardNumber = null;

  @JsonProperty("masked_card_number")
  private String maskedCardNumber = null;

  @JsonProperty("images_path")
  private String imagesPath = null;

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo cardNumber(Long cardNumber) {
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

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo maskedCardNumber(String maskedCardNumber) {
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

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo imagesPath(String imagesPath) {
    this.imagesPath = imagesPath;
    return this;
  }

  /**
   * Get imagesPath
   * @return imagesPath
  **/
  @ApiModelProperty(value = "")


  public String getImagesPath() {
    return imagesPath;
  }

  public void setImagesPath(String imagesPath) {
    this.imagesPath = imagesPath;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo = (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo) o;
    return Objects.equals(this.cardNumber, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo.cardNumber) &&
        Objects.equals(this.maskedCardNumber, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo.maskedCardNumber) &&
        Objects.equals(this.imagesPath, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo.imagesPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNumber, maskedCardNumber, imagesPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo {\n");
    
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    maskedCardNumber: ").append(toIndentedString(maskedCardNumber)).append("\n");
    sb.append("    imagesPath: ").append(toIndentedString(imagesPath)).append("\n");
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

