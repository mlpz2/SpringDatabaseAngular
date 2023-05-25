package com.mlpz.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	@Column(name = "id_profesor1")
	private int titular;
	@Column(name = "id_profesor2", nullable = true)
	private Integer suplente;
	
	public Asignatura() {
		
	}
	
	public Asignatura(int id) {
		this.id = id;
	}

	public Asignatura(String nombre) {
		this.nombre = nombre;
	}
	
	public Asignatura(String nombre, int titular) {
		this.nombre = nombre;
		this.titular = titular;
	}

	public Asignatura(String nombre, int titular, int suplente) {
		this.nombre = nombre;
		this.titular = titular;
		this.suplente = suplente;
	}


	public Asignatura(int id, String nombre, int titular) {
		this.id = id;
		this.nombre = nombre;
		this.titular = titular;
	}
		
	public Asignatura(int id, String nombre, int titular, int suplente) {
		this.id = id;
		this.nombre = nombre;
		this.titular = titular;
		this.suplente = suplente;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTitular() {
		return titular;
	}
	public void setTitular(int titular) {
		this.titular = titular;
	}
	public Integer getSuplente() {
		return suplente;
	}
	public void setSuplente(int suplente) {
		this.suplente = suplente;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", titular=" + titular + ", suplente=" + suplente + "]";
	}
	
	
}
