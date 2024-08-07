package Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    /* private Integer id;
    private int codigoNumerico;
    private String nombre;
    private String laboratorio;
    private int cantidad;
    private Double precio;*/
    private static final Logger logger=Logger.getLogger(BD.class);
    private static final String SQL_CREATE="DROP TABLE IF EXISTS MEDICAMENTOS; " +
            "CREATE TABLE MEDICAMENTOS(ID INT PRIMARY KEY, CODIGO_NUMERICO INT NOT NULL, " +
            "NOMBRE VARCHAR(100) NOT NULL, LABORATORIO VARCHAR(100) NOT NULL, CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL )";


    public static void crearTablas(){
        Connection connection=null;
        try{
            connection=getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_CREATE);
            logger.info("tabla creada con exito");

        }catch (Exception e){
            logger.error("error producido: "+e.getMessage());
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/daoMedicamento","sa","sa");
    }

}
