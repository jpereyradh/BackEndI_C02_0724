package com.example.ClinicaOdontologicaSpringMVC.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Domicilio {
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

}
