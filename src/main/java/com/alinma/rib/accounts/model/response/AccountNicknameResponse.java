package com.alinma.rib.accounts.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-12T09:42:03.213Z")

public class AccountNicknameResponse   {
  @JsonProperty("update_account_nickname_response")
  private AccountNicknameResponseUpdateAccountNicknameResponse updateAccountNicknameResponse = null;

  public AccountNicknameResponse updateAccountNicknameResponse(AccountNicknameResponseUpdateAccountNicknameResponse updateAccountNicknameResponse) {
    this.updateAccountNicknameResponse = updateAccountNicknameResponse;
    return this;
  }

  /**
   * Get updateAccountNicknameResponse
   * @return updateAccountNicknameResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountNicknameResponseUpdateAccountNicknameResponse getUpdateAccountNicknameResponse() {
    return updateAccountNicknameResponse;
  }

  public void setUpdateAccountNicknameResponse(AccountNicknameResponseUpdateAccountNicknameResponse updateAccountNicknameResponse) {
    this.updateAccountNicknameResponse = updateAccountNicknameResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountNicknameResponse accountNicknameResponse = (AccountNicknameResponse) o;
    return Objects.equals(this.updateAccountNicknameResponse, accountNicknameResponse.updateAccountNicknameResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateAccountNicknameResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountNicknameResponse {\n");
    
    sb.append("    updateAccountNicknameResponse: ").append(toIndentedString(updateAccountNicknameResponse)).append("\n");
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

