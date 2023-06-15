package org.grupoTP.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.grupoTP.clases.Hotel.Habitacion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RepoHotel implements IntRepository<Habitacion> {

        private final File archivo = new File("src/main/resources/hotel.json");
        private final ObjectMapper mapper = new ObjectMapper();
        private List<Habitacion> listaHabitaciones;

        @Override
        public void cargar() {

            try {
                CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Habitacion.class);
                this.listaHabitaciones = mapper.readValue(archivo, collectionType);
            } catch (IOException e) {
                this.listaHabitaciones = new ArrayList<>();
            }
        }
        @Override
        public void guardar() {

            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaHabitaciones);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public List<Habitacion> listar() {
            cargar();
            return this.listaHabitaciones;
        }
        @Override
        public void agregar(Habitacion... objeto) {
            cargar();
            this.listaHabitaciones.addAll(List.of(objeto));
            guardar();
        }
        @Override
        public void eliminar(int id) {

            cargar();
            for(Habitacion hab: this.listaHabitaciones){

                if(hab.getNumero() == id){
                    this.listaHabitaciones.remove(hab);
                    break;
                }

            }
            guardar();
        }
        @Override
        public void modificar(Habitacion habitacion) {

        cargar();

        for (Habitacion hab : this.listaHabitaciones) {
            if (hab.getNumero() == habitacion.getNumero()) {
                hab.setPiso(habitacion.getPiso());
                hab.setTipo(habitacion.getTipo());
                hab.setCochera(habitacion.getCochera());
                hab.setEstado(habitacion.getEstado());
                break;
            }
        }
        guardar();
    }

}


