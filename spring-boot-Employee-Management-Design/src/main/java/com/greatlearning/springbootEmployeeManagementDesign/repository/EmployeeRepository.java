package com.greatlearning.springbootEmployeeManagementDesign.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.springbootEmployeeManagementDesign.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaRepository<Employee, Integer>{
	
	
	/*List<Employee> fetchEmployeeListSorted(String order);

	List<Employee> fetchEmployeeListByFirstName(String firstName);

	List<Employee> getEmployeeListByFirstName(String firstName);8*/
	@Query("SELECT u FROM Employee u WHERE u.firstName = ?1")
	public List<Employee> getEmployeeByFirstName(String firstName);

	

}
