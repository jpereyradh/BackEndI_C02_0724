package com.example.ClinicaOdontologicaSpringMVC.Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

   private static final Logger logger= Logger.getLogger(BD.class);
   private static final String SQL_DROP_CREATE_PACIENTES=" DROP TABLE IF EXISTS PACIENTES; " +
           "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(30) NOT NULL, APELLIDO VARCHAR(40) NOT NULL, " +
           "CEDULA VARCHAR(30) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL, EMAIL VARCHAR(100) NOT NULL)";
    private static final String SQL_DROP_CREATE_DOMICILIOS="DROP TABLE IF EXISTS DOMICILIOS; " +
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL)";
    private static final String SQL_DROP_CREATE_ODONTOLOGOS="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, MATRICULA VARCHAR(100) NOT NULL)";
    private static final String SQL_DROP_PRUEBA="INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES('Siempre Viva','748','Sprinfield','EUA'),('Calle Falsa','123','Sprinfield','EUA'); " +
            "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES('Julian','Espinoza','234455667','2024-08-08',1,'julian@julian.com'),('Helen','Vasquez','3445666','2024-07-20',2,'helen@helen.com');" +
            "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES('Mathias','Santos','MP10')";
        public static void crearTablas(){
        Connection connection=null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIOS);
            statement.execute(SQL_DROP_CREATE_PACIENTES);
            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            statement.execute(SQL_DROP_PRUEBA);
            logger.info("datos cargados con exito");
        }catch (Exception e){
            logger.error("error inesperado: "+e.getMessage());
        }
    }


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/ClinicaOdontologicaC2","sa","sa");
    }
}
