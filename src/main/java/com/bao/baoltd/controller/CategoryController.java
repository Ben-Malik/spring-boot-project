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

import com.bao.baoltd.model.Category;
import com.bao.baoltd.service.CategoryManager;


@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryManager categoryManager;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddNewCategoryForm(Model model) {
		model.addAttribute("category", new Category());

		return "categoryForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveNewCategory(@Validated @ModelAttribute("category") Category category, HttpServletRequest request) {
		
		categoryManager.create(category);
		return "redirect:categoryList";
	}

	 @RequestMapping("/categoryList")
		public String articleList(Model model) {
			List<Category> categories = categoryManager.getAllCategories();
			model.addAttribute("categories", categories);
			return "categoryList";
		}
}
