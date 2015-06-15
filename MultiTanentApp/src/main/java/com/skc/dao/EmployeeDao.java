package com.skc.dao;

import java.util.List;

import com.skc.domain.Employee;

public interface EmployeeDao {
	List<Employee> readAllEmployee();
}
