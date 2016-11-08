package cz.spi.datamock.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SPI
 *
 */
public class DateProbabilityDistributionStrategy extends AbstractStrategy {
	private List<MonthRate> monthRates = new ArrayList<MonthRate>();
	private int yearFrom;
	private int yearTo;
	
	public void addRate(int month, int rate) {
		monthRates.add(new MonthRate(month, rate));
	}
	
	public List<MonthRate> getRates() {
		return monthRates;
	}
	
	public static class MonthRate {
		int month;
		int rate;

		public MonthRate(int month, int rate) {
			super();
			this.month = month;
			this.rate = rate;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getRate() {
			return rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}
	}

	public int getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}

	public int getYearTo() {
		return yearTo;
	}

	public void setYearTo(int yearTo) {
		this.yearTo = yearTo;
	}
}
