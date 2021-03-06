/*
 * Account Transfer Transactions
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.alinma.rib.accounts.model.response;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountTransferTransactionsResponseAccountTransferTransactionsRsTransferTransactionList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-05T16:29:04.058Z")
public class AccountTransferTransactionsRsTransferTransactionList {
  @SerializedName("TransferTransactionInfo")
  private List<AccountTransferTransactionsTransferTransactionInfo> transferTransactionInfo = null;

  public AccountTransferTransactionsRsTransferTransactionList transferTransactionInfo(List<AccountTransferTransactionsTransferTransactionInfo> transferTransactionInfo) {
    this.transferTransactionInfo = transferTransactionInfo;
    return this;
  }

  public AccountTransferTransactionsRsTransferTransactionList addTransferTransactionInfoItem(AccountTransferTransactionsTransferTransactionInfo transferTransactionInfoItem) {
    if (this.transferTransactionInfo == null) {
      this.transferTransactionInfo = new ArrayList<AccountTransferTransactionsTransferTransactionInfo>();
    }
    this.transferTransactionInfo.add(transferTransactionInfoItem);
    return this;
  }

   /**
   * Get transferTransactionInfo
   * @return transferTransactionInfo
  **/
  @ApiModelProperty(value = "")
  public List<AccountTransferTransactionsTransferTransactionInfo> getTransferTransactionInfo() {
    return transferTransactionInfo;
  }

  public void setTransferTransactionInfo(List<AccountTransferTransactionsTransferTransactionInfo> transferTransactionInfo) {
    this.transferTransactionInfo = transferTransactionInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransferTransactionsRsTransferTransactionList accountTransferTransactionsResponseAccountTransferTransactionsRsTransferTransactionList = (AccountTransferTransactionsRsTransferTransactionList) o;
    return Objects.equals(this.transferTransactionInfo, accountTransferTransactionsResponseAccountTransferTransactionsRsTransferTransactionList.transferTransactionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transferTransactionInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransferTransactionsResponseAccountTransferTransactionsRsTransferTransactionList {\n");
    
    sb.append("    transferTransactionInfo: ").append(toIndentedString(transferTransactionInfo)).append("\n");
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

