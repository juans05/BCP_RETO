package com.example.converter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Convertion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String currencyOrigin;
	private String currencyDestination;
	private Double amount;
	private Double calculate;
	private Double exchangeRate;
	
	public Convertion() {
		
	}
	
	public Convertion(String currencyOrigin, String currencyDestination, Double amount) {
		super();
		this.currencyOrigin = currencyOrigin;
		this.currencyDestination = currencyDestination;
		this.amount = amount;
	}
	public String getCurrencyOrigin() {
		return currencyOrigin;
	}
	public void setCurrencyOrigin(String currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}
	public String getCurrencyDestination() {
		return currencyDestination;
	}
	public void setCurrencyDestination(String currencyDestination) {
		this.currencyDestination = currencyDestination;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCalculate() {
		return calculate;
	}
	public Double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public void setCalculate(Double calculate) {
		this.calculate = calculate;
	}
	

}
