package com.poseidonapp.prototipo.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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

import com.poseidonapp.prototipo.model.Venta;
import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.model.ProductoVenta;
import com.poseidonapp.prototipo.service.VentaService;
import com.poseidonapp.prototipo.service.ProductoService;
import com.poseidonapp.prototipo.service.ProductoVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private ProductoService productoService;
	 @Autowired
	 private VentaService ventaService;
	 @Autowired
	 private ProductoVentaService productoVentaService;
	 
	
	 
	//------------------------ Agregar venta
	// @GetMapping("/formularioventa/{id}/{cantidadproducto}")
	 @RequestMapping(value = "/formularioventa",method=RequestMethod.POST)
	 public String añadirProductoventa(@RequestParam (value="id") int productoId,@RequestParam (value="cantidadproducto") int cantidad_producto, RedirectAttributes flash) throws ParseException {
			Producto producto= productoService.findOne(productoId);
			ProductoVenta productoV= new ProductoVenta(); 
			List<Venta> listaV= (List<Venta>) ventaService.listAll();

						
			productoV.setCantidad_producto(cantidad_producto);
			productoV.setProducto(producto);
			productoV.setSubtotal(producto.getValor()*productoV.getCantidad_producto());
			
			Venta ventita = new Venta();
			for(int i=0;i<listaV.size();i++) {
				if(listaV.isEmpty()) {
					ventita.setId(i+1);
					ventita.setEstado(true);
					ventaService.save(ventita);

    				productoV.setVenta(ventita);
					break;
				}
				if(listaV.get(i).getEstado()== true ) {
					ventita=listaV.get(i);
					productoV.setVenta(ventita);
					break;
				}
			}
/*       
			Date fecha = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String fechaTexto = formatter.format(fecha);
			venta.setFecha(fechaTexto);
			venta.setEstado(true);*/   
			producto.setCantidad(producto.getCantidad()-cantidad_producto);
			productoVentaService.save(productoV);
			flash
	        .addFlashAttribute("mensaje", "Producto agregado al venta correctamente")
	        .addFlashAttribute("clase", "success");
			
			return "redirect:/categoria/";
			
		}
	 
	 
	 
	 
	 //Listar ventas, no estoy seguro de si esta sea una funcionalidad, OJO EL DE AQUI EN ADELANTE EL CRUD ESTÄ INCOMPLETO
	 @RequestMapping("/compra")
		public String listarCatalogo(Model model) {
			model.addAttribute("productoVenta", productoVentaService.listAll());
			return "carrito";
		}
	 @GetMapping("/delete/{id}")
	 public String deleteventa(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) throws Exception {
	        ProductoVenta pv=productoVentaService.findId(id);
	        Producto p=pv.getProducto();
	        p.setCantidad(p.getCantidad()+pv.getCantidad_producto());
		     productoVentaService.deleteById(id);
	        redirectAttrs
	        .addFlashAttribute("mensaje", "Eliminado correctamente")
	        .addFlashAttribute("clase", "warning");
	        
	       
			return "redirect:/venta/compra";
	    }
	 
	//-----------------update----------------------
			@RequestMapping(value={"/formularioupdateventa/{id}"}, method = RequestMethod.GET)
		    public String formularioUpdateventa(Model model, @PathVariable ("id") int id) {
				
		        if(id>0) {
		        	Optional<Venta> venta=ventaService.findId(id);
		            model.addAttribute("venta", venta);
		            
		        }else {
		        	model.addAttribute("venta",new Venta());
		        }
		        return "updateventa";
		    }
		 
		    @RequestMapping(value= "/updateventasucces", method = RequestMethod.POST)
		    public String updateCategoria( Model model, @Valid @ModelAttribute ("venta") Venta venta, BindingResult result, RedirectAttributes redirectAttrs) throws Exception {
		    	if (result.hasErrors()) {
		            return "updateventa";
		        }
		    	ventaService.save(venta);
		        redirectAttrs
	            .addFlashAttribute("mensaje", "Editado correctamente")
	            .addFlashAttribute("clase", "success");
		        return "redirect:/";
		    }
}
