package com.mlpz.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlpz.spring.entities.Usuario;
import com.mlpz.spring.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario getOne(int id) {
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario getByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	public Usuario getByDNI(String dni) {
		return usuarioRepository.findByDni(dni);
	}
	
	public boolean checkLogin(String username, String password) {
		return usuarioRepository.existsByUsernameAndContrasena(username, password);
	}
	
	public boolean checkUsername(String username) {
		return usuarioRepository.existsByUsername(username);
	}
	
	public Usuario login(String username, String password) {
		return usuarioRepository.findByUsernameAndContrasena(username, password);
	}
	
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
    
    public void delete(Usuario usuario) {
    	usuarioRepository.delete(usuario);
    }
    
}
