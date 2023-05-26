package com.mlpz.spring.controllers;

import java.util.List;

import com.mlpz.spring.dto.AuthToken;
import com.mlpz.spring.dto.Message;
import com.mlpz.spring.entities.Usuario;
import com.mlpz.spring.jwt.JwtUtils;
import com.mlpz.spring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	private UsuarioService usuarioService;
	private final JwtUtils jwtUtils;

	public UsuarioController(JwtUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
	}

	@Autowired
	public UsuarioController(UsuarioService usuarioService, JwtUtils jwtUtils) {
		this.usuarioService = usuarioService;
		this.jwtUtils = jwtUtils;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> allUsers(){
		List<Usuario> usuarios = usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id){
		Usuario usuario = usuarioService.getOne(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<Usuario> findByUsername(@PathVariable("username") String username){
		Usuario usuario = usuarioService.getByUsername(username);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/dni/{dni}")
	public ResponseEntity<Usuario> findByDNI(@PathVariable("dni") String dni){
		Usuario usuario = usuarioService.getByDNI(dni);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Usuario usuario){
		usuarioService.save(usuario);
		return new ResponseEntity<>("Usuario save successfully", HttpStatus.OK);
	}

	@PutMapping("/pass/")
	public ResponseEntity<?> updatePassword(@RequestBody Usuario usuario) {
		Usuario usuarioAux = usuarioService.getByUsername(usuario.getUsername());
		usuarioAux.setContrasena(usuario.getContrasena());
		usuarioService.save(usuarioAux);
		return new ResponseEntity<>("Password change successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
		Usuario usuario = usuarioService.getByUsername(username);
		usuarioService.delete(usuario);
		return new ResponseEntity<>("User delete successfully", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario usuario){
		if(!usuarioService.checkLogin(usuario.getUsername(), usuario.getContrasena())) {
			return new ResponseEntity<>(new Message("Username or password incorrect!"), HttpStatus.UNAUTHORIZED);
		}
		String token = jwtUtils.generateAuthToken(usuario.getUsername());
		return ResponseEntity.ok(new AuthToken(token));
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> getByToken(@RequestBody String token){
		String username = jwtUtils.extractUsername(token);
		if(!usuarioService.checkUsername(username)){
			return new ResponseEntity<>(new Message("Token incorrect!"), HttpStatus.UNAUTHORIZED);
		}
		Usuario usuario = usuarioService.getByUsername(username);
		return new ResponseEntity<Usuario>(usuario ,HttpStatus.OK);
	}
}
