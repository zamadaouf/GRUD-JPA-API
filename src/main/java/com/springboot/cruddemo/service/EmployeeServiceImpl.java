package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	// our constructor injection injection
	/*
	 * spring doesn't know which DAO impl to use (by EmployeeDAO in arguments)
	 * he found 2 : employeeDAOHibernateImpl & employeeDAOJPAImpl
	 * to solve that we use @Qualifier and give it the bean we wanna use
	 */
	@Autowired
	public EmployeeServiceImpl(@Qualifier("EmployeeDAOJpaImpl")EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deletById(int theId) {
		employeeDAO.deletById(theId);
	}
	
	
	
}
