package com.example.ClinicaOdontologicaSpringMVC;

import com.example.ClinicaOdontologicaSpringMVC.Dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaSpringMvcApplication {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ClinicaOdontologicaSpringMvcApplication.class, args);
	}

}
