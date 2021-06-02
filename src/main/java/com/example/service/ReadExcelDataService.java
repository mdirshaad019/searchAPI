package com.example.service;

import java.text.ParseException;
import java.util.List;

import com.example.models.Netflix;

public interface ReadExcelDataService {
	
	List<Netflix> getExcelDataAsList() throws ParseException;

	int saveExcelData(List<Netflix> netflix);
}
