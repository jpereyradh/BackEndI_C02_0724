package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CompruebaMailTest {


    @Test
    public void mailMovidoSpam(){
        //DADO
        Mail mail= new Mail("jorgito@digitalhouse.com","jkdjklsjdklasd","kljskljklsjkls");
        CompruebaMail compruebaMail= new CompruebaMail();
        String respEsp= "mail movido a spam";
        //CUANDO
        String respAct= compruebaMail.disparadorCadena(mail);
        //ENTONCES
        Assertions.assertEquals(respAct,respEsp);
    }
}
