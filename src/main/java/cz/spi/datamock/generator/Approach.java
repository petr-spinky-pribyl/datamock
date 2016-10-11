/**
 * 
 */
package cz.spi.datamock.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SPI
 *
 */
public class Approach {
	private List<GeneratingStep> steps = new ArrayList<GeneratingStep>();

	public List<GeneratingStep> getSteps() {
		return steps;
	}

	public void addStep(GeneratingStep step) {
		steps.add(step) ;
	}
		
}