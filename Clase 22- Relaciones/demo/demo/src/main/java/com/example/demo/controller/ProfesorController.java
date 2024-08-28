package com.example.demo.controller;

import com.example.demo.entity.Profesor;
import com.example.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;


    @PostMapping
    public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.registrarProfesor(profesor));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id){
        Optional<Profesor> profesorBuscado= profesorService.buscarPorID(id);
        if(profesorBuscado.isPresent()){
            profesorService.eliminarProfesor(id);
            return ResponseEntity.ok("profesor eliminado con exito");
        }else {
            return ResponseEntity.badRequest().body("profesor no encontrado");
        }
    }
}
