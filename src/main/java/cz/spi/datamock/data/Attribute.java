package cz.spi.datamock.data;

import cz.spi.datamock.data.datatypes.AttributeDataType;

/**
 * One column value
 * 
 * @author SPI
 *
 */
public class Attribute {
	private AttributeDataType dataType;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttributeDataType getDataType() {
		return dataType;
	}

	public void setDataType(AttributeDataType dataType) {
		this.dataType = dataType;
	}
}
