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
import org.springframework.validation.BindingResult;
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
import com.poseidonapp.prototipo.service.VentaService;
import com.poseidonapp.prototipo.service.CategoriaService;
import com.poseidonapp.prototipo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	

	@RequestMapping("/")
	public String listarCatalogo(Model model) {
		model.addAttribute("productos", productoService.listAll());
		
		return "listaproductos";
	}
	
	@GetMapping("/ver/{id}")
	public String detalleProducto(@PathVariable(value="id") int id ,Model model) {
		
		Producto producto= productoService.findOne(id);
		model.addAttribute("producto", productoService.listAll());
		model.addAttribute("producto", producto);
		
		return "ver";
	}

	
	
	@GetMapping("/formularioproducto/{categoriaId}")
	public String formularioProducto(@PathVariable(value="categoriaId") int categoriaId, Model model) {
		
		Categoria categoria= categoriaService.findId(categoriaId);
		
		if(categoria==null) {
			return "redirect:/";
		}
		
		Producto producto= new Producto();
		
		producto.setCategoria(categoria);
		System.out.println(producto);
		model.addAttribute("producto", producto);
		
		return "addproducto";
		
		
	}
	
	
	
	@RequestMapping(value = "/saveproductosucces",method=RequestMethod.POST)
	public String formularioProductoSave(@Valid Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash ) throws Exception {
		System.out.println(producto);
		if (result.hasErrors()) {
         //   return "addproducto";
        }
		if(!foto.isEmpty()) {
		
			
			
			
			if(producto.getId()>0 && producto.getImagen()!=null) {
				Path rootPath =Paths.get("src//main//resources//static/imgProducto").resolve(producto.getImagen()).toAbsolutePath();
				File archivo= rootPath.toFile();
				
				if(archivo.exists()&& archivo.canRead()) {
					archivo.delete();
				}
				flash
		        .addFlashAttribute("mensaje", "Editado correctamente")
		        .addFlashAttribute("clase", "success");
			}
			
			String uniqueFilename= UUID.randomUUID().toString()+"_"+foto.getOriginalFilename();
			Path rootPath= Paths.get("src//main//resources//static/imgProducto").resolve(uniqueFilename);
			
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

		flash
        .addFlashAttribute("mensaje", "Productos actualizados")
        .addFlashAttribute("clase", "success");
		return "redirect:/categoria/listcategoria/"+producto.getCategoria().getId();
	}
	
	
	@GetMapping(value="/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {
		Path pathFoto = Paths.get("src//main//resources//static/imgProducto").resolve(filename).toAbsolutePath();
	
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
       
		
        
		Producto producto= productoService.findOne(id);
		int aux=producto.getCategoria().getId();
		
		if(id>0) {
			
			productoService.delete(id);
			flash
	        .addFlashAttribute("mensaje", "Producto eliminado correctamente")
	        .addFlashAttribute("clase", "warning");
			
			if(producto.getImagen()!=null) {
			Path rootPath =Paths.get("src//main//resources//static/imgProducto").resolve(producto.getImagen()).toAbsolutePath();
			File archivo= rootPath.toFile();
			
			if(archivo.exists()&& archivo.canRead()) {
				if(archivo.delete()) {
					flash.addFlashAttribute("info", "foto"+ producto.getImagen()+ "Eliminada con exito");
				}
			}
			
		}
		}
		
		return "redirect:/categoria/listcategoria/"+aux;
    }
	
	@RequestMapping(value="/updateproducto/{id}", method=RequestMethod.GET)
	public String formularioUpdateProducto(Model model, @PathVariable("id")int id) {

		if(id>0) {
			Producto producto=productoService.findOne(id);
			model.addAttribute("producto",producto);
		}else {
			model.addAttribute("producto",new Producto());
		}
		
		return "updateproducto";
	}
	
	
	@RequestMapping(value="/updateproductosucces", method= RequestMethod.POST)
	public String updateProducto(Model model,@Valid @ModelAttribute ("producto") Producto producto,BindingResult result,RedirectAttributes flash) throws Exception {
		if (result.hasErrors()) {
            return "addproducto";
        }
		productoService.save(producto);
		
		
		return "redirect:/categoria/listcategoria/"+producto.getCategoria().getId();
	}
}
