package com.example.converter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.converter.entities.Currency;
import com.example.converter.repository.CurrencyRepository;

@SpringBootApplication
public class ConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CurrencyRepository repository) {
	    return (args) -> {
	    	repository.save(new Currency("PEN","USD",0.30));
	    	repository.save(new Currency("PEN","EUR",0.26));
	    	repository.save(new Currency("USD","PEN",0.30));
	    };
	}
}
