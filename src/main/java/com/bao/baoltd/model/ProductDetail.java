package com.bao.baoltd.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Table(name = "product_detail")
//@Entity
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class ProductDetail {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int rate;

	Set<Review> reviews = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		if (rate > 5 || rate < 0) {
			throw new IllegalArgumentException("Rate cannot be larger than 5 or less than 0");
		}
		this.rate = rate;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetail other = (ProductDetail) obj;
		return Objects.equals(id, other.id) && rate == other.rate;
	}
	

}
