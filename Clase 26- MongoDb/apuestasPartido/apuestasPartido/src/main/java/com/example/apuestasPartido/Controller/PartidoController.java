package com.example.apuestasPartido.Controller;

import com.example.apuestasPartido.Entity.Partido;
import com.example.apuestasPartido.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partido")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;


    @PostMapping
    public ResponseEntity<Partido> registrarPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(partidoService.registrarPartido(partido));
    }
}
