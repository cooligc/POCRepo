package com.skc.rest.hateos.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee extends ResourceSupport {
	
	@JsonProperty("empId")
	private Long emp_id;
	
	@JsonProperty("name")
	private String name;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		}
		else if (!emp_id.equals(other.emp_id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Employee(Long emp_id, String name) {
		super();
		this.emp_id = emp_id;
		this.name = name;
	}
	
	public Long getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
