package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo {
    @JsonProperty("date")
    private String date = null;

    @JsonProperty("channel")
    private String channel = null;

    @JsonProperty("referenceNumber")
    private String referenceNumber = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("debit")
    private String debit = null;

    @JsonProperty("credit")
    private String credit = null;

    @JsonProperty("credit_debit")
    private String creditDebit = null;

    @JsonProperty("balance")
    private String balance = null;

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo date(String date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @ApiModelProperty(value = "")


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo channel(String channel) {
        this.channel = channel;
        return this;
    }

    /**
     * Get channel
     *
     * @return channel
     **/
    @ApiModelProperty(value = "")


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo referenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    /**
     * Get referenceNumber
     *
     * @return referenceNumber
     **/
    @ApiModelProperty(value = "")


    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(value = "")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(value = "")


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo debit(String debit) {
        this.debit = debit;
        return this;
    }

    /**
     * Get debit
     *
     * @return debit
     **/
    @ApiModelProperty(value = "")


    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo credit(String credit) {
        this.credit = credit;
        return this;
    }

    /**
     * Get credit
     *
     * @return credit
     **/
    @ApiModelProperty(value = "")


    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo creditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
        return this;
    }

    /**
     * Get creditDebit
     *
     * @return creditDebit
     **/
    @ApiModelProperty(value = "")


    public String getCreditDebit() {
        return creditDebit;
    }

    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    public AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo balance(String balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @ApiModelProperty(value = "")


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo = (AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo) o;
        return Objects.equals(this.date, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.date) &&
                Objects.equals(this.channel, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.channel) &&
                Objects.equals(this.referenceNumber, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.referenceNumber) &&
                Objects.equals(this.description, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.description) &&
                Objects.equals(this.type, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.type) &&
                Objects.equals(this.debit, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.debit) &&
                Objects.equals(this.credit, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.credit) &&
                Objects.equals(this.creditDebit, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.creditDebit) &&
                Objects.equals(this.balance, accountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, channel, referenceNumber, description, type, debit, credit, creditDebit, balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementInquiryResponseStmtDtlsInqRsTransactionListStatementTransactionInfo {\n");

        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    referenceNumber: ").append(toIndentedString(referenceNumber)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    debit: ").append(toIndentedString(debit)).append("\n");
        sb.append("    credit: ").append(toIndentedString(credit)).append("\n");
        sb.append("    creditDebit: ").append(toIndentedString(creditDebit)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

