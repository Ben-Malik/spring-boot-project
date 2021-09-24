package com.bao.baoltd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Table(name = "brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
    @OneToMany(mappedBy="brand")
	Set<Product> products = new HashSet<>();
	
	public String getName() {
		return name;
	}

	public Brand(String name) {
		this.name = name;
	}
	
	public Brand() {
		
	}
	public Brand(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
