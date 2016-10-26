package com.skc.rest.hateos.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skc.rest.hateos.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping("/employees")
	public HttpEntity<List<Employee>> getEmployee() {

		List<Employee> employees = new ArrayList<>();

		Employee e = new Employee(new Long(25), "skc");
		Employee e2 = new Employee(new Long(65), "skc");

		// static imports
		e.add(linkTo(methodOn(EmployeeController.class).getEmployeeOnId(e.getEmp_id())).withSelfRel());
		e2.add(linkTo(methodOn(EmployeeController.class).getEmployeeOnId(e2.getEmp_id())).withSelfRel());

		employees.add(e);
		employees.add(e2);

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@RequestMapping("/employees/{id}")
	public HttpEntity<Employee> getEmployeeOnId(@PathVariable("id") Long id) {

		Employee e = new Employee(new Long(id), "skc");
		// static imports
		e.add(linkTo(methodOn(EmployeeController.class).getEmployeeOnId(id)).withSelfRel());
		e.add(linkTo(methodOn(EmployeeController.class).getEmployeeOnId(e.getEmp_id())).withRel("parent"));

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	

}
