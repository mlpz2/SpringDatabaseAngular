package com.mlpz.spring.repositories;

import com.mlpz.spring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(@Param("username") String username);
	Usuario findByUsernameAndContrasena(@Param("username") String username, @Param("contrasena") String contrasena);
	Usuario findByDni(String dni);
	boolean existsByUsername(@Param("username") String username);
	boolean existsByUsernameAndContrasena(@Param("username") String username, @Param("contrasena") String contrasena);
}
