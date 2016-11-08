package cz.spi.datamock;

import java.io.File;

import org.junit.Test;

import cz.spi.datamock.configuration.ConfigurationException;
import cz.spi.datamock.output.DataWriterException;

public class DateProbabilityDistributionGeneratorTest {

	@Test
	public void testMockGenerator() throws ConfigurationException, DataWriterException {
		ClassLoader loader = getClass().getClassLoader();
		File configurationFile = new File(loader.getResource("configuration/ProbabilityDistributionConfiguration.xml").getFile());
		
		DataMockGenerator generator = new DataMockGenerator();
		generator.generate(configurationFile, "TEXT_FILE", "c:\\temp\\a.txt", 5000);
	}

}
