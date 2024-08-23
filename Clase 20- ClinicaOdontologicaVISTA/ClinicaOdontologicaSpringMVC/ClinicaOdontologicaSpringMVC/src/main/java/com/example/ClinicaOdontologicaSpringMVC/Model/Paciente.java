package com.example.ClinicaOdontologicaSpringMVC.Model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Paciente {
    //atributos de la clase paciente
   private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;
    private String email;

}
