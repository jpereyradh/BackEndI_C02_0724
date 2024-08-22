package com.example.ClinicaOdontologicaSpringMVC;

import com.example.ClinicaOdontologicaSpringMVC.Dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologica {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ClinicaOdontologica.class, args);
	}

}
