package presencial;

public class ManejadorComercial extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("comercial@colmena.com")||mail.getAsunto().equalsIgnoreCase("comercial")){
            return "en unos minutos lo atenderá el departamento Comercial";
        }else{
            System.out.println("Disculpe, no lo pudimos atender, a continuación lo derivaremos");
            return getSiguienteManejador().compruebaMail(mail);
        }
    }
}
