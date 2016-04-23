package com.skc.cassendra.core;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.AlreadyExistsException;
import com.skc.bootstrap.ConfigurationLoader;
import com.skc.util.AppUtil;
import com.skc.util.ApplicationConstants;
import com.skc.util.CQLUtil;

public class CassendraPool {
	private static CassendraPool cassendraPool;
	private static Cluster cluster;
	private Session session;
	
	static{
		cluster = Cluster.builder().addContactPoint(ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_HOST))
									.build();
	}
	
	private CassendraPool(){
		try{
			getSession().execute(String.format(CQLUtil.CREATE_KEYSPACE, ConfigurationLoader.CASSENDRA_CONFIG.getProperty(ApplicationConstants.CASSENDRA_KEYSPACE)));
		}catch(AlreadyExistsException alreadyExistsException){
			System.out.println("KEYSPACE exists.");
		}
	}
	
	public static CassendraPool getInstance(){
		if(AppUtil.doNullCheckFor(cassendraPool)){
			cassendraPool = new CassendraPool();
		}
		return cassendraPool;
	}
	
	public Session getSession() {
		session = cluster.connect();
		return session;
	}

}
