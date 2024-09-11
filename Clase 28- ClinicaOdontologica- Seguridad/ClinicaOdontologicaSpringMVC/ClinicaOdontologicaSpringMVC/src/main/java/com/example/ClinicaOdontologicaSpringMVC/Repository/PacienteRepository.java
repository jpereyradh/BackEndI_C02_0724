package com.example.ClinicaOdontologicaSpringMVC.Repository;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByEmail(String correo);
}
