package com.example.ClinicaOdontologicaSpringMVC.Dao;

import com.example.ClinicaOdontologicaSpringMVC.Model.Turno;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAOLISTA implements iDao<Turno>{
    private static final Logger logger=Logger.getLogger(TurnoDAOLISTA.class);
    private List<Turno> turnos=new ArrayList<>();
    @Override
    public Turno guardar(Turno turno) {
        PacienteDAOH2 daoPaciente= new PacienteDAOH2();
        OdontologoDAOH2 daoOdontologo= new OdontologoDAOH2();
        turno.setPaciente(daoPaciente.buscarporId(turno.getPaciente().getId()));
        turno.setOdontologo(daoOdontologo.buscarporId(turno.getOdontologo().getId()));
        turnos.add(turno);
        logger.info("turno guardado con exito");
        return turno;
    }

    @Override
    public void actualizar(Turno turno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Turno> listarTodos() {
        return  turnos;
    }

    @Override
    public Turno buscarporId(Integer id) {
        logger.info("iniciando las operaciones de busqueda: "+id);
        for (Turno turno : turnos) {
           if(turno.getId().equals(id)){
               return turno;
                      }
        }
        System.out.println("turno no encontrado");
       return null;
    }

    @Override
    public Turno buscarPorString(String string) {
        return null;
    }
}
