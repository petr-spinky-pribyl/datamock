package cz.spi.datamock.strategy;

import java.util.Random;

public class TestStrategy {

	public static void main(String[] args) {
		FuncVal[] xs = new FuncVal[100];
		
		for (int i = 0; i < 100; i++) {
			double x = i * 4.0 / 100;
			xs[i] = new FuncVal(x, func(x));
		}
		
		Random random = new Random();
		for (int i = 0; i < 100000; i++) {
			double f = random.nextDouble() * 4;
			double min = Double.MAX_VALUE;
			int minj = 0;
			for (int j = 0; j < 100; j++) {
				if (Math.abs(xs[j].f - f) < min) {
					min = Math.abs(xs[j].f - f);
					minj = j;
				}
			}
			System.out.println(xs[minj].x);
		}

	}
	
	private static double func(double x) {
		return x * x / 4;
	}

	static class FuncVal {
		double x;
		double f;

		public FuncVal(double x, double f) {
			super();
			this.x = x;
			this.f = f;
		}
	}
}
