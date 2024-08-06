package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Cuentas {
    private static final String SQL_CREATE="DROP TABLE IF EXISTS CUENTAS; " +
            "CREATE TABLE CUENTAS (ID INT PRIMARY KEY, SALDO NUMERIC(10,2) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL)";
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS SET SALDO=? WHERE ID=?";
    private static final Logger logger= Logger.getLogger(Cuentas.class);

    public static void main(String[] args) {
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_CREATE);
            logger.info("tabla creada con exito");

            //PreparedStatement
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,1);
            psInsert.setDouble(2,100);
            psInsert.setString(3,"Marisol");
            psInsert.setInt(4,1111111);
            psInsert.execute();

            //ahora debemos hacer el update
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,100+10);
            psUpdate.setInt(2,1);
            psUpdate.execute();
            logger.info("saldo actualizado efectivamente");
            connection.setAutoCommit(true);
            try{
                if(!connection.getAutoCommit()){
                    PreparedStatement psUpdate2= connection.prepareStatement(SQL_UPDATE);
                    psUpdate2.setDouble(1,110+15);
                    psUpdate2.setInt(2,1);
                    psUpdate2.execute();
                    logger.info("saldo nuevamente actualizado efectivamente");
                }else{
                    throw new Exception("forzamos una excepcion");
                }
                ResultSet rs= statement.executeQuery("SELECT * FROM CUENTAS");
                while(rs.next()){
                    System.out.println("Valor del saldo: "+rs.getDouble(2));
                }
                connection.setAutoCommit(true);

            }catch (Exception exe){
                try {
                    connection.rollback();
                    System.out.println("conexion fallida y revertida: " + exe.getMessage());
                   ResultSet rs= statement.executeQuery("SELECT * FROM CUENTAS");
                    while(rs.next()){
                        System.out.println("Valor del saldo: "+rs.getDouble(2));
                    }
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }

            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
    }




    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/tablaCuenta","admin","admin");
    }
}
