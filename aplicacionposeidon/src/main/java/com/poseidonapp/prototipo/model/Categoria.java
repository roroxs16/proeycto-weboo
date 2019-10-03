package com.poseidonapp.prototipo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categoria_producto")
public class Categoria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6747164488338538811L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="nombre")
	private String nombreCategoria;



	public Categoria(int id, String nombreCategoria) {
	
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		
	}







	public Categoria() {
		
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
