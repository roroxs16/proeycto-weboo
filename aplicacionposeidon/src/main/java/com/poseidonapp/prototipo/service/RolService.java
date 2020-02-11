package com.poseidonapp.prototipo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poseidonapp.prototipo.model.Rol;

public interface RolService {
	List <Rol> findAll();
}
