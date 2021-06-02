package com.example.models;

public enum Rating {
	 TVMA("TV-MA"),
	 R("R"),
	 PG13("PG-13"),
	TV14("TV-14"),
	TVY7("TV-Y&"),
	TVPG("TV-PG"),
	NR("NR")
	;
	
	private Rating(String name) {
		this.name = name;
	}
	public String getRating() {
		return name;
	}
	private String name;
}
