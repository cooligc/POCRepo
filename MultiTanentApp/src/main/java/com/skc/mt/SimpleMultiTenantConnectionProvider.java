package com.skc.mt;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.stereotype.Component;
/**
 * <p> Get the Right Tanent </p>
 * @author IgnatiusCipher
 * */
public class SimpleMultiTenantConnectionProvider extends
		AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Map<String, DataSource> dataSourceMap;
	
	@Override
	public DataSource selectAnyDataSource() {
		return (DataSource) dataSourceMap.values().toArray()[0];
	}

	@Override
	public DataSource selectDataSource(String tanentIdentifier) {
		return dataSourceMap.get(tanentIdentifier);
	}

	/**
	 * @param dataSourceMap the dataSourceMap to set
	 */
	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}

}
