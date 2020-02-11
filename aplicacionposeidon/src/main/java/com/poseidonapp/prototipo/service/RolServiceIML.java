package com.poseidonapp.prototipo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Rol;
import com.poseidonapp.prototipo.repository.RolRepository;

@Service("rolService")
public class RolServiceIML implements RolService {

	@Autowired
	private RolRepository rolRepo;

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return rolRepo.findAll();
	}
	


}
