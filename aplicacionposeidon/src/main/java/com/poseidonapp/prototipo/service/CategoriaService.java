package com.poseidonapp.prototipo.service;

import java.util.List;

import com.poseidonapp.prototipo.model.Categoria;

public interface CategoriaService {

	List<Categoria> listAll();

	void save(Categoria categoria);
	
	void delete(Categoria categoria);
	
	public void findOne(int id);
	
}
