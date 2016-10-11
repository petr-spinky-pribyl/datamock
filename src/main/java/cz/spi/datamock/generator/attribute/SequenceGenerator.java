package cz.spi.datamock.generator.attribute;

import java.math.BigDecimal;

import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.data.datatypes.NumberType;
import cz.spi.datamock.strategy.SequenceStrategy;

public class SequenceGenerator extends AbstractAttributeGenerator<SequenceStrategy> {
	private long counter;
	
	public SequenceGenerator(SequenceStrategy strategy) {
		this.strategy = strategy;
		counter = strategy.getStart();
	}

	@Override
	protected IDataType createAttributeValue() {
		NumberType number = new NumberType(BigDecimal.valueOf(counter++));
		return number;
	}

	
}
