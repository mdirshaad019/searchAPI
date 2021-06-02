package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Cast;


public interface CastRepo extends JpaRepository<Cast, Long> {

}
