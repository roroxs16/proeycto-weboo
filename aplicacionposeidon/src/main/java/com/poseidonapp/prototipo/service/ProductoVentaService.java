package com.poseidonapp.prototipo.service;

import java.util.Optional;

import com.poseidonapp.prototipo.model.ProductoVenta;

public interface ProductoVentaService {

	void save(ProductoVenta productoVenta);

	Object listAll();

	void deleteById(int id);

	ProductoVenta findId(int id);
}
