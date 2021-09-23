package com.bao.baoltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.Category;

/**
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("CategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category>{

}
