package com.skc.cassendra.dao;

import com.datastax.driver.core.exceptions.AlreadyExistsException;
import com.skc.cassendra.core.CassendraPool;
import com.skc.log.Logger;

public class CassendraCoreDao {
	
	protected CassendraPool cassendraPool;
	
	public CassendraCoreDao(){
		super();
		cassendraPool = CassendraPool.getInstance();
	}
	
	public void executeQuery(String cql){
		try{
			Logger.log(cql);
			cassendraPool.getSession().execute(cql);
		}catch(AlreadyExistsException alreadyExistsException){
			System.out.println("Table exists");
		}
	}
}
