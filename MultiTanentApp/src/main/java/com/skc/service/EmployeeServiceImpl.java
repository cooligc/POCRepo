package com.skc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skc.dao.EmployeeDao;
import com.skc.domain.Employee;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("empDao")
	EmployeeDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> readAllEmployee() {
		return dao.readAllEmployee();
	}

}
