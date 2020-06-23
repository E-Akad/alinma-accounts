package com.alinma.rib.accounts.model.request;

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

public class AccountStatementRequest {
    @JsonProperty("statement_cycles_inquiry_request")
    private AccountStatementRequestStatementCyclesInquiryRequest statementCyclesInquiryRequest = null;

    public AccountStatementRequest statementCyclesInquiryRequest(AccountStatementRequestStatementCyclesInquiryRequest statementCyclesInquiryRequest) {
        this.statementCyclesInquiryRequest = statementCyclesInquiryRequest;
        return this;
    }

    /**
     * Get statementCyclesInquiryRequest
     *
     * @return statementCyclesInquiryRequest
     **/
    @ApiModelProperty(value = "")

    @Valid

    public AccountStatementRequestStatementCyclesInquiryRequest getStatementCyclesInquiryRequest() {
        return statementCyclesInquiryRequest;
    }

    public void setStatementCyclesInquiryRequest(AccountStatementRequestStatementCyclesInquiryRequest statementCyclesInquiryRequest) {
        this.statementCyclesInquiryRequest = statementCyclesInquiryRequest;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementRequest accountStatementRequest = (AccountStatementRequest) o;
        return Objects.equals(this.statementCyclesInquiryRequest, accountStatementRequest.statementCyclesInquiryRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementCyclesInquiryRequest);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementRequest {\n");

        sb.append("    statementCyclesInquiryRequest: ").append(toIndentedString(statementCyclesInquiryRequest)).append("\n");
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

