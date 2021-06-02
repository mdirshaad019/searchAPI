package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Netflix;

public interface NetflixRepo extends JpaRepository<Netflix, String> , NetflixCustomRepo {
	
}
