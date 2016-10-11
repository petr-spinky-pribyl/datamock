package cz.spi.datamock.data;

import cz.spi.datamock.data.datatypes.IDataType;

/**
 * Container for one row of data
 * @author SPI
 *
 */
public class Row {
	private IDataType[] attributes;
	
	public void createAttributes(int size) {
		attributes = new IDataType[size];
	}
	
	public IDataType[] getAttributes() {
		return attributes;
	}

	public void addAttributeData(int index, IDataType data) {
		attributes[index] = data;
	}
}
