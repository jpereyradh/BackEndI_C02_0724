package com.example.ClinicaOdontologicaSpringMVC.Service;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Domicilio;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPaciente(){
        Paciente paciente= new Paciente("jorgito","Pereyra","1111111", LocalDate.of(2024,9,10),new Domicilio("Calle 1",12,"La Rioja","La Rioja"),"jorgito@jorgito.com");
        Paciente pacienteGuardado= pacienteService.registrarPaciente(paciente);
        assertEquals(1L,pacienteGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarPaciente(){
        Long id=1L;
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorId(id);
        assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void actualizarPaciente(){
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorId(1L);
        if(pacienteBuscado.isPresent()){
            pacienteBuscado.get().setApellido("Perez");
        }
        pacienteService.actualizarPaciente(pacienteBuscado.get());
        assertEquals("Perez",pacienteBuscado.get().getApellido());
    }
    @Test
    @Order(4)
    public void listarTodos(){
        List<Paciente> pacientes= pacienteService.listarTodos();
        assertEquals(1,pacientes.size());
    }
    @Test
    @Order(5)
    public void eliminaPaciente(){
        pacienteService.eliminarPaciente(1L);
        Optional<Paciente> pacienteEliminado= pacienteService.buscarPorId(1L);
        assertFalse(pacienteEliminado.isPresent());
    }
}
