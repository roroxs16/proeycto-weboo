package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.poseidonapp.prototipo.service.DetalleService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping("/")
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", productoService.listAll());
		
		return "detalle";
	}
	
}
