package org.skc.jvm.load.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.skc.jvm.load.SimpleLoadApp;
import org.skc.jvm.load.util.SimpleLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jvmLoad")
public class SimpleJVMLoadController {

	private static final Logger LOGGER = Logger.getLogger(SimpleLoad.class);

	@Autowired
	SimpleLoad simpleLoad;
	
	@Autowired
	SimpleLoadApp loadApp;
	
	@RequestMapping("/start")
	public String startLoad(){
		LOGGER.info(simpleLoad);
		simpleLoad.startLoad();
		LOGGER.info("========>");
		return "Load started";
	}
	
	@RequestMapping("/startV2")
	public String startLoadV2(){
		try {
			loadApp.putLoad();
		}
		catch (IOException e) {
			LOGGER.error(e);
		}
		catch (InterruptedException e) {
			LOGGER.error(e);
		}
		return "Load2 started";
	}
	
	
	@RequestMapping(value="/test",method=RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Map<String,Object> testLoad(){
		LOGGER.info(simpleLoad);
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("message", "Its working ! You can start putting the load.");
		Map<String,String> osDetails = new HashMap<String, String>();
		osDetails.put("os", System.getProperty("os.name"));
		osDetails.put("osVersion", System.getProperty("os.version"));
		osDetails.put("userHome", System.getProperty("user.home"));
		osDetails.put("timeZone", System.getProperty("user.timezone"));
		osDetails.put("osArch", System.getProperty("os.arch"));
		maps.put("osDetails", osDetails);
		
		Map<String,String> jvmDetails = new HashMap<String, String>();
		jvmDetails.put("jvmVersions", System.getProperty("java.vm.version"));
		jvmDetails.put("jvmVendor", System.getProperty("java.vm.vendor"));
		jvmDetails.put("javaHome", System.getProperty("java.home"));
		jvmDetails.put("javaRuntime", System.getProperty("java.runtime.name"));
		jvmDetails.put("totalAvailableProcessors", Runtime.getRuntime().availableProcessors()+"");
		maps.put("jvmDetails", jvmDetails);
		
		Map<String,String> jvmMemory = new HashMap<String, String>();
		jvmMemory.put("totalAvailableMemory", Runtime.getRuntime().totalMemory()/(1024*1024)+"MB");
		jvmMemory.put("maxAvailableMemory", Runtime.getRuntime().maxMemory()/(1024*1024)+"MB");
		jvmMemory.put("freeMemory", Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
		
		maps.put("jvmMemory", jvmMemory);
		LOGGER.info("Requested Details "+maps);
		return maps;
	}
}
