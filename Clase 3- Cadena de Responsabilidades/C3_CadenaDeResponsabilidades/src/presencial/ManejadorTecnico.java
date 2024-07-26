package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("tecnica@colmena.com")||mail.getAsunto().equalsIgnoreCase("tecnico")){
            return "en unos minutos lo atenderá el departamento Tecnico";
        }else{
            System.out.println("Disculpe, no lo pudimos atender, a continuación lo derivaremos");
            return getSiguienteManejador().compruebaMail(mail);
        }

    }
}
