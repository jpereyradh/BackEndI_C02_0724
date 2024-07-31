package presencial;

public class Cliente {
    public static void main(String[] args) {
        Tarjeta tarjeta= new Tarjeta(1111111,"star bank");
        Producto producto= new Producto("Arroz","latas");
        int cantidad= 15;
        FacadeDescuento fachada= new FacadeDescuento();
        System.out.println("Descuento acumulado en esta compra: "+fachada.descuento(producto,tarjeta,cantidad)+" %");
    }
}
