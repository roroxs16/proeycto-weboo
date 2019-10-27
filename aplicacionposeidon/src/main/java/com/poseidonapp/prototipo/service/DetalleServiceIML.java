package com.poseidonapp.prototipo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Detalle;
import com.poseidonapp.prototipo.model.Producto;
import com.poseidonapp.prototipo.repository.DetalleRepository;
import com.poseidonapp.prototipo.repository.ProductoRepository;

@Service
public class DetalleServiceIML implements DetalleService {

	@Autowired
	private DetalleRepository detalleRepository;
	
	@Autowired 
	private ProductoRepository productoRepository;
	
	public void save(Detalle detalle) {
		detalleRepository.save(detalle);
	}

	@Override
	public List<Detalle> listAll() {
		return detalleRepository.findAll();
	}
}
