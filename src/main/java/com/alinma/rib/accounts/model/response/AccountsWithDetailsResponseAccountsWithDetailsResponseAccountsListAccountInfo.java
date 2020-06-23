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
 * AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:28:08.667Z")

public class AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo   {
  @JsonProperty("account_number")
  private String accountNumber = null;

  @JsonProperty("account_type")
  private String accountType = null;

  @JsonProperty("account_nickname")
  private String accountNickname = null;

  @JsonProperty("available_balance")
  private String availableBalance = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("account_status")
  private String accountStatus = null;

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountType(String accountType) {
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

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountNickname(String accountNickname) {
    this.accountNickname = accountNickname;
    return this;
  }

  /**
   * Get accountNickname
   * @return accountNickname
  **/
  @ApiModelProperty(value = "")


  public String getAccountNickname() {
    return accountNickname;
  }

  public void setAccountNickname(String accountNickname) {
    this.accountNickname = accountNickname;
  }

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo availableBalance(String availableBalance) {
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

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo currency(String currency) {
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

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountStatus(String accountStatus) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo = (AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo) o;
    return Objects.equals(this.accountNumber, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.accountNumber) &&
        Objects.equals(this.accountType, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.accountType) &&
        Objects.equals(this.accountNickname, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.accountNickname) &&
        Objects.equals(this.availableBalance, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.availableBalance) &&
        Objects.equals(this.currency, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.currency) &&
        Objects.equals(this.accountStatus, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo.accountStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, accountType, accountNickname, availableBalance, currency, accountStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo {\n");
    
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    accountNickname: ").append(toIndentedString(accountNickname)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
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

