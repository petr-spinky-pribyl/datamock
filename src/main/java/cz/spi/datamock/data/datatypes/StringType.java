package cz.spi.datamock.data.datatypes;

/**
 * Datatype for String values
 * 
 * @author SPI
 *
 */
public class StringType implements IDataType{
	private String text;

	public StringType(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
