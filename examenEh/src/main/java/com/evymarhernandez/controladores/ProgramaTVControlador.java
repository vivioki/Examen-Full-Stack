package com.evymarhernandez.controladores;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.evymarhernandez.modelos.ProgramaTV;
import com.evymarhernandez.modelos.Usuario;
import com.evymarhernandez.servicios.ServicioProgramaTV;
import com.evymarhernandez.servicios.ServicioUsuario;

@Controller
@RequestMapping("/programas")
public class ProgramaTVControlador {

	@Autowired
    private ServicioProgramaTV servicioProgramaTV;
	
	@Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping
    public String mostrarProgramas(Model model, HttpSession sesion) {
    	
    	System.out.println("NAMEEEE: " + sesion.getAttribute("user"));
        model.addAttribute("programas", servicioProgramaTV.obtenerTodosLosProgramas());
        model.addAttribute("usuario", sesion.getAttribute("user"));
        return "programas";
    }

    @GetMapping("/nuevo")
    public String nuevoPrograma(Model model) {
        model.addAttribute("programa", new ProgramaTV());
        return "nuevoPrograma";
    }

    //CREAR
    @PostMapping("/crear")
    public String crearPrograma(@Valid @ModelAttribute("programa") ProgramaTV programa, 
                                BindingResult result, Model model, HttpSession sesion) {
        if (result.hasErrors()) {
            return "nuevoPrograma";
        }
        String userId = sesion.getAttribute("userId").toString();
        Usuario usuarioExistente = servicioUsuario.obtenerUsuarioPorId(Long.parseLong(userId));
        //VALIDACION
        if (result.hasErrors()) {
            return "redirect:/programas";
        }
        programa.setUsuario(usuarioExistente);
        servicioProgramaTV.insertarPrograma(programa);
        return "redirect:/programas";
    }

    //MOSTRAR
    @GetMapping("/{id}")
    public String mostrarPrograma(@PathVariable("id") Long id, Model model) {
        ProgramaTV programa = servicioProgramaTV.obtenerProgramaPorId(id);

        if (programa == null) {
            return "redirect:/programas";
        }
        model.addAttribute("programa", programa);
        model.addAttribute("usuario", programa.getUsuario().getNombre());
        return "mostrarPrograma";
    }

    //EDITAR
    @GetMapping("/{id}/editar")
    public String editarPrograma(@PathVariable("id") Long id, Model model) {
   
        ProgramaTV programa = servicioProgramaTV.obtenerProgramaPorId(id);
        if (programa == null) {
            return "redirect:/programas";
        }
     
        model.addAttribute("programa", programa);
        model.addAttribute("usuario", programa.getUsuario().getNombre());
        return "editarPrograma";
    }

    //ACTULIZAR
    @PostMapping("/{id}/actualizar")
    public String actualizarPrograma(@PathVariable("id") Long id, 
                                     @Valid @ModelAttribute("programa") ProgramaTV programa, 
                                     BindingResult result, HttpSession sesion) {
        if (programa == null) {
            return "editarPrograma";
        }
        
        String userId = sesion.getAttribute("userId").toString();
        Usuario usuarioExistente = servicioUsuario.obtenerUsuarioPorId(Long.parseLong(userId));
        //VALIDACION
        if (result.hasErrors()) {
        	//result.rejectValue("tituloEditar", "error.programaEditar", "El correo ya está en uso.");
        	
            return "editarPrograma";
        }
        programa.setUsuario(usuarioExistente);
        
        programa.setId(id);
        servicioProgramaTV.actualizarPrograma(programa);
        return "redirect:/programas";
    }

    //ELIMINAR
    @PostMapping("/{id}/eliminar")
    public String eliminarPrograma(@PathVariable("id") Long id) {
        servicioProgramaTV.eliminarPrograma(id);
        return "redirect:/programas";
    }
}
