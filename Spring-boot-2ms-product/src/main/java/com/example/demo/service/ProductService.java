package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> listAll(){
	return repo.findAll();
	}
	
	public String save(Product product) {
		Product pd=repo.save(product);
		 if(pd!=null) {
			 return "product add successfully";
		 }else {
			 return "sorry product not added";
		 }
	}
	
	public Product get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
