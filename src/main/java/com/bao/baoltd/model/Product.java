package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedEntityGraph(
		name= "ProductComplete",
		attributeNodes= { @NamedAttributeNode(value="brands"), @NamedAttributeNode(value="categories") }
	)
@Table(name = "product",  schema = "public")
@Setter
@Getter
@Entity
@NoArgsConstructor
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
    
    public Product() {}
    

	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<Brand> brands  = new HashSet<>();;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<Category> categories  = new HashSet<>();

	public String getName() {
		return name;
	}
	
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

	public void setCategories(Set<Category> catElements) {
		this.categories = catElements;
		
	}

	public void setBrands(Set<Brand> brandlements) {
		this.brands = brandlements;
	}

	public Set<Brand> getBrands() {
		return brands;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
}
