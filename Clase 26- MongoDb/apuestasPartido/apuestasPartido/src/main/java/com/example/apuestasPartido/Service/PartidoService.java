package com.example.apuestasPartido.Service;

import com.example.apuestasPartido.Entity.Partido;
import com.example.apuestasPartido.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido registrarPartido(Partido partido){
        return partidoRepository.save(partido);
    }
}
