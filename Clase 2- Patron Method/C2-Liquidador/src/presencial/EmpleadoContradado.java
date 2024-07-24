package presencial;

public class EmpleadoContradado extends Empleado{

    private double cantidadDehoras;
    private double precioPorHora;

    public EmpleadoContradado(String nombre, String apellido, int cuentaBancaria, double cantidadDehoras, double precioPorHora) {
        super(nombre, apellido, cuentaBancaria);
        this.cantidadDehoras = cantidadDehoras;
        this.precioPorHora = precioPorHora;
    }

    public double getCantidadDehoras() {
        return cantidadDehoras;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }
}
