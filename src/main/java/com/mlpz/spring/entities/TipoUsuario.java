package com.mlpz.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario" )
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String funciones;
	
	public TipoUsuario() {
		
	}
	
	public TipoUsuario(int id) {
		this.id = id;
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
	public String getFunciones() {
		return funciones;
	}
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	
	
}
