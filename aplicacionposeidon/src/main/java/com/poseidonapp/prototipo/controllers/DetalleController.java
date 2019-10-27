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

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.model.Detalle;
import com.poseidonapp.prototipo.service.DetalleService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/compra")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping("/")
	public String carrito(Model model) {
	//	model.addAttribute("categorias", productoService.listAll());
		
		return "carrito";
	}
	
	@RequestMapping("/ventas")
	public String listaVentas(Model model) {
		model.addAttribute("detalles", detalleService.listAll());
		
		return "listaventas";
	}
	
	/*------------------------save-----------------------*/
	
	@GetMapping("/agregaracompra")
	public String formularioCategoria(Model model) {
	
	
		model.addAttribute("detalle", new Detalle());
		
		
		return "carrito";
		
	}
	//guarda la categoria
	@PostMapping("/savecarritosucces")
	public String formularioCategoriaSave(@Valid @ModelAttribute Detalle detalle, BindingResult result, Model model,SessionStatus status,RedirectAttributes redirectAttrs) throws Exception  {
		if (result.hasErrors()) {
            return "carrito";
        }
		
		detalleService.save(detalle);
		redirectAttrs
        .addFlashAttribute("mensaje", "Carrito pagado")
        .addFlashAttribute("clase", "success");
		status.setComplete();
		return "redirect:/producto/";
	
	}
	
	
	
}
