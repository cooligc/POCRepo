package com.skc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.skc.domain.Employee;

@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Employee> readAllEmployee() {
		TypedQuery<Employee> query = entityManager.createNamedQuery("from com.skc.domain.Employee", Employee.class); 
		return query.getResultList();
	}

}
