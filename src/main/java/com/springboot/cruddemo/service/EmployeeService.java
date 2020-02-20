package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theID);
	
	public void save(Employee theEmployee);
	
	public void deletById(int theId);
	
}
