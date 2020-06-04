package com.example.converter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.converter.entities.Convertion;
import com.example.converter.entities.Currency;
import com.example.converter.repository.ConvertionRepository;
import com.example.converter.repository.CurrencyRepository;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyRepository currencyRepo;
	
	@Autowired
	ConvertionRepository converRepo;
	
	@GetMapping
	public List<Currency> init() {
		return currencyRepo.findAll();
	}
	
	@PostMapping("/convert")
	public Convertion convert(@RequestBody Convertion convert) {
		
		Currency currency=currencyRepo.findByBaseAndCurrency(convert.getCurrencyOrigin(), convert.getCurrencyDestination());
		if(currency!=null) {
			System.out.println("Origen:"+convert.getCurrencyOrigin());
			System.out.println("Monto"+convert.getAmount());
			System.out.println("Destino:"+convert.getCurrencyDestination());
			
			System.out.println("Tipo de Cambio:"+currency.getValue());
			convert.setCalculate(convert.getAmount()*currency.getValue());
			convert.setExchangeRate(currency.getValue());
			converRepo.save(convert);
		}else {
			System.out.println("Tipo de cambio no encontrado:"+convert.getCurrencyOrigin());
		}
		
		return convert;
	}
	
	@GetMapping("/convertions")
	public List<Convertion> convertions() {
		return converRepo.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Currency> update(@PathVariable(value = "id") Long currencyId,
	        @Validated @RequestBody Currency currency) {
		Optional<Currency> currExist = currencyRepo.findById(currencyId);
		
		if(currExist.isPresent()) {
			Currency currUpdate=currExist.get();
			currUpdate.setValue(currency.getValue());
			currUpdate.setCurrency(currency.getCurrency());
			currUpdate.setBase(currency.getBase());
			final Currency updatedCurrency = currencyRepo.save(currUpdate);
	        return ResponseEntity.ok(updatedCurrency);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(currency);
		}
	}
}
