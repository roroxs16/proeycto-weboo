package com.poseidonapp.prototipo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
    public Usuario findByCorreo(String username);

    @Modifying
    @Query(value = "insert into usuario_roles (usuario_id,role_id) VALUES (:usuario_id,:role_id)", nativeQuery = true)
    @Transactional
    void saveUsuario_Roles(@Param("usuario_id") int usuario_id, @Param("role_id") int id);
}
