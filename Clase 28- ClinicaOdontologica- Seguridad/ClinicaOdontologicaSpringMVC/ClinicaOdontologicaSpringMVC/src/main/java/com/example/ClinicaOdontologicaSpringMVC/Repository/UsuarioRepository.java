package com.example.ClinicaOdontologicaSpringMVC.Repository;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String correo);
}
