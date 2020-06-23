package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * AccountStatementResponseStatementCyclesInquiryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:09:31.801Z")

public class AccountStatementResponseStatementCyclesInquiryResponse {
    @JsonProperty("status_code")
    private String statusCode = null;

    @JsonProperty("status_desc")
    private String statusDesc = null;

    @JsonProperty("statement_cycle_list")
    private AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList statementCycleList = null;

    public AccountStatementResponseStatementCyclesInquiryResponse statusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Get statusCode
     *
     * @return statusCode
     **/
    @ApiModelProperty(value = "")


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public AccountStatementResponseStatementCyclesInquiryResponse statusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
        return this;
    }

    /**
     * Get statusDesc
     *
     * @return statusDesc
     **/
    @ApiModelProperty(value = "")


    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public AccountStatementResponseStatementCyclesInquiryResponse statementCycleList(AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList statementCycleList) {
        this.statementCycleList = statementCycleList;
        return this;
    }

    /**
     * Get statementCycleList
     *
     * @return statementCycleList
     **/
    @ApiModelProperty(value = "")

    @Valid

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList getStatementCycleList() {
        return statementCycleList;
    }

    public void setStatementCycleList(AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList statementCycleList) {
        this.statementCycleList = statementCycleList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementResponseStatementCyclesInquiryResponse accountStatementResponseStatementCyclesInquiryResponse = (AccountStatementResponseStatementCyclesInquiryResponse) o;
        return Objects.equals(this.statusCode, accountStatementResponseStatementCyclesInquiryResponse.statusCode) &&
                Objects.equals(this.statusDesc, accountStatementResponseStatementCyclesInquiryResponse.statusDesc) &&
                Objects.equals(this.statementCycleList, accountStatementResponseStatementCyclesInquiryResponse.statementCycleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, statusDesc, statementCycleList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementResponseStatementCyclesInquiryResponse {\n");

        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
        sb.append("    statusDesc: ").append(toIndentedString(statusDesc)).append("\n");
        sb.append("    statementCycleList: ").append(toIndentedString(statementCycleList)).append("\n");
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

