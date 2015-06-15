package com.skc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("empService")
	EmployeeService employeeService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String readAllEmployee(HttpServletRequest httpServletRequest){
		httpServletRequest.setAttribute("data", employeeService.readAllEmployee());
		return "index";
	}
}
