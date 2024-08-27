package com.example.tablaMovimientos.controller;

import com.example.tablaMovimientos.entity.Movimiento;
import com.example.tablaMovimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.guardarMovimiento(movimiento));
    }
    @GetMapping
    public ResponseEntity<List<Movimiento>> listarTodos(){
        return ResponseEntity.ok(movimientoService.listarTodos());
    }
}
