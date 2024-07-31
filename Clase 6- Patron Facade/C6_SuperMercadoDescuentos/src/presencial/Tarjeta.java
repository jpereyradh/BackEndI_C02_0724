package presencial;

public class Tarjeta {
    private int numeroTarjeta;
    private String banco;

    public Tarjeta(int numeroTarjeta, String banco) {
        this.numeroTarjeta = numeroTarjeta;
        this.banco = banco;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getBanco() {
        return banco;
    }
}
