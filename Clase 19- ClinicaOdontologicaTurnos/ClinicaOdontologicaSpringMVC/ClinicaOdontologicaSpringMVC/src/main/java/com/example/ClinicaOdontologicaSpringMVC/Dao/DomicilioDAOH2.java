package com.example.ClinicaOdontologicaSpringMVC.Dao;

import com.example.ClinicaOdontologicaSpringMVC.Model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DomicilioDAOH2 implements iDao<Domicilio>{
    private static final Logger logger= Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO,LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIOS WHERE ID=?";



    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("iniciando las operaciones de : guardado de un domicilio: "+domicilio.getCalle());
        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2,domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();
            ResultSet rs= psInsert.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
            }
            logger.info("domicilio persistido con exito");

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Domicilio> listarTodos() {
        return List.of();
    }

    @Override
    public Domicilio buscarporId(Integer id) {
        logger.info("iniciando las operaciones de : busqueda de un domicilio con ID: "+id);
        Connection connection=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            psSelectOne.execute();
            ResultSet rs= psSelectOne.executeQuery();
            while(rs.next()){
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5));
            }

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorString(String string) {
        return null;
    }
}
