package com.bao.baoltd.repository;

import com.bao.baoltd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * An interface indicating all the operations doable on the Product object to the db.
 *
 * @author ben-maliktchamalam
 */
@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
