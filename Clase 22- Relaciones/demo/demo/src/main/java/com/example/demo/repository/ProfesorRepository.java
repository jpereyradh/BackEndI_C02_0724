package com.example.demo.repository;

import com.example.demo.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
