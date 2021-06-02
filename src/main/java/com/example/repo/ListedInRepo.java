package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Listed_In;


public interface ListedInRepo extends JpaRepository<Listed_In, Long> {

}
