package com.bao.baoltd.controller;

import com.bao.baoltd.model.Product;
import com.bao.baoltd.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductManager productManager;

    @RequestMapping(name = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProducts() {
        return productManager.getAllProducts();
    }

}
