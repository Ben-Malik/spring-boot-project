package com.bao.baoltd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductBuilder {
	
	private String name;
	private int count;	
	private double price;
	private String picture;
	private String code;
	private String boxCode;
	private String description;
	private List<String> categories;

	public ProductBuilder() {
	}
	
	public ProductBuilder withTitle(String name) {
		this.name = name;
		return this;
	}
	
	public ProductBuilder stockAvailable(int stock) {
		this.count = stock;
		return this;
	}
	
	public ProductBuilder withPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ProductBuilder imageLink(String picture) {
		this.picture = picture;
		return this;
	}
	
	public ProductBuilder ofCategories(List<String> categories) {
		this.categories = categories;
		return this;
	}
	
	
	
	
	public ProductBuilder withCode(String code) {
		this.code = code;
		return this;
	}
	
	public ProductBuilder withBoxCode(String boxCode) {
		this.boxCode = boxCode;
		return this;
	}
	
	
	public ProductBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	public Product build() {
		Product product = new Product();
		product.setName(this.name);
		product.setPrice(this.price);
		product.setCount(this.count);
		product.setPicture(this.picture);		
	
		
		if (this.categories != null && !this.categories.isEmpty() ) {
			Set<Category> catElements = new HashSet<>();
			Set<Product> products = new HashSet<>();
			products.add(product);
			for (String val : this.categories) {
				catElements.add(new Category(val,products));
			}
			product.setCategories(catElements);
		}		
			
		
		
		return product;
	}

	
	
}
