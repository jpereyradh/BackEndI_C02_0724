package com.example.ClinicaOdontologicaSpringMVC;

import com.example.ClinicaOdontologicaSpringMVC.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Domicilio;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Odontologo;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Paciente;
import com.example.ClinicaOdontologicaSpringMVC.Entity.Turno;
import com.example.ClinicaOdontologicaSpringMVC.Service.OdontologoService;
import com.example.ClinicaOdontologicaSpringMVC.Service.PacienteService;
import com.example.ClinicaOdontologicaSpringMVC.Service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //no necesito login en esta clase
public class TurnoIntegracionTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private MockMvc mockMvc;


    public void cargarTurnos(){
        Paciente paciente1= pacienteService.registrarPaciente(new Paciente("Matias","Santos","111111", LocalDate.of(2024,9,12),new Domicilio("Calle 1",122,"Uruguay","Montevideo"),"matiassantos@digitalhouse.com"));
        Paciente paciente2= pacienteService.registrarPaciente(new Paciente("Helen","Vasquez","1112221", LocalDate.of(2024,9,12),new Domicilio("Calle 2",122,"Lima","Peru"),"helenvasquez@digitalhouse.com"));
        Odontologo odontologo1= odontologoService.registrarOdontologo(new Odontologo("Juan","Maldonado","MP10"));
        Odontologo odontologo2= odontologoService.registrarOdontologo(new Odontologo("Daniela","Paz","MP20"));
        TurnoDTO turnoDTO1= turnoService.registrarTurno(new Turno(paciente1,odontologo1,LocalDate.of(2024,11,12)));
        TurnoDTO turnoDTO2= turnoService.registrarTurno(new Turno(paciente2,odontologo2,LocalDate.of(2024,12,20)));
            }

     @Test
    public void listarTodosLosTurnos() throws Exception{
        cargarTurnos();
         MvcResult resultado= mockMvc.perform(MockMvcRequestBuilders.get("/turno").accept(MediaType.APPLICATION_JSON))
                 .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                 .andReturn();
         assertFalse(resultado.getResponse().getContentAsString().isEmpty());

     }
}
