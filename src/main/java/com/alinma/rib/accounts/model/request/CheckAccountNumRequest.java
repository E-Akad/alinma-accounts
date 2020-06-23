package com.alinma.rib.accounts.model.request;

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

public class CheckAccountNumRequest   {
  @JsonProperty("checkAccountNumRq")
  private CheckAccountNumRq checkAccountNumRq = null;

  public CheckAccountNumRequest checkAccountNumRq(CheckAccountNumRq checkAccountNumRq) {
    this.checkAccountNumRq = checkAccountNumRq;
    return this;
  }

  /**
   * Get checkAccountNumRq
   * @return checkAccountNumRq
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CheckAccountNumRq getCheckAccountNumRq() {
    return checkAccountNumRq;
  }

  public void setCheckAccountNumRq(CheckAccountNumRq checkAccountNumRq) {
    this.checkAccountNumRq = checkAccountNumRq;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckAccountNumRequest checkAccountNumRequest = (CheckAccountNumRequest) o;
    return Objects.equals(this.checkAccountNumRq, checkAccountNumRequest.checkAccountNumRq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkAccountNumRq);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckAccountNumRequest {\n");
    
    sb.append("    checkAccountNumRq: ").append(toIndentedString(checkAccountNumRq)).append("\n");
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

