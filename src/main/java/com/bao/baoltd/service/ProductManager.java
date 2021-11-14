package com.bao.baoltd.service;

import com.bao.baoltd.dto.ProductDTO;
import com.bao.baoltd.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * An interface of the {@link Product} services.
 * 
 * @author ben-maliktchamalam
 *
 */
public interface ProductManager {

	/**
	 * Grabs all the products available in the database.
	 * 
	 * @return a list of {@link Product}
	 */
    List<Product> getAllProducts();

    /**
     * Finds a product with the given id if one exists and null otherwise.
     * @param id the id whose product is looked for.
     * @return a product if one found and null otherwise.
     */
    Optional<Product> getById(Long id);
    
    /**
     * Creates and save the given product to the database.
     * @param product The product to be saved.
     * @return The newly saved product.
     */
    Product create(Product product);

    /**
     * Finds and delete the product with the given id.
     * @param id The id of the product to be deleted.
     */
    void deleteById(Long id);

	/**
	 * Get the products with count zero.
	 * @return a list of products having count as 0.
	 */
	List<Product> getProductsWithZeroCount();
	
	/**
	 * Gets the number of products having count 0.
	 * @return a long value of the count
	 */
	int getProductCountWithZeroCount();
	
	/**
	 * Grabs products newly added.
	 * @return a list of products newly added to the database.
	 */
	List<Product> getNewArrivals();
	
	/**
	 * Finds all products newly added and returns them as dto objects.
	 * @return a list of {@link ProductDTO}
	 */
	
	/**
	 * 
	 * @return
	 */
	List<Product> importProducts();
	
	List<ProductDTO> getNewArivalDTOs();
	/**
	 * 
	 * @param pageable
	 * @param priceLow
	 * @param priceHigh
	 * @param sizes
	 * @param categories
	 * @param brands
	 * @param search
	 * @return
	 */
	Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, List<String> sizes,
			List<String> categories, List<String> brands, String search);

}
