package com.poseidonapp.prototipo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="producto")
public class Producto {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@NotEmpty
		@Column(name="nombre")
		private String nombreProducto;
		
		@NotNull
		@Column(name="cantidad")
		private int cantidad;
		
		@NotNull
		@Column(name="valor")
		private int valor;
		
		@NotEmpty
		@Column(name="descripcion")
		private String descripcion;
		
		
		@Column(name="img")
		private String imagen;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "categoria_producto_id", nullable = false)
		private Categoria  categoria;

		
		@ManyToMany(mappedBy = "productos")
	    private Set<Detalle> detalles = new HashSet<>();		
		
		public Producto() {
			
		}

		public Producto(int id, @NotEmpty String nombreProducto, @NotNull int cantidad, @NotNull int valor,
				@NotEmpty String descripcion, String imagen, Categoria categoria) {
			
			this.id = id;
			this.nombreProducto = nombreProducto;
			this.cantidad = cantidad;
			this.valor = valor;
			this.descripcion = descripcion;
			this.imagen = imagen;
			this.categoria = categoria;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	
		public String getNombreProducto() {
			return nombreProducto;
		}

		public void setNombreProducto(String nombreProducto) {
			this.nombreProducto = nombreProducto;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		@Override
		public String toString() {
			return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", valor="
					+ valor + ", descripcion=" + descripcion + ", imagen=" + imagen + ", categoria=" + categoria + "]";
		}
		
		public int valorTotal(int cantidad){
			int total= this.valor * cantidad;
			
			return total;
		}

		public Set<Detalle> getDetalles() {
			return detalles;
		}

		public void setDetalles(Set<Detalle> detalles) {
			this.detalles = detalles;
		}
		
		
}
