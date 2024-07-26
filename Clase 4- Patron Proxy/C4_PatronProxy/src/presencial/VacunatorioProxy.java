package presencial;

import java.util.Date;

public class VacunatorioProxy implements VacunatorioInterface{
    private Vacunatorio centroVacunario;

    public VacunatorioProxy() {
        centroVacunario= new Vacunatorio();
    }

    @Override
    public String vacunar(Persona persona) {
        //deberia estar el guardian, el protector, el intermediario
        //aca deberiamos check de la fecha
        Date fechaHoy= new Date();
        System.out.println("Fecha del dia: "+fechaHoy);
        System.out.println("*****Verificando datos cargados...*****");
        if(fechaHoy.before(persona.getFechaVacuna())){
            //deberiamos vacunar?
            return "vuelva el dia de la fecha de vacunacion o posteriormente";
        }else{
            //deberia poder vacunarse.
            return centroVacunario.vacunar(persona);
                    }



    }
}
