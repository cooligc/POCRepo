/**
 * 
 */
package com.skc.api.resource;

import java.io.Serializable;

/**
 * @author sitakant
 *
 */
public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String dept;
	private Integer empId;
	/**
	 * @param name
	 * @param dept
	 * @param empId
	 */
	public Employee(String name, String dept, Integer empId) {
		this.name = name;
		this.dept = dept;
		this.empId = empId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the empId
	 */
	public Integer getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
	
}
