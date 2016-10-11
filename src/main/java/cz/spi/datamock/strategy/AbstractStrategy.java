package cz.spi.datamock.strategy;

/**
 * Common attributes and methods for strategies
 * 
 */
public abstract class AbstractStrategy implements IStrategy {
	private Integer percentage;

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
}
