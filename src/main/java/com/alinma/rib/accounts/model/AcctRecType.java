package com.alinma.rib.accounts.model;
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.15 at 01:56:50 PM EET 
//



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.alinma.rib.accounts.model.system.response.CustAcctDtlsInqBodyRsType;


/**
 * <p>Java class for AcctRec_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcctRec_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.alinma.com}AcctId"/>
 *         &lt;element ref="{http://www.alinma.com}AcctSubType" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}IBAN" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctName" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ShortDesc" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctNickname" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctStatus" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctCur" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctCategory" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}PostingRestrict" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}StmtCycleFreq" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}StmtDeliveryOpt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}StmtDeliveryLoc" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}StmtLangPref" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}MT940Enabled" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}BranchId" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctOpenDt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctOpenDtHjr" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctExpDt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctExpDtHjr" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctMatDt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctMatDtHjr" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AvailBal" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}LedgerBal" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}CurrBal" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}BlockedAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ATMCardExist" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}SignId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctSPStatus1" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctSPStatus2" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctSPStatus3" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ProductId" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ProductTypeId" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}SettlementAcctBank" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}SettlementAcctBranch" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}SettlementAcctNum" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}SAMAAcctNum" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}OpenReason" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}AcctPurpose" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}PostingRestrictCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}PrimaryRM" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}PrincipleAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}PlacementDt" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ProfitRate" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}RelAcctInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}ChkAlternId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcctRec_Type", propOrder = {
    "acctId",
    "acctSubType",
    "iban",
    "acctName",
    "shortDesc",
    "acctNickname",
    "acctStatus",
    "acctCur",
    "acctCategory",
    "postingRestrict",
    "stmtCycleFreq",
    "stmtDeliveryOpt",
    "stmtDeliveryLoc",
    "stmtLangPref",
    "mt940Enabled",
    "branchId",
    "acctOpenDt",
    "acctOpenDtHjr",
    "acctExpDt",
    "acctExpDtHjr",
    "acctMatDt",
    "acctMatDtHjr",
    "availBal",
    "ledgerBal",
    "currBal",
    "blockedAmt",
    "atmCardExist",
    "signId",
    "acctSPStatus1",
    "acctSPStatus2",
    "acctSPStatus3",
    "productId",
    "productTypeId",
    "settlementAcctBank",
    "settlementAcctBranch",
    "settlementAcctNum",
    "samaAcctNum",
    "openReason",
    "acctPurpose",
    "postingRestrictCode",
    "primaryRM",
    "principleAmt",
    "placementDt",
    "profitRate",
    "relAcctInfo",
    "chkAlternId"
})
@XmlSeeAlso({
    CustAcctDtlsInqBodyRsType.class
})
public class AcctRecType {

    @XmlElement(name = "AcctId", required = true)
    protected AcctIdType acctId;
    @XmlElement(name = "AcctSubType")
    protected String acctSubType;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "AcctName")
    protected String acctName;
    @XmlElement(name = "ShortDesc")
    protected String shortDesc;
    @XmlElement(name = "AcctNickname")
    protected String acctNickname;
    @XmlElement(name = "AcctStatus")
    protected String acctStatus;
    @XmlElement(name = "AcctCur")
    protected String acctCur;
    @XmlElement(name = "AcctCategory")
    protected String acctCategory;
    @XmlElement(name = "PostingRestrict")
    protected String postingRestrict;
    @XmlElement(name = "StmtCycleFreq")
    protected String stmtCycleFreq;
    @XmlElement(name = "StmtDeliveryOpt")
    protected String stmtDeliveryOpt;
    @XmlElement(name = "StmtDeliveryLoc")
    protected String stmtDeliveryLoc;
    @XmlElement(name = "StmtLangPref")
    protected String stmtLangPref;
    @XmlElement(name = "MT940Enabled")
    @XmlSchemaType(name = "string")
    protected Boolean mt940Enabled;
    @XmlElement(name = "BranchId")
    protected String branchId;
    @XmlElement(name = "AcctOpenDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar acctOpenDt;
    @XmlElement(name = "AcctOpenDtHjr")
    protected String acctOpenDtHjr;
    @XmlElement(name = "AcctExpDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar acctExpDt;
    @XmlElement(name = "AcctExpDtHjr")
    protected String acctExpDtHjr;
    @XmlElement(name = "AcctMatDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar acctMatDt;
    @XmlElement(name = "AcctMatDtHjr")
    protected String acctMatDtHjr;
    @XmlElement(name = "AvailBal")
    protected BigDecimal availBal;
    @XmlElement(name = "LedgerBal")
    protected BigDecimal ledgerBal;
    @XmlElement(name = "CurrBal")
    protected BigDecimal currBal;
    @XmlElement(name = "BlockedAmt")
    protected BigDecimal blockedAmt;
    @XmlElement(name = "ATMCardExist")
    @XmlSchemaType(name = "string")
    protected Boolean atmCardExist;
    @XmlElement(name = "SignId")
    protected List<String> signId;
    @XmlElement(name = "AcctSPStatus1")
    protected String acctSPStatus1;
    @XmlElement(name = "AcctSPStatus2")
    protected String acctSPStatus2;
    @XmlElement(name = "AcctSPStatus3")
    protected String acctSPStatus3;
    @XmlElement(name = "ProductId")
    protected String productId;
    @XmlElement(name = "ProductTypeId")
    protected String productTypeId;
    @XmlElement(name = "SettlementAcctBank")
    protected String settlementAcctBank;
    @XmlElement(name = "SettlementAcctBranch")
    protected String settlementAcctBranch;
    @XmlElement(name = "SettlementAcctNum")
    protected String settlementAcctNum;
    @XmlElement(name = "SAMAAcctNum")
    protected String samaAcctNum;
    @XmlElement(name = "OpenReason")
    protected String openReason;
    @XmlElement(name = "AcctPurpose")
    protected String acctPurpose;
    @XmlElement(name = "PostingRestrictCode")
    protected List<String> postingRestrictCode;
    @XmlElement(name = "PrimaryRM")
    protected String primaryRM;
    @XmlElement(name = "PrincipleAmt")
    protected BigDecimal principleAmt;
    @XmlElement(name = "PlacementDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar placementDt;
    @XmlElement(name = "ProfitRate")
    protected BigDecimal profitRate;
    @XmlElement(name = "RelAcctInfo")
    protected List<RelAcctInfoType> relAcctInfo;
    @XmlElement(name = "ChkAlternId")
    protected String chkAlternId;

    /**
     * Gets the value of the acctId property.
     * 
     * @return
     *     possible object is
     *     {@link AcctIdType }
     *     
     */
    public AcctIdType getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctIdType }
     *     
     */
    public void setAcctId(AcctIdType value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the acctSubType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSubType() {
        return acctSubType;
    }

    /**
     * Sets the value of the acctSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSubType(String value) {
        this.acctSubType = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the acctName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * Sets the value of the acctName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctName(String value) {
        this.acctName = value;
    }

    /**
     * Gets the value of the shortDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * Sets the value of the shortDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDesc(String value) {
        this.shortDesc = value;
    }

    /**
     * Gets the value of the acctNickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctNickname() {
        return acctNickname;
    }

    /**
     * Sets the value of the acctNickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctNickname(String value) {
        this.acctNickname = value;
    }

    /**
     * Gets the value of the acctStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctStatus() {
        return acctStatus;
    }

    /**
     * Sets the value of the acctStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctStatus(String value) {
        this.acctStatus = value;
    }

    /**
     * Gets the value of the acctCur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctCur() {
        return acctCur;
    }

    /**
     * Sets the value of the acctCur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctCur(String value) {
        this.acctCur = value;
    }

    /**
     * Gets the value of the acctCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctCategory() {
        return acctCategory;
    }

    /**
     * Sets the value of the acctCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctCategory(String value) {
        this.acctCategory = value;
    }

    /**
     * Gets the value of the postingRestrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingRestrict() {
        return postingRestrict;
    }

    /**
     * Sets the value of the postingRestrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingRestrict(String value) {
        this.postingRestrict = value;
    }

    /**
     * Gets the value of the stmtCycleFreq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStmtCycleFreq() {
        return stmtCycleFreq;
    }

    /**
     * Sets the value of the stmtCycleFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStmtCycleFreq(String value) {
        this.stmtCycleFreq = value;
    }

    /**
     * Gets the value of the stmtDeliveryOpt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStmtDeliveryOpt() {
        return stmtDeliveryOpt;
    }

    /**
     * Sets the value of the stmtDeliveryOpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStmtDeliveryOpt(String value) {
        this.stmtDeliveryOpt = value;
    }

    /**
     * Gets the value of the stmtDeliveryLoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStmtDeliveryLoc() {
        return stmtDeliveryLoc;
    }

    /**
     * Sets the value of the stmtDeliveryLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStmtDeliveryLoc(String value) {
        this.stmtDeliveryLoc = value;
    }

    /**
     * Gets the value of the stmtLangPref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStmtLangPref() {
        return stmtLangPref;
    }

    /**
     * Sets the value of the stmtLangPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStmtLangPref(String value) {
        this.stmtLangPref = value;
    }

    /**
     * Gets the value of the mt940Enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getMT940Enabled() {
        return mt940Enabled;
    }

    /**
     * Sets the value of the mt940Enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMT940Enabled(Boolean value) {
        this.mt940Enabled = value;
    }

    /**
     * Gets the value of the branchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * Sets the value of the branchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchId(String value) {
        this.branchId = value;
    }

    /**
     * Gets the value of the acctOpenDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcctOpenDt() {
        return acctOpenDt;
    }

    /**
     * Sets the value of the acctOpenDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcctOpenDt(XMLGregorianCalendar value) {
        this.acctOpenDt = value;
    }

    /**
     * Gets the value of the acctOpenDtHjr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctOpenDtHjr() {
        return acctOpenDtHjr;
    }

    /**
     * Sets the value of the acctOpenDtHjr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctOpenDtHjr(String value) {
        this.acctOpenDtHjr = value;
    }

    /**
     * Gets the value of the acctExpDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcctExpDt() {
        return acctExpDt;
    }

    /**
     * Sets the value of the acctExpDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcctExpDt(XMLGregorianCalendar value) {
        this.acctExpDt = value;
    }

    /**
     * Gets the value of the acctExpDtHjr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctExpDtHjr() {
        return acctExpDtHjr;
    }

    /**
     * Sets the value of the acctExpDtHjr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctExpDtHjr(String value) {
        this.acctExpDtHjr = value;
    }

    /**
     * Gets the value of the acctMatDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcctMatDt() {
        return acctMatDt;
    }

    /**
     * Sets the value of the acctMatDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcctMatDt(XMLGregorianCalendar value) {
        this.acctMatDt = value;
    }

    /**
     * Gets the value of the acctMatDtHjr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctMatDtHjr() {
        return acctMatDtHjr;
    }

    /**
     * Sets the value of the acctMatDtHjr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctMatDtHjr(String value) {
        this.acctMatDtHjr = value;
    }

    /**
     * Gets the value of the availBal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvailBal() {
        return availBal;
    }

    /**
     * Sets the value of the availBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvailBal(BigDecimal value) {
        this.availBal = value;
    }

    /**
     * Gets the value of the ledgerBal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLedgerBal() {
        return ledgerBal;
    }

    /**
     * Sets the value of the ledgerBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLedgerBal(BigDecimal value) {
        this.ledgerBal = value;
    }

    /**
     * Gets the value of the currBal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrBal() {
        return currBal;
    }

    /**
     * Sets the value of the currBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrBal(BigDecimal value) {
        this.currBal = value;
    }

    /**
     * Gets the value of the blockedAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBlockedAmt() {
        return blockedAmt;
    }

    /**
     * Sets the value of the blockedAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBlockedAmt(BigDecimal value) {
        this.blockedAmt = value;
    }

    /**
     * Gets the value of the atmCardExist property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getATMCardExist() {
        return atmCardExist;
    }

    /**
     * Sets the value of the atmCardExist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setATMCardExist(Boolean value) {
        this.atmCardExist = value;
    }

    /**
     * Gets the value of the signId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSignId() {
        if (signId == null) {
            signId = new ArrayList<String>();
        }
        return this.signId;
    }

    /**
     * Gets the value of the acctSPStatus1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSPStatus1() {
        return acctSPStatus1;
    }

    /**
     * Sets the value of the acctSPStatus1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSPStatus1(String value) {
        this.acctSPStatus1 = value;
    }

    /**
     * Gets the value of the acctSPStatus2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSPStatus2() {
        return acctSPStatus2;
    }

    /**
     * Sets the value of the acctSPStatus2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSPStatus2(String value) {
        this.acctSPStatus2 = value;
    }

    /**
     * Gets the value of the acctSPStatus3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSPStatus3() {
        return acctSPStatus3;
    }

    /**
     * Sets the value of the acctSPStatus3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSPStatus3(String value) {
        this.acctSPStatus3 = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    /**
     * Gets the value of the productTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTypeId() {
        return productTypeId;
    }

    /**
     * Sets the value of the productTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTypeId(String value) {
        this.productTypeId = value;
    }

    /**
     * Gets the value of the settlementAcctBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementAcctBank() {
        return settlementAcctBank;
    }

    /**
     * Sets the value of the settlementAcctBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementAcctBank(String value) {
        this.settlementAcctBank = value;
    }

    /**
     * Gets the value of the settlementAcctBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementAcctBranch() {
        return settlementAcctBranch;
    }

    /**
     * Sets the value of the settlementAcctBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementAcctBranch(String value) {
        this.settlementAcctBranch = value;
    }

    /**
     * Gets the value of the settlementAcctNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementAcctNum() {
        return settlementAcctNum;
    }

    /**
     * Sets the value of the settlementAcctNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementAcctNum(String value) {
        this.settlementAcctNum = value;
    }

    /**
     * Gets the value of the samaAcctNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSAMAAcctNum() {
        return samaAcctNum;
    }

    /**
     * Sets the value of the samaAcctNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSAMAAcctNum(String value) {
        this.samaAcctNum = value;
    }

    /**
     * Gets the value of the openReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenReason() {
        return openReason;
    }

    /**
     * Sets the value of the openReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenReason(String value) {
        this.openReason = value;
    }

    /**
     * Gets the value of the acctPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctPurpose() {
        return acctPurpose;
    }

    /**
     * Sets the value of the acctPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctPurpose(String value) {
        this.acctPurpose = value;
    }

    /**
     * Gets the value of the postingRestrictCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postingRestrictCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostingRestrictCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPostingRestrictCode() {
        if (postingRestrictCode == null) {
            postingRestrictCode = new ArrayList<String>();
        }
        return this.postingRestrictCode;
    }

    /**
     * Gets the value of the primaryRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryRM() {
        return primaryRM;
    }

    /**
     * Sets the value of the primaryRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryRM(String value) {
        this.primaryRM = value;
    }

    /**
     * Gets the value of the principleAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrincipleAmt() {
        return principleAmt;
    }

    /**
     * Sets the value of the principleAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrincipleAmt(BigDecimal value) {
        this.principleAmt = value;
    }

    /**
     * Gets the value of the placementDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlacementDt() {
        return placementDt;
    }

    /**
     * Sets the value of the placementDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlacementDt(XMLGregorianCalendar value) {
        this.placementDt = value;
    }

    /**
     * Gets the value of the profitRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProfitRate() {
        return profitRate;
    }

    /**
     * Sets the value of the profitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProfitRate(BigDecimal value) {
        this.profitRate = value;
    }

    /**
     * Gets the value of the relAcctInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relAcctInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelAcctInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelAcctInfoType }
     * 
     * 
     */
    public List<RelAcctInfoType> getRelAcctInfo() {
        if (relAcctInfo == null) {
            relAcctInfo = new ArrayList<RelAcctInfoType>();
        }
        return this.relAcctInfo;
    }

    /**
     * Gets the value of the chkAlternId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChkAlternId() {
        return chkAlternId;
    }

    /**
     * Sets the value of the chkAlternId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChkAlternId(String value) {
        this.chkAlternId = value;
    }

}
