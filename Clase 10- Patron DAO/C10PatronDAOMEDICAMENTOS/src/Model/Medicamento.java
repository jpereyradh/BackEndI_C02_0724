package Model;

public class Medicamento {
    private Integer id;
    private int codigoNumerico;
    private String nombre;
    private String laboratorio;
    private int cantidad;
    private Double precio;


    public Medicamento(Integer id, int codigoNumerico, String nombre, String laboratorio, int cantidad, Double precio) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(int codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
