package com.poseidonapp.prototipo.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.service.CategoriaService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/producto")
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@RequestMapping("/")
	public String listarProducto(Model model) {
		
		model.addAttribute("productos", productoService.listAll());
		
		return "listp";
	}
	
	@GetMapping("/ver/{id}")
	public String detalleProducto(@PathVariable(value="id") int id ,Model model) {
		
		Producto producto= productoService.findOne(id);
		
		model.addAttribute("producto", producto);
		
		return "ver";
	}


	
	
	
	@GetMapping("/formularioproducto/{categoriaId}")
	public String formularioProducto(@PathVariable(value="categoriaId") int clienteId, Model model) {
		
		Categoria categoria= categoriaService.findId(clienteId);
		
		if(categoria==null) {
			return "redirect:/";
		}
		
		Producto producto= new Producto();
		producto.setCategoria(categoria);
		model.addAttribute("producto", producto);
		
		return "addproducto";
		
		
	}
	
	
	
	@RequestMapping(value = "/saveproductosucces",method=RequestMethod.POST)
	public String formularioProductoSave(@Valid Producto producto, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash ) throws Exception {
		
		if(!foto.isEmpty()) {
		
			
			
			
			if(producto.getId()>0 && producto.getImagen()!=null) {
				Path rootPath =Paths.get("uploads").resolve(producto.getImagen()).toAbsolutePath();
				File archivo= rootPath.toFile();
				
				if(archivo.exists()&& archivo.canRead()) {
					archivo.delete();
				}
			}
			
			String uniqueFilename= UUID.randomUUID().toString()+"_"+foto.getOriginalFilename();
			Path rootPath= Paths.get("uploads").resolve(uniqueFilename);
			
			Path rootAbsoluPath = rootPath.toAbsolutePath();
			
			
			try {
				Files.copy(foto.getInputStream(), rootAbsoluPath);
				
				flash.addFlashAttribute("info","Imagen subida correctamente" +uniqueFilename+"");
				
				producto.setImagen(uniqueFilename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		productoService.save(producto);
		return "redirect:/categoria/";
	}
	
	
	@GetMapping(value="/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {
		Path pathFoto = Paths.get("uploads").resolve(filename).toAbsolutePath();
	
		Resource recurso = null;
		try {
			recurso = new UrlResource(pathFoto.toUri());
			if(!recurso.exists() || !recurso.isReadable()) {
				throw new RuntimeException("Error: no se puede cargar la imagen: " + pathFoto.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +  recurso.getFilename() +"\"")
				.body(recurso);
	}
	
	@GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable("id") int id, Model model, RedirectAttributes flash) throws Exception {
       
		
        
     
		
		if(id>0) {
			Producto producto= productoService.findOne(id);
			productoService.delete(id);
			
			Path rootPath =Paths.get("uploads").resolve(producto.getImagen()).toAbsolutePath();
			File archivo= rootPath.toFile();
			
			if(archivo.exists()&& archivo.canRead()) {
				if(archivo.delete()) {
					flash.addFlashAttribute("info", "foto"+ producto.getImagen()+ "Eliminada con exito");
				}
			}
			
		}
		
		return "redirect:/categoria/";
    }
	
	@RequestMapping(value="/updateproducto/{id}", method=RequestMethod.GET)
	public String formularioUpdateProducto(Model model, @PathVariable("id")int id) {

		if(id>0) {
			Producto producto=productoService.findOne(id);
			model.addAttribute("producto",producto);
		}else {
			model.addAttribute("producto",new Producto());
		}
		
		return "addproducto";
	}
	
	
	@RequestMapping(value="/updateproductosucces", method= RequestMethod.POST)
	public String updateProducto(Model model, @ModelAttribute ("producto") Producto producto) {
		
		System.out.println(producto);
		productoService.save(producto);
		
		return "redirect:/producto/";
	}
}