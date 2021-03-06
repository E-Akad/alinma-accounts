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

/**
 * AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-05T16:29:04.058Z")
public class AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut {
  @SerializedName("MatchedRecs")
  private Integer matchedRecs = null;

  @SerializedName("SentRecs")
  private Integer sentRecs = null;

  public AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut matchedRecs(Integer matchedRecs) {
    this.matchedRecs = matchedRecs;
    return this;
  }

   /**
   * Get matchedRecs
   * @return matchedRecs
  **/
  @ApiModelProperty(value = "")
  public Integer getMatchedRecs() {
    return matchedRecs;
  }

  public void setMatchedRecs(Integer matchedRecs) {
    this.matchedRecs = matchedRecs;
  }

  public AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut sentRecs(Integer sentRecs) {
    this.sentRecs = sentRecs;
    return this;
  }

   /**
   * Get sentRecs
   * @return sentRecs
  **/
  @ApiModelProperty(value = "")
  public Integer getSentRecs() {
    return sentRecs;
  }

  public void setSentRecs(Integer sentRecs) {
    this.sentRecs = sentRecs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut accountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut = (AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut) o;
    return Objects.equals(this.matchedRecs, accountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut.matchedRecs) &&
        Objects.equals(this.sentRecs, accountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut.sentRecs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchedRecs, sentRecs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransferTransactionsResponseAccountTransferTransactionsRsRecCtrlOut {\n");
    
    sb.append("    matchedRecs: ").append(toIndentedString(matchedRecs)).append("\n");
    sb.append("    sentRecs: ").append(toIndentedString(sentRecs)).append("\n");
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

