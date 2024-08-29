package com.example.directorTecnico.service;

import com.example.directorTecnico.entity.DirectorTecnico;
import com.example.directorTecnico.repository.DirectorTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorTecnicoService {
    @Autowired
    private DirectorTecnicoRepository directorTecnicoRepository;


    public DirectorTecnico registrarTecnico(DirectorTecnico directorTecnico){
        return directorTecnicoRepository.save(directorTecnico);
    }
    public Optional<DirectorTecnico> buscarPorNombre(String nombre){
        return directorTecnicoRepository.buscarTenicoPorNombre(nombre);
    }
    public List<DirectorTecnico> buscarMayorQue(Integer edad){
        return directorTecnicoRepository.findByEdadGreaterThan(edad);
    }
}
