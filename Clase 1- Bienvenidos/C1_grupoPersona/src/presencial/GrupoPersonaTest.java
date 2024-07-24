package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoPersonaTest {

   @Test
   public void agregar2Personas(){
        //DADO
        GrupoPersona grupoPersona= new GrupoPersona();
        Persona persona1= new Persona(18,"Juan");
        Persona persona2= new Persona(17,"Pedro");
        Persona persona3= new Persona(22,"Ana");
        Persona persona4= new Persona(14, "Luz");
        Persona persona5= new Persona(32,"Julian");
             //CUANDO
       grupoPersona.agregarPersonas(persona1);
       grupoPersona.agregarPersonas(persona2);
       grupoPersona.agregarPersonas(persona3);
       grupoPersona.agregarPersonas(persona4);
       grupoPersona.agregarPersonas(persona5);
        //ENTONCES
       Assertions.assertTrue(grupoPersona.getListaPersona().size()==2);
    }
}
