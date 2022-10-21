package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryRepository repo;
	
	public List<Country> listAll(){
		return repo.findAll();
	}
	
	public void save(Country country) {
		repo.save(country);
	}
	
	public Country get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
