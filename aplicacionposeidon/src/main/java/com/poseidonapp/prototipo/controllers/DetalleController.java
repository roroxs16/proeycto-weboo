package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidonapp.prototipo.service.DetalleService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;
	
	@RequestMapping("/")
	public String listarCategoria(Model model) {
		model.addAttribute("detalles", detalleService.listAll());
		
		return "listdetalle";
	}
	public String agregaDetalle() {
		//No sé que va aca

		return "";
	}
}
