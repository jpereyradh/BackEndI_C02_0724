package com.example.ClinicaOdontologicaSpringMVC.Controller;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Odontologo;
import com.example.ClinicaOdontologicaSpringMVC.Exception.ResourceNotFE;
import com.example.ClinicaOdontologicaSpringMVC.Service.OdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    @Operation(summary = "Permite registrar un Odontologo")
    @ApiResponse(responseCode = "200",description = "Odontologo creado")
    @ApiResponse(responseCode = "400",description = "error de servidor")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }
    /*@PutMapping
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoService.actualizarOdontologo(odontologo);
            }*/

 /* @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }*/
    @GetMapping("/buscar/{id}")
    @Parameter(name = "id",description = "necesita para buscar un ID")
    public ResponseEntity<Optional<Odontologo>> buscarPorId(@PathVariable Long id) throws ResourceNotFE {
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado);
        }else{
            throw new ResourceNotFE("Odontologo no encontrado");
        }
        //return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }
}
