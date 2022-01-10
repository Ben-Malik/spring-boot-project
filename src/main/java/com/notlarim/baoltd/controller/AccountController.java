package com.notlarim.notlarimltd.controller;

import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.LocalTime;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.notlarim.notlarimltd.model.Address;
import com.notlarim.notlarimltd.model.Exchange;
import com.notlarim.notlarimltd.model.User;
import com.notlarim.notlarimltd.service.ExchangeManager;
import com.notlarim.notlarimltd.service.UserManager;
import com.notlarim.notlarimltd.service.UserSecurityManager;

import utility.GreetingUtility;
import utility.SecurityUtility;

@Controller
public class AccountController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserSecurityManager userSecurityManager;
	
	@Autowired
	private ExchangeManager exchangeManager;

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
	
	@RequestMapping("/myAddress")
	public String myAddress(Model model, Principal principal) {
		User user = userManager.findByUsername(principal.getName());
		model.addAttribute("user", user);
		return "myAddress";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Authentication authentication) {				
		
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
		user = userManager.createUser(user.getUsername(), password,  user.getEmail(), Arrays.asList("ROLE_USER", "ROLE_ADMIN"));	
		userSecurityManager.authenticateUser(user.getUsername());
		return "redirect:/myProfile";  
	}
	
	@RequestMapping(value="/update-user-address", method=RequestMethod.POST)
	public String updateUserAddress(@ModelAttribute("address") Address address, 
			Model model, Principal principal) throws Exception {
		User currentUser = userManager.findByUsername(principal.getName());
		if(currentUser == null) {
			throw new Exception ("User not found");
		}
		currentUser.setAddress(address);
		userManager.save(currentUser);
		model.addAttribute("user", currentUser);
		model.addAttribute("addressUpdateSuccess", true);
		
		return "myAddress";
	}
	
	@RequestMapping(value="/update-user-info", method=RequestMethod.POST)
	public String updateUserInfo( @ModelAttribute("user") User user,
								  @RequestParam("newPassword") @Nullable String newPassword,
								  Model model, Principal principal) throws Exception {
		User currentUser = userManager.findByUsername(principal.getName());
		if(currentUser == null) {
			throw new Exception ("User not found");
		}
		/*check username already exists*/
		User existingUser = userManager.findByUsername(user.getUsername());
		if (existingUser != null && !existingUser.getId().equals(currentUser.getId()))  {
			model.addAttribute("usernameExists", true);
			return "myProfile";
		}
		
		/*check email already exists*/
		existingUser = userManager.findByEmail(user.getEmail());
		if (existingUser != null && !existingUser.getId().equals(currentUser.getId()))  {
			model.addAttribute("emailExists", true);
			return "myProfile";
		}			
		/*update password*/
		if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")){
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			if(passwordEncoder.matches(user.getPassword(), dbPassword)){
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			} else {
				model.addAttribute("incorrectPassword", true);
				return "myProfile";
			}
		}		
		currentUser.setFirstname(user.getFirstname());
		currentUser.setSurname(user.getSurname());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());		
		userManager.save(currentUser);
		model.addAttribute("updateSuccess", true);
		model.addAttribute("user", currentUser);				
		userSecurityManager.authenticateUser(currentUser.getUsername());		
		
		return "myProfile";
	}
	
	@PreAuthorize("ROLE_ADMIN")
	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public String addAdminForm(Model model) {
		
		return "admin/add";
	}
	
	@PreAuthorize("ROLE_ADMIN")
	@RequestMapping(value="/admin/add", method=RequestMethod.POST)
	public String newAdmin(@Valid @ModelAttribute("user") User user, BindingResult bindingResults,
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
		user = userManager.createUser(user.getUsername(), password,  user.getEmail(), Arrays.asList("ROLE_USER", "ROLE_ADMIN"));	
		userSecurityManager.authenticateUser(user.getUsername());
		return "redirect:/myProfile";  
	}
}
