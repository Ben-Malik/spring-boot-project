package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRODUCT")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Column(name="ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="CODE", nullable = false, length = 5)
    private String code;
    
    @Column(name = "PRICE", nullable = false)
    private Double price;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "COUNT")
    private int count;
    
    @Column(name = "BOX_CODE", length = 10)
    private String boxCode;
    


}
