package com.poseidonapp.prototipo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	
	public Usuario findByCorreo(String correo);

}
