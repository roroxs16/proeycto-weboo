package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidonapp.prototipo.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/listar")
	public String listarCategoria(Model model) {
		model.addAttribute("categoria", categoriaService.listAll());
		
		return "listarcategoria";
	}
	
	
	
	
	
}
