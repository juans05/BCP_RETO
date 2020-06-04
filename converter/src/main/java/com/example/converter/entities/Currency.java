package com.example.converter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String base;
	private String currency;
	private Double value;
	
	public Currency() {
		
	}
	
	public Currency(String base,String currency, Double value) {
		super();
		this.base=base;
		this.currency = currency;
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
	
	
}
