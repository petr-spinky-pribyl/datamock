package cz.spi.datamock.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains rules for actual data generation
 * 
 * @author SPI
 *
 */
public class Configuration {
	private List<RowSetDefinition> rowsets;
	
	public Configuration() {
		rowsets = new ArrayList<RowSetDefinition>();
	}

	public List<RowSetDefinition> getRowsets() {
		return rowsets;
	}

	public void addRowSet(RowSetDefinition rowSet) {
		rowsets.add(rowSet);
	}
}
