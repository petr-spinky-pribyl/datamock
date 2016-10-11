/**
 * 
 */
package cz.spi.datamock.output;

/**
 * @author SPI
 *
 */
public class DataWriterFactory {

	public static IDataWriter getDataWriter(String outputType) {
		OutputTypes type = OutputTypes.valueOf(outputType.toUpperCase());
		
		switch (type) {
		case TEXT_FILE : return new TextFileDataWriter();
		case JSON:
			break;
		case MS_EXCEL:
			break;
		case SQL_SCRIPT:
			break;
		case XML:
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
