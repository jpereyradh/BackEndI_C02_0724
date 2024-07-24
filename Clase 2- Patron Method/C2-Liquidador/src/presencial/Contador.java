package presencial;

public abstract   class Contador {

    public String liquidarSueldo(Empleado empleado){
        String resp= "No le pudo liquidador el sueldo";
        double sueldo= calcularSueldo(empleado);
        if(sueldo>0){
            String recibo= emitirRecibo(empleado);
            resp= recibo+ "Sueldo a liquidar: "+sueldo;
        }
        return resp;
    }
    public String depositarSueldo(Empleado empleado){
        return "sueldo depositado en la cuenta: "+empleado.getCuentaBancaria();
    }

    public abstract double calcularSueldo(Empleado empleado);
    public abstract String emitirRecibo(Empleado empleado);
}
