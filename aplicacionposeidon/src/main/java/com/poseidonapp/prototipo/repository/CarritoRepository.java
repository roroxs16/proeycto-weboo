package com.poseidonapp.prototipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

}
