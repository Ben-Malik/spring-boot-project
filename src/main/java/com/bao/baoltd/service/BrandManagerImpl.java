package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.repository.BrandRepository;

/**
 * An implementation of the {@link BrandManager} interface.
 * 
 * @author ben-maliktchamalam
 *
 */
public class BrandManagerImpl implements BrandManager{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public Optional<Brand> getById(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public void deleteById(Long id) {
		brandRepository.deleteById(id);
	}

}
