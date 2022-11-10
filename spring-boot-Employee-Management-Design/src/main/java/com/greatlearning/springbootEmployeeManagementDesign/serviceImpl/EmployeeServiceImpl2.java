package com.greatlearning.springbootEmployeeManagementDesign.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import com.greatlearning.springbootEmployeeManagementDesign.Exception.ResourceNotFoundException;
import com.greatlearning.springbootEmployeeManagementDesign.entity.Employee;
import com.greatlearning.springbootEmployeeManagementDesign.repository.EmployeeRepository;
import com.greatlearning.springbootEmployeeManagementDesign.service.EmployeeService;

@Service
public class EmployeeServiceImpl2 implements EmployeeService {

	public EmployeeRepository employeeRepository;

	public EmployeeServiceImpl2(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	

	public Employee getEmployeeById(Integer id) {
		/*
		 * Optional<Employee> employee=employeeRepository.findById(id);
		 * if(employee.isPresent()) {
		 * 
		 * return employee.get(); } else { throw new
		 * ResourceNotFoundException("Employee",Id,id); }
		 */
		return employeeRepository.findById(id).get();
	}

	

	@Override
	public Employee updateEmployee(Employee employee, Integer Id) {

		Employee employeeDB = employeeRepository.findById(Id).get();
		if (Objects.nonNull(employee.getfirstName()) && !"".equalsIgnoreCase(employee.getlastName())) {
			employeeDB.setfirstName(employee.getfirstName());
			employeeDB.setlastName(employee.getlastName());
			employeeDB.setemail(employee.getemail());
		}
		return employeeRepository.save(employeeDB);
	}

	
	// Delete operation by ID
	@Override
	public void deleteEmployee(Integer Id) {
		employeeRepository.deleteById(Id);

	}
	

	@Override
	public List<Employee> fetchEmployeeListByFirstName(String FirstName) {
		return employeeRepository.getEmployeeByFirstName(FirstName);
	}

	@Override
	public List<Employee> fetchEmployeeListSorted(String order) {
		if (order.equals("asc")) {

			return (List<Employee>) employeeRepository.findAll(Sort.by("firstName").ascending());

		}
		if (order.equals("desc")) {

			return (List<Employee>) employeeRepository.findAll(Sort.by("firstName").descending());
		}
		return null;
	}

}
