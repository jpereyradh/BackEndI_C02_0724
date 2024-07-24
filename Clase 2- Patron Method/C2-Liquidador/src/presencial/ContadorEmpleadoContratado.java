package presencial;

public class ContadorEmpleadoContratado extends Contador {
    @Override
    public double calcularSueldo(Empleado empleado) {

        double resp=0;
        if(empleado instanceof EmpleadoContradado) {
            EmpleadoContradado empleadoContradado = (EmpleadoContradado) empleado;
            resp = empleadoContradado.getCantidadDehoras() * empleadoContradado.getPrecioPorHora();
        }
        return resp;
    }

    @Override
    public String emitirRecibo(Empleado empleado) {
        return " un documento digital";
    }
}
