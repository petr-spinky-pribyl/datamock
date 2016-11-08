package cz.spi.datamock.data.datatypes;

import java.util.Date;

/**
 * Datatype for String values
 * 
 * @author SPI
 *
 */
public class DateType implements IDataType{
	private Date date;

	public DateType(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
