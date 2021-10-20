package com.bao.baoltd.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A DTO class for basic product information
 * 
 * @author ben-maliktchamalam
 *
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private String image;
	
	private int rate;
	
	private String name;
	
	private double price;
	
	private boolean isNew;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
}
