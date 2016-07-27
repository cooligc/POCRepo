package org.skc.jvm.load.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.skc.jvm.load.cache.KCache;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loadCache")
public class SimpleKCacheController implements ApplicationContextAware{

	KCache<String, Object> kCache;
	
	ApplicationContext context;
	
	Map<String, String> _tempMap;

	@RequestMapping("/start")
	public @ResponseBody String putValues() {
//		kCache = KittyCacheManager.getKittyCache();
		
		String responseMessage="Unable to put the response message as no sufficient memory";

		if (checkMemory()) {
			for (int i = 0; i < 100000; i++) {
				_tempMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
			}
			responseMessage="Values are kept in the cache safely";
		}

		return responseMessage;
	}

	private boolean checkMemory() {
		if(((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) > (0.9* (Runtime.getRuntime().maxMemory())))){
			System.out.println("Full of memory");
//			kCache = (KCache<String, Object>) context.getBean("cacheEngine");
			_tempMap = new ConcurrentHashMap<String, String>();
			return false;
		}
		if(null == _tempMap){
//			kCache = (KCache<String, Object>) context.getBean("cacheEngine");
			_tempMap = new ConcurrentHashMap<String, String>();
		}
		return true;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

}
