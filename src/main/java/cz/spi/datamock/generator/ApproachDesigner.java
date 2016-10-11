package cz.spi.datamock.generator;

import java.util.ArrayList;
import java.util.List;

import cz.spi.datamock.configuration.AttributeDefinition;
import cz.spi.datamock.configuration.Configuration;
import cz.spi.datamock.configuration.RowSetDefinition;
import cz.spi.datamock.generator.attribute.AttributeGeneratorFactory;
import cz.spi.datamock.generator.rowset.RowSetGeneratorFactory;

/**
 * ApproachDesigner creates plan - Approach, from configuration.
 * 
 * @author SPI
 *
 */
public class ApproachDesigner {

	/**
	 * Row strategies first, than dependency strategies, attribute strategies last.
	 * It is neccessary to have links to parent generated objects (relation between attribute
	 * and rowset it belongs to)
	 * 
	 * @param configuration
	 * @return
	 */
	public Approach createApproach(Configuration configuration) {
		List<GeneratingStep> attributeSteps = new ArrayList<GeneratingStep>();
//		List<GeneratingStep> dependentSteps = new ArrayList<GeneratingStep>();
		List<GeneratingStep> rowsetSteps = new ArrayList<GeneratingStep>();
		int stepId = 0;

		for (RowSetDefinition rowset : configuration.getRowsets()) {
			GeneratingStep step = new GeneratingStep(stepId++, RowSetGeneratorFactory.createGenerator(rowset.getStrategy(), rowset));
			rowsetSteps.add(step);
			for (AttributeDefinition attribute : rowset.getAttributeDefinitions()) {
				GeneratingStep attributeStep = new GeneratingStep(stepId++,
						AttributeGeneratorFactory.createGenerator(attribute.getStrategy(), attribute), step.getStepId());
				attributeSteps.add(attributeStep);
			}
		}
		
		Approach approach = new Approach();
		approach.getSteps().addAll(rowsetSteps);
		approach.getSteps().addAll(attributeSteps);
		
		return approach;
	}

}
