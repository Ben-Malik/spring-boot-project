package com.bao.baoltd.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Exchange {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "amount")
	private BigDecimal amount;

}
