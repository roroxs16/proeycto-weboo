package com.poseidonapp.prototipo.service;

import java.util.Optional;

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
	@Override
	public Object listAll() {
		// TODO Auto-generated method stub
		return carritoRepository.findAll();
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		carritoRepository.deleteById(id);
	}
	@Override
	public Optional<Carrito> findId(int id) {
		// TODO Auto-generated method stub
		return carritoRepository.findById(id);
	}

}
