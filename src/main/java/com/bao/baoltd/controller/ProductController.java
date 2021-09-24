package com.bao.baoltd.controller;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.model.Product;
import com.bao.baoltd.model.ProductBuilder;
import com.bao.baoltd.service.BrandManager;
import com.bao.baoltd.service.CategoryManager;
import com.bao.baoltd.service.ProductManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {


	@Autowired
	ProductManager productManager;
	
	@Autowired
	CategoryManager categoryManager;
	
	@Autowired
	BrandManager brandManager;
	
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
    	model.addAttribute("products", productManager.getAllProducts());
        return "product";
    }
    
    @RequestMapping("/productList")
	public String productList(Model model) {
		List<Product> products = productManager.getAllProducts();
		
		model.addAttribute("products", products);
		return "productList";
	}
	
    
    
    
    @RequestMapping(value = "/addProduct", method = { RequestMethod.GET})
    public String addUser(@ModelAttribute Product product, BindingResult result, Model model) {
        model.addAttribute("product", new Product());
        
        return "productForm";
    }
    
    
    @RequestMapping("/add")
	public String addArticle(Model model) {
		model.addAttribute("allBrands", brandManager.getAllBrands());

		Product product = new Product();
		product.setBrand(new Brand());
		product.setCategories(new HashSet<>());
		model.addAttribute("product", product);
		model.addAttribute("allBrands", brandManager.getAllBrands());
		model.addAttribute("allCategories", categoryManager.getAllCategories());
		return "product";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticlePost(@Validated @ModelAttribute("product") Product product, HttpServletRequest request) {
			
		productManager.create(product);	
		return "redirect:productList";
	}
    
    
}
