package Dao;

import Model.Domicilio;
import Model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente>{

    private static final Logger logger=Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO PACIENTES VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT="SELECT * FROM PACIENTES";
    @Override
        public Paciente guardar(Paciente paciente) {
        logger.info("iniciando las operaciones de : guardado de: "+paciente.getNombre());
        Connection connection=null;
        try {
        connection = BD.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
        //aca comunicamos mundo objeto con tabla
        psInsert.setString(1, paciente.getNombre());
        psInsert.setString(2, paciente.getApellido());
        psInsert.setString(3, paciente.getCedula());
        psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
        psInsert.setInt(5,paciente.getDomicilio().getId());
       //en teoria en este punto cargo a la tabla y genero ID
        //comunico tabla con objeto
        ResultSet rs= psInsert.getGeneratedKeys(); //traigo los ID
        while(rs.next()){
            paciente.setId(rs.getInt(1));
        }

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
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
            }

        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return paciente;
    }
}
