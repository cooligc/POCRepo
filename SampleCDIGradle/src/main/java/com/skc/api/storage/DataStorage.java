/**
 * 
 */
package com.skc.api.storage;

import java.util.List;

import com.skc.api.resource.Employee;

/**
 * @author sitakant
 *
 */
public interface DataStorage {
	
	/**
	 * <p> Method to retrieve all the employee </p>
	 * */
	List<Employee> getAllEmployee();
	
	/**
	 * <p> Save the employee </p>
	 * */
	Employee save(Employee employee);
}
