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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryRequest {
    @JsonProperty("statement_details_inquiry_request")
    private AccountStatementInquiryRequestStatementDetailsInquiryRequest statementDetailsInquiryRequest = null;

    public AccountStatementInquiryRequest statementDetailsInquiryRequest(AccountStatementInquiryRequestStatementDetailsInquiryRequest statementDetailsInquiryRequest) {
        this.statementDetailsInquiryRequest = statementDetailsInquiryRequest;
        return this;
    }

    /**
     * Get statementDetailsInquiryRequest
     *
     * @return statementDetailsInquiryRequest
     **/
    @ApiModelProperty(value = "")

    @Valid

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest getStatementDetailsInquiryRequest() {
        return statementDetailsInquiryRequest;
    }

    public void setStatementDetailsInquiryRequest(AccountStatementInquiryRequestStatementDetailsInquiryRequest statementDetailsInquiryRequest) {
        this.statementDetailsInquiryRequest = statementDetailsInquiryRequest;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementInquiryRequest accountStatementInquiryRequest = (AccountStatementInquiryRequest) o;
        return Objects.equals(this.statementDetailsInquiryRequest, accountStatementInquiryRequest.statementDetailsInquiryRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementDetailsInquiryRequest);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementInquiryRequest {\n");

        sb.append("    statementDetailsInquiryRequest: ").append(toIndentedString(statementDetailsInquiryRequest)).append("\n");
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

