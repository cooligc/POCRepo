/**
 * 
 */
package com.skc.api.storage;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Named;

import com.skc.api.resource.Employee;

/**
 * @author sitakant
 *
 */
@Any
@Named("myStorage")
@ApplicationScoped
public class MyStorage implements DataStorage {

	private static List<Employee> _employees;
	
	static {
		_employees = new ArrayList<Employee>();
	}
	
	/* (non-Javadoc)
	 * @see com.skc.api.storage.DataStorage#getAllEmployee()
	 */
	@Override
	public List<Employee> getAllEmployee() {
		return _employees;
	}

	/* (non-Javadoc)
	 * @see com.skc.api.storage.DataStorage#save(com.skc.api.resource.Employee)
	 */
	@Override
	public Employee save(Employee employee) {
		_employees.add(employee);
		return employee;
	}

}