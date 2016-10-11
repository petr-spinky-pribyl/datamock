package cz.spi.datamock.strategy;

/**
 * @author SPI
 *
 */
public class SimpleTableStrategy extends AbstractStrategy {
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
