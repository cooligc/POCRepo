package com.skc.bootstrap;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {
	public static final Properties CASSENDRA_CONFIG;
	
	static{
		CASSENDRA_CONFIG = new Properties();
		try {
			CASSENDRA_CONFIG.load(ConfigurationLoader.class.getResourceAsStream("/cassendra.properties"));
		} catch (IOException e) {
			System.out.println("Unable to load properties file");
			System.exit(1);
		}
		for (Object object : CASSENDRA_CONFIG.keySet()) {
			if(Boolean.valueOf(CASSENDRA_CONFIG.getProperty("system.log.enable"))){
				System.out.println(object.toString() +"========>"+CASSENDRA_CONFIG.getProperty(object.toString()));
			}
		}
	}
}
