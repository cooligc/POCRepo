package com.skc.util;

import com.skc.bootstrap.ConfigurationLoader;

public interface CQLUtil {
	String CREATE_KEYSPACE = "CREATE KEYSPACE %s WITH replication = {'class':'SimpleStrategy','replication_factor':1}";
	String CREATE_TABLE_EMPLOYEE = String.format("CREATE TABLE %s.employee(emp_id bigint PRIMARY KEY, first_name varchar,last_name varchar)",ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE));
	String CREATE_EMP_CQL="INSERT INTO %s.employee(emp_id,first_name,last_name) VALUES(%s,'%s','%s')";
//	String CREATE_EMPLOYEE = String.format(CREATE_EMP_CQL, ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE));
	String DELETE_EMP_CQL="DELETE FROM %s.employee WHERE emp_id=%s";
//	String DELETE_EMPLOYEE = String.format(DELETE_EMP_CQL, ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE));
	String UPDATE_EMP_CQL="UPDATE %s.employee set first_name='%s' where emp_id=%s";
//	String UPDATE_EMPLOYEE = String.format(UPDATE_EMP_CQL, ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE));
	String RETRIVE_EMPLOYEE = String.format("SELECT * FROM %s.employee", ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE));
}
