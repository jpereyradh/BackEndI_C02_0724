package com.example.demo.service;

import com.example.demo.entity.Profesor;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor registrarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }
    public Optional<Profesor> buscarPorID(Long id){
        return profesorRepository.findById(id);
    }
    public void eliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }
}
