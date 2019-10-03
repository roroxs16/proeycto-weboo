package com.poseidonapp.prototipo.controllers;


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

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.service.CategoriaService;





@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	//funcionalidad de listar categorias
	@RequestMapping("/")
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", categoriaService.listAll());
		
		return "list";
	}

	//agrega categoria
	@GetMapping("/formulariocategoria")
	public String formularioCategoria(Model model) {
	
	
		model.addAttribute("categoria", new Categoria());
		
		
		return "addcategoria";
		
	}
	//guarda la categoria
	@PostMapping("/savecategoriasucces")
	public String formularioCategoriaSave(@Valid @ModelAttribute Categoria categoria, Model model) {
		
		categoriaService.save(categoria);
		return "redirect:/categoria/";
		
	}

	//busca por id
	public Categoria findById(int id) throws Exception {
		 Optional<Categoria> categoria = categoriaService.findById(id);
        
	        if(categoria.isPresent()) {
	            return categoria.get();
	        } else {
	            throw new Exception("No customer record exist for given id");
	        }
	}
	
	

     //elimina por id
	@GetMapping("delete/{id}")
    public String deleteCategoria(@PathVariable("id") int id, Model model) throws Exception {
        Optional<Categoria> categoria =  categoriaService.findById(id);  
        if(categoria.isPresent())
        {
          categoriaService.deleteById(id);
        } else {
            throw new Exception("No customer record exist for given id");
        }
      
       List<Categoria> list = categoriaService.listAll();
		if(list == null) System.out.println("list es null");
		if(list.isEmpty()) System.out.println("La lista esta vacia");
		model.addAttribute("categorias",list);
		return "list";
    }

	
	
	
}
