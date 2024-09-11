package com.example.ClinicaOdontologicaSpringMVC.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    //al manejo de exception hay que hacerlo de manera individual
    @ExceptionHandler({ResourceNotFE.class})
    public ResponseEntity<String> tratamientoRNFE(ResourceNotFE rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mensaje: "+rnfe.getMessage());
    }

}
