package com.bao.baoltd.model;

import javax.persistence.Column;
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

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {

	public Category(String val, Product product) {
		this.name = val;
		this.product = product;
	}
		
	public Category(String name) {
		this.name = name;
	}
	
	
	public Category() {}
	public Category(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.product = category.getProduct();
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name = "name")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Product getProduct() {
		return product;
	}
	
}
