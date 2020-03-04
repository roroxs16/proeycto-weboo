package com.poseidonapp.prototipo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

	    @Modifying
	    @Query(value = "insert into carrito_productos (carrito_id,productos_id) VALUES (:carrito_id,:productos_id)", nativeQuery = true)
	    @Transactional
	    void saveCarrito_Productos(@Param("carrito_id") int carrito_id, @Param("productos_id") int productos_id);

		
}
