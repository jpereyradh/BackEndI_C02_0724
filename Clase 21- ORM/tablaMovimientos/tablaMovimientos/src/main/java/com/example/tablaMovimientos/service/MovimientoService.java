package com.example.tablaMovimientos.service;

import com.example.tablaMovimientos.entity.Movimiento;
import com.example.tablaMovimientos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
    public Optional<Movimiento> buscarPorId(Long id){
        return movimientoRepository.findById(id);
    }
    public void actualizarMovimiento(Movimiento movimiento){
        movimientoRepository.save(movimiento);
    }
    public void eliminarUnMovimiento(Long id){
        movimientoRepository.deleteById(id);
    }
    public List<Movimiento> listarTodos(){
        return movimientoRepository.findAll();
    }

}
