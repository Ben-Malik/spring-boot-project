package com.bao.baoltd.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.Brand;

/***
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("BrandRepository")
public interface BrandRepository extends CrudRepository<Brand, Long>{
	
	Optional<Brand> findByName(String name);

}
