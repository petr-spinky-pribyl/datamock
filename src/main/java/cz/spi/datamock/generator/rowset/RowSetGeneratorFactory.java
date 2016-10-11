package cz.spi.datamock.generator.rowset;

import cz.spi.datamock.configuration.RowSetDefinition;
import cz.spi.datamock.strategy.IStrategy;
import cz.spi.datamock.strategy.SimpleTableStrategy;

public class RowSetGeneratorFactory {
	public static AbstractRowSetGenerator<?> createGenerator(IStrategy strategy, RowSetDefinition definition) {
		if (strategy instanceof SimpleTableStrategy) {
			SimpleTableGenerator generator = new SimpleTableGenerator((SimpleTableStrategy)strategy, definition);
			return generator;
		}
		return null;
	}
}
