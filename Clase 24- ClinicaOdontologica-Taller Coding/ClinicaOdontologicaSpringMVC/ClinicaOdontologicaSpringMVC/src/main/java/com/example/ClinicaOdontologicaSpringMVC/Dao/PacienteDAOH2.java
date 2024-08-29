package com.example.ClinicaOdontologicaSpringMVC.Dao;

import com.example.ClinicaOdontologicaSpringMVC.Model.Domicilio;
import com.example.ClinicaOdontologicaSpringMVC.Model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente>{

    private static final Logger logger=Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_SELECT="SELECT * FROM PACIENTES";
    @Override
        public Paciente guardar(Paciente paciente) {
        logger.info("iniciando las operaciones de : guardado de: "+paciente.getNombre());
        Connection connection=null;
        DomicilioDAOH2 daoAux= new DomicilioDAOH2();
        Domicilio domicilio= daoAux.guardar(paciente.getDomicilio());
        try {
        connection = BD.getConnection();
        PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
        //aca comunicamos mundo objeto con tabla
        psInsert.setString(1, paciente.getNombre());
        psInsert.setString(2, paciente.getApellido());
        psInsert.setString(3, paciente.getCedula());
        psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
        psInsert.setInt(5,domicilio.getId());
        psInsert.setString(6, paciente.getEmail());
        psInsert.execute(); //ahora se generan las claves
       //en teoria en este punto cargo a la tabla y genero ID
        //comunico tabla con objeto
        ResultSet rs= psInsert.getGeneratedKeys(); //traigo los ID
        while(rs.next()){
            paciente.setId(rs.getInt(1));
        }
        logger.info("paciente registrado: ID: "+paciente.getId()+ " con domicilio asignado: "+paciente.getDomicilio().getId());
        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("iniciando las operaciones de : guardado de: "+paciente.getNombre());
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }

    }

    @Override
    public void eliminar(Integer id) {
        logger.info("iniciando las operaciones de :");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }

    }

    @Override
    public List<Paciente> listarTodos() {
        logger.info("iniciando las operaciones de : listar");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return List.of();
    }

    @Override
    public Paciente buscarporId(Integer id) {
        logger.info("iniciando las operaciones de : busqueda  de un paciente: "+id);
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio= null;
        try{
            connection=BD.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psUpdate=connection.prepareStatement(SQL_SELECT_ONE);
            psUpdate.setInt(1,id);
            ResultSet rs= psUpdate.executeQuery();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                domicilio= daoAux.buscarporId(rs.getInt(6)); //--< FK
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
            }

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }if(paciente!=null){
            logger.info("paciente encontrado: "+paciente.getNombre());
            return paciente;
        }
        logger.warn("paciente no encontrado");
        return null;
        //

    }

    @Override
    public Paciente buscarPorString(String string) {
        logger.info("iniciando las operaciones de busqueda de : "+string);
        Paciente paciente=null;
        Domicilio domicilio= null;
        DomicilioDAOH2 daoAux= new DomicilioDAOH2();
        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectEmail= connection.prepareStatement(SQL_SELECT_EMAIL);
            psSelectEmail.setString(1,string);
            ResultSet rs= psSelectEmail.executeQuery();
            while(rs.next()){
                domicilio= daoAux.buscarporId(rs.getInt(6)); //--< FK
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
                            }

        }catch (Exception e){
            logger.error("Error en la conexion: "+e.getMessage());
        }
        if(paciente!=null){
            logger.info("busqueda exitosa:  Nombre y Apellido: "+paciente.getNombre()+" "+paciente.getApellido());
        }else{
            logger.warn("busqueda sin resultados coincidentes: "+paciente);

        }
        return paciente;
    }
}
