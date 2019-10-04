package com.poseidonapp.prototipo.service;

import java.util.List;


import com.poseidonapp.prototipo.model.Producto;

	

public interface ProductoService {
	List<Producto> listAll();

	void save(Producto producto);
	
	void delete(int id);
	
	public Producto findOne(int id);
}
