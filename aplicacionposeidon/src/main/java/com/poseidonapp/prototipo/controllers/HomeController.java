package com.poseidonapp.prototipo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
    public String welcome() {
        return "home";
    }
	
	@GetMapping("/aboutus")
	public String about() {
		return "aboutus";
	}
	
}
