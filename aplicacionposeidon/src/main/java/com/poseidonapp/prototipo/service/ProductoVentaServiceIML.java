package com.poseidonapp.prototipo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.model.ProductoVenta;

import com.poseidonapp.prototipo.repository.ProductoVentaRepository;


@Service
public class ProductoVentaServiceIML implements ProductoVentaService {

	@Autowired
	private ProductoVentaRepository productoVentaRepository;
	
	
	public void save(ProductoVenta productoVenta) {
		productoVentaRepository.save(productoVenta);
		
	}
	
	public Object listAll() {
		// TODO Auto-generated method stub
		return productoVentaRepository.findAll();
	}
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productoVentaRepository.deleteById(id);
	}
	public ProductoVenta findId(int id) {
		// TODO Auto-generated method stub
		Optional<ProductoVenta> pv= productoVentaRepository.findById(id);
		if(pv.isPresent()) {
			return pv.get();
		}
		return null;
	}
	}

