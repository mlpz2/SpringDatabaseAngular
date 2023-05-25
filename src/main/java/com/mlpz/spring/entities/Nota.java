package com.mlpz.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private Usuario alumno;
	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private Asignatura asignatura;
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	private float nota;
	
	public Nota() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getAlumno() {
		return alumno;
	}

	public void setAlumno(Usuario alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}


}
