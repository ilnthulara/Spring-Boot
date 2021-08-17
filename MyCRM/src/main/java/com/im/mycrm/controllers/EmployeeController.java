package com.im.mycrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.im.mycrm.entities.Employee;
import com.im.mycrm.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
		
	}
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@DeleteMapping("/employee/{id}")
	public boolean deleteEmployee(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
		return true;
	}
}
