package cz.spi.datamock.generator.attribute;

import cz.spi.datamock.configuration.AttributeDefinition;
import cz.spi.datamock.strategy.IStrategy;
import cz.spi.datamock.strategy.RandomStringStrategy;
import cz.spi.datamock.strategy.SequenceStrategy;

public class AttributeGeneratorFactory {
	public static AbstractAttributeGenerator<? extends IStrategy> createGenerator(IStrategy strategy, AttributeDefinition attributeDefinition) {
		AbstractAttributeGenerator<? extends IStrategy> generator = null;
		if (strategy instanceof SequenceStrategy) {
			generator = new SequenceGenerator((SequenceStrategy)strategy);
		}
		if (strategy instanceof RandomStringStrategy) {
			generator = new RandomStringGenerator((RandomStringStrategy)strategy);
		}

		if (generator != null) {
			generator.setDefinition(attributeDefinition);
		}
		
		return generator;
	}
}
