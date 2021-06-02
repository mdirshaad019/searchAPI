package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {
	@Id
	@GeneratedValue
	private Long directorId;
	private String name;
	@ManyToMany
	private List<Netflix> netflix = new ArrayList<>();;
	public Long getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Netflix> getNetflix() {
		return netflix;
	}
	public void setNetflix(List<Netflix> netflix) {
		this.netflix = netflix;
	}
}
