package com.mlpz.spring.services;

import java.util.List;

import com.mlpz.spring.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlpz.spring.entities.Asignatura;

@Service
@Transactional
public class AsignaturaService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}
	
	public Asignatura getById(int id) {
		return asignaturaRepository.findById(id).get();
	}
	
	public Asignatura getByName(String nombre) {
		return asignaturaRepository.findByNombre(nombre);
	}
	
    public void save(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    public void delete(Integer id) {
        asignaturaRepository.deleteById(id);
    }	
}
