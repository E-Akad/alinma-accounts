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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T08:51:33.014Z")

public class CheckIdNumberRequest   {
  @JsonProperty("id_number")
  private String idNumber = null;

  public CheckIdNumberRequest idNumber(String idNumber) {
    this.idNumber = idNumber;
    return this;
  }

  /**
   * Get idNumber
   * @return idNumber
  **/
  @ApiModelProperty(value = "")


  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckIdNumberRequest checkIdNumberRequest = (CheckIdNumberRequest) o;
    return Objects.equals(this.idNumber, checkIdNumberRequest.idNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckIdNumberRequest {\n");
    
    sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

