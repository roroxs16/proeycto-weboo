package com.poseidonapp.prototipo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Venta;
import com.poseidonapp.prototipo.repository.VentaRepository;


@Service
public class VentaServiceIML implements VentaService{

	@Autowired
	private VentaRepository ventaRepository;
	@Override
	public void save(Venta venta) {
		ventaRepository.save(venta);
		
	}
	@Override
	public List<Venta> listAll() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ventaRepository.deleteById(id);
	}
	@Override
	public Venta findId(int id) {
		// TODO Auto-generated method stub
		return ventaRepository.getOne(id);
	}
//	@Override
	/*public void saveProductoCarritos(int i, int j) {
		  ventaRepository.saveProducto_Carritos(i, j);
		
	}*/
	

}
