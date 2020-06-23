
package com.alinma.rib.accounts.model.system.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.alinma.rib.accounts.model.AcctIdType;



/**
 * <p>Java class for CustAcctDtlsInqBodyRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustAcctDtlsInqBodyRq_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.alinma.com}AcctId"/>
 *           &lt;element ref="{http://www.alinma.com}IBAN"/>
 *           &lt;element ref="{http://www.alinma.com}AlternAcctNum"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustAcctDtlsInqBodyRq_Type", propOrder = {
    "acctId",
    "iban",
    "alternAcctNum"
})
public class CustAcctDtlsInqBodyRqType {

    @XmlElement(name = "AcctId")
    protected AcctIdType acctId;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "AlternAcctNum")
    protected String alternAcctNum;

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
     * Gets the value of the alternAcctNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternAcctNum() {
        return alternAcctNum;
    }

    /**
     * Sets the value of the alternAcctNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternAcctNum(String value) {
        this.alternAcctNum = value;
    }

}
