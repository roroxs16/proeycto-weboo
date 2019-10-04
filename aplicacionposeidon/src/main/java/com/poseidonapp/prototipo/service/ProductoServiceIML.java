package com.poseidonapp.prototipo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.repository.ProductoRepository;

@Service
public class ProductoServiceIML implements ProductoService{

	@Autowired
		private ProductoRepository productoRepository;
	@Override
	public List<Producto> listAll() {
		return productoRepository.findAll();
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(int id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto findOne(int id) {
		Optional<Producto> customer= productoRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

}
