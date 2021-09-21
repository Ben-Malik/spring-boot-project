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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
		model.addAttribute("product", product);
		model.addAttribute("allBrands", productManager.getAllBrands());
		model.addAttribute("allCategories", productManager.getAllCategories());
		return "addProduct";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addArticlePost(@ModelAttribute("product") Product product, HttpServletRequest request) {
		Product newProduct = new ArticleBuilder()
				.withTitle(product.getName())
				.stockAvailable(product.getCount())
				.withPrice(product.getPrice())
				.imageLink(product.getPicture())
				.sizesAvailable(Arrays.asList(request.getParameter("size").split("\\s*,\\s*")))
				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
				.ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
				.build();		
		productManager.create(newProduct);	
		return "redirect:article-list";
	}
    
    
}
