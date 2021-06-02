package com.example.service;

import java.util.List;

import com.example.dto.NetflixData;
import com.example.models.Netflix;

public interface SearchService {
	List<Object[]> getAll(NetflixData netflixData , int pageNo);
}
