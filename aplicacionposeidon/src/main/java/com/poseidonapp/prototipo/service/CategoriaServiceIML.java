package com.poseidonapp.prototipo.service;

import java.util.List;
import java.util.Optional;

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

		categoriaRepository.deleteById(categoria.getId());

		// TODO Auto-generated method stub
		categoriaRepository.delete(categoria);

		
	}
	public void deleteById(int id) {
		categoriaRepository.deleteById(id);
	}

	

	@Override
	public Categoria findId(int id) {
		Optional<Categoria> categoria=categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		return null;
	}

}
