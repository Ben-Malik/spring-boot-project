package com.bao.baoltd.service;

import com.bao.baoltd.enums.ProductType;
import com.bao.baoltd.model.Category;
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

@Service
@Transactional
public class ProductManagerImpl implements ProductManager{

	@Value("${productmanager.featured-items-number}")
	private int featuredProductsNumber;
	
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
	@Transactional
	public Product create(Product product) {
		return repository.save(product);
	}

	@Override
	public List<String> getAllBrands() {
		return repository.findAllBrands();
	}

	@Override
	public List<String> getAllCategories() {
		return repository.findAllCategories();
	}

	@Override
	public Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh,
			List<String> sizes, List<String> categories, List<String> brands, String search) {
		Page<Product> page = repository.findAll(ProductSpecification.filterBy(priceLow, priceHigh, sizes, categories, brands, search), pageable);
        return page;
	}
}
