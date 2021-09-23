package com.bao.baoltd.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Brand(String val, Product product2) {
		this.name = val;
		this.product = product2;
	}
	

	public Brand(String name) {
		this.name = name;
	}
	
	public Brand() {
		
	}
	public Brand(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();
		this.product = brand.getProduct();
	}

	private Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

}
