package presencial;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
    public boolean esMayorQue(){
        return edad>=18; //por default siempre va a ser true esa condicion
    }
    public boolean checkEdad(){
        boolean resp=false;
        if(edad>0&&edad<=120){
            resp= true;
        }
        return resp; //return edad>0&&edad<=120;
    } public boolean cantidadDeLetras(){
        return nombre.length()>=4;
    }
    public boolean checkAZ(){
        boolean resp= false; // JORGITO
       char[] arrayletras= nombre.toCharArray(); //----> J(0) 0(1) R(2) G(3) I(4) T(5) O(6)
        for (char letra : arrayletras) {
            if(Character.isLetter(letra)) {
                resp = true;
            }
        }
        return resp;
    }

    public String getNombre() {
        return nombre;
    }
}
