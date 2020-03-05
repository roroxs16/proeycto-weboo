package com.poseidonapp.prototipo.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidonapp.prototipo.model.Carrito;
import com.poseidonapp.prototipo.model.Categoria;
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
	 public String añadirProductoCarrito(@RequestParam (value="id") int productoId,@RequestParam (value="cantidadproducto") int cantidad_producto, RedirectAttributes flash) throws ParseException {
			Producto producto= productoService.findOne(productoId);
			 ArrayList<Producto> listaProductos = new ArrayList<Producto>() ;
			listaProductos.add(producto);
			
			
			Carrito carrito= new Carrito();
			carrito.setProductos(listaProductos);
			carrito.setNombreProducto(producto.getNombreProducto());
			carrito.setCantidad_producto(cantidad_producto);
			carrito.setPrecio(producto.getValor());
			carrito.setSubtotal(carrito.getCantidad_producto()*carrito.getPrecio());
			Date fecha = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String fechaTexto = formatter.format(fecha);
			carrito.setFecha(fechaTexto);
			carrito.setEstado(true);
            
			producto.setCantidad(producto.getCantidad()-cantidad_producto);
			carritoService.saveProductoCarritos(carrito.getId(), productoId);
			carritoService.save(carrito);
			flash
	        .addFlashAttribute("mensaje", "Producto agregado al carrito correctamente")
	        .addFlashAttribute("clase", "success");
			
			return "redirect:/categoria/";
			
		}
	 
	 
	 
	 
	 //Listar carritos, no estoy seguro de si esta sea una funcionalidad, OJO EL DE AQUI EN ADELANTE EL CRUD ESTÄ INCOMPLETO
	 @RequestMapping("/compra")
		public String listarCatalogo(Model model) {
			model.addAttribute("carritos", carritoService.listAll());
		

			return "carrito";
		}
	 @GetMapping("/delete/{id}")
	 public String deleteCarrito(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) throws Exception {
	        
	        
	        redirectAttrs
	        .addFlashAttribute("mensaje", "Eliminado correctamente")
	        .addFlashAttribute("clase", "warning");
	        carritoService.deleteById(id);
	       
			return "redirect:/carrito";
	    }
	 
	//-----------------update----------------------
			@RequestMapping(value={"/formularioupdatecarrito/{id}"}, method = RequestMethod.GET)
		    public String formularioUpdateCarrito(Model model, @PathVariable ("id") int id) {
				
		        if(id>0) {
		        	Optional<Carrito> carrito=carritoService.findId(id);
		            model.addAttribute("carrito", carrito);
		            
		        }else {
		        	model.addAttribute("carrito",new Carrito());
		        }
		        return "updatecarrito";
		    }
		 
		    @RequestMapping(value= "/updatecarritosucces", method = RequestMethod.POST)
		    public String updateCategoria( Model model, @Valid @ModelAttribute ("carrito") Carrito carrito, BindingResult result, RedirectAttributes redirectAttrs) throws Exception {
		    	if (result.hasErrors()) {
		            return "updatecarrito";
		        }
		    	carritoService.save(carrito);
		        redirectAttrs
	            .addFlashAttribute("mensaje", "Editado correctamente")
	            .addFlashAttribute("clase", "success");
		        return "redirect:/";
		    }
}
