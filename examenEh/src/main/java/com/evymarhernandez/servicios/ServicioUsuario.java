package com.evymarhernandez.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.evymarhernandez.modelos.Usuario;
import com.evymarhernandez.modelos.UsuarioLogin;
import com.evymarhernandez.repositorios.UsuarioRepositorio;

@Service
public class ServicioUsuario {

	private final UsuarioRepositorio repositorioUsuario;

    public ServicioUsuario(UsuarioRepositorio repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return this.repositorioUsuario.findAll();
    }

    //INSERTAR USUARIO
    public Usuario insertarUsuario(Usuario nuevoUsuario) {
        String passwordEncriptada = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
        nuevoUsuario.setPassword(passwordEncriptada);
        return this.repositorioUsuario.save(nuevoUsuario);
    }

    //ELIMINAR USUARIO
    public void eliminarUsuario(Long id) {
        this.repositorioUsuario.deleteById(id);
    }

    //OBTENER USUARIO POR ID
    public Usuario obtenerUsuarioPorId(Long id) {
        return this.repositorioUsuario.findById(id).orElse(null);
    }

    //ACTUALIZAR USUARIO
    public Usuario actualizarUsuario(Usuario usuario) {
        return this.repositorioUsuario.save(usuario);
    }

    //OBTENER USUARIO POR EMAIL
    public Usuario obtenerUsuarioPorEmail(String correo) {
        return this.repositorioUsuario.findByCorreo(correo);
    }
    
    //OBTENER USUARIO POR EMAIL Y PASS
    public Usuario obtenerUsuarioPorEmailYPassword(UsuarioLogin usuarioLogin) {
        Usuario usuarioActual = this.repositorioUsuario.findByCorreo(usuarioLogin.getUsuarioCorreo());

        //VERIFICAR SI USUARIO EXISTE
        if (usuarioActual == null) {
            return null;
        }

        if (BCrypt.checkpw(usuarioLogin.getUsuarioPassword(), usuarioActual.getPassword())) {
            return usuarioActual;
        } else {
            return null;
        }
    }
}
