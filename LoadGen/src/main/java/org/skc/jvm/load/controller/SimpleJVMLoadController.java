package org.skc.jvm.load.controller;

import org.skc.jvm.load.util.SimpleLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jvmLoad")
public class SimpleJVMLoadController {


	@Autowired
	SimpleLoad simpleLoad;
	
	@RequestMapping("/start")
	public String startLoad(){
		System.out.println(simpleLoad);
		simpleLoad.startLoad();
		System.out.println("========>");
		return "Load started";
	}
	
	
}
