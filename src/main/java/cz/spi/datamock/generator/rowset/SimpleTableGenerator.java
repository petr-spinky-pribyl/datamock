package cz.spi.datamock.generator.rowset;

import cz.spi.datamock.configuration.RowSetDefinition;
import cz.spi.datamock.data.RowSet;
import cz.spi.datamock.strategy.SimpleTableStrategy;

public class SimpleTableGenerator extends AbstractRowSetGenerator<SimpleTableStrategy> {


	public SimpleTableGenerator(SimpleTableStrategy strategy, RowSetDefinition definition) {
		this.definition = definition;
		this.strategy = strategy;
	}
	
	@Override
	public RowSet generateRows(long size) {
		int percentage = 50;
		RowSet rowset = createRowset(definition);
		
		
		if (strategy.getPercentage() != null) {
			percentage = strategy.getPercentage();
		}
		
		for (long i = 0; i < size * 100 / percentage; i++) {
			rowset.addRow(createRow(definition));
		}
		
		rowset.setName(definition.getName());
		
		return rowset;
		
	}

}
