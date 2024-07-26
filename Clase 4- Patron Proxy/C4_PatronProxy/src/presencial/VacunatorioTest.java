package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VacunatorioTest {

    @Test
    public void casoCorrecto(){
        //DADO
        Persona persona= new Persona("Juan","1111111",new Date(2024-1900,6,25),"aspirina");
        VacunatorioProxy centro= new VacunatorioProxy();
        String respEsp= "finalizado ok";

        //CUANDO
        String respAct= centro.vacunar(persona);
        //ENTONCES
        Assertions.assertEquals(respAct,respEsp);

    }
}
