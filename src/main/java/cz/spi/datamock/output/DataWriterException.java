package cz.spi.datamock.output;

import java.io.IOException;

public class DataWriterException extends Exception {

	public DataWriterException(IOException e) {
		super(e);
	}

}
