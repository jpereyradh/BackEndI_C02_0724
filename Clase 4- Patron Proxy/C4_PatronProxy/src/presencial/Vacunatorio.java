package presencial;

public class Vacunatorio implements VacunatorioInterface{
    @Override
    public String vacunar(Persona persona) {
        //aplicar el caso sin proxy
        System.out.println("***************Verificando datos**************");
        System.out.println("Datos del paciente: "+persona.getNombre()+" vacuna: "+persona.getNombreVacuna());
        System.out.println("vacunacion registrada con exito");
        return "finalizado ok";
    }
}
