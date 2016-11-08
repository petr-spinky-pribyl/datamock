package cz.spi.datamock.output;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import cz.spi.datamock.data.Attribute;
import cz.spi.datamock.data.MockData;
import cz.spi.datamock.data.Row;
import cz.spi.datamock.data.RowSet;
import cz.spi.datamock.data.datatypes.AttributeDataType;
import cz.spi.datamock.data.datatypes.DateType;
import cz.spi.datamock.data.datatypes.IDataType;
import cz.spi.datamock.data.datatypes.NumberType;
import cz.spi.datamock.data.datatypes.StringType;

/**
 * @author SPI
 *
 */
public class TextFileDataWriter implements IDataWriter {

	/* (non-Javadoc)
	 * @see cz.spi.datamock.output.IDataWriter#writeMockData(java.lang.String)
	 */
	
	PrintStream ps;
	
	@Override
	public void writeMockData(String outputName, MockData mockData) throws DataWriterException {
		try {
			ps = new PrintStream(outputName);
					
			for (int i = 0; i < mockData.getRowsets().size(); i++) {
				RowSet rowset = mockData.getRowsets().get(i);
				writeRowset(rowset);
				writeRows(rowset);
			}
		}
		catch (IOException e) {
			throw new DataWriterException(e);
		}
		
	}

	private void writeRowset(RowSet rowset) {
		boolean notFirst = false;
		
		ps.println('#' + rowset.getName());
		for (Attribute attribute : rowset.getAttributes()) {
			if (notFirst) {
				ps.print(',');
			}
			else {
				notFirst = true;
				ps.print('#');
			}
			ps.print(attribute.getName());
		}
		ps.println();
	}

	private void writeRows(RowSet rowset) {
		boolean notFirst;
		Attribute[] attributes = rowset.getAttributes();
		
		for (Row row : rowset.getRows()) {
			notFirst = false;
			for (int i = 0; i < attributes.length; i++) {
				if (notFirst) {
					ps.print(',');
				}
				else {
					notFirst = true;
				}
				IDataType data = row.getAttributes()[i];
				writeValue(data, attributes[i].getDataType());
			}
			ps.println();
		}
	}

	private void writeValue(IDataType data, AttributeDataType dataType) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
		
		switch(dataType) {
		case DATE: ps.print(format.format(((DateType)data).getDate()));
			break;
		case NUMBER: ps.print(((NumberType)data).getNumber().toString());
			break;
		case ROW:
			break;
		case ROWSET:
			break;
		case STRING: ps.print(((StringType)data).getText());
			break;
		default:
			break;
		
		}
		
	}

}
