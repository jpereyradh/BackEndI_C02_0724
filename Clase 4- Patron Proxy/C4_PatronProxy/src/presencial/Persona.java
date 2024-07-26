package presencial;

import java.util.Date;

public class Persona {
    private String nombre;
    private String cedula;
    private Date fechaVacuna;
    private  String nombreVacuna;

    public Persona(String nombre, String cedula, Date fechaVacuna, String nombreVacuna) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaVacuna = fechaVacuna;
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }
}
