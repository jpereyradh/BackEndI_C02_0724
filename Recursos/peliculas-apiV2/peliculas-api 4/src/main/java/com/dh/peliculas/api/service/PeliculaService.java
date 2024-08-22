package com.dh.peliculas.api.service;

import com.dh.peliculas.api.dto.PeliculaDTO;
import com.dh.peliculas.api.model.Pelicula;
import com.dh.peliculas.api.repository.IRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class PeliculaService {

    private IRepository<Pelicula> peliculaRepository;

    public PeliculaService(IRepository<Pelicula> peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Pelicula agregarPelicula(Pelicula pelicula){
        return this.peliculaRepository.agregar(pelicula);
    }
    public List<PeliculaDTO> buscarTodas(){
        ObjectMapper mapper = new ObjectMapper();
        List<Pelicula> peliculas = peliculaRepository.buscar();
        List<PeliculaDTO> peliculasDTO = new ArrayList<PeliculaDTO>();

        for(Pelicula pelicula : peliculas) {
            PeliculaDTO peliculaDTO = mapper.convertValue(pelicula,PeliculaDTO.class);
            peliculasDTO.add(peliculaDTO);
        }

        return peliculasDTO;
    }

    public Boolean eliminar(Integer id){
        return peliculaRepository.eliminar(id);
    }

    public Pelicula actualizar(Pelicula pelicula){return peliculaRepository.actualizar(pelicula);}

    public Pelicula buscar(Integer id){return peliculaRepository.buscar(id);}


}
