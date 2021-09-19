package com.bao.baoltd.controller;

import com.bao.baoltd.model.Product;
import com.bao.baoltd.service.ProductManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Optional;

@Controller
public class ProductController {


	@Autowired
	ProductManager productManager;
	
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
    	model.addAttribute("products", productManager.getAllProducts());
        return "product";
    }
    
    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("productsCount", productManager.getAllProducts().size());
        model.addAttribute("zeroStockProducts", productManager.getAllProducts().size());
        return "index";
    }
    
    
    @RequestMapping(value = "/addProduct", method = { RequestMethod.GET})
    public String addUser(@ModelAttribute Product product, BindingResult result, Model model) {
        model.addAttribute("product", new Product());
        
        return "productForm";
    }
    
    
    @RequestMapping(value = "/product/add", method = { RequestMethod.POST })
    public String addProduct(@Validated Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "productForm";
        }
        
        productManager.create(product);
        return "redirect:/products";
    }
    
    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
    public String displayProduct(@PathVariable("id") Long id, Model model) {
    	
    	Optional<Product> product = productManager.getById(id);
    	if(product == null) {
    		return "notFound";
    	}
    	model.addAttribute("product", product.get());
    	return "productDetail";
    }
    
    
}
