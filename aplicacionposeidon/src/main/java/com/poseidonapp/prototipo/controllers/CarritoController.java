package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidonapp.prototipo.model.Carrito;
import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.service.CarritoService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private ProductoService productoService;
	 @Autowired
	 private CarritoService carritoService;
	 
	//------------------------ Agregar carrito
	// @GetMapping("/formulariocarrito/{id}/{cantidadproducto}")
	 @RequestMapping(value = "/formulariocarrito",method=RequestMethod.POST)
	 public String añadirProductoCarrito(@RequestParam (value="id") int productoId,@RequestParam (value="cantidadproducto") int cantidad_producto, RedirectAttributes flash) {
			Producto producto= productoService.findOne(productoId);
			
			
			
			Carrito carrito= new Carrito();
			carrito.setProducto(producto);
			carrito.setCantidad_producto(cantidad_producto);
			carrito.setPrecio(producto.getValor());
			carrito.setSubtotal(carrito.getCantidad_producto()*carrito.getPrecio());
			
			producto.setCantidad(producto.getCantidad()-cantidad_producto);
			
			carritoService.save(carrito);
			flash
	        .addFlashAttribute("mensaje", "Producto agregado al carrito correctamente")
	        .addFlashAttribute("clase", "success");
			
			return "redirect:/categoria/";
			
		}
}
