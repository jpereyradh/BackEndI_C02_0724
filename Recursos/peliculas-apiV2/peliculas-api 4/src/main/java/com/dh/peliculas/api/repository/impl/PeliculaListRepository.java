package com.dh.peliculas.api.repository.impl;
import com.dh.peliculas.api.model.Pelicula;
import com.dh.peliculas.api.repository.IRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class PeliculaListRepository  implements IRepository<Pelicula> {

    private List<Pelicula> peliculas;

    public PeliculaListRepository() {
        this.peliculas = cargarPeliculas();
    }

    @Override
    public Pelicula agregar(Pelicula pelicula) {
        if(pelicula.getId() == null)
            pelicula.setId(new Random().nextInt());
        this.peliculas.add(pelicula);
        return pelicula;

    }

    @Override
    public List<Pelicula> buscar() {
        return this.peliculas;
    }

    @Override
    public Pelicula actualizar(Pelicula pelicula) {
        eliminar(pelicula.getId());
        agregar(pelicula);
        return pelicula;
    }

    @Override
    public Boolean eliminar(Integer id) {

        for(Pelicula pelicula : peliculas){
            if(pelicula.getId().equals(id)){
                peliculas.remove(pelicula);
                return true;
            }
        }
        return false;
    }

    @Override
    public Pelicula buscar(Integer id) {
        for(Pelicula pelicula : peliculas){
            if(pelicula.getId().equals(id)){
               return pelicula;
            }
        }
        return null;
    }


    private List<Pelicula> cargarPeliculas(){
        List<Pelicula> peliculasCargadas = new ArrayList<>();
        peliculasCargadas.add(new Pelicula(1,"Star Wars" , "Ficcion",7));
        peliculasCargadas.add(new Pelicula(2,"It" , "Terror",0));
        return peliculasCargadas;
    }
}
