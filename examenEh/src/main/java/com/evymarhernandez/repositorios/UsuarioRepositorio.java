package com.evymarhernandez.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evymarhernandez.modelos.Usuario;



@Repository
public interface UsuarioRepositorio extends CrudRepository<com.evymarhernandez.modelos.Usuario, Long>{

	//SELECT * FROM USUARIOS;
	List<com.evymarhernandez.modelos.Usuario> findAll();

	Usuario findByCorreo(String correo);
}
