package com.poseidonapp.prototipo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.poseidonapp.prototipo.model.Venta;

public interface VentaService {

	void save(Venta carrito);

	List<Venta> listAll();

	void deleteById(int id);

	public Venta findId(int id);



}
