package com.curd.employeeservice;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.curd.employeeRepositories.EmployeeRepository;
import com.curd.employeemodel.Employee;
import com.curd.responewrappers.EmployeeResponseWappers;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public ResponseEntity<?> addEmployee(Employee employee)
	{
		Employee add_employee = employeeRepository.save(employee);
		if(add_employee==null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee Details Not Added");
		}
		else
		{
			EmployeeResponseWappers erw = new EmployeeResponseWappers();
			erw.setData(add_employee);
			erw.setMessage("Employee Added");
			return new ResponseEntity <>(erw ,  HttpStatus.OK);
		}
				
		
	}
	
	public ResponseEntity<?> getEmployee()
	{
		Iterable<Employee> data = employeeRepository.findAll();
		Iterator<Employee> allEmpData = data.iterator();
		
		if(allEmpData.hasNext())
		{
			EmployeeResponseWappers erw = new EmployeeResponseWappers();
			erw.setData(allEmpData);
			erw.setMessage("Employee Found");
			return new ResponseEntity <>(erw ,  HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such Empolyee Details Found . Add To Get");
		}
		
		
		
		
	}
	
	public Optional<Employee> getEmpbyId(int empId)
	{
		return employeeRepository.findById(empId);
	}
	
	public Employee putEmpIdupdate(int empId ,Employee employee)
	{
		employee.setEmpId(empId);
		return employeeRepository.save(employee);
	}
	
	public String deletebyId(int empId)
	{
		employeeRepository.deleteById(empId);
		return "Employee Details Deleted SuccessFully";
	}
	


}
