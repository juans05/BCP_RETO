package com.example.converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.converter.entities.Convertion;

@Repository
public interface ConvertionRepository extends JpaRepository<Convertion, Long>{

}
