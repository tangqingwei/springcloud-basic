package com.qige.eureka.consumer.domain;

import java.io.Serializable;

public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2148397513829377365L;
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
