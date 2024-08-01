package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros= new ArrayList<>();
    }

    public List<Integer> getListaEnteros() {
        return listaEnteros;
    }

    public void agregaElementos(Integer num){
        listaEnteros.add(num);
        if(listaEnteros.size()>5){
            //deberiamos logguear
            logger.info("la longitud de la lista mayor a  5");
        }
}

}
