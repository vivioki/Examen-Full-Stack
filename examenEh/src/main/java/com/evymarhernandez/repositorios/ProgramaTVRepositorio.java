package com.evymarhernandez.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evymarhernandez.modelos.ProgramaTV;

@Repository
public interface ProgramaTVRepositorio extends CrudRepository<ProgramaTV, Long>{

	List<ProgramaTV> findAll();
}
