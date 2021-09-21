package com.bao.baoltd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bao.baoltd.model.Product;
import com.bao.baoltd.service.ProductManager;

@Controller
public class HomeController {

	
	@Autowired
	private ProductManager productManager;
	
	
	@RequestMapping("/")
	public String index(Model model) {		
		List<Product> products = productManager.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}
	
}
