package presencial;

import java.util.ArrayList;
import java.util.List;

public class GrupoPersona {
    private List<Persona> listaPersona;

    public GrupoPersona() {
       listaPersona = new ArrayList<>();
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void agregarPersonas(Persona persona){
        if(persona.checkEdad()&&persona.checkAZ()&& persona.cantidadDeLetras()&& persona.esMayorQue()){
            listaPersona.add(persona);
            System.out.println("persona agregarda : "+persona.getNombre());
        }else{
            System.out.println("no se permite agregar a la persona: "+persona.getNombre());
        }
    }
}
