package cz.spi.datamock.generator.attribute;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import cz.spi.datamock.data.datatypes.DateType;
import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.strategy.DateProbabilityDistributionStrategy;

public class DateProbabilityDistributionGenerator
		extends AbstractAttributeGenerator<DateProbabilityDistributionStrategy> {

	private int[] distributionArray;
	private int limit;

	public DateProbabilityDistributionGenerator(DateProbabilityDistributionStrategy strategy) {
		this.strategy = strategy;

		limit = 0;
		distributionArray = new int[strategy.getRates().size()];
		int i = 0;
		
		for (DateProbabilityDistributionStrategy.MonthRate rate : strategy.getRates()) {
			limit += rate.getRate();
			distributionArray[i++] = limit;
		}
	}

	@Override
	protected IDataType createAttributeValue() {
		Random random = new Random();
		
		int randomMonth = random.nextInt(limit) + 1;

		int min = Integer.MAX_VALUE;
		int mini = 0;
		for (int i = 0; i < distributionArray.length; i++) {
			if (Math.abs(distributionArray[i] - randomMonth) < min) {
				min = Math.abs(distributionArray[i] - randomMonth);
				mini = i;
			}
		}

		int randomYear = random.nextInt(strategy.getYearTo() - strategy.getYearFrom()) + strategy.getYearFrom();
		
		GregorianCalendar gc = new GregorianCalendar(randomYear, mini + 1, 1);
		int randomDay = random.nextInt(gc.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
		gc.set(Calendar.DAY_OF_MONTH, randomDay);

		return new DateType(gc.getTime()); 
	}

}
