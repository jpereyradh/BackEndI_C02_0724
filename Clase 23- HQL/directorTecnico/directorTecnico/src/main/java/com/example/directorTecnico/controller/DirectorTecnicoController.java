package com.example.directorTecnico.controller;

import com.example.directorTecnico.entity.DirectorTecnico;
import com.example.directorTecnico.service.DirectorTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directorTecnico")
public class DirectorTecnicoController {
    @Autowired
    private DirectorTecnicoService directorTecnicoService;

    @PostMapping
    public ResponseEntity<DirectorTecnico> registrarTecnico(@RequestBody DirectorTecnico directorTecnico){
        return ResponseEntity.ok(directorTecnicoService.registrarTecnico(directorTecnico));
    }
    @GetMapping("/mayor/{edad}")
    public ResponseEntity<List<DirectorTecnico>> buscarMayorQue(@PathVariable Integer edad){
        return ResponseEntity.ok(directorTecnicoService.buscarMayorQue(edad));
    }
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Optional<DirectorTecnico>> buscarPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(directorTecnicoService.buscarPorNombre(nombre));
    }
}
