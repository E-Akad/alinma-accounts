package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:09:31.801Z")

public class AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList {
    @JsonProperty("statement_cycle_info")
    @Valid
    private List<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo> statementCycleInfo = null;

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList statementCycleInfo(List<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo> statementCycleInfo) {
        this.statementCycleInfo = statementCycleInfo;
        return this;
    }

    public AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList addStatementCycleInfoItem(AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo statementCycleInfoItem) {
        if (this.statementCycleInfo == null) {
            this.statementCycleInfo = new ArrayList<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo>();
        }
        this.statementCycleInfo.add(statementCycleInfoItem);
        return this;
    }

    /**
     * Get statementCycleInfo
     *
     * @return statementCycleInfo
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo> getStatementCycleInfo() {
        return statementCycleInfo;
    }

    public void setStatementCycleInfo(List<AccountStatementResponseStatementCyclesInquiryResponseStatementCycleListStatementCycleInfo> statementCycleInfo) {
        this.statementCycleInfo = statementCycleInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList accountStatementResponseStatementCyclesInquiryResponseStatementCycleList = (AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList) o;
        return Objects.equals(this.statementCycleInfo, accountStatementResponseStatementCyclesInquiryResponseStatementCycleList.statementCycleInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementCycleInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementResponseStatementCyclesInquiryResponseStatementCycleList {\n");

        sb.append("    statementCycleInfo: ").append(toIndentedString(statementCycleInfo)).append("\n");
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

