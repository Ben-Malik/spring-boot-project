package com.bao.baoltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.Brand;

/**
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("BrandRepository")
public interface BrandRepository extends JpaRepository<Brand, Long>, JpaSpecificationExecutor<Brand>{

}
