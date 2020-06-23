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
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T08:37:02.592Z")

public class CheckAccountNumResponse   {
  @JsonProperty("checkAccountNumRs")
  private CheckAccountNumRs checkAccountNumRs = null;

  public CheckAccountNumResponse checkAccountNumRs(CheckAccountNumRs checkAccountNumRs) {
    this.checkAccountNumRs = checkAccountNumRs;
    return this;
  }

  /**
   * Get checkAccountNumRs
   * @return checkAccountNumRs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CheckAccountNumRs getCheckAccountNumRs() {
    return checkAccountNumRs;
  }

  public void setCheckAccountNumRs(CheckAccountNumRs checkAccountNumRs) {
    this.checkAccountNumRs = checkAccountNumRs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckAccountNumResponse checkAccountNumResponse = (CheckAccountNumResponse) o;
    return Objects.equals(this.checkAccountNumRs, checkAccountNumResponse.checkAccountNumRs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkAccountNumRs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckAccountNumResponse {\n");
    
    sb.append("    checkAccountNumRs: ").append(toIndentedString(checkAccountNumRs)).append("\n");
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

