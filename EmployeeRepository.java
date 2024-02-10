package com.curd.employeeRepositories;

import org.springframework.data.repository.CrudRepository;

import com.curd.employeemodel.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
