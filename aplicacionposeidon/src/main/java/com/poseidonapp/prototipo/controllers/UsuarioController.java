package com.poseidonapp.prototipo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidonapp.prototipo.model.Usuario;
import com.poseidonapp.prototipo.service.UsuarioService;



@Controller
@RequestMapping("/registrar")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("Usuario",new Usuario());
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model,SessionStatus status,RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return "register";
		}
		usuarioService.save(usuario);
		redirectAttrs
        .addFlashAttribute("mensaje", "Usuario agregado correctamente")
        .addFlashAttribute("clase", "success");
		status.setComplete();
		return "redirect:/";
	}
}
