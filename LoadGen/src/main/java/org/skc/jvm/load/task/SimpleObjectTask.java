package org.skc.jvm.load.task;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.skc.jvm.load.util.SimpleLoad;

public class SimpleObjectTask implements Runnable{
	
	private static final Logger LOGGER  = Logger.getLogger(SimpleObjectTask.class);
	
	public static final Map<AtomicLong, Object> _MAP = new HashMap<AtomicLong, Object>();
	public static final Map<AtomicLong, Object> _temp = new HashMap<AtomicLong, Object>();
	

	public void run() {
		try{
			_MAP.put(new AtomicLong(_MAP.size()+1), new SimpleLoad());
			LOGGER.info("Object loaded "+_MAP);
		}catch(ConcurrentModificationException e){
			synchronized (this) {
				_temp.put(new AtomicLong(_MAP.size()+1), new SimpleLoad());
				LOGGER.info("Object loaded "+_MAP);
			}
		}
		

	}

}
