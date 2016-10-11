package cz.spi.datamock.generator.attribute;

import cz.spi.datamock.configuration.AttributeDefinition;
import cz.spi.datamock.data.Row;
import cz.spi.datamock.data.RowSet;
import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.generator.AbstractGenerator;
import cz.spi.datamock.generator.utils.RandomHelper;
import cz.spi.datamock.strategy.IStrategy;

public abstract class AbstractAttributeGenerator<T extends IStrategy> extends AbstractGenerator<T, AttributeDefinition> {
	protected abstract IDataType createAttributeValue();
	
	public void generateAttributes(RowSet rowset) {
		// TODO Auto-generated method stub
		int index = findAttributeIndex(rowset, definition.getName());
		
		for (Row row : rowset.getRows()) {
			if (RandomHelper.generateByPercentage(strategy.getPercentage())) {
				row.getAttributes()[index] = createAttributeValue();
			}
		}
	}
	
	private int findAttributeIndex(RowSet rowset, String attributeName) {
		for (int i = 0; i < rowset.getAttributes().length; i++) {
			if ((rowset.getAttributes()[i].getName().equals(attributeName))) {
				return i;
			}
		}
		
		return -1;
	}
}
