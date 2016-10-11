package cz.spi.datamock.generator.attribute;

import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.data.datatypes.StringType;
import cz.spi.datamock.generator.utils.RandomHelper;
import cz.spi.datamock.strategy.RandomStringStrategy;

public class RandomStringGenerator extends AbstractAttributeGenerator<RandomStringStrategy> {
	private static final int CHAR_LIMIT = 61;
	private static final int DIGIT_LIMIT = 10;
	private static final int UPPERCASE_LIMIT = 36;
	private static final int FIRST_DIGIT = 48;
	private static final int FIRST_UPPER = 65 - DIGIT_LIMIT;
	private static final int FIRST_LOWER = 97 - UPPERCASE_LIMIT;
	
	private int minSize;
	private int maxSize;
	
	public RandomStringGenerator(RandomStringStrategy strategy) {
		this.strategy = strategy;
		minSize = strategy.getMinimumSize();
		maxSize = strategy.getMaximumSize();
	}

	@Override
	protected IDataType createAttributeValue() {
		int stringSize = RandomHelper.randomInt(minSize, maxSize);
		StringBuffer sb = new StringBuffer(stringSize);
		
		for (int i = 0; i < stringSize; i++) {
			int letter = RandomHelper.randomInt(0, CHAR_LIMIT);
			if (letter < DIGIT_LIMIT) {
				sb.append((char)(letter + FIRST_DIGIT));
				continue;
			}
			if (letter < UPPERCASE_LIMIT) {
				sb.append((char)(letter + FIRST_UPPER));
				continue;
			}
			sb.append((char)(letter + FIRST_LOWER));
		}
		
		StringType text = new StringType(sb.toString());
		return text;
	}

	
}
