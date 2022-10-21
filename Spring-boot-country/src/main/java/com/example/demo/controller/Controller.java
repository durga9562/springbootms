package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

	@Autowired
	private CountryService service;
	
	@GetMapping("/countries")
	public List<Country> list(){
		return service.listAll();
	}
}
