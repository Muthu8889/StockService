package com.swl.stockwatchlist.domain;

import java.io.Serializable;

public class Stock implements Serializable{
	private String id;
	private String description;
	private String date;
	private String value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Stock(String id, String description, String date, String value) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.value = value;
	}	
}
