package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.poseidonapp.prototipo.validator.ValidAge;
import com.poseidonapp.prototipo.validator.ValidRut;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Campo obligatorio (*)")
	@NotEmpty(message="Debe ingresar su Nombre")
	@Size(min=3,max=150, message="El apellido ingresado debe tener mas de 3 caracteres")
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank(message="Campo obligatorio (*)")
	@NotEmpty(message="Debe ingresar su Apellido")
	@Size(min=3,max=150, message="El apellido ingresado debe tener mas de 3 caracteres")
	@Column(name = "apellidos")
	private String apellidos;

	@NotBlank(message="Campo obligatorio (*)")
	@NotEmpty(message="Debe ingresar una Password")
	@Column(name = "password")
	private String password;

	// este es el usuario de logeo
	@NotEmpty
	@Email
	@NotEmpty(message="Debe ingresar un correo electronico valido")
	@Column(name = "correo", unique = true)
	private String correo;
	
	@NotBlank(message="Campo obligatorio (*)")
	@NotEmpty(message="Debe ingresar una dirección valida")
	@Column(name = "direccion")
	private String direccion;
	
	@ValidAge(message = "El Socio debe ser mayor de 18 años")
	@NotNull(message="Campo obligatorio (*)")
	@Past(message = "La fecha de pago debe ser anterior a la fecha actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	@NotBlank(message="Campo obligatorio (*)")
	@ValidRut(message="Ingrese un Rut válido")
	@Column(name = "run")
	private String run;
	
	@NotBlank(message="Campo obligatorio (*)")
	@NotEmpty(message="Debe ingresar una ciudad valida")
	@Column(name = "ciudad")
	private String ciudad;

	@NotNull(message="Campo obligatorio (*)")
	@Range(min=100000000, max=999999999 , message="Ingrese un número de teléfono de 9 digitos")
	@Column(name = "telefono")
	private Long telefono;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Rol> roles;


		

		public Usuario(int id,
			@NotBlank(message = "Campo obligatorio (*)") @NotEmpty(message = "Debe ingresar su Nombre") @Size(min = 3, max = 150, message = "El apellido ingresado debe tener mas de 3 caracteres") String nombre,
			@NotBlank(message = "Campo obligatorio (*)") @NotEmpty(message = "Debe ingresar su Apellido") @Size(min = 3, max = 150, message = "El apellido ingresado debe tener mas de 3 caracteres") String apellidos,
			@NotBlank(message = "Campo obligatorio (*)") @NotEmpty(message = "Debe ingresar una Password") String password,
			@NotEmpty @Email @NotEmpty(message = "Debe ingresar un correo electronico valido") String correo,
			@NotBlank(message = "Campo obligatorio (*)") @NotEmpty(message = "Debe ingresar una dirección valida") String direccion,
			@NotNull(message = "Campo obligatorio (*)") @Past(message = "La fecha de pago debe ser anterior a la fecha actual") Date fechaNacimiento,
			@NotBlank(message = "Campo obligatorio (*)") String run,
			@NotBlank(message = "Campo obligatorio (*)") @NotEmpty(message = "Debe ingresar una ciudad valida") String ciudad,
			@NotNull(message = "Campo obligatorio (*)") @Range(min = 100000000, max = 999999999, message = "Ingrese un número de teléfono de 9 digitos") Long telefono,
			List<Rol> roles, List<Venta> ventas) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.roles = roles;
	}

		public Usuario() {

	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	
/*
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
*/


	/**
	 * 
	 */
	private static final long serialVersionUID = -8345568794830008231L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
