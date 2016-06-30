package com.skc.poc.pojo;

import io.swagger.annotations.ApiModelProperty;

public class Employee {
	private Integer empId;
	@ApiModelProperty(notes = "Name of employee", required = true)
	private String name;
	private Integer age;
	@ApiModelProperty(notes = "Department of employee", required = true)
	private Departnment dept;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;	
	}
	
	public void setAge(Integer age) {
		this.age = age;	
	}
	
	public Departnment getDept() {
		return dept;
	}
	
	public void setDept(Departnment dept) {
		this.dept = dept;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
}
