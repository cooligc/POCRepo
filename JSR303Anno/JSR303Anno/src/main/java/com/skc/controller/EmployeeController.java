package com.skc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skc.command.Employee;
import com.skc.validator.JsonResponse;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getEmployeePage(Model model,@ModelAttribute("employee") Employee employee){
		return "employee";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	@ResponseBody public JsonResponse getEmployee(Model model,@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult){
		
		JsonResponse jsonResponse = new JsonResponse();
		if(bindingResult.hasErrors()){
			jsonResponse.setStatus("FAIL");
			jsonResponse.setMessages(bindingResult.getAllErrors());
			return jsonResponse;
		}
		jsonResponse.setStatus("SUCCESS");
		model.addAttribute("employee",employee);
		System.out.println(employee);
		return jsonResponse;
	}
}
