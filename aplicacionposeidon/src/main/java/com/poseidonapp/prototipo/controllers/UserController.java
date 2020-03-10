package com.poseidonapp.prototipo.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poseidonapp.prototipo.model.Rol;
import com.poseidonapp.prototipo.model.Usuario;
import com.poseidonapp.prototipo.service.RolService;
import com.poseidonapp.prototipo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RolService rolService;
	
	List<Rol> rolesList ;
	
	//agrega usuario
	@RequestMapping("/formulariousuario")
	public String formularioRegistro(Model model) {
	
	
		model.addAttribute("nuevousuario", new Usuario());

		
		return "registro";
		
	}

	@PostMapping("/saveusuario")
	public String formularioUsuarioSave(@Valid @ModelAttribute("nuevousuario") Usuario usuario, BindingResult result, Model model,SessionStatus status,RedirectAttributes redirectAttrs) throws IOException  {
		
		if(result.hasErrors()) {
			return "registro";
		}
		
		rolesList =  rolService.findAll();
		
		String password = usuario.getPassword();
		
		
		usuario.setPassword(passwordEncoder.encode(password));
		
		
		usuarioService.save(usuario);
		
		usuarioService.saveUsuarioRoles(usuario.getId(), rolesList.get(1).getId());

		return "redirect:/";
	
	}
	



}