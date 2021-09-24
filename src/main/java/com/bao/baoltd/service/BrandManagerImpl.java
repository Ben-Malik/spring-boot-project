package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.repository.BrandRepository;

@Service
@Transactional
public class BrandManagerImpl implements BrandManager{
	
	@Autowired
	private BrandRepository repository;

	@Override
	public List<Brand> getAllBrands() {
		return repository.findAll();
	}

	@Override
	public Optional<Brand> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Brand create(Brand brand) {
		return repository.save(brand);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
