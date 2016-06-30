package com.skc.poc.pojo;

import io.swagger.annotations.ApiModelProperty;

public class Departnment {
	@ApiModelProperty(notes = "Departnemnt Name", required = true)
	private String deptName;
	@ApiModelProperty(notes = "Departnemnt Code", required = true)
	private String deptCode;
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptCode() {
		return deptCode;
	}
	
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	
}
