package com.poseidonapp.prototipo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poseidonapp.prototipo.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	   

		
}
