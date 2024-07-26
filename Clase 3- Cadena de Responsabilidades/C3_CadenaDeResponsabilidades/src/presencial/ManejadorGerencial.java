package presencial;

public class ManejadorGerencial extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("gerencial@colmena.com")||mail.getAsunto().equalsIgnoreCase("gerencial")){
            return "en unos minutos lo atenderá el departamento gerencial";
        }else{
            System.out.println("Disculpe, no lo pudimos atender, a continuación lo derivaremos");
            return getSiguienteManejador().compruebaMail(mail);
        }
    }
}
