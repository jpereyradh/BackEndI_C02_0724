package presencial;

public class CompruebaMail {
    //donde inicia la cadena
    private Manejador inicial;

    public CompruebaMail() {
        //necesito instanciar la cadena(armar los eslabones)
        inicial= new ManejadorGerencial();
        Manejador tecnico= new ManejadorTecnico();
        Manejador comercial= new ManejadorComercial();
        Manejador spam= new ManejadorSpam();
        //unir los eslabones
        inicial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(spam);
    }
    public String disparadorCadena(Mail mail){
        return inicial.compruebaMail(mail);
    }
}
