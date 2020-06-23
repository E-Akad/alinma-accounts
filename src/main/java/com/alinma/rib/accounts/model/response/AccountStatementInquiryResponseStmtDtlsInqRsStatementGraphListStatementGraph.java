package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph {
 //   @JsonProperty("transaction_type")
    private String transactionType = null;

//    @JsonProperty("transaction_type_amount")
    private String transactionTypeAmount = null;

    public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph transactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * Get transactionType
     *
     * @return transactionType
     **/
    @ApiModelProperty(value = "")


    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph transactionTypeAmount(String transactionTypeAmount) {
        this.transactionTypeAmount = transactionTypeAmount;
        return this;
    }

    /**
     * Get transactionTypeAmount
     *
     * @return transactionTypeAmount
     **/
    @ApiModelProperty(value = "")


    public String getTransactionTypeAmount() {
        return transactionTypeAmount;
    }

    public void setTransactionTypeAmount(String transactionTypeAmount) {
        this.transactionTypeAmount = transactionTypeAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph = (AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph) o;
        return Objects.equals(this.transactionType, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph.transactionType) &&
                Objects.equals(this.transactionTypeAmount, accountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph.transactionTypeAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionType, transactionTypeAmount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsStatementGraphListStatementGraph {\n");

        sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
        sb.append("    transactionTypeAmount: ").append(toIndentedString(transactionTypeAmount)).append("\n");
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

