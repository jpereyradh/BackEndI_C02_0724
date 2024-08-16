package Service;

import Dao.PacienteDAOH2;
import Dao.iDao;
import Model.Paciente;

public class PacienteService {
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorID(Integer id){
        return pacienteiDao.buscarporId(id);
    }
}
