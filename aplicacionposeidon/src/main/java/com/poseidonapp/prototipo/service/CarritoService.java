package com.poseidonapp.prototipo.service;

import java.util.Optional;

import com.poseidonapp.prototipo.model.Carrito;

public interface CarritoService {

	void save(Carrito carrito);

	Object listAll();

	void deleteById(int id);

	Optional<Carrito> findId(int id);

}
