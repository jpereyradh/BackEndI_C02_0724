package Dao;

import Model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicamentoDAOH2 implements iDao<Medicamento> {
    /* private Integer id;
    private int codigoNumerico;
    private String nombre;
    private String laboratorio;
    private int cantidad;
    private Double precio;*/
    private static final Logger logger= Logger.getLogger(MedicamentoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,medicamento.getId());
            psInsert.setInt(2,medicamento.getCodigoNumerico());
            psInsert.setString(3, medicamento.getNombre());
            psInsert.setString(4, medicamento.getLaboratorio());
            psInsert.setInt(5,medicamento.getCantidad());
            psInsert.setDouble(6,medicamento.getPrecio());
            psInsert.execute();
            logger.info("carga exitosa");

        }catch (Exception e){
            logger.error("Problemas de Conexion: "+e.getMessage());
        }
        return medicamento;
    }
    //aca deberia estar toda la logica de CRUD traia desde el iDAO
}
