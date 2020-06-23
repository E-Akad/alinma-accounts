package com.alinma.rib.accounts.model.response;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T09:11:56.084Z")

public class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo   {
  @JsonProperty("accountNumber")
  private Long accountNumber = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("accountNickName")
  private String accountNickName = null;

  @JsonProperty("availableBalance")
  private String availableBalance = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("accountStatus")
  private String accountStatus = null;

  @JsonProperty("dormant")
  private Boolean dormant = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("cardCount")
  private String cardCount = null;

  @JsonProperty("cardList")
  private AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList cardList = null;

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo accountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")


  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  **/
  @ApiModelProperty(value = "")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo accountNickName(String accountNickName) {
    this.accountNickName = accountNickName;
    return this;
  }

  /**
   * Get accountNickName
   * @return accountNickName
  **/
  @ApiModelProperty(value = "")


  public String getAccountNickName() {
    return accountNickName;
  }

  public void setAccountNickName(String accountNickName) {
    this.accountNickName = accountNickName;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo availableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  /**
   * Get availableBalance
   * @return availableBalance
  **/
  @ApiModelProperty(value = "")


  public String getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo accountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * Get accountStatus
   * @return accountStatus
  **/
  @ApiModelProperty(value = "")


  public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo dormant(Boolean dormant) {
    this.dormant = dormant;
    return this;
  }

  /**
   * Get dormant
   * @return dormant
  **/
  @ApiModelProperty(value = "")


  public Boolean isDormant() {
    return dormant;
  }

  public void setDormant(Boolean dormant) {
    this.dormant = dormant;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  **/
  @ApiModelProperty(value = "")


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo cardCount(String cardCount) {
    this.cardCount = cardCount;
    return this;
  }

  /**
   * Get cardCount
   * @return cardCount
  **/
  @ApiModelProperty(value = "")


  public String getCardCount() {
    return cardCount;
  }

  public void setCardCount(String cardCount) {
    this.cardCount = cardCount;
  }

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo cardList(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList cardList) {
    this.cardList = cardList;
    return this;
  }

  /**
   * Get cardList
   * @return cardList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList getCardList() {
    return cardList;
  }

  public void setCardList(AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListCardList cardList) {
    this.cardList = cardList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo = (AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo) o;
    return Objects.equals(this.accountNumber, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.accountNumber) &&
        Objects.equals(this.accountType, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.accountType) &&
        Objects.equals(this.accountNickName, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.accountNickName) &&
        Objects.equals(this.availableBalance, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.availableBalance) &&
        Objects.equals(this.currency, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.currency) &&
        Objects.equals(this.accountStatus, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.accountStatus) &&
        Objects.equals(this.dormant, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.dormant) &&
        Objects.equals(this.iban, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.iban) &&
        Objects.equals(this.cardCount, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.cardCount) &&
        Objects.equals(this.cardList, accountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo.cardList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, accountType, accountNickName, availableBalance, currency, accountStatus, dormant, iban, cardCount, cardList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithBalanceAndCardsResponseAccountsWithBalanceAndCardsResponseAccountsListAccountInfo {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    accountNickName: ").append(toIndentedString(accountNickName)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    dormant: ").append(toIndentedString(dormant)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    cardCount: ").append(toIndentedString(cardCount)).append("\n");
    sb.append("    cardList: ").append(toIndentedString(cardList)).append("\n");
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

