package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.model.Product;

public interface BrandManager {
	
	 List<Brand> getAllBrands();

	    Optional<Brand> getById(Long id);
	    
	    Product create(Brand brand);

	    void deleteById(Long id);


}
