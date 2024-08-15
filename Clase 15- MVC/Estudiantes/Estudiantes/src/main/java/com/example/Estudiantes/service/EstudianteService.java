package com.example.Estudiantes.service;

import com.example.Estudiantes.dao.EstudianteDAOLISTA;
import com.example.Estudiantes.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    private EstudianteDAOLISTA estudianteDAOLISTA;

    public EstudianteService() {
        estudianteDAOLISTA= new EstudianteDAOLISTA();
    }
    public List<Estudiante> buscarTodos(){
        return estudianteDAOLISTA.buscarTodos();
    }
}
