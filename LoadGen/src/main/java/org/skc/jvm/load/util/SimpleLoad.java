package org.skc.jvm.load.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.skc.jvm.load.task.SimpleObjectTask;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoad {
	private static final Logger LOGGER = Logger.getLogger(SimpleLoad.class);
	public void startLoad(){
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(200);
        boolean isEnable=true;
        for (int i = 0; true; i++) 
        {
        	if(isEnable){
        		LOGGER.info("AAAAAAAA========>");
//	            SimpleTask task = new SimpleTask();
        		SimpleObjectTask task = new SimpleObjectTask();
	            executor.execute(task);
	            if(((Runtime.getRuntime().freeMemory()/(1024*1024)) > (0.95*(Runtime.getRuntime().maxMemory()/(1024*1024))))){
	            	LOGGER.info("Memory is going to be freeze");
	            	isEnable=false;
	            	executor.remove(task);
	            	executor.shutdownNow();
	            }
        	}/*else{
        		System.out.println("Memory is going to be full. Please try after sometime.");
        		if(((Runtime.getRuntime().totalMemory()/(1024*1024)) < (0.1*(Runtime.getRuntime().maxMemory()/(1024*1024))))){
	            	System.out.println("Process is restarting now");
	            	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            	isEnable=true;
	            }
        	}*/
        }
	}
	
}
