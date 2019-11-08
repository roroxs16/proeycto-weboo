package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="detalle")
public class Detalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8619174119821048590L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="valor_total")
	private int total;
	
	
	@Column(name="estado")
	private boolean estado;
	
	
	
	
	
	
	
	
}
