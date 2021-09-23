package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bao.baoltd.model.Category;
import com.bao.baoltd.repository.CategoryRepository;

@Service
@Transactional
public class CategoryManagerImpl implements CategoryManager{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	@Override
	public Optional<Category> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Category create(Category category) {
		return repository.save(category);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
