package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidonapp.prototipo.service.ProductoService;

@Controller("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@RequestMapping("/")
	public String listarProducto(Model model) {
		model.addAttribute("productos", productoService.listAll());
		
		return "listarproducto";
	}
}
