package com.poseidonapp.prototipo.controllers;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.service.CategoriaService;
import com.poseidonapp.prototipo.service.ProductoService;





@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	//funcionalidad de listar categorias
	@RequestMapping("/")
	public String listarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria,  BindingResult result, Model model,SessionStatus status,RedirectAttributes redirectAttrs) {
		model.addAttribute("categorias", categoriaService.listAll());
		model.addAttribute("categoria", new Categoria());
		
		return "listcategoria";
	}

	//agrega categoria
	@GetMapping("/formulariocategoria")
	public String formularioCategoria(Model model) {
	
	
		model.addAttribute("categoria", new Categoria());
		
		
		return "addcategoria";
		
	}
	//guarda la categoria
	@PostMapping("/savecategoriasucces")
	public String formularioCategoriaSave(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, Model model,SessionStatus status,RedirectAttributes redirectAttrs) throws IOException  {
		if (result.hasErrors()) {
           // return "addcategoria";
          //  return "redirect:/categoria/";
        }
		
		categoriaService.save(categoria);
		redirectAttrs
        .addFlashAttribute("mensaje", "Categoria agregada correctamente")
        .addFlashAttribute("clase", "success");
		status.setComplete();
		return "redirect:/categoria/";
	
	}

	
	//mostrar por id
	@GetMapping("/listcategoria/{id}")
	public String verProductosPorCategoria(@PathVariable("id") int id, Model model) {
		Categoria categoria = categoriaService.findId(id);
		if(categoria==null) {
			return"redirect:/";
		}
		
		model.addAttribute("productos", categoria.getProductos());
		model.addAttribute("categoria", categoria);
		
		return "verproductos";
	}
	

     //elimina por id
	

	@GetMapping("/delete/{id}")

    public String deleteCategoria(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) throws Exception {
        
        
        redirectAttrs
        .addFlashAttribute("mensaje", "Eliminado correctamente")
        .addFlashAttribute("clase", "warning");
        categoriaService.deleteById(id);
       
		return "redirect:/categoria/";
    }
	
	//-----------------update----------------------
		@RequestMapping(value={"/formularioupdatecategoria/{id}"}, method = RequestMethod.GET)
	    public String formularioUpdateCategoria(Model model, @PathVariable ("id") int id) {
			
	        if(id>0) {
	        	Categoria categoria=categoriaService.findId(id);
	            model.addAttribute("categoria", categoria);
	            
	        }else {
	        	model.addAttribute("categoria",new Categoria());
	        }
	        return "updatecategoria";
	    }
	 
	    @RequestMapping(value= "/updatecategoriasucces", method = RequestMethod.POST)
	    public String updateCategoria( Model model, @Valid @ModelAttribute ("categoria") Categoria categoria, BindingResult result, RedirectAttributes redirectAttrs) throws Exception {
	    	if (result.hasErrors()) {
	            return "updatecategoria";
	        }
	    	categoriaService.save(categoria);
	        redirectAttrs
            .addFlashAttribute("mensaje", "Editado correctamente")
            .addFlashAttribute("clase", "success");
	        return "redirect:/categoria/";
	    }
	
	
	
	
	
}
