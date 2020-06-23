package com.alinma.rib.accounts.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-18T14:28:08.667Z")

public class AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList   {
  @JsonProperty("account_info")
  @Valid
  private List<AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo> accountInfo = null;

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList accountInfo(List<AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo> accountInfo) {
    this.accountInfo = accountInfo;
    return this;
  }

  public AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList addAccountInfoItem(AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo accountInfoItem) {
    if (this.accountInfo == null) {
      this.accountInfo = new ArrayList<AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo>();
    }
    this.accountInfo.add(accountInfoItem);
    return this;
  }

  /**
   * Get accountInfo
   * @return accountInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo> getAccountInfo() {
    return accountInfo;
  }

  public void setAccountInfo(List<AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsListAccountInfo> accountInfo) {
    this.accountInfo = accountInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList accountsWithDetailsResponseAccountsWithDetailsResponseAccountsList = (AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList) o;
    return Objects.equals(this.accountInfo, accountsWithDetailsResponseAccountsWithDetailsResponseAccountsList.accountInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsWithDetailsResponseAccountsWithDetailsResponseAccountsList {\n");
    
    sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
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

