package com.bao.baoltd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.model.Product;

/***
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("BrandRepository")
public interface BrandRepository extends JpaRepository<Brand, Long>, JpaSpecificationExecutor<Product>{
	
	Optional<Brand> findByName(String name);

}
