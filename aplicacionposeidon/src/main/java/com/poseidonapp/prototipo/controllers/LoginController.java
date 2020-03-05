package com.poseidonapp.prototipo.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
     
	
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,@RequestParam(value="logout", required=false) String logout,
			Model model,Principal principal, RedirectAttributes flash) {
		
		
		if(principal !=null) {
			flash.addFlashAttribute("info", "Ya ha iniciado sesion");
		
			return"redirect:/";	
		}
		if(error != null) {
			model.addAttribute("error", "Error en el login: Usuario o Contrasena incorrecto");
		}
			
		if(logout !=null) {
			model.addAttribute("success", "Ha cerrado sesion!");
		}
		
		return "login";
	}
	
	
}
