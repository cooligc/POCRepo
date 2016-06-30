package com.skc.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skc.poc.pojo.Employee;
import com.skc.poc.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@ApiOperation(value = "employee", nickname = "Employee")
	/* @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })*/
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	@RequestMapping(method=RequestMethod.GET,produces={"application/json"})
	public List<Employee> getEmployees(){
		return employeeRepository.getEmployees();
	}
}
