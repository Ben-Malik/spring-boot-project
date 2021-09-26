package com.bao.baoltd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="brand")
	Set<Product> products = new HashSet<>();
    
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Brand other = (Brand) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
