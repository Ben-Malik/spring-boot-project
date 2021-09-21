package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedEntityGraph(
		name= "ProductComplete",
		attributeNodes= { @NamedAttributeNode(value="brands"), @NamedAttributeNode(value="categories") }
	)
@Table(name = "product",  schema = "public")
@Data
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

	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<Brand> brands  = new HashSet<>();;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	private Set<Category> categories  = new HashSet<>();

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public String getPicture() {
		// TODO Auto-generated method stub
		return picture;
	};    


}
