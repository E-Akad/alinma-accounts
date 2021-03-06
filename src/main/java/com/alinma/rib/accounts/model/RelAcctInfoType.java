//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.15 at 01:56:50 PM EET 
//


package com.alinma.rib.accounts.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelAcctInfo_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelAcctInfo_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.alinma.com}BankCode"/>
 *         &lt;element ref="{http://www.alinma.com}IBAN"/>
 *         &lt;element ref="{http://www.alinma.com}AcctName"/>
 *         &lt;element ref="{http://www.alinma.com}RelAcctClass"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelAcctInfo_Type", propOrder = {
    "bankCode",
    "iban",
    "acctName",
    "relAcctClass"
})
public class RelAcctInfoType {

    @XmlElement(name = "BankCode", required = true)
    protected String bankCode;
    @XmlElement(name = "IBAN", required = true)
    protected String iban;
    @XmlElement(name = "AcctName", required = true)
    protected String acctName;
    @XmlElement(name = "RelAcctClass", required = true)
    protected String relAcctClass;

    /**
     * Gets the value of the bankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
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
     * Gets the value of the relAcctClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelAcctClass() {
        return relAcctClass;
    }

    /**
     * Sets the value of the relAcctClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelAcctClass(String value) {
        this.relAcctClass = value;
    }

}
