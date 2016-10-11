package cz.spi.datamock.generator;

import cz.spi.datamock.configuration.IConfigurationObject;
import cz.spi.datamock.strategy.IStrategy;

/**
 * @author SPI
 *
 */
public abstract class AbstractGenerator<T extends IStrategy, D extends IConfigurationObject> implements IGenerator {
	protected T strategy;
	protected D definition;

	public T getStrategy() {
		return strategy;
	}

	public void setStrategy(T strategy) {
		this.strategy = strategy;
	}

	public void setDefinition(D definition) {
		this.definition = definition;
	}

	public D getDefinition() {
		return definition;
	}

}
