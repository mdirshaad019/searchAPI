package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
	List<Country> findByName(String name);
}
