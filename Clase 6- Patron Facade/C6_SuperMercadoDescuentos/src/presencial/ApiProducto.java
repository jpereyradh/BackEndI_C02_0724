package presencial;

public class ApiProducto {
    public int descuentoPorProducto(Producto producto){
        if(producto.getTipo().equalsIgnoreCase("latas")){
            return 10;
        }
        return 0;
    }
}
