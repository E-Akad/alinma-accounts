//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.25 at 03:52:28 PM EET 
//


package com.alinma.rib.accounts.model.system.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.alinma.rib.models.system.common.RecCtrlInType;


/**
 * <p>Java class for CardsInqBodyRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardsInqBodyRq_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.alinma.com}LnkdAcctNum" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}LnkdCIF" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}FuncId" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}CardType" minOccurs="0"/>
 *         &lt;element ref="{http://www.alinma.com}RecCtrlIn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardsInqBodyRq_Type", propOrder = {
    "lnkdAcctNum",
    "lnkdCIF",
    "funcId",
    "cardType",
    "recCtrlIn"
})
public class CardsInqBodyRqType {

    @XmlElement(name = "LnkdAcctNum")
    protected String lnkdAcctNum;
    @XmlElement(name = "LnkdCIF")
    protected String lnkdCIF;
    @XmlElement(name = "FuncId")
    protected String funcId;
    @XmlElement(name = "CardType")
    protected String cardType;
    @XmlElement(name = "RecCtrlIn")
    protected RecCtrlInType recCtrlIn;

    /**
     * Gets the value of the lnkdAcctNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLnkdAcctNum() {
        return lnkdAcctNum;
    }

    /**
     * Sets the value of the lnkdAcctNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLnkdAcctNum(String value) {
        this.lnkdAcctNum = value;
    }

    /**
     * Gets the value of the lnkdCIF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLnkdCIF() {
        return lnkdCIF;
    }

    /**
     * Sets the value of the lnkdCIF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLnkdCIF(String value) {
        this.lnkdCIF = value;
    }

    /**
     * Gets the value of the funcId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * Sets the value of the funcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncId(String value) {
        this.funcId = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the recCtrlIn property.
     * 
     * @return
     *     possible object is
     *     {@link RecCtrlInType }
     *     
     */
    public RecCtrlInType getRecCtrlIn() {
        return recCtrlIn;
    }

    /**
     * Sets the value of the recCtrlIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecCtrlInType }
     *     
     */
    public void setRecCtrlIn(RecCtrlInType value) {
        this.recCtrlIn = value;
    }

}