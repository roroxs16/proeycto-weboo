package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
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
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecha;
	
	@NotNull
	@Column(name="valor_total")
	private int valor_total;
	
	@NotNull
	@Column(name="usuario_id")
	private int usuario_id;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "detalle_producto",
        joinColumns = @JoinColumn(name = "detalle_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id"))
	private Set<Producto> productos = new HashSet<>();
	
	

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Detalle() {
		
	}	

	public Detalle(int id, @NotNull Date fecha, @NotNull int valor_total, @NotNull int usuario_id) {
		this.id = id;
		this.fecha = fecha;
		this.valor_total = valor_total;
		this.usuario_id = usuario_id;
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
	
	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
