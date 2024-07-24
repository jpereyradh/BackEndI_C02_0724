package presencial;

public class ContadorEmpleadoEfectivo extends Contador{
    @Override
    public double calcularSueldo(Empleado empleado) {
        double resp=0;
        if(empleado instanceof EmpleadoEfectivo) {
            EmpleadoEfectivo empleadoEfectivo = (EmpleadoEfectivo) empleado;
            resp = (empleadoEfectivo.getSalarioBasico() + empleadoEfectivo.getPremios()) - empleadoEfectivo.getDescuentos();
        }
        return resp;
    }

    @Override
    public String emitirRecibo(Empleado empleado) {
        return "un documento en papel";
    }
}
