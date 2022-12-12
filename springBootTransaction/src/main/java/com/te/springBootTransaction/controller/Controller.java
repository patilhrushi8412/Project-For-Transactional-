package com.te.springBootTransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.springBootTransaction.dto.Employeedto;
import com.te.springBootTransaction.entity.Employee;
import com.te.springBootTransaction.responce.Responce;
import com.te.springBootTransaction.services.ServiceImpl;
import com.te.springBootTransaction.services.Services;

@RestController
public class Controller {

	@Autowired
	Services service;

	@Autowired
	ServiceImpl impl;

	@PostMapping("/addEmployee")
	public ResponseEntity<Responce> addEmployee(@RequestBody Employeedto dto) {
		Employee employee = service.addEmployee(dto);
		return new ResponseEntity<Responce>(new Responce(false, "Employee Added Succesfully", employee), HttpStatus.OK);
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<Responce> getEmployee(@RequestParam int id) {
		Employee employee = service.getEmployee(id);
		return new ResponseEntity<Responce>(new Responce(false, "Employee Details", employee), HttpStatus.OK);
	}

	@Scheduled(fixedRate = 3000)
	@GetMapping("/getall")
	public ResponseEntity<Responce> getAll() {
		List<Employee> getall = impl.getall();
		return new ResponseEntity<Responce>(new Responce(false, "getting all details", getall), HttpStatus.OK);
	}

}
