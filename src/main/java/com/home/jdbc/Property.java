package com.home.jdbc;

/**
 * Property entity
 * 
 * @author spark
 *
 */
public class Property {
	String name;
	String data;
	String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
