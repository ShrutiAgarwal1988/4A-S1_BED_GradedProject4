package com.greatlearning.springbootEmployeeManagementDesign.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.greatlearning.springbootEmployeeManagementDesign.service.UserService;
import com.greatlearning.springbootEmployeeManagementDesign.entity.Employee;
import com.greatlearning.springbootEmployeeManagementDesign.service.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    @Autowired
	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// Save or Create Operation
		@PostMapping("/employee")
		@ResponseBody
		public Employee roleAddSave(@Validated @RequestBody Employee employee) {
			return employeeService.saveEmployee(employee);

		}
		
		// Read Operations
		@GetMapping("/employee")
		@ResponseBody
		public List<Employee> getAllEmployees(){
			return employeeService.getAllEmployees();
			
	}

		// Update Operation
		@PutMapping("/employee/{Id}")
		@ResponseBody
		public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("Id") Integer Id) {
			return employeeService.updateEmployee(employee, Id);

		}

		// Search Employee by ID Operation
		@GetMapping("/employee/{Id}")
		@ResponseBody
		public Employee getEmployeeById(@PathVariable("Id") Integer Id) {

			return employeeService.getEmployeeById(Id);

		}

		// Delete Operation
		@DeleteMapping("/employee/{Id}")
		@ResponseBody

		public String deleteEmployeeById(@PathVariable("Id") Integer Id) {

			employeeService.deleteEmployee(Id);
			return "Deleted employee id - " + Id;

		}

		// Search By First Name Operations
		@GetMapping("/employee/search/{FirstName}")
		@ResponseBody
		public List<Employee> searchByFirstName(@PathVariable("FirstName") String FirstName) {

			return employeeService.fetchEmployeeListByFirstName(FirstName);

		}

		// Sort By First Name Operations
		@GetMapping("/employee/sort")
		@ResponseBody
		public List<Employee> sortByFirstName(@RequestParam String order) {

			return employeeService.fetchEmployeeListSorted(order);

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees(){
//		return employeeService.getAllEmployees();
//		
//}
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee> (employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
//build get employee by id REST API
//	@GetMapping("/v1{id}")
//	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") long employeeid){
//		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid),HttpStatus.OK);
//		
//}
//	@PutMapping("/v2{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
//			                                      ,@RequestBody Employee employee){
//	
//	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
//	
//	
//	}
	   //build delete rest api 
//	@DeleteMapping("/v3{id}")
//		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
//	
//		employeeService.deleteEmployee(id);
//		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
//		
//		}
//	
/*@GetMapping("/{id}/{firstName}")
private ResponseEntity<String> SortAllEmployees(@PathVariable String firstName){
	employeeService.SortAllEmployees(firstName);
	return new ResponseEntity<String>(HttpStatus.OK);*/
	
	/*// Search By First Name Operations
		@GetMapping("/employee/{firstName}")
		@ResponseBody
		public List<Employee> searchByFirstName(@PathVariable("firstName") String firstName) {

			return employeeService.fetchEmployeeListByFirstName(firstName);

		}

		// Sort By First Name Operations
		@GetMapping("/employee/sort")
		@ResponseBody
		public List<Employee> sortByFristName(@RequestParam String order) {

			return employeeService.fetchEmployeeListSorted(order);*/

	/*@RequestMapping("/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
		}*/
	
}