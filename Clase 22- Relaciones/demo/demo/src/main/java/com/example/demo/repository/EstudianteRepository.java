package com.example.demo.repository;

import com.example.demo.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
