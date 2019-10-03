package com.poseidonapp.prototipo.service;

import java.util.List;
import java.util.Optional;

import com.poseidonapp.prototipo.model.Categoria;

public interface CategoriaService {

	List<Categoria> listAll();

	void save(Categoria categoria);
	
	void delete(Categoria categoria);

	Optional<Categoria> findById(int id);
	

	public void findOne(int id);
	

	void deleteById(int id);

}
