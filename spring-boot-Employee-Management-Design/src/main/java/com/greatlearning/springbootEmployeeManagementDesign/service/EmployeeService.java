package com.greatlearning.springbootEmployeeManagementDesign.service;

import java.util.List;
import java.util.Set;

import com.greatlearning.springbootEmployeeManagementDesign.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee employee, Integer id);

	/*List<Employee> fetchEmployeeListByFirstName(String firstName);

	List<Employee> fetchEmployeeListSorted(String order);*/

	Employee getEmployeeById(Integer id);

	/*List<Employee> fetchEmployeeListByFirstName(String firstName);

	List<Employee> fetchEmployeeListSorted(String order);*/

	void deleteEmployee(Integer id);

	Employee saveEmployee(Employee employee);
	
	// Employee search by First Name
		List<Employee> fetchEmployeeListByFirstName(String FirstName);

		// Employee Record Sorting by First Name
		List<Employee> fetchEmployeeListSorted(String order);

	 
	

}
	
	
	

