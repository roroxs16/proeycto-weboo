package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidonapp.prototipo.service.CarritoService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private ProductoService productoService;
	 @Autowired
	 private CarritoService carritoService;
	 
	 
}
