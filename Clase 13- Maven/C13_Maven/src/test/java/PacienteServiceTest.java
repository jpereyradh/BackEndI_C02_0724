import Dao.BD;
import Model.Paciente;
import Service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PacienteServiceTest {

    @Test
    public void pruebaBusquedaPaciente(){
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();
        Integer idABuscar=2;
        Paciente paciente= pacienteService.buscarPorID(idABuscar);
        Assertions.assertTrue(paciente.getApellido().equals("Vasquez"));

    }

}
