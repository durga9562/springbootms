package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	//get All Employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	//get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist with id:"+id));
		
		return ResponseEntity.ok(employee);
	}
	
	
	//update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
	
		Employee employee=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist with id:"+id));
	
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updateEmployee=empRepo.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
	
		Employee employee=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not Exist with id:"+id));
	
		empRepo.delete(employee);
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
