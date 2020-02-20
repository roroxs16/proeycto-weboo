package com.poseidonapp.prototipo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Carrito;
import com.poseidonapp.prototipo.repository.CarritoRepository;

@Service
public class CarritoServiceIML implements CarritoService{

	@Autowired
	private CarritoRepository carritoRepository;
	@Override
	public void save(Carrito carrito) {
		carritoRepository.save(carrito);
		
	}

}
