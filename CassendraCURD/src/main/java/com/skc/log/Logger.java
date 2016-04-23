package com.skc.log;

import java.util.Date;

import com.skc.bootstrap.ConfigurationLoader;

public class Logger {
	
	public static void log(Object obj){
		if(Boolean.valueOf(ConfigurationLoader.CASSENDRA_CONFIG.getProperty("system.log.enable"))){
			System.out.println(new Date()+"\t--->     "+Thread.currentThread().getName()+"\t--->     "+obj);
		}
	}
}
