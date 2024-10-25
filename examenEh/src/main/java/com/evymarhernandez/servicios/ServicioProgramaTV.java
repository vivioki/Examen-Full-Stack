package com.evymarhernandez.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evymarhernandez.modelos.ProgramaTV;
import com.evymarhernandez.repositorios.ProgramaTVRepositorio;

@Service
public class ServicioProgramaTV {

	@Autowired
    private final ProgramaTVRepositorio programaTVRepository;

    public ServicioProgramaTV(ProgramaTVRepositorio programaTVRepository) {
        this.programaTVRepository = programaTVRepository;
    }

    //OBTNER LOS PROGRAMAS
    public List<ProgramaTV> obtenerTodosLosProgramas() {
        return this.programaTVRepository.findAll();
    }

    //INSERTAR PROGRAM
    public ProgramaTV insertarPrograma(ProgramaTV nuevoPrograma) {
        return this.programaTVRepository.save(nuevoPrograma);
    }

    //ELIMINAR PROGRAM
    public void eliminarPrograma(Long id) {
        this.programaTVRepository.deleteById(id);
    }

    //OBTNER PROGRAM POR ID
    public ProgramaTV obtenerProgramaPorId(Long id) {
        return this.programaTVRepository.findById(id).orElse(null);
    }

    //ACTUALIZAR PROGRAM
    public ProgramaTV actualizarPrograma(ProgramaTV programa) {
        return this.programaTVRepository.save(programa);
    }
}
