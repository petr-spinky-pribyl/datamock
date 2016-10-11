package cz.spi.datamock.generator.rowset;

import java.util.List;

import cz.spi.datamock.configuration.AttributeDefinition;
import cz.spi.datamock.configuration.RowSetDefinition;
import cz.spi.datamock.data.Attribute;
import cz.spi.datamock.data.Row;
import cz.spi.datamock.data.RowSet;
import cz.spi.datamock.generator.AbstractGenerator;
import cz.spi.datamock.strategy.IStrategy;

public abstract class AbstractRowSetGenerator<T extends IStrategy> extends AbstractGenerator<T, RowSetDefinition> {
	public abstract RowSet generateRows(long size);
	
	protected RowSet createRowset(RowSetDefinition definition) {
		RowSet rowset = new RowSet();
		List<AttributeDefinition> attributes = definition.getAttributeDefinitions();
		int i = 0;
		
		rowset.createAttributes(attributes.size());
		
		for (AttributeDefinition attributeDefinition : attributes) {
			Attribute attribute = new Attribute();
			attribute.setDataType(attributeDefinition.getDataType());
			attribute.setName(attributeDefinition.getName());
			(rowset.getAttributes())[i++] = attribute;
		}
		
		return rowset;
	}
	
	protected Row createRow(RowSetDefinition definition) {
		Row row = new Row();
		List<AttributeDefinition> attributes = definition.getAttributeDefinitions();
		
		row.createAttributes(attributes.size());
		
		return row;
	}
}
