package cz.spi.datamock.configuration;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import cz.spi.datamock.configuration.xml.AttributeType;
import cz.spi.datamock.configuration.xml.DataType;
import cz.spi.datamock.configuration.xml.DefinitionType;
import cz.spi.datamock.configuration.xml.RowsetType;
import cz.spi.datamock.data.datatypes.AttributeDataType;

/**
 * Reads configuration definitions from XML file and builds its structure in new Configuration object
 *  
 * @author SPI
 *
 */
public class ConfigurationReader {
	public Configuration readFile(File file) throws ConfigurationException {
		Configuration configuration = new Configuration();
	
		JAXBContext context;
		DefinitionType definition;
		try {
			context = JAXBContext.newInstance(DefinitionType.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<DefinitionType> definitionObject = unmarshaller.unmarshal(new StreamSource(file), DefinitionType.class); 
			definition = definitionObject.getValue();
		} catch (JAXBException e) {
			throw new ConfigurationException("Bad configuration file", e);
		}
		
		for (RowsetType rowsetType : definition.getRowset()) {
			RowSetDefinition rowset = new RowSetDefinition(rowsetType.getName());
			if (rowsetType.getStrategy() != null) {
				rowset.setStrategy(StrategyFactory.createStrategy(rowsetType.getStrategy()));
			}
			for (AttributeType attributeType : rowsetType.getAttribute()) {
				AttributeDefinition attribute = new AttributeDefinition(attributeType.getName());
				if (attributeType.getStrategy() != null) {
					attribute.setStrategy(StrategyFactory.createStrategy(attributeType.getStrategy()));
				}
				attribute.setDataType(mapDataType(attributeType.getDatatype()));
				rowset.addAttributeDefinition(attribute);
			}
			configuration.addRowSet(rowset);
		}
		
		return configuration;
	}
	
	private AttributeDataType mapDataType(DataType xmlType) {
		switch (xmlType) {
		case STRING: return AttributeDataType.STRING;
		case DATE:   return AttributeDataType.DATE;
		case NUMBER: return AttributeDataType.NUMBER;
		case ROW:    return AttributeDataType.ROW;
		case ROWSET: return AttributeDataType.ROWSET;
		}
		return null;
	}
}
