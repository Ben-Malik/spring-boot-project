package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedEntityGraph(
		name= "ProductComplete",
		attributeNodes= { @NamedAttributeNode(value="brand"), @NamedAttributeNode(value="categories") }
	)
@Table(name = "product",  schema = "public")
@Setter
@Getter
@Entity
@AllArgsConstructor
public class Product {

	@Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code", nullable = false, length = 5)
    private String code;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "count")
    private int count;
    
    @Column(name = "BOX_CODE", length = 10)
    private String boxCode;
    
    @Column(name = "picture")
	private String picture;
    
	@OneToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "product_id")
	private List<Category> categories  = new ArrayList<>();

	public String getName() {
		return name;
	}
	
	public Product() {}
	
	public Long getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public Double getPrice() {
		return price;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPicture() {
		return picture;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public void setPrice(double price) {
		this.price = price;
		
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public void setCategories(List<Category> catElements) {
		this.categories = catElements;
		
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Brand getBrand() {
		return brand;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
}
