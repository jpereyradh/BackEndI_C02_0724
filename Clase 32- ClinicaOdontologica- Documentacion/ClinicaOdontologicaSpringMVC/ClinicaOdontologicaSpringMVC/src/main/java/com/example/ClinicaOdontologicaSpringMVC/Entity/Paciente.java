package com.example.ClinicaOdontologicaSpringMVC.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    //atributos de la clase paciente
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column
    private String nombre;
   @Column
   private String apellido;
   @Column
   private String cedula;
   @Column
   private LocalDate fechaIngreso;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
   private Domicilio domicilio;
   @Column(unique = true)
    private String email;

    public Paciente(String nombre, String apellido, String cedula, LocalDate fechaIngreso, Domicilio domicilio, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email = email;
    }
}
