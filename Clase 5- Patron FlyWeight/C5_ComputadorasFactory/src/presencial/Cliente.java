package presencial;

public class Cliente {

    public static void main(String[] args) {
        ComputadoraFactory factory= new ComputadoraFactory();
        Computadora pc1= factory.fabricarComputadora(2,128);
        Computadora pc2= factory.fabricarComputadora(16,500);
        Computadora pc3= factory.fabricarComputadora(2,128);
        Computadora pc4= factory.fabricarComputadora(16,500);
        Computadora pc5= factory.fabricarComputadora(2,128);
        Computadora pc6= factory.fabricarComputadora(16,500);

        System.out.println("computadoras creadas : "+Computadora.getContador());
        System.out.println("instancias no creadas: "+factory.getContadorCache());

    }
}
