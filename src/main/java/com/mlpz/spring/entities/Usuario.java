package com.mlpz.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String dni;
	protected String nombre;
	protected String apellido;
	@Column(name = "usuario")
	protected String username;
	protected String contrasena;
	protected String email;
	protected String foto;
	protected String direccion;
	protected String telefono;
	@Column(name = "tipo")
	protected int tipoUsuario;
	protected boolean activo;
	
	public Usuario() {
		
	}
	
	public Usuario(int id) {
		this.id = id;
	}
	
	public Usuario(int id, String contrasena) {
		this.id = id;
		this.contrasena = contrasena;
	}
	
	public Usuario(String username, String contrasena) {
		this.username = username;
		this.contrasena = contrasena;
	}

	public Usuario(String dni, String nombre, String apellido, String username, String contrasena, int tipoUsuario,
			boolean activo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.activo = activo;
	}

	
	public Usuario(int id, String dni, String nombre, String apellido, String username, String contrasena, int tipoUsuario,
			boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.activo = activo;
	}

	public Usuario(int id, String dni, String nombre, String apellido, String username, String contrasena, String foto,
			String direccion, String telefono, int tipoUsuario, boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasena = contrasena;
		this.foto = foto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.activo = activo;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", username="
				+ username + ", contrasena=" + contrasena + ", email=" + email + ", foto=" + foto + ", direccion="
				+ direccion + ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + ", activo=" + activo + "]";
	}
	
	
}
