package presencial;

public class Empleado {
    private String nombre;
    private String apellido;
    private int cuentaBancaria;

    public Empleado(String nombre, String apellido, int cuentaBancaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentaBancaria = cuentaBancaria;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }
}
