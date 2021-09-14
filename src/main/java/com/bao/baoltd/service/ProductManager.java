package com.bao.baoltd.service;

import com.bao.baoltd.enums.ProductType;
import com.bao.baoltd.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductManager {

    List<Product> getAllProducts();

    Optional<Product> getById(Long id);

    void deleteById(Long id);

    List<Product> getByType(ProductType type);

}
