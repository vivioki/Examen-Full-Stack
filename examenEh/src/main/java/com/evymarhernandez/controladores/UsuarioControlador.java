package com.evymarhernandez.controladores;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.evymarhernandez.modelos.Usuario;
import com.evymarhernandez.modelos.UsuarioLogin;
import com.evymarhernandez.servicios.ServicioUsuario;

@Controller
public class UsuarioControlador {

	@Autowired
    private ServicioUsuario servicioUsuario;
	//
	@GetMapping("/")
    public String home() {
        return "NewFile";
    }
	//

	/*
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nuevoUsuario", new Usuario());
        model.addAttribute("usuarioLogin", new UsuarioLogin());
        return "index";
    }*/

    //REGISTRAR
    @PostMapping("/registrar")
    public String registrar(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, 
                            BindingResult result, 
                            Model model, HttpSession sesion) {
        if (result.hasErrors()) {
            return "index";
        }
        
        Usuario usuarioExistente = servicioUsuario.obtenerUsuarioPorEmail(nuevoUsuario.getCorreo());
        //VALIDATION
        if (usuarioExistente != null) {
            result.rejectValue("correo", "error.usuario", "El correo ya está en uso.");
            return "index";
        }
        servicioUsuario.insertarUsuario(nuevoUsuario);
        sesion.setAttribute("user", nuevoUsuario.getNombre());
        sesion.setAttribute("userId", nuevoUsuario.getId());
        return "redirect:/programas";
    }

    //LOING
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, 
                        BindingResult result, 
                        Model model, HttpSession sesion) {
        if (result.hasErrors()) {
            return "index";
        }
        Usuario usuario = servicioUsuario.obtenerUsuarioPorEmailYPassword(usuarioLogin);
      //VALIDATION
        if (usuario == null) {
            result.rejectValue("usuarioCorreo", "error.usuarioLogin", "Correo o contraseña incorrectos.");
            
            return "index";
        }
        model.addAttribute("usuario", usuario);
        sesion.setAttribute("user", usuario.getNombre());
        sesion.setAttribute("userId", usuario.getId());
        return "redirect:/programas";
    }
    
	//LOGOUT DE LA SESION
	@GetMapping("/logout")
	public String procesarLogout(HttpSession sesion) {
		sesion.invalidate();
		return "index";
	}
}
