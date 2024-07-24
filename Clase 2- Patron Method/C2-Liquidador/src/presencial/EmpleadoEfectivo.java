package presencial;

public class EmpleadoEfectivo extends Empleado {
    private double salarioBasico;
    private double premios;
    private double descuentos;

    public EmpleadoEfectivo(String nombre, String apellido, int cuentaBancaria, double salarioBasico, double premios, double descuentos) {
        super(nombre, apellido, cuentaBancaria);
        this.salarioBasico = salarioBasico;
        this.premios = premios;
        this.descuentos = descuentos;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public double getPremios() {
        return premios;
    }

    public double getDescuentos() {
        return descuentos;
    }
}
