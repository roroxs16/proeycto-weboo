package com.poseidonapp.prototipo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", categoriaService.listAll());
		
		return "listarcategoria";
	}
	
	@GetMapping("/formulariocategoria")
	public String formularioCategoria(Model model) {
	
	
		model.addAttribute("categoria", new Categoria());
		
		
		return "savecategoria";
		
	}
	
	@PostMapping("/savecategoriasucces")
	public String formularioCategoriaSave(@Valid @ModelAttribute Categoria categoria, Model model) {
		
		categoriaService.save(categoria);
		return "redirect:/categoria/";
		
	}
	
	
	
	
}
