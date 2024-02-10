package com.curd.employeecontroller;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.employeemodel.Employee;
import com.curd.employeeservice.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("")
	public ResponseEntity<?> addEmployee(@RequestBody @Valid Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getEmployee()
	{
		 return employeeService.getEmployee();
	}
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmpbyId(@PathVariable int empId)
	{
		return employeeService.getEmpbyId(empId);
	}
	
	@PostMapping("/{empId}")
	public Employee putEmpIdupdate(@PathVariable @RequestBody int empId ,Employee employee)
	{
		return employeeService.putEmpIdupdate(empId, employee);
	}
	
	@DeleteMapping("/{empId}")
	public String deletebyId(@PathVariable int empId)
	{
		return employeeService.deletebyId(empId);
	}
	
	
	
	

}
