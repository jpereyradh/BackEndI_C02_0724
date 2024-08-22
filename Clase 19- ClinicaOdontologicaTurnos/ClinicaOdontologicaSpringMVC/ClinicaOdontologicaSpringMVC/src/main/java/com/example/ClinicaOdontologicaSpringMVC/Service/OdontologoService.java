package com.example.ClinicaOdontologicaSpringMVC.Service;

import com.example.ClinicaOdontologicaSpringMVC.Dao.OdontologoDAOH2;
import com.example.ClinicaOdontologicaSpringMVC.Dao.iDao;
import com.example.ClinicaOdontologicaSpringMVC.Model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
           odontologoiDao= new OdontologoDAOH2();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoiDao.actualizar(odontologo);
    }
   public void eliminarOdontologo(Integer id){
        odontologoiDao.eliminar(id);
   }
   public List<Odontologo> listarTodos(){
        return odontologoiDao.listarTodos();
   }
   public Odontologo buscarPorId(Integer id){
        return odontologoiDao.buscarporId(id);
   }
}
