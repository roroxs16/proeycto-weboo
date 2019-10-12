package com.poseidonapp.prototipo.service;

import java.util.List;
import java.util.Optional;

import com.poseidonapp.prototipo.model.Categoria;

public interface CategoriaService {

	List<Categoria> listAll();

	void save(Categoria categoria);
	
	void delete(Categoria categoria);

	Categoria findId(int id);
	


	

	void deleteById(int id);

}
