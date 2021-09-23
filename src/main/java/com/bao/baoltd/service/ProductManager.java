package com.bao.baoltd.service;

import com.bao.baoltd.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductManager {

    List<Product> getAllProducts();

    Optional<Product> getById(Long id);
    
    Product create(Product product);

    void deleteById(Long id);

	List<String> getAllBrands();
	
	List<String> getAllCategories();

	Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, List<String> sizes,
			List<String> categories, List<String> brands, String search);

}
