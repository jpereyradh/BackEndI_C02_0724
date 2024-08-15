package com.example.Estudiantes.controller;

import com.example.Estudiantes.model.Estudiante;
import com.example.Estudiantes.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    private EstudianteService estudianteService;

    public EstudianteController() {
        estudianteService= new EstudianteService();
    }

    @GetMapping("/todos")
    public List<Estudiante> obtenerTodos(){
        return estudianteService.buscarTodos();
    }
}
