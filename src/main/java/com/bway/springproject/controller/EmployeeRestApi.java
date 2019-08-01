package com.bway.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.model.Employee;

@RestController
public class EmployeeRestApi {
	@Autowired
	private EmployeeDao edoa;

	@RequestMapping(value = "/api")
	public ResponseEntity<List<Employee>> getAll() {

		ResponseEntity<List<Employee>> elist = new ResponseEntity<List<Employee>>(edoa.getAll(), HttpStatus.OK);
		return elist;

	}
	
	// Json to To Object Mapping
	
	@RequestMapping(value = "/jsonToObject")
	public String jsonObject() {
		RestTemplate temp=new RestTemplate();
		Employee emp=temp.getForObject("http://localhost:8085/springproject/api/1", Employee.class);
		System.out.println("Name = "+emp.getFname());
		return "Success";
	}
	
	
	@RequestMapping(value = "/currency")
	public String RestApi() {
		RestTemplate temp=new RestTemplate();
		String emp=temp.getForObject("http://data.fixer.io/api/latest?access_key=e497218ddebd21f9af06a8691c0c9064", String.class);
		return emp;
	}
	
	
}
