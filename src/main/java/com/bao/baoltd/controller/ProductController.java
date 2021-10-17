package com.bao.baoltd.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		for (Product p: products) {
			if (p.getBrand() != null) {
				System.out.println("Product brand: " + p.getBrand().toString());
			}

		}
		model.addAttribute("products", products);
		return "productList";
	}  
    
    @RequestMapping(value = "/addProduct", method = { RequestMethod.GET})
    public String addUser(@ModelAttribute Product product, BindingResult result, Model model) {
        model.addAttribute("product", new Product());
        
        return "productForm";
    }
    
    
    @RequestMapping("/add")
	public String addProductGet(Model model) {

		Product product = new Product();
		product.setCategories(new HashSet<>());
		model.addAttribute("product", product);
		model.addAttribute("allCategories", categoryManager.getAllCategories());
		model.addAttribute("allBrands", brandManager.getAllBrands());
		return "product";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProductPost(@Validated @ModelAttribute("product") Product product, HttpServletRequest request) {

		if (product.getId() != null) {
			Product oldProduct = productManager.getById(product.getId()).get();
			System.out.println("old: " + oldProduct.toString());
			oldProduct = product;
			productManager.create(oldProduct);	
			return "redirect:productList";
		}
		System.out.println("new: " + product.toString());
	
		productManager.create(product);	
		return "redirect:productList";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditProduct( @PathVariable("id") Long id, Model model) {
		
		Product product = productManager.getById(id).get();
		List<Long> categoryIds = product.getCategories().stream().map(cat -> cat.getId()).collect(Collectors.toList());
		model.addAttribute("product", product);
		System.out.println(categoryIds);
		model.addAttribute("currentCat", categoryIds);
		model.addAttribute("allCategories", categoryManager.getAllCategories());
		model.addAttribute("allBrands", brandManager.getAllBrands());
		return "product";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		productManager.deleteById(id);
		
		return "redirect:/product/productList";
	}
    
}
