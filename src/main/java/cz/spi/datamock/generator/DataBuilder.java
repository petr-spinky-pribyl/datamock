package cz.spi.datamock.generator;

import cz.spi.datamock.data.MockData;
import cz.spi.datamock.data.RowSet;
import cz.spi.datamock.generator.attribute.AbstractAttributeGenerator;
import cz.spi.datamock.generator.rowset.AbstractRowSetGenerator;

/**
 * @author SPI
 *
 */
public class DataBuilder {
	private Approach approach;
	
	public DataBuilder(Approach approach) {
		this.approach = approach;
	}

	public MockData createDataset(long size) {
		MockData resultData = new MockData();
		
		for (GeneratingStep step : approach.getSteps()) {
			if (step.getGenerator() instanceof AbstractRowSetGenerator) {
				AbstractRowSetGenerator<?> generator = (AbstractRowSetGenerator<?>) step.getGenerator(); 
				RowSet rowset = generator.generateRows(size);
				resultData.addRowset(step.getStepId(), rowset);
			}
			
			if (step.getGenerator() instanceof AbstractAttributeGenerator) {
				AbstractAttributeGenerator<?> generator = (AbstractAttributeGenerator<?>)step.getGenerator();
				RowSet parentRowset = resultData.getRowSet(step.getParentStepId());
				generator.generateAttributes(parentRowset);
			}
		}

		return resultData;
		
	}
}
