package cz.spi.datamock.data.datatypes;

import java.math.BigDecimal;

/**
 * Datatype for String values
 * 
 * @author SPI
 *
 */
public class NumberType implements IDataType{
	private BigDecimal number;

	public NumberType(BigDecimal number) {
		super();
		this.number = number;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}
}
