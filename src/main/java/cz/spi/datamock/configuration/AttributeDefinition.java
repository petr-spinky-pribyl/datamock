package cz.spi.datamock.configuration;

import cz.spi.datamock.data.datatypes.AttributeDataType;
import cz.spi.datamock.strategy.IStrategy;

/**
 * @author SPI
 *
 */
public class AttributeDefinition implements IConfigurationObject {
	private String name;
	private AttributeDataType dataType;
	private IStrategy strategy;

	public AttributeDefinition(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}

	public AttributeDataType getDataType() {
		return dataType;
	}

	public void setDataType(AttributeDataType dataType) {
		this.dataType = dataType;
	}
	

}
