//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.08 at 12:31:50 AM CET 
//


package cz.spi.datamock.configuration.xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for constantStrategyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="constantStrategyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datamock.spi.cz}strategyType">
 *       &lt;attribute name="constantString" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="constantNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "constantStrategyType")
public class ConstantStrategyType
    extends StrategyType
{

    @XmlAttribute(name = "constantString")
    protected String constantString;
    @XmlAttribute(name = "constantNumber")
    protected BigDecimal constantNumber;

    /**
     * Gets the value of the constantString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstantString() {
        return constantString;
    }

    /**
     * Sets the value of the constantString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstantString(String value) {
        this.constantString = value;
    }

    /**
     * Gets the value of the constantNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConstantNumber() {
        return constantNumber;
    }

    /**
     * Sets the value of the constantNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConstantNumber(BigDecimal value) {
        this.constantNumber = value;
    }

}
