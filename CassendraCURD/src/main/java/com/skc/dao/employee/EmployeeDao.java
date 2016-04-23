package com.skc.dao.employee;

import com.datastax.driver.core.Row;
import com.skc.bootstrap.ConfigurationLoader;
import com.skc.cassendra.dao.CassendraCoreDao;
import com.skc.log.Logger;
import com.skc.util.ApplicationConstants;
import com.skc.util.CQLUtil;

public class EmployeeDao extends CassendraCoreDao {
	
	public EmployeeDao() {
		super();
		Logger.log(CQLUtil.CREATE_TABLE_EMPLOYEE);
		executeQuery(CQLUtil.CREATE_TABLE_EMPLOYEE);
	}
	
	public void createEmployee(int emp_id,String first_name,String last_name){
		executeQuery(String.format(CQLUtil.CREATE_EMP_CQL,ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE), emp_id,first_name,last_name));
	}

	public void deleteEmployee(Integer empId){
		executeQuery(String.format(CQLUtil.DELETE_EMP_CQL,ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE), empId));
	}
	
	public void updateEmployee(String first_name,int emp_id){
		executeQuery(String.format(CQLUtil.UPDATE_EMP_CQL,ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE),first_name,emp_id));
	}
	
	public void retrieveEmployee(){
		Logger.log(CQLUtil.RETRIVE_EMPLOYEE);
		for (Row row: cassendraPool.getSession().execute(CQLUtil.RETRIVE_EMPLOYEE)) {
			Logger.log(row.toString());
		}
	}
}
