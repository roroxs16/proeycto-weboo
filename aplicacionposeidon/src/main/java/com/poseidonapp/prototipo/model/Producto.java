package com.poseidonapp.prototipo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="nombre")
		private String nombreProducto;
		
		@Column(name="cantidad")
		private int cantidad;
		
		@Column(name="valor")
		private int valor;
		
		@Column(name="descripcion")
		private String descripcion;
		
		@Column(name="img")
		private String imagen;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "categoria_producto_id", nullable = false)
		private Categoria  categoria;

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

		public Producto(int id, String nombreProducto, int cantidad, int valor, String descripcion, String imagen) {
			
			this.id = id;
			this.nombreProducto = nombreProducto;
			this.cantidad = cantidad;
			this.valor = valor;
			this.descripcion = descripcion;
			this.imagen = imagen;
		}

		public Producto() {
	
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
		
}
