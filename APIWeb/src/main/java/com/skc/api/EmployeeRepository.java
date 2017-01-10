package com.skc.api;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skc.mode.Employee;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
/**
 * Employee Repository Class
 * */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	List<Employee> findByName(@Param("name") String name);
}
