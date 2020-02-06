package com.poseidonapp.prototipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Rol;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer>{

}
