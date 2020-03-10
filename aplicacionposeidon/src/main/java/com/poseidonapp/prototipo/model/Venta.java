package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity	
@Table(name="venta")
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="total")
	private int total;
	
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="estado")
	private Boolean estado;
	

	@OneToMany(mappedBy="venta", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ProductoVenta> productosVenta;


	public Venta(int id, int total, String fecha, Boolean estado,
			List<ProductoVenta> productosVenta) {
		
		this.id = id;
		this.total = total;
		this.fecha = fecha;
		this.estado = estado;
		this.productosVenta = productosVenta;
	}


	public Venta() {
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public List<ProductoVenta> getProductosVenta() {
		return productosVenta;
	}


	public void setProductosVenta(List<ProductoVenta> productosVenta) {
		this.productosVenta = productosVenta;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


		
	
}