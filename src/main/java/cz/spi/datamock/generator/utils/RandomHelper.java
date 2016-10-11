package cz.spi.datamock.generator.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {
	public static boolean generateByPercentage(int percentage) {
		if (percentage == 100) {
			return true;
		}
		
		if (ThreadLocalRandom.current().nextInt(0, 100) <= percentage) {
			return true;
		}
		
		return false;
	}
	
	public static int randomInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}

}
