package com.hexaware.easypay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping({"/index"})
    public String homePage() {
        return "index"; 
    }
	
	@GetMapping({"/"})
    public String landingPage() {
        return "index"; 
    }
}
