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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SysSbscrptnId_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SysSbscrptnId_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.alinma.com}SysSbscrptnNum"/>
 *         &lt;element ref="{http://www.alinma.com}SysSbscrptnType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SysSbscrptnId_Type", propOrder = {
    "sysSbscrptnNum",
    "sysSbscrptnType"
})
public class SysSbscrptnIdType {

    @XmlElement(name = "SysSbscrptnNum", required = true)
    protected String sysSbscrptnNum;
    @XmlElement(name = "SysSbscrptnType", required = true)
    @XmlSchemaType(name = "string")
    protected SysSbscrptnTypeType sysSbscrptnType;

    /**
     * Gets the value of the sysSbscrptnNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysSbscrptnNum() {
        return sysSbscrptnNum;
    }

    /**
     * Sets the value of the sysSbscrptnNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysSbscrptnNum(String value) {
        this.sysSbscrptnNum = value;
    }

    /**
     * Gets the value of the sysSbscrptnType property.
     * 
     * @return
     *     possible object is
     *     {@link SysSbscrptnTypeType }
     *     
     */
    public SysSbscrptnTypeType getSysSbscrptnType() {
        return sysSbscrptnType;
    }

    /**
     * Sets the value of the sysSbscrptnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysSbscrptnTypeType }
     *     
     */
    public void setSysSbscrptnType(SysSbscrptnTypeType value) {
        this.sysSbscrptnType = value;
    }

}
