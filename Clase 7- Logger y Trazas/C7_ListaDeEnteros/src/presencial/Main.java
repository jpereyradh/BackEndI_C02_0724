package presencial;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger= Logger.getLogger(Main.class);
    public static void main(String[] args) {
        App listado= new App();
        for(int i=0;i<=5;i++){
            listado.agregaElementos(i);
        }
        logger.warn("proceso terminado con exito: "+ listado.getListaEnteros());
    }
}
