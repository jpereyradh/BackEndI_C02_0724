package com.example.ClinicaOdontologicaSpringMVC.Dao;

import com.example.ClinicaOdontologicaSpringMVC.Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger=Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("iniciando las operaciones de : guardado de: "+odontologo.getNombre());

        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3, odontologo.getMatricula());
            psInsert.execute();
            ResultSet rs= psInsert.getGeneratedKeys();
            while(rs.next()){
                odontologo.setId(rs.getInt(1));
            }
            logger.info("odontologo cargado : "+odontologo.getId());

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {
        logger.info("iniciando las operaciones de : eliminar un odontologo con id:  de"+id);
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }

    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("iniciando las operaciones de : listar los odontologos: ");
        List<Odontologo> listaOdontologos= new ArrayList<>();
        Odontologo odontologo= null;
        Connection connection=null;
        try{
            connection=BD.getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT_ALL);
            while(rs.next()){
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                listaOdontologos.add(odontologo);
            }
            for (Odontologo odontologo1 : listaOdontologos) {
                
                System.out.println("ID: "+odontologo1.getId()+" Nombre : "+odontologo1.getNombre()+" Apellido: "+odontologo1.getNombre()+" Matricula: "+odontologo1.getMatricula());
                System.out.println("**********************************************************************************");
                
            }
        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return listaOdontologos;
    }

    @Override
    public Odontologo buscarporId(Integer id) {
        logger.info("iniciando las operaciones de : busqueda un odontologo con id:  de"+id);
        Odontologo odontologo=null;
        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            while(rs.next()){
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            logger.info("odontologo encontrado: "+odontologo.getNombre());

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorString(String string) {
        return null;
    }
}
