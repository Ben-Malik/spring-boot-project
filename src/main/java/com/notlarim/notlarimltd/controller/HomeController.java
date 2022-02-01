package com.notlarim.notlarimltd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        String message = "Your app is well set! Happy coding.";
        String github = "https://github.com/ben-malik";

        model.addAttribute("message", message);
        model.addAttribute("github", github);

        return "index";
    }
}
