//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.10 at 11:08:47 PM CEST 
//


package cz.spi.datamock.configuration.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for randomStringStrategyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="randomStringStrategyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datamock.spi.cz}strategyType">
 *       &lt;attribute name="minimumSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maximumSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "randomStringStrategyType")
public class RandomStringStrategyType
    extends StrategyType
{

    @XmlAttribute(name = "minimumSize")
    protected Integer minimumSize;
    @XmlAttribute(name = "maximumSize")
    protected Integer maximumSize;

    /**
     * Gets the value of the minimumSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinimumSize() {
        return minimumSize;
    }

    /**
     * Sets the value of the minimumSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimumSize(Integer value) {
        this.minimumSize = value;
    }

    /**
     * Gets the value of the maximumSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumSize() {
        return maximumSize;
    }

    /**
     * Sets the value of the maximumSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumSize(Integer value) {
        this.maximumSize = value;
    }

}
