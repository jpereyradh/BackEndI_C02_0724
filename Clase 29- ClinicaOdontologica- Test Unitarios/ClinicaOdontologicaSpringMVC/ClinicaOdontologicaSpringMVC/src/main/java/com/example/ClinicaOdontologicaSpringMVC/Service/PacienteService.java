package com.example.ClinicaOdontologicaSpringMVC.Service;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Paciente;
import com.example.ClinicaOdontologicaSpringMVC.Repository.PacienteRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;


    public Paciente registrarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }
    public void actualizarPaciente(Paciente paciente){
        Optional<Paciente> pacienteBuscado= pacienteRepository.findById(paciente.getId());
        if(pacienteBuscado.isPresent()){
        pacienteRepository.save(paciente);
    }else{
            System.out.println("paciente no encontrado");
        }
    }
public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
}
public void eliminarPaciente(Long id){
        Optional<Paciente> pacienteBuscado= pacienteRepository.findById(id);
        if(pacienteBuscado.isPresent()){
            pacienteRepository.deleteById(id);
        }else
            System.out.println("paciente no encontrado");
}
}
