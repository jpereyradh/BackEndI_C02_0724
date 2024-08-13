package Dao;

import java.util.List;

public interface iDao<T> {

   T guardar(T t);
   void actualizar(T t);
   void eliminar(Integer id);
   List<T> listarTodos();
   T buscarporId(Integer id);
}
