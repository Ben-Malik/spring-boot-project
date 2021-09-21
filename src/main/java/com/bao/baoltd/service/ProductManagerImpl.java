package com.bao.baoltd.service;

import com.bao.baoltd.enums.ProductType;
import com.bao.baoltd.model.Product;
import com.bao.baoltd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManagerImpl implements ProductManager{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);
    }

    @Override
    public List<Product> getByType(ProductType type) {
        return null;
    }

	@Override
	public Product create(Product product) {
		return repository.save(product);
	}
}
