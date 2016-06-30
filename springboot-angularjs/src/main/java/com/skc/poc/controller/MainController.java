package com.skc.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
    
    @RequestMapping(value="/roles",produces="application/json")
    public @ResponseBody List<String> getRoles(){
    	List<String> strings = new ArrayList<String>();
    	strings.add("ROLE_ADMIN");
    	strings.add("ROLE_SUPER_ADMIN");
    	strings.add("ROLE_USER");
    	strings.add("ROLE_SEMI_USER");
		return strings;
    }
}
