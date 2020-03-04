package com.poseidonapp.prototipo.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@NotEmpty
	@Column(name="nombreProducto")
	private String nombreProducto;
	
	@NotEmpty
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="estado")
	private Boolean estado;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name = "producto_id", nullable = false)
	//private Producto carritoProducto;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;

	public Carrito(int id, @NotNull int cantidad_producto, @NotNull int precio, @NotNull int subtotal,
			@NotEmpty String nombreProducto, @NotEmpty String fecha, Boolean estado, List<Producto> productos) {
		super();
		this.id = id;
		this.cantidad_producto = cantidad_producto;
		this.precio = precio;
		this.subtotal = subtotal;
		this.nombreProducto = nombreProducto;
		this.fecha = fecha;
		this.estado = estado;
		this.productos = productos;
	}

	public Carrito() {
		super();
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

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public  String getFecha() {
		return fecha;
	}

	public void setFecha(String fechaTexto) {
		this.fecha = fechaTexto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


	
	
}
