package cz.spi.datamock;

import java.io.File;

import cz.spi.datamock.configuration.Configuration;
import cz.spi.datamock.configuration.ConfigurationException;
import cz.spi.datamock.configuration.ConfigurationReader;
import cz.spi.datamock.data.MockData;
import cz.spi.datamock.generator.Approach;
import cz.spi.datamock.generator.ApproachDesigner;
import cz.spi.datamock.generator.DataBuilder;
import cz.spi.datamock.output.DataWriterException;
import cz.spi.datamock.output.DataWriterFactory;
import cz.spi.datamock.output.IDataWriter;

/**
 * Entry point for data generating.
 *
 */
public class DataMockGenerator 
{

	public void generate(String configurationFileName, String outputType, String outputName, long size) throws ConfigurationException, DataWriterException {
		generate(new File(configurationFileName), outputType, outputName, size);
	}

	public void generate(File configurationFile, String outputType, String outputName, long size) throws ConfigurationException, DataWriterException {
    	Configuration configuration;
    	ConfigurationReader configurationReader = new ConfigurationReader();
    	
    	configuration = configurationReader.readFile(configurationFile);
    	
    	ApproachDesigner designer = new ApproachDesigner();
    	Approach approach = designer.createApproach(configuration);
    	
    	DataBuilder dataBuilder = new DataBuilder(approach);
    	MockData mockData = dataBuilder.createDataset(size);
    	
    	IDataWriter dataWriter = DataWriterFactory.getDataWriter(outputType);
    	dataWriter.writeMockData(outputName, mockData);
    }
}
