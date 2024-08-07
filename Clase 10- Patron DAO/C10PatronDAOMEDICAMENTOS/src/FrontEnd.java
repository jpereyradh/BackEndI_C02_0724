import Dao.BD;
import Model.Medicamento;
import Service.MedicamentoService;

public class FrontEnd {
    public static void main(String[] args) {
        Medicamento medicamento= new Medicamento(1,11111,"aspirina","bayer",1000,34.5);
        MedicamentoService medicamentoService= new MedicamentoService();
        BD.crearTablas();
        medicamentoService.guardarMedicamento(medicamento);
    }
}
