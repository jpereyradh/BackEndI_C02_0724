package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
private Map<String,Computadora>computadoraMap;
private int contadorCache=0;

    public ComputadoraFactory() {
        computadoraMap= new HashMap<>();
    }
    public Computadora fabricarComputadora(int ram, int discoDuro){
        //1 consultar  si existe la clave,
        String clave= "k:"+ram+discoDuro;
        if(!computadoraMap.containsKey(clave)){
            //deberiamos poder entonces crear
            computadoraMap.put(clave,new Computadora(ram,discoDuro));
            System.out.println("computadora creada");
        }
        contadorCache++;
        return computadoraMap.get(clave);
    }

    public int getContadorCache() {
        return contadorCache;
    }
}
