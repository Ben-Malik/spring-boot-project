package com.notlarim.notlarimltd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller having the endpoints accessible by all clients and users.
 * @author ben-maliktchamalam
 *
 */
@Controller
public class HomeController {

	
	
	
	@RequestMapping("/")
	public String index(Model model) {		
		return "index";
	}
	
}
