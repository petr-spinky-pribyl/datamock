/**
 * 
 */
package cz.spi.datamock.generator;

/**
 * @author SPI
 *
 */
public class GeneratingStep {
	private int stepId;
	private IGenerator generator;
	private int parentStepId;

	public GeneratingStep(int stepId, IGenerator generator) {
		super();
		this.generator = generator;
		this.stepId = stepId;
	}

	public GeneratingStep(int stepId, IGenerator generator, int parentStepId) {
		super();
		this.generator = generator;
		this.parentStepId = parentStepId;
		this.stepId = stepId;
	}

	public IGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(IGenerator generator) {
		this.generator = generator;
	}

	public int getParentStepId() {
		return parentStepId;
	}

	public void setParentStepId(int parentStepId) {
		this.parentStepId = parentStepId;
	}

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}
}
