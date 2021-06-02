package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Director;


public interface DirectorRepo extends JpaRepository<Director, Long> {

}
