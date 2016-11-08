package cz.spi.datamock.configuration;

import cz.spi.datamock.configuration.xml.ConstantStrategyType;
import cz.spi.datamock.configuration.xml.DateProbabilityDistributionStrategyType;
import cz.spi.datamock.configuration.xml.MonthRateType;
import cz.spi.datamock.configuration.xml.RandomStringStrategyType;
import cz.spi.datamock.configuration.xml.SequenceStrategyType;
import cz.spi.datamock.configuration.xml.SimpleTableStrategyType;
import cz.spi.datamock.configuration.xml.StrategyType;
import cz.spi.datamock.strategy.ConstantStrategy;
import cz.spi.datamock.strategy.DateProbabilityDistributionStrategy;
import cz.spi.datamock.strategy.IStrategy;
import cz.spi.datamock.strategy.RandomStringStrategy;
import cz.spi.datamock.strategy.SequenceStrategy;
import cz.spi.datamock.strategy.SimpleTableStrategy;

/**
 * @author SPI
 *
 */
public class StrategyFactory {
	public static IStrategy createStrategy(StrategyType strategyType) throws ConfigurationException {
		IStrategy strategy = null;

		if (strategyType instanceof SequenceStrategyType) {
			strategy = createSequenceStrategy((SequenceStrategyType) strategyType);
		}
		if (strategyType instanceof RandomStringStrategyType) {
			strategy = createRandomStringStrategy((RandomStringStrategyType) strategyType);
		}
		if (strategyType instanceof SimpleTableStrategyType) {
			strategy = createSimpleTableStrategy((SimpleTableStrategyType) strategyType);
		}
		if (strategyType instanceof ConstantStrategyType) {
			strategy = createConstantStrategy((ConstantStrategyType) strategyType);
		}
		if (strategyType instanceof DateProbabilityDistributionStrategyType) {
			strategy = createDateProbabilityDistributionStrategy((DateProbabilityDistributionStrategyType) strategyType);
		}

		if (strategy == null) {
			throw new ConfigurationException("Unknown strategy: " + strategyType.getClass().getName());
		}

		if (strategyType.getPercentage() == null) {
			strategy.setPercentage(100);
		}
		else {
			strategy.setPercentage(strategyType.getPercentage());
		}
		return strategy;
	}

	private static IStrategy createSimpleTableStrategy(SimpleTableStrategyType strategyType) {
		SimpleTableStrategy strategy = new SimpleTableStrategy();
		strategy.setTableName(strategyType.getTableName());

		return strategy;
	}

	private static IStrategy createRandomStringStrategy(RandomStringStrategyType strategyType) {
		RandomStringStrategy strategy = new RandomStringStrategy();
		strategy.setMinimumSize(strategyType.getMinimumSize());
		strategy.setMaximumSize(strategyType.getMaximumSize());

		return strategy;
	}

	private static IStrategy createSequenceStrategy(SequenceStrategyType strategyType) {
		SequenceStrategy strategy = new SequenceStrategy();
		strategy.setStart(strategyType.getStart());

		return strategy;
	}

	private static IStrategy createConstantStrategy(ConstantStrategyType strategyType) {
		ConstantStrategy strategy = new ConstantStrategy();
		strategy.setConstantString(strategyType.getConstantString());
		strategy.setConstantNumber(strategyType.getConstantNumber());

		return strategy;
	}

	private static IStrategy createDateProbabilityDistributionStrategy(DateProbabilityDistributionStrategyType strategyType) {
		DateProbabilityDistributionStrategy strategy = new DateProbabilityDistributionStrategy();
		strategy.setYearFrom(strategyType.getYearFrom());
		strategy.setYearTo(strategyType.getYearTo());
		for (MonthRateType monthRateType : strategyType.getMonthRate()) {
			strategy.addRate(monthRateType.getMonth(), monthRateType.getRate());
		}

		return strategy;
	}

}
