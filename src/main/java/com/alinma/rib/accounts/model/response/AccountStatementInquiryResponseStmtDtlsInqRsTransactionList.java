package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsTransactionList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsTransactionList {
    @JsonProperty("statement_transaction_info")
    @Valid
    private List<AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo> statementTransactionInfo = null;

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionList statementTransactionInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo> statementTransactionInfo) {
        this.statementTransactionInfo = statementTransactionInfo;
        return this;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionList addStatementTransactionInfoItem(AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo statementTransactionInfoItem) {
        if (this.statementTransactionInfo == null) {
            this.statementTransactionInfo = new ArrayList<AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo>();
        }
        this.statementTransactionInfo.add(statementTransactionInfoItem);
        return this;
    }

    /**
     * Get statementTransactionInfo
     *
     * @return statementTransactionInfo
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo> getStatementTransactionInfo() {
        return statementTransactionInfo;
    }

    public void setStatementTransactionInfo(List<AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo> statementTransactionInfo) {
        this.statementTransactionInfo = statementTransactionInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementInquiryResponseStmtDtlsInqRsTransactionList accountStatementInquiryResponseStmtDtlsInqRsTransactionList = (AccountStatementInquiryResponseStmtDtlsInqRsTransactionList) o;
        return Objects.equals(this.statementTransactionInfo, accountStatementInquiryResponseStmtDtlsInqRsTransactionList.statementTransactionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementTransactionInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsTransactionList {\n");

        sb.append("    statementTransactionInfo: ").append(toIndentedString(statementTransactionInfo)).append("\n");
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

