package com.poseidonapp.prototipo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity	
@Table(name="carrito")
public class Carrito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	
	/*@NotNull
	@Column(name="detalle_id")
	private Detalle detalle_id;*/
	
	@NotNull
	@Column(name="cantidad_producto")
	private int cantidad_producto;
	
	@NotNull
	@Column(name="precio")
	private int precio;
	
	@NotNull
	@Column(name="subtotal")
	private int subtotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto carritoProducto;

	public Carrito(int id, @NotNull int cantidad_producto, @NotNull int precio, @NotNull int subtotal,
			Producto producto) {
		
		this.id = id;
		this.cantidad_producto = cantidad_producto;
		this.precio = precio;
		this.subtotal = subtotal;
		this.carritoProducto = producto;
	}

	public Carrito() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return carritoProducto;
	}

	public void setProducto(Producto producto) {
		this.carritoProducto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
