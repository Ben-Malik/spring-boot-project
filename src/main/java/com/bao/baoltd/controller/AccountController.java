package com.bao.baoltd.controller;

import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bao.baoltd.model.User;
import com.bao.baoltd.service.UserManager;
import com.bao.baoltd.service.UserSecurityManager;
import com.fasterxml.jackson.databind.util.JSONPObject;

import utility.GreetingUtility;

@Controller
public class AccountController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserSecurityManager userSecurityManager;


	@RequestMapping("/login")
	public String log(Model model) {
		model.addAttribute("usernameExists", model.asMap().get("usernameExists"));
		model.addAttribute("emailExists", model.asMap().get("emailExists"));
		return "myAccount";
	}
	
	@RequestMapping("/myProfile")
	public String myProfile(Model model, Authentication authentication) {				
		User user = (User) authentication.getPrincipal();
		model.addAttribute("user", user);
		return "myProfile";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Authentication authentication) {				
		User user = (User) authentication.getPrincipal();
		
		String urlEuro = "https://free.currconv.com/api/v7/convert?q=EUR_TRY&compact=ultra&apiKey=ac495209d6cdd9e87736";
		String urlDolar = "https://free.currconv.com/api/v7/convert?q=USD_TRY&compact=ultra&apiKey=ac495209d6cdd9e87736";

		RestTemplate template = new RestTemplate();
		ResponseEntity<String> jsonEURO = template.getForEntity(urlEuro, String.class);
		ResponseEntity<String> jsonDOLAR = template.getForEntity(urlDolar, String.class);

		String euro = jsonEURO.getBody().split(":")[1].split("}")[0];
		String dollar = jsonDOLAR.getBody().split(":")[1].split("}")[0];
		

		GreetingUtility greeting = new GreetingUtility(LocalTime.now());
		String message = greeting.get() + ", " + user.getUsername() + "!";
		model.addAttribute("user", user);
		model.addAttribute("dollar", dollar);
		model.addAttribute("euro", euro);
		model.addAttribute("welcomeMessage", message);
		return "admin";
	}
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String newUserPost(@Valid @ModelAttribute("user") User user, BindingResult bindingResults,
							  @ModelAttribute("new-password") String password, 
							  RedirectAttributes redirectAttributes, Model model) {
		model.addAttribute("email", user.getEmail());
		model.addAttribute("username", user.getUsername());	
		boolean invalidFields = false;
		if (bindingResults.hasErrors()) {
			return "redirect:/login";
		}		
		if (userManager.findByUsername(user.getUsername()) != null) {
			redirectAttributes.addFlashAttribute("usernameExists", true);
			invalidFields = true;
		}
		if (userManager.findByEmail(user.getEmail()) != null) {
			redirectAttributes.addFlashAttribute("emailExists", true);
			invalidFields = true;
		}	
		if (invalidFields) {
			return "redirect:/login";
		}		
		user = userManager.createUser(user.getUsername(), password,  user.getEmail(), Arrays.asList("ROLE_USER"));	
		userSecurityManager.authenticateUser(user.getUsername());
		return "redirect:/myProfile";  
	}
}
