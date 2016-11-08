package cz.spi.datamock.generator.attribute;

import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.data.datatypes.NumberType;
import cz.spi.datamock.data.datatypes.StringType;
import cz.spi.datamock.strategy.ConstantStrategy;

public class ConstantGenerator extends AbstractAttributeGenerator<ConstantStrategy> {

	public ConstantGenerator(ConstantStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	protected IDataType createAttributeValue() {
		if (strategy.getConstantString() != null) {
			StringType text = new StringType(strategy.getConstantString());
			return text;
		}
		if (strategy.getConstantNumber() != null) {
			NumberType decimal = new NumberType(strategy.getConstantNumber());
			return decimal;
		}
		
		return null;
	}

	
}
