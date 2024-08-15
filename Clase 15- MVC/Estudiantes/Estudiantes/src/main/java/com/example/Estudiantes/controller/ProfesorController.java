package com.example.Estudiantes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {


    @GetMapping("/todos")
    public String buscarTodos(){
        return "Todos los profesores";
    }
}
