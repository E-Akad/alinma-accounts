package com.alinma.rib.accounts.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * AccountStatementInquiryRequestStatementDetailsInquiryRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-04T11:10:36.272Z")

public class AccountStatementInquiryRequestStatementDetailsInquiryRequest {
    @JsonProperty("account_number")
    private String accountNumber = null;

    @JsonProperty("from_date")
    private String fromDate = null;

    @JsonProperty("to_date")
    private String toDate = null;

    @JsonProperty("from_date_hijri")
    private String fromDateHijri = null;

    @JsonProperty("to_date_hijri")
    private String toDateHijri = null;

    @JsonProperty("record_ctrl_in")
    private AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn recordCtrlIn = null;

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Get accountNumber
     *
     * @return accountNumber
     **/
    @ApiModelProperty(value = "")


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest fromDate(String fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    /**
     * Get fromDate
     *
     * @return fromDate
     **/
    @ApiModelProperty(value = "")


    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest toDate(String toDate) {
        this.toDate = toDate;
        return this;
    }

    /**
     * Get toDate
     *
     * @return toDate
     **/
    @ApiModelProperty(value = "")


    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest fromDateHijri(String fromDateHijri) {
        this.fromDateHijri = fromDateHijri;
        return this;
    }

    /**
     * Get fromDateHijri
     *
     * @return fromDateHijri
     **/
    @ApiModelProperty(value = "")


    public String getFromDateHijri() {
        return fromDateHijri;
    }

    public void setFromDateHijri(String fromDateHijri) {
        this.fromDateHijri = fromDateHijri;
    }

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest toDateHijri(String toDateHijri) {
        this.toDateHijri = toDateHijri;
        return this;
    }

    /**
     * Get toDateHijri
     *
     * @return toDateHijri
     **/
    @ApiModelProperty(value = "")


    public String getToDateHijri() {
        return toDateHijri;
    }

    public void setToDateHijri(String toDateHijri) {
        this.toDateHijri = toDateHijri;
    }

    public AccountStatementInquiryRequestStatementDetailsInquiryRequest recordCtrlIn(AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn recordCtrlIn) {
        this.recordCtrlIn = recordCtrlIn;
        return this;
    }

    /**
     * Get recordCtrlIn
     *
     * @return recordCtrlIn
     **/
    @ApiModelProperty(value = "")

    @Valid

    public AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn getRecordCtrlIn() {
        return recordCtrlIn;
    }

    public void setRecordCtrlIn(AccountStatementInquiryRequestStatementDetailsInquiryRequestRecordCtrlIn recordCtrlIn) {
        this.recordCtrlIn = recordCtrlIn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatementInquiryRequestStatementDetailsInquiryRequest accountStatementInquiryRequestStatementDetailsInquiryRequest = (AccountStatementInquiryRequestStatementDetailsInquiryRequest) o;
        return Objects.equals(this.accountNumber, accountStatementInquiryRequestStatementDetailsInquiryRequest.accountNumber) &&
                Objects.equals(this.fromDate, accountStatementInquiryRequestStatementDetailsInquiryRequest.fromDate) &&
                Objects.equals(this.toDate, accountStatementInquiryRequestStatementDetailsInquiryRequest.toDate) &&
                Objects.equals(this.fromDateHijri, accountStatementInquiryRequestStatementDetailsInquiryRequest.fromDateHijri) &&
                Objects.equals(this.toDateHijri, accountStatementInquiryRequestStatementDetailsInquiryRequest.toDateHijri) &&
                Objects.equals(this.recordCtrlIn, accountStatementInquiryRequestStatementDetailsInquiryRequest.recordCtrlIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, fromDate, toDate, fromDateHijri, toDateHijri, recordCtrlIn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatementInquiryRequestStatementDetailsInquiryRequest {\n");

        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
        sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
        sb.append("    fromDateHijri: ").append(toIndentedString(fromDateHijri)).append("\n");
        sb.append("    toDateHijri: ").append(toIndentedString(toDateHijri)).append("\n");
        sb.append("    recordCtrlIn: ").append(toIndentedString(recordCtrlIn)).append("\n");
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

