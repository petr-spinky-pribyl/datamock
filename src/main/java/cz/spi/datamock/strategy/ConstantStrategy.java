package cz.spi.datamock.strategy;

import java.math.BigDecimal;

/**
 * @author SPI
 *
 */
public class ConstantStrategy extends AbstractStrategy {
	private String constantString;
	private BigDecimal constantNumber;

	public String getConstantString() {
		return constantString;
	}

	public void setConstantString(String constantString) {
		this.constantString = constantString;
	}

	public BigDecimal getConstantNumber() {
		return constantNumber;
	}

	public void setConstantNumber(BigDecimal number) {
		constantNumber = number;
	}

}
