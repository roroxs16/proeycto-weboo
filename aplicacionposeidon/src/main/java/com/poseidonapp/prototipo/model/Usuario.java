package com.poseidonapp.prototipo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Debe ingresar su Nombre")
	@Size(min=3,max=150, message="El apellido ingresado debe tener mas de 3 caracteres")
	@Column(name = "nombre")
	private String nombre;

	@NotEmpty(message="Debe ingresar su Apellido")
	@Size(min=3,max=150, message="El apellido ingresado debe tener mas de 3 caracteres")
	@Column(name = "apellidos")
	private String apellidos;

	@NotEmpty(message="Debe ingresar una Password")
	@Size(min=6,max=25, message="La Password ingresada debe tener mas de 6 caracteres")
	@Column(name = "password")
	private String password;

	// este es el usuario de logeo
	@Email
	@NotEmpty(message="Debe ingresar un correo electronico valido")
	@Column(name = "correo", unique = true)
	private String correo;
	
	@NotEmpty(message="Debe ingresar una dirección valida")
	@Column(name = "direccion")
	private String direccion;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@NotEmpty(message="Debe ingresar un Rut valida")
	@Column(name = "run")
	private String run;
	
	@NotEmpty(message="Debe ingresar una ciudad valida")
	@Column(name = "ciudad")
	private String ciudad;


	@Column(name = "telefono")
	private Long telefono;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rol> roles;


	public Usuario(int id, String nombre, String apellidos, String password, @Email String correo, String direccion,
			Date fechaNacimiento, String run, String ciudad, Long telefono, List<Rol> roles) {
		super();
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

	/**
	 * 
	 */
	private static final long serialVersionUID = -8345568794830008231L;

}
