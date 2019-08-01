package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.model.Employee;

@RestController
public class RestEmployeeGetById {
	
	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping(value = "/api/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable("id") int id){
		ResponseEntity<Employee> emp=new ResponseEntity<Employee>(edao.getById(id),HttpStatus.OK);
		return emp;
	}
}
