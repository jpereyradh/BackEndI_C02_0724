package com.example.ClinicaOdontologicaSpringMVC.Service;

import com.example.ClinicaOdontologicaSpringMVC.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Turno;
import com.example.ClinicaOdontologicaSpringMVC.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoDTO registrarTurno(Turno turno){
        Turno turnoGuardado= turnoRepository.save(turno);
        return turnoATurnoDTO(turnoGuardado);
    }


    public TurnoDTO turnoATurnoDTO(Turno turno){
        TurnoDTO dto= new TurnoDTO();
        dto.setId(turno.getId());
        dto.setPacienteId(turno.getPaciente().getId());
        dto.setOdontologoId(turno.getOdontologo().getId());
        dto.setFecha(turno.getFecha());
        return dto;

    }
}
