package presencial;

public class ApiCantidad {
    public int descuentoPorCantidad(int cant){
        if(cant>12){
            return 15;
        }
        return 0;
    }
}
