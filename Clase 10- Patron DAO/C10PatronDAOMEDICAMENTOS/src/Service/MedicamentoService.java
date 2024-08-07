package Service;

import Dao.MedicamentoDAOH2;
import Dao.iDao;
import Model.Medicamento;
//tener toda la logica de como
// acceder a la comunicacion con la BDD y los metodos para trabajar en ella
public class MedicamentoService {
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService() {
        medicamentoiDao= new MedicamentoDAOH2();
    }
    //va tener metodos manuales
    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
    }


}
