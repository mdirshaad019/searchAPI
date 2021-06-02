package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NetflixData;
import com.example.models.Netflix;
import com.example.service.ReadExcelDataService;
import com.example.service.SearchService;

@RestController
public class SearchApi {
	
	@Autowired
	ReadExcelDataService readExcelDataService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping("/saveData")
    public String saveExcelData() {
		List<Netflix> excelDataAsList = null;
		try {
			excelDataAsList = readExcelDataService.getExcelDataAsList();
			int noOfRecords = readExcelDataService.saveExcelData(excelDataAsList);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	return "saved data to database";
    }
	
	@PostMapping("/search/{pageNo}")
	@ResponseBody
	public List<Object[]> getSearchData(@RequestBody NetflixData netflixData,@PathVariable String pageNo) {
		return searchService.getAll(netflixData, Integer.parseInt(pageNo));
	}
	
	
}
