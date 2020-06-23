package com.alinma.rib.accounts.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-15T11:30:07.745Z")

public class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList   {
  @JsonProperty("card_info")
  @Valid
  private List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo> cardInfo = null;

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList cardInfo(List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo> cardInfo) {
    this.cardInfo = cardInfo;
    return this;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList addCardInfoItem(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo cardInfoItem) {
    if (this.cardInfo == null) {
      this.cardInfo = new ArrayList<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo>();
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

  public List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo> getCardInfo() {
    return cardInfo;
  }

  public void setCardInfo(List<AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardListCardInfo> cardInfo) {
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
    AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList = (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList) o;
    return Objects.equals(this.cardInfo, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList.cardInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList {\n");
    
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

