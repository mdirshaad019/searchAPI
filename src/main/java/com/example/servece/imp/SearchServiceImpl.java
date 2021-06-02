package com.example.servece.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.NetflixData;
import com.example.models.Netflix;
import com.example.repo.NetflixRepo;
import com.example.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private NetflixRepo neflixrepo;

	@Override
	public List<Object[]> getAll(NetflixData netflixData, int pageNo) {
		
		List<Object[]> searchResult = neflixrepo.getAll(netflixData, pageNo);
		
		return searchResult;
	}
	
}
