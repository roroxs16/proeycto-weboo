package com.poseidonapp.prototipo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Categoria;
import com.poseidonapp.prototipo.repository.CategoriaRepository;

@Service
public class CategoriaServiceIML implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listAll() {

		return categoriaRepository.findAll();
	}

	@Override
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

	@Override
	public void delete(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

}
