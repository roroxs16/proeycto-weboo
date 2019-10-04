package com.poseidonapp.prototipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
