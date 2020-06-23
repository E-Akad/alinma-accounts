package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:09:31.801Z")

public class AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo {
    @JsonProperty("statement_cycle_index")
    private String statementCycleIndex = null;

    @JsonProperty("start_date")
    private String startDate = null;

    @JsonProperty("end_date")
    private String endDate = null;

    @JsonProperty("statement_cycle")
    private String statementCycle = null;

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo statementCycleIndex(String statementCycleIndex) {
        this.statementCycleIndex = statementCycleIndex;
        return this;
    }

    /**
     * Get statementCycleIndex
     *
     * @return statementCycleIndex
     **/
    @ApiModelProperty(value = "")


    public String getStatementCycleIndex() {
        return statementCycleIndex;
    }

    public void setStatementCycleIndex(String statementCycleIndex) {
        this.statementCycleIndex = statementCycleIndex;
    }

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     **/
    @ApiModelProperty(value = "")


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     **/
    @ApiModelProperty(value = "")


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo statementCycle(String statementCycle) {
        this.statementCycle = statementCycle;
        return this;
    }

    /**
     * Get statementCycle
     *
     * @return statementCycle
     **/
    @ApiModelProperty(value = "")


    public String getStatementCycle() {
        return statementCycle;
    }

    public void setStatementCycle(String statementCycle) {
        this.statementCycle = statementCycle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo accountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo = (AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo) o;
        return Objects.equals(this.statementCycleIndex, accountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo.statementCycleIndex) &&
                Objects.equals(this.startDate, accountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo.startDate) &&
                Objects.equals(this.endDate, accountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo.endDate) &&
                Objects.equals(this.statementCycle, accountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo.statementCycle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementCycleIndex, startDate, endDate, statementCycle);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo {\n");

        sb.append("    statementCycleIndex: ").append(toIndentedString(statementCycleIndex)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    statementCycle: ").append(toIndentedString(statementCycle)).append("\n");
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

