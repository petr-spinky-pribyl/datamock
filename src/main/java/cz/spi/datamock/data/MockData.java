package cz.spi.datamock.data;

import java.util.Hashtable;

/**
 * @author SPI
 *
 */
public class MockData {
	private Hashtable<Integer, RowSet> rowsets = new Hashtable<Integer,RowSet>();

	public Hashtable<Integer, RowSet> getRowsets() {
		return rowsets;
	}

	public void setRowsets(Hashtable<Integer, RowSet> rowsets) {
		this.rowsets = rowsets;
	}
	
	public void addRowset(Integer id, RowSet rowset) {
		rowsets.put(id, rowset);
	}
	
	public RowSet getRowSet(Integer id) {
		return rowsets.get(id);
	}
}
