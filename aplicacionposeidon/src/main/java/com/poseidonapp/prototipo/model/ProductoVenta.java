package com.poseidonapp.prototipo.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="producto_venta")
public class ProductoVenta {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@NotNull
	@Column(name="cantidad_producto")
	private int cantidad_producto;
	
	@NotNull
	@Column(name="subtotal")
	private int subtotal;
	
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="venta_id")
    private Venta venta;

	public ProductoVenta(int id, @NotNull int cantidad_producto, @NotNull int subtotal, Producto producto,
			Venta venta) {
		
		this.id = id;
		this.cantidad_producto = cantidad_producto;
		this.subtotal = subtotal;
		this.producto = producto;
		this.venta = venta;
	}

	public ProductoVenta() {
	
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

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	
    
}
