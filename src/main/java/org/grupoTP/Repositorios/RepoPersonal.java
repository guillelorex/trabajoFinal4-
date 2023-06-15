package org.grupoTP.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.grupoTP.clases.Usuarios.Empleados.Empleado;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RepoPersonal implements IntRepository<Empleado> {

    private final File archivo = new File("src/main/resources/Personal.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Empleado> listaEmpleados;

    @Override
    public void cargar() {

        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class);
            this.listaEmpleados = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaEmpleados = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaEmpleados);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Empleado> listar() {
        cargar();
        return this.listaEmpleados;
    }
    @Override
    public void agregar(Empleado... objeto) {
        cargar();
        this.listaEmpleados.addAll(List.of(objeto));
        guardar();
    }
    @Override
    public void eliminar(int id) {

        cargar();
        for(Empleado emp: this.listaEmpleados){

            if(emp.getLegajo() == id){
                this.listaEmpleados.remove(emp);
                break;
            }

        }
        guardar();
    }

    @Override
    public void modificar(Empleado empleado) {

        cargar();

        for(Empleado emp: this.listaEmpleados){
            if(emp.getLegajo() == empleado.getLegajo()){
                emp.setArea(empleado.getArea());
                emp.setNombre(empleado.getNombre());
                emp.setApellido(empleado.getApellido());
                emp.setDni(empleado.getDni());
                emp.setDni(empleado.getDni());
                break;
            }
        }
        guardar();
    }



}
