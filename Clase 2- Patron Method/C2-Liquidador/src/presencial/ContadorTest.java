package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContadorTest {
    @Test
    public void liquidarSueldo(){
      //DADO
    Empleado juan= new EmpleadoEfectivo("Juan","Pererz",11111111,2000,50,40);
    //Empleado juan= new EmpleadoContradado("Juan","Perez",11111,40,100);
        Contador julian= new ContadorEmpleadoEfectivo();
    String respEsp= "un documento en papelSueldo a liquidar: 2010.0";
      //CUANDO
        String respActual= julian.liquidarSueldo(juan);
      //ENTONCES
        Assertions.assertEquals(respActual,respEsp);
    }
}
