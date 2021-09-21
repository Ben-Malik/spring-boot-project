package com.bao.baoltd.repository;

import com.bao.baoltd.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * An interface indicating all the operations doable on the Product object to the db.
 *
 * @author ben-maliktchamalam
 */
@Repository("ProductRepository")
public interface ProductRepository extends CrudRepository<Product, Long> {

}
