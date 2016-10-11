package cz.spi.datamock.data;

import cz.spi.datamock.data.datatypes.IDataType;

/**
 * Class for typed values of generated data
 * 
 * @author SPI
 *
 */
public class AttributeData {
	private IDataType value;

	public IDataType getValue() {
		return value;
	}

	public void setValue(IDataType value) {
		this.value = value;
	}

}
