package org.grupoTP.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.grupoTP.clases.Usuarios.Reserva.Reserva;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RepoReserva implements IntRepository<Reserva> {

    private final File archivo = new File("src/main/resources/reservas.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Reserva> listaReservas;

    @Override
    public void cargar() {

        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Reserva.class);
            this.listaReservas = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaReservas = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaReservas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Reserva> listar() {
        cargar();
        return this.listaReservas;
    }
    @Override
    public void agregar(Reserva... objeto) {
        cargar();
        this.listaReservas.addAll(List.of(objeto));
        guardar();
    }
    @Override
    public void eliminar(int id) {

        cargar();
        for(Reserva res: this.listaReservas){

            if(res.getNroReserva() == id){
                this.listaReservas.remove(res);
                break;
            }

        }
        guardar();
    }

    @Override
     public void modificar(Reserva reserva) {

        cargar();

        for(Reserva res: this.listaReservas){
            if(res.getNroReserva() == reserva.getNroReserva()){
                res.setNroHabitacion(reserva.getNroHabitacion());
                res.setFechaIngreso(reserva.getFechaIngreso());
                res.setFechaEgreso(reserva.getFechaEgreso());
                res.setEstado(reserva.getEstado());
                res.setTipo(reserva.getTipo());
                res.setPension(reserva.getPension());
                res.setFormaPago(reserva.getFormaPago());
                res.setNombre(reserva.getNombre());
                res.setApellido(reserva.getApellido());
                res.setDni(reserva.getDni());
                res.setTelefono(reserva.getTelefono());
                break;
            }
        }
        guardar();
     }

}


