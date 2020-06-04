package com.example.converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.converter.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{
	public Currency findByBaseAndCurrency(String base,String currency);
	public Currency findByCurrency(String currency);
}
