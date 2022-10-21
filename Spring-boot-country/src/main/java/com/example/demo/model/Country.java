package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer country_id;
	@Column(name="country_name")
	private String country_name;
	
	public Country() {
		
	}

	public Country(Integer country_id, String country_name) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
	}

	public Integer getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	
	
	
}
