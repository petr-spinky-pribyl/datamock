package cz.spi.datamock.strategy;

/**
 * @author SPI
 *
 */
public class RandomStringStrategy extends AbstractStrategy {
	private int minimumSize;
	private int maximumSize;

	public int getMinimumSize() {
		return minimumSize;
	}

	public void setMinimumSize(int minimumSize) {
		this.minimumSize = minimumSize;
	}

	public int getMaximumSize() {
		return maximumSize;
	}

	public void setMaximumSize(int maximumSize) {
		this.maximumSize = maximumSize;
	}
}
