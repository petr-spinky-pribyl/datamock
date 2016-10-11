package cz.spi.datamock.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import cz.spi.datamock.strategy.RandomStringStrategy;
import cz.spi.datamock.strategy.SequenceStrategy;
import cz.spi.datamock.strategy.SimpleTableStrategy;

public class ConfigurationReaderTest {

	@Test
	public void testReadFile() throws ConfigurationException {
		ClassLoader loader = getClass().getClassLoader();
		File configurationFile = new File(loader.getResource("configuration/SimpleTableConfiguration.xml").getFile());
		
		ConfigurationReader configurationReader = new ConfigurationReader();
		
		Configuration configuration = configurationReader.readFile(configurationFile);
		
		RowSetDefinition rowset = configuration.getRowsets().get(0);
		assertEquals(rowset.getName(), "emp");
		assertTrue(rowset.getStrategy() instanceof SimpleTableStrategy);
		assertEquals(rowset.getAttributeDefinitions().size(), 2);
		AttributeDefinition attribute = rowset.getAttributeDefinitions().get(0);
		assertEquals(attribute.getName(), "empno");
		assertTrue(attribute.getStrategy() instanceof SequenceStrategy);
		assertEquals(((SequenceStrategy)attribute.getStrategy()).getStart(), 1);
		attribute = rowset.getAttributeDefinitions().get(1);
		assertEquals(attribute.getName(), "ename");
		assertTrue(attribute.getStrategy() instanceof RandomStringStrategy);
		assertEquals(((RandomStringStrategy)attribute.getStrategy()).getMinimumSize(), 5);
		assertEquals(((RandomStringStrategy)attribute.getStrategy()).getMaximumSize(), 10);
	}

}
