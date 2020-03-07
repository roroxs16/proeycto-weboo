package com.poseidonapp.prototipo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta,Integer>{

}
