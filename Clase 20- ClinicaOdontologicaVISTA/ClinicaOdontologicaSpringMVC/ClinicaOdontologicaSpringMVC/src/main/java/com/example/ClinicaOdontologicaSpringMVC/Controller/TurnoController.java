package com.example.ClinicaOdontologicaSpringMVC.Controller;

import com.example.ClinicaOdontologicaSpringMVC.Model.Odontologo;
import com.example.ClinicaOdontologicaSpringMVC.Model.Paciente;
import com.example.ClinicaOdontologicaSpringMVC.Model.Turno;
import com.example.ClinicaOdontologicaSpringMVC.Service.OdontologoService;
import com.example.ClinicaOdontologicaSpringMVC.Service.PacienteService;
import com.example.ClinicaOdontologicaSpringMVC.Service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoController() {
        turnoService= new TurnoService();
        pacienteService= new PacienteService();
        odontologoService= new OdontologoService();
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        Paciente pacienteBuscado= pacienteService.buscarPorID(turno.getPaciente().getId());
        Odontologo odontologoBuscado= odontologoService.buscarPorId(turno.getOdontologo().getId());
        if(pacienteBuscado!=null&&odontologoBuscado!=null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno)); //si el retorno es correcto , seria un 200
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
}
