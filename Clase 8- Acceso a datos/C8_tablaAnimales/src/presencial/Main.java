package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    private static final Logger logger= Logger.getLogger(Main.class);
    public static void main(String[] args) {

        //obtener la conexion
        Connection connection= null;
        try{
            connection= getConnection();
            logger.info("conexion establecida");

            //crear las queries
        //necesitamos comunicar desde el mundo POO a SQL
            //java provee un objeto de tipo Statement
            // usamos Statement POO -----> SQL
            Statement statement= connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES; " +
                    "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, NOMBRE VARCHAR(40) NOT NULL, TIPO VARCHAR(45) NOT NULL);");
            //AHORA INSERTEMOS 5 ANIMALES
            statement.execute("INSERT INTO ANIMALES VALUES (1,'Luca','Perro'), (2,'Lili','Gato'),(3,'Astro','Gato'),(4,'Ruda','Tortuga'),(5,'Perry','Ornitorrinco')");
            logger.info("datos cargados");

            //para mostrar por pantalla
            //usamos ResultSet SQL ------> POO
            ResultSet rs= statement.executeQuery("SELECT * FROM ANIMALES");
            while(rs.next()){
                //mostrar por pantalla
                System.out.println("ID: "+rs.getInt(1)+" Nombre: "+rs.getString(2)+" Tipo: "+rs.getString(3));
            }
            System.out.println("***********************************************");
            //eliminamos 1
            statement.execute("DELETE  FROM ANIMALES WHERE ID = 4");
            logger.warn("elminamos a Ruda");

            rs= statement.executeQuery("SELECT * FROM ANIMALES");
            while(rs.next()){
                //mostrar por pantalla
                System.out.println("ID: "+rs.getInt(1)+" Nombre: "+rs.getString(2)+" Tipo: "+rs.getString(3));
            }
            System.out.println("***********************************************");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        //Cerrar la conexion
        finally {
            try{
                connection.close();
            }catch (SQLException sql){
                sql.printStackTrace();

            }
        }

    }
    //Cargar el driver
    //necesitamos crear un metodo que devuelva la conecction
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/c8Tabla","admin","admin");
    }

}
