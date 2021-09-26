package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import com.bao.baoltd.model.Brand;

/**
 * An interface for operational of the brand entity.
 * 
 * @author ben-maliktchamalam
 *
 */
public interface BrandManager {
	
	/**
	 * Grabs all available brands from the database.
	 * 
	 * @return a list of brands.
	 */
	List<Brand> getAllBrands();

	/**
	 * Finds an object with the given id if any exists.
	 * @param id The id of the brand looked for.
	 * @return a brand if found.
	 */
    Optional<Brand> getById(Long id);
    
    /**
     * Creates a brand.
     * @param brand the brand to be created.
     * @return the newly created brand.
     */
    Brand create(Brand brand);

    /**
     * Deletes the brand with given id.
     * @param id The id of the brand to be deleted.
     */
    void deleteById(Long id);
    
}
