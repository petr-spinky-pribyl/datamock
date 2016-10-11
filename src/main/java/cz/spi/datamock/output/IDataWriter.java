package cz.spi.datamock.output;

import cz.spi.datamock.data.MockData;

/**
 * @author SPI
 *
 */
public interface IDataWriter {
	public void writeMockData(String outputName, MockData mockData) throws DataWriterException;
}
