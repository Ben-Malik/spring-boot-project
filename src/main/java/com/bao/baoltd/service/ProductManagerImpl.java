package com.bao.baoltd.service;


import com.bao.baoltd.model.Product;
import com.bao.baoltd.repository.ProductRepository;
import com.bao.baoltd.repository.ProductSpecification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ProductManagerImpl implements ProductManager{

	@Value("${productmanager.featured-items-number}")
	private int featuredProductsNumber;
	
	@PersistenceContext
    EntityManager entityManager;
    
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
	@Transactional
	public Product create(Product product) {
		entityManager.clear();
		//perform modification on object
		 entityManager.merge(product);
		 entityManager.flush();
		 return product;
	}

	@Override
	public List<String> getAllBrands() {
		return null;
	}

	@Override
	public List<String> getAllCategories() {
		return null;
	}
	
	

	@Override
	public Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh,
			List<String> sizes, List<String> categories, List<String> brands, String search) {
		Page<Product> page = repository.findAll(ProductSpecification.filterBy(priceLow, priceHigh, sizes, categories, brands, search), pageable);
        return page;
	}

}
