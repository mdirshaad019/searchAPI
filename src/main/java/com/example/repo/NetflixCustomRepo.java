package com.example.repo;

import java.util.List;

import com.example.dto.NetflixData;
import com.example.models.Netflix;

public interface NetflixCustomRepo {
	
	List<Object[]> getAll(NetflixData netflixData,int pageNo);

}
