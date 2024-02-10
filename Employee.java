package com.curd.employeemodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
public class Employee {
	
	@Id
	@Min(value =1 , message = "value should be more than 1")
	private int empId;
	
	@Column (nullable = false)
	private String name;
	
	@Column (nullable = false)
	private String city;
	
	@Column 
	private int age;
	
	@Column (unique = true , nullable = false)
	private String phoneNo;
	
	@Column
	private String designation;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	

}
