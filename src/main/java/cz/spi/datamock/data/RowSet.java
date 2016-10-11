package cz.spi.datamock.data;

import java.util.ArrayList;
import java.util.List;

import cz.spi.datamock.generator.GeneratingStep;

/**
 * Container for group of generated records
 * 
 * @author SPI
 *
 */
public class RowSet {
	private String name;
	private List<Row> rows;
	private GeneratingStep generatingStep;
	private Attribute[] attributes;

	public RowSet() {
		rows = new ArrayList<Row>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void addRow(Row row) {
		rows.add(row);
	}

	public GeneratingStep getGeneratingStep() {
		return generatingStep;
	}

	public void setGeneratingStep(GeneratingStep generatingStep) {
		this.generatingStep = generatingStep;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}
	
	public void createAttributes(int size) {
		attributes = new Attribute[size];
	}

	public void setAttribute(int index, Attribute attribute) {
		this.attributes[index] = attribute;
	}
}
