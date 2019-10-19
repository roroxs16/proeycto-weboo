package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity	
@Table(name="detalle")
public class Detalle  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146570703128669525L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecha;
	
	@NotNull
	private int valor_total;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Producto> producto;
	
	
	
	

	public Detalle() {
		
	}

	public Detalle(int id, @NotNull Date fecha, @NotNull int valor_total, @NotNull List<Producto> producto) {
		
		this.id = id;
		this.fecha = fecha;
		this.valor_total = valor_total;
		this.producto = producto;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
