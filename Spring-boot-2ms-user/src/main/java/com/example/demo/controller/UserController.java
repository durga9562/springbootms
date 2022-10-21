package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.users;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<users> list(){
		return service.listAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<users> get(@PathVariable Integer id){
		try {
			users user=service.get(id);
			return new ResponseEntity<users>(user,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<users>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users")
	public String add(@RequestBody users user) {
	String msg=	service.saveuser(user);
	return msg; 
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody users user,@PathVariable Integer id){
		try {
			users existusers = service.get(id);
			service.saveuser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
