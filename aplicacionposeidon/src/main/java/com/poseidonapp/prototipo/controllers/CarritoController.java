package com.poseidonapp.prototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 @GetMapping("/formulariocarrito/{id}/{cantidadproducto}")
		public String añadirProductoCarrito(@PathVariable (value="id") int productoId,@PathVariable (value="cantidadproducto") int cantidad_producto) {
			Producto producto= productoService.findOne(productoId);
			
			Carrito carrito= new Carrito();
			carrito.setProducto(producto);
			carrito.setCantidad_producto(cantidad_producto);
			carrito.setPrecio(producto.getValor());
			carrito.setSubtotal(carrito.getCantidad_producto()*carrito.getPrecio());
			
			carritoService.save(carrito);
			
			return "listaproductos";
			
		}
}
