package com.skc.mt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class AppLocalContainerEntityFactory extends LocalContainerEntityManagerFactoryBean {
	
	@Autowired
	@Qualifier("simpleTenantConnectionProvider")
	SimpleMultiTenantConnectionProvider connectionProvider;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		dataSource=connectionProvider.selectAnyDataSource();
		super.setDataSource(dataSource);
	}
}
