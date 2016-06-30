package com.skc.poc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.skc.poc.pojo.Departnment;
import com.skc.poc.pojo.Employee;

@Repository("employeeRepository")
public class EmployeeRepository {
	
	private static List<Employee> employees = null;
	
	static{
		employees = new ArrayList<Employee>();
		for (int i = 0; i < 5; i++) {
			Departnment departnment = new Departnment();
			departnment.setDeptCode(i+"");
			departnment.setDeptName(i+" Dept");
			Employee employee = new Employee();
			int id = new Random().nextInt();
			if(id<0){
				id=-1*id;
			}
			employee.setEmpId(id);
			employee.setAge(20*i);
			employee.setName("A"+i);
			employee.setDept(departnment);
			employees.add(employee);
		}
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}
	
	public Employee getEmployeeById(Integer empId){
		for (Employee employee : employees) {
			if(employee.getEmpId()==empId){
				return employee;
			}
		}
		return null;
	}
	
	public Employee createEmployee(Employee employee){
		employees.add(employee);
		return employee;
	}
	
	public String deleteEmployee(Integer empId){
		for (Employee employee : employees) {
			if(employee.getEmpId()==empId){
				employees.remove(employee);
			}
		}
		return "DELETED";
	}
}
