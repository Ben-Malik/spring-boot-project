package com.bao.baoltd.repository;

import com.bao.baoltd.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * An interface indicating all the operations doable on the Product object to
 * the database.
 *
 * @author ben-maliktchamalam
 */
@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	/**
	 * 
	 * @return
	 */
	@EntityGraph(attributePaths = { "categories" })
	List<Product> findAllEagerBy();

	/**
	 * 
	 */
	@EntityGraph(attributePaths = { "categories" })
	Optional<Product> findById(Long id);

	/**
	 * 
	 * @return
	 */
	@Query("select p from Product p where p.count = 0")
	List<Product> findProductWithZeroCount();

	
}
