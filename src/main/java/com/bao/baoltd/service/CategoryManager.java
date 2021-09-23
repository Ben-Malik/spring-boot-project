package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import com.bao.baoltd.model.Category;

public interface CategoryManager {
	
	List<Category> getAllCategories();

    Optional<Category> getById(Long id);
    
    Category create(Category brand);

    void deleteById(Long id);

}
