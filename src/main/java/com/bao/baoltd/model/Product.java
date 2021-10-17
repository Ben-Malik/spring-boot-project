package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.bao.baoltd.enums.State;

@NamedEntityGraph(
		name= "ProductComplete",
		attributeNodes= {  @NamedAttributeNode(value="categories") }
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
    
    @Column(name = "state", nullable = true)
    private State state;
    
	@LazyCollection(LazyCollectionOption.FALSE)
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_category",
    joinColumns = { @JoinColumn(name = "product_id") },
    inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private Set<Category> categories  = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
	@EqualsAndHashCode.Exclude
	private Brand brand;
	 
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

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

	public void setCategories(Set<Category> catElements) {
		this.categories = catElements;
		
	}

	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", price=" + price + ", description="
				+ description + ", count=" + count + ", boxCode=" + boxCode + ", picture=" + picture + "]";
	}
	
}
