package cz.spi.datamock.strategy;

/**
 * Supertype for specific generation type settings.
 * 
 * @author SPI
 *
 */
public interface IStrategy {
	public Integer getPercentage();

	public void setPercentage(Integer percentage);
}
