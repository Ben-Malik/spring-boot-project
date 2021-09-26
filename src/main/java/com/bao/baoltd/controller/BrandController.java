package com.bao.baoltd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bao.baoltd.model.Brand;
import com.bao.baoltd.model.Category;
import com.bao.baoltd.service.BrandManager;

@Controller
@RequestMapping("/brand")
public class BrandController {


	@Autowired
	private BrandManager brandManager;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddNewCategoryForm(Model model) {
		model.addAttribute("category", new Category());

		return "categoryForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveNewBrand(@Validated @ModelAttribute("brand") Brand brand, HttpServletRequest request) {
		
		brandManager.create(brand);
		return "redirect:brandList";
	}

	 @RequestMapping("/categoryList")
		public String brandList(Model model) {
			List<Brand> brands = brandManager.getAllBrands();
			model.addAttribute("brands", brands);
			return "brandList";
	}
	 
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String showEditBrand( @PathVariable("id") Long id, Model model) {
			
			Brand brand = brandManager.getById(id).get();
			model.addAttribute("brand", brand);
			return "brandForm";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteProduct(@PathVariable("id") Long id, Model model) {
			brandManager.deleteById(id);
			
			return "redirect:/brand/brandList";
		}
	
	
}
