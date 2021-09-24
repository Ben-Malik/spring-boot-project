package com.bao.baoltd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.service.BrandManager;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandManager brandManager;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddNewCategoryForm(Model model) {
		model.addAttribute("brand", new Brand());

		return "brandForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveNewCategory(@Validated @ModelAttribute("brand") Brand brand, HttpServletRequest request) {
		
		brandManager.create(brand);
		return "redirect:brandList";
	}

	 @RequestMapping("/brandList")
		public String articleList(Model model) {
			List<Brand> brands = brandManager.getAllBrands();
			model.addAttribute("brands", brands);
			return "brandList";
		}
}
