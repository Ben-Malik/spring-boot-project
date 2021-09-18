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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {


	@Autowired
	ProductManager productManager;
	
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
    	model.addAttribute("products", productManager.getAllProducts());
        return "product";
    }
    
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", productManager.getAllProducts());
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
        return "redirect:/index";
    }
    
    
}
