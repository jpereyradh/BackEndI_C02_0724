package com.dh.peliculas.api.repository;

import java.util.List;

public interface IRepository<T> {

    T agregar(T t);
    List<T> buscar();
    T actualizar(T t);
    Boolean eliminar(Integer id);
    T buscar(Integer id);

}
