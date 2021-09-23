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
	private List<String> brands;

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
	
	public ProductBuilder ofBrand(List<String> brands) {
		this.brands = brands;
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
			List<Category> catElements = new ArrayList<>();
			for (String val : this.categories) {
				catElements.add(new Category(val,product));
			}
			product.setCategories(catElements);
		}		
		if (this.brands != null && !this.brands.isEmpty() ) {
			List<Brand> brandlements = new ArrayList<>();
			for (String val : this.brands) {
				brandlements.add(new Brand(val,product));
			}
			product.setBrands(brandlements);
		}		
		
		
		return product;
	}

	
	
}
