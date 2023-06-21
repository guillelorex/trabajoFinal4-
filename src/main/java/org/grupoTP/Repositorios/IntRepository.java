package org.grupoTP.Repositorios;

import java.util.List;

public interface IntRepository<T>{

    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T... objeto);
    void eliminar(int id);
   void modificar(T objeto);
}
