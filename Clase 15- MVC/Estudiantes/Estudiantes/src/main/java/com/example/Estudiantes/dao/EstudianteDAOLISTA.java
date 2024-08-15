package com.example.Estudiantes.dao;

import com.example.Estudiantes.model.Estudiante;

import java.util.Arrays;
import java.util.List;

public class EstudianteDAOLISTA implements iDao<Estudiante>{
    @Override
    public List<Estudiante> buscarTodos() {

        return Arrays.asList(new Estudiante("Julian","Espinoza"), new Estudiante("Jesus","Mendoza"), new Estudiante("Eduardo", "Gonzalez"));
    }
}
