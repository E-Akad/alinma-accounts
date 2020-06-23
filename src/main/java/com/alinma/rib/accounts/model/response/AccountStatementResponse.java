package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 *
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:09:31.801Z")

public class AccountStatementResponse {
    @JsonProperty("statement_cycles_inquiry_response")
    private AccountStatementResponseStatementCyclesInquiryResponse statementCyclesInquiryResponse = null;

    public AccountStatementResponse statementCyclesInquiryResponse(AccountStatementResponseStatementCyclesInquiryResponse statementCyclesInquiryResponse) {
        this.statementCyclesInquiryResponse = statementCyclesInquiryResponse;
        return this;
    }

    /**
     * Get statementCyclesInquiryResponse
     *
     * @return statementCyclesInquiryResponse
     **/
    @ApiModelProperty(value = "")

    @Valid

    public AccountStatementResponseStatementCyclesInquiryResponse getStatementCyclesInquiryResponse() {
        return statementCyclesInquiryResponse;
    }

    public void setStatementCyclesInquiryResponse(AccountStatementResponseStatementCyclesInquiryResponse statementCyclesInquiryResponse) {
        this.statementCyclesInquiryResponse = statementCyclesInquiryResponse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementResponse accountStatementResponse = (AccountStatementResponse) o;
        return Objects.equals(this.statementCyclesInquiryResponse, accountStatementResponse.statementCyclesInquiryResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementCyclesInquiryResponse);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementResponse {\n");

        sb.append("    statementCyclesInquiryResponse: ").append(toIndentedString(statementCyclesInquiryResponse)).append("\n");
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

