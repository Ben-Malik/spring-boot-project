package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import com.bao.baoltd.model.Brand;

public interface BrandManager {
	
	 List<Brand> getAllBrands();

	    Optional<Brand> getById(Long id);
	    
	    Brand create(Brand brand);

	    void deleteById(Long id);


}
