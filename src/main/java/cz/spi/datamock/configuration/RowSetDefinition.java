package cz.spi.datamock.configuration;

import java.util.ArrayList;
import java.util.List;

import cz.spi.datamock.strategy.IStrategy;

/**
 * Configuration for RowSet definition
 * @author SPI
 *
 */
public class RowSetDefinition implements IConfigurationObject {
	private String name;
	private IStrategy strategy;
	private List<AttributeDefinition> attributeDefinitions;
	
	public RowSetDefinition() {
		attributeDefinitions = new ArrayList<AttributeDefinition>();
	}
	
	public RowSetDefinition(String name) {
		this();
		this.name = name;
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

	public List<AttributeDefinition> getAttributeDefinitions() {
		return attributeDefinitions;
	}

	public void addAttributeDefinition(AttributeDefinition attributeDefinition) {
		attributeDefinitions.add(attributeDefinition);
	}
}
