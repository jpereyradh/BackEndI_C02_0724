package presencial;

public class FacadeDescuento implements iFacadeDescuento{
    private ApiCantidad apiCantidad;
    private ApiProducto apiProducto;
    private ApiTarjeta apiTarjeta;

    public FacadeDescuento() {
        apiProducto= new ApiProducto();
        apiTarjeta = new ApiTarjeta();
        apiCantidad = new ApiCantidad();
    }

    //la clase encargada de interactuar con las api
    @Override
    public int descuento(Producto producto, Tarjeta tarjeta, int cantidad) {
        int descuento=0;
        descuento= descuento+apiCantidad.descuentoPorCantidad(cantidad);
        descuento= descuento+ apiTarjeta.descuentoPorTarjeta(tarjeta);
        descuento= descuento+ apiProducto.descuentoPorProducto(producto);
        return descuento;
    }
}
