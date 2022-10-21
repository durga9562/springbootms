package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> list(){
		return service.listAll();
	}
	@PostMapping("/addProduct")
	 public String saveProduct(@RequestBody Product product) {
		 return service.save(product); 
	 }
}
