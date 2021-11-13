package com.bao.baoltd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bao.baoltd.dto.ProductDTO;
import com.bao.baoltd.model.Product;
import com.bao.baoltd.service.ProductManager;

/**
 * The controller having the endpoints accessible by all clients and users.
 * @author ben-maliktchamalam
 *
 */
@Controller
public class HomeController {

	
	@Autowired
	private ProductManager productManager;
	
	
	@RequestMapping("/")
	public String index(Model model) {		
		
		List<ProductDTO> productDTOs = productManager.getNewArivalDTOs();
		
		
		model.addAttribute("productDTOs", productDTOs);
		return "index";
	}
	
}
