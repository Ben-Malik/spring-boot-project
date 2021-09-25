package com.bao.baoltd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {

	public Category(String val, Set<Product> product) {
		this.name = val;
		this.products = product;
	}
		
	public Category(String name) {
		this.name = name;
	}
	
	
	public Category() {}
	
	public Category(Category category) {
		this.name = category.getName();
		this.products = category.getProducts();
		
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
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@EqualsAndHashCode.Exclude
	@ManyToMany(
     cascade = {
     CascadeType.MERGE
     },
     mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
	@Column(name = "name")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
}
