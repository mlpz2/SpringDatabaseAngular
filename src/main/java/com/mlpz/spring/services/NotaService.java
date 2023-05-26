package com.mlpz.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlpz.spring.entities.Asignatura;
import com.mlpz.spring.entities.Curso;
import com.mlpz.spring.entities.Nota;
import com.mlpz.spring.entities.Usuario;
import com.mlpz.spring.repositories.NotaRepository;


@Service
@Transactional
public class NotaService {
	
	private final NotaRepository notaRepository;

	public NotaService(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
	}

	public List<Nota> getByCursoAndAlumno(Curso curso, Usuario alumno){
		return notaRepository.findByCursoAndAlumno(curso, alumno);
	}

	public List<Nota> getByCursoAndAsignatura(Curso curso, Asignatura asignatura){
		return notaRepository.findByCursoAndAsignatura(curso, asignatura);
	}

	public List<Nota> getByAsignaturaAndAlumno(Asignatura asignatura, Usuario alumno){
		return notaRepository.findByAsignaturaAndAlumno(asignatura, alumno);
	}	
	
	public List<Nota> findNotas(String dniAlumno, String nombreCurso, String nombreAsignatura){
		List<Nota> notas = notaRepository.findAll();
		if(dniAlumno != null && dniAlumno != "") {
			notas = notas.stream().filter(nota -> nota.getAlumno().getDni().equals(dniAlumno)).collect(Collectors.toList());;
		}
		if(nombreCurso != null && nombreCurso != "") {
			notas = notas.stream().filter(nota -> nota.getCurso().getNombre().equals(nombreCurso)).collect(Collectors.toList());;
		}
		if(nombreAsignatura != null && nombreAsignatura != "") {
			notas = notas.stream().filter(nota -> nota.getAsignatura().getNombre().equals(nombreAsignatura)).collect(Collectors.toList());;
		}	
		return notas;
	}
	
	public boolean existsById(int id) {
		return notaRepository.existsById(id);
	}
	
	public void save(Nota nota) {
		notaRepository.save(nota);
	}
	
	public void delete(Nota nota) {
		notaRepository.delete(nota);
	}
	
	public void deleteById(int id) {
		notaRepository.deleteById(id);
	}
	
}
