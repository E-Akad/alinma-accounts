//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.25 at 03:52:28 PM EET 
//


package com.alinma.rib.accounts.model.system.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.alinma.rib.models.system.common.MsgRsHdrType;


/**
 * <p>Java class for CardsInqRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardsInqRs_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.alinma.com}MsgRsHdr"/>
 *         &lt;element name="Body" type="{http://www.alinma.com}CardsInqBodyRs_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "CardsInqRs")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardsInqRs_Type", propOrder = {
    "msgRsHdr",
    "body"
})
public class CardsInqRsType {

    @XmlElement(name = "MsgRsHdr", required = true)
    protected MsgRsHdrType msgRsHdr;
    @XmlElement(name = "Body")
    protected CardsInqBodyRsType body;

    /**
     * Gets the value of the msgRsHdr property.
     * 
     * @return
     *     possible object is
     *     {@link MsgRsHdrType }
     *     
     */
    public MsgRsHdrType getMsgRsHdr() {
        return msgRsHdr;
    }

    /**
     * Sets the value of the msgRsHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgRsHdrType }
     *     
     */
    public void setMsgRsHdr(MsgRsHdrType value) {
        this.msgRsHdr = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link CardsInqBodyRsType }
     *     
     */
    public CardsInqBodyRsType getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardsInqBodyRsType }
     *     
     */
    public void setBody(CardsInqBodyRsType value) {
        this.body = value;
    }

}