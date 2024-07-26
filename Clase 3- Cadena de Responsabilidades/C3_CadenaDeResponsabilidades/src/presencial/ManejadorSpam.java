package presencial;

public class ManejadorSpam extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        return "mail movido a spam";
    }
}
