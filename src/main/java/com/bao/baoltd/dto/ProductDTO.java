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

	private Long id;
			
	private String name;
	
	private double price;
		
	private String code;
	
	private String boxCode;
	
	private Long stock;
	
	public Long getId() {
		return id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

}
