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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", categoriaService.listAll());
		
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

	

	public String formularioCategoriaSave(@Valid @ModelAttribute Categoria categoria, Model model, BindingResult result,SessionStatus status) {
		if (result.hasErrors()) {
            return "addcategoria";
        }
		
		
		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:/categoria/";
		
	}

	/*busca por id
	public Categoria findById(int id) throws Exception {
		 Categoria categoria = categoriaService.findId(id);
        
	        
	}*/
	
	//mostrar por id
	@GetMapping("/listcategoria/{id}")
	public String verProductosPorCategoria(@PathVariable("id") int id, Model model) {
		Categoria categoria = categoriaService.findId(id);
		if(categoria==null) {
			return"redirect:/";
		}
		
		model.addAttribute("productos", categoria.getProductos());
		
		return "verproductos";
	}
	

     //elimina por id

	

	@GetMapping("/delete/{id}")

    public String deleteCategoria(@PathVariable("id") int id, Model model) throws Exception {
        categoriaService.deleteById(id);
        
      
       List<Categoria> list = categoriaService.listAll();
		if(list == null) System.out.println("list es null");
		if(list.isEmpty()) System.out.println("La lista esta vacia");
		model.addAttribute("categorias",list);
		return "listcategoria";
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
	    public String updateCategoria( Model model, @ModelAttribute ("categoria") Categoria categoria) {
	        categoriaService.save(categoria);
	        
	        return "redirect:/categoria/";
	    }
	
	
	
	
	
}
