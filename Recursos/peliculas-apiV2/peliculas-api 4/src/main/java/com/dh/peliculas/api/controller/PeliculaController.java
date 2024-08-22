package com.dh.peliculas.api.controller;

import com.dh.peliculas.api.dto.PeliculaDTO;
import com.dh.peliculas.api.model.Pelicula;
import com.dh.peliculas.api.repository.impl.PeliculaListRepository;
import com.dh.peliculas.api.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private PeliculaService peliculaService = new PeliculaService(new PeliculaListRepository());

    @GetMapping
    public List<PeliculaDTO> buscarTodas() {
        return peliculaService.buscarTodas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (peliculaService.eliminar(id))
            response = ResponseEntity.status(HttpStatus.OK).build();
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
    @PostMapping
    public ResponseEntity<Pelicula> agregarPelicula(@RequestBody Pelicula pelicula){
        return  ResponseEntity.ok(peliculaService.agregarPelicula(pelicula));
    }
    @PutMapping
    public ResponseEntity<Pelicula> actualizarPelicula(@RequestBody Pelicula pelicula){
        return ResponseEntity.ok(peliculaService.actualizar(pelicula));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable Integer id){
        return ResponseEntity.ok(peliculaService.buscar(id));
    }






}
