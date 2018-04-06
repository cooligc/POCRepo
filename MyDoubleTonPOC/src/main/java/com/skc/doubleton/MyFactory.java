/**
 * 
 */
package com.skc.doubleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chaudhsi
 *
 */
@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class MyFactory implements ApplicationContextAware{

	
	private Map<Class,List<Object>> _myCache = new ConcurrentHashMap<>();
	
	private ApplicationContext context;
	
	public void createInstances(Class clazz, int number) {
		List<Object> lists = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			lists.add(context.getBean(clazz));
		}
		_myCache.put(clazz, lists);
	}
	
	
	public Object getInstance(Class clazz){
		List<Object> myObjects = _myCache.get(clazz);
		int index = Math.abs((new Random().nextInt() % myObjects.size())-1);
		if(index >= myObjects.size()) {
			index = Math.abs(index - myObjects.size());
		}
		System.out.println(index);
		return myObjects.get(index) ;
	}
	
	public void makeUnModifiable() {
		Collections.unmodifiableMap(_myCache);
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	
}
