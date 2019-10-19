package com.poseidonapp.prototipo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Detalle;
import com.poseidonapp.prototipo.model.Producto;

@Service
public interface DetalleService {

	void save(Detalle detalle);
	List<Producto> listAll();
}
