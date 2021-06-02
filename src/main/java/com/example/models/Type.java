package com.example.models;

public enum Type {
	movie("Movie"),
	tvshow("TV Show");
	
	private Type(String name) {
		this.name=name;
	}
	
	public String getType() {
		return name;
	}
	
	private String name;
}
