package com.example.tablaMovimientos.repository;

import com.example.tablaMovimientos.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    //metodos comunes

}
