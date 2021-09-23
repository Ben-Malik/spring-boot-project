package com.bao.baoltd.controller;

import com.bao.baoltd.model.Product;
import com.bao.baoltd.model.ProductBuilder;
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
	
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
    	model.addAttribute("products", productManager.getAllProducts());
        return "product";
    }
    
    @RequestMapping("/productList")
	public String articleList(Model model) {
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
		Product product = new Product();
		product.setBrands(new HashSet<>());
		product.setCategories(new HashSet<>());
		model.addAttribute("product", product);
		model.addAttribute("allBrands", productManager.getBrands());
		model.addAttribute("allCategories", productManager.getCategories());
		return "product";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticlePost(@ModelAttribute("product") Product product, HttpServletRequest request) {
		Product newProduct = new ProductBuilder()
				.withTitle(product.getName())
				.stockAvailable(product.getCount())
				.withPrice(product.getPrice())
				.withCode(product.getCode())
				.withBoxCode(product.getBoxCode())
				.withDescription(product.getDescription())
				.imageLink("")
				.ofCategories(null)
				.ofBrand(null)
				.build();		
		productManager.create(product);	
		return "redirect:productList";
	}
    
    
}
