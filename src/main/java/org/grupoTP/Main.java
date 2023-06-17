package org.grupoTP;

import org.grupoTP.Repositorios.RepoHotel;
import org.grupoTP.clases.Hotel.Habitacion;
import org.grupoTP.clases.Hotel.TipoHabitacion;

import org.grupoTP.clases.Usuarios.Admin.MenuAdmin;


public class Main {
    public static void main(String[] args) {

        //region Creacion de habitaciones para el archivo Hotel.json
        /* RepoHotel hotel = new RepoHotel();

        Habitacion habitacion1  = new Habitacion(11,1, TipoHabitacion.SIM, true,  Habitacion.EstadoHabitacion.OCUPADA);
        Habitacion habitacion2  = new Habitacion(12,1, TipoHabitacion.DOB, true,  Habitacion.EstadoHabitacion.OCUPADA);
        Habitacion habitacion3  = new Habitacion(13,1, TipoHabitacion.DOB, false, Habitacion.EstadoHabitacion.DISPONIBLE);
        Habitacion habitacion4  = new Habitacion(14,1, TipoHabitacion.SIM, false, Habitacion.EstadoHabitacion.FUERA_SERVICIO);
        Habitacion habitacion5  = new Habitacion(21,2, TipoHabitacion.TRI, false, Habitacion.EstadoHabitacion.OCUPADA);
        Habitacion habitacion6  = new Habitacion(22,2, TipoHabitacion.TRI, true,  Habitacion.EstadoHabitacion.DISPONIBLE);
        Habitacion habitacion7  = new Habitacion(23,2, TipoHabitacion.TRI, true,  Habitacion.EstadoHabitacion.DISPONIBLE);
        Habitacion habitacion8  = new Habitacion(24,2, TipoHabitacion.TRI, true,  Habitacion.EstadoHabitacion.MANTENIMIENTO);
        Habitacion habitacion9  = new Habitacion(31,3, TipoHabitacion.SUI, true,  Habitacion.EstadoHabitacion.OCUPADA);
        Habitacion habitacion10 = new Habitacion(32,3, TipoHabitacion.DOB, false, Habitacion.EstadoHabitacion.OCUPADA);
        Habitacion habitacion11 = new Habitacion(33,3, TipoHabitacion.DOB, false, Habitacion.EstadoHabitacion.DISPONIBLE);
        Habitacion habitacion12 = new Habitacion(34,3, TipoHabitacion.SUI, true,  Habitacion.EstadoHabitacion.DISPONIBLE);

        hotel.agregar(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5, habitacion6, habitacion7, habitacion8, habitacion9, habitacion10, habitacion11, habitacion12);
        hotel.listar().forEach(System.out::println);
        */
        //endregion

        /*
        RepoReserva reservas = new RepoReserva();

        Reserva reserva1 = new Reserva("guille", "laurencio", "34561223","2235454567","1@gmail.com","123",11,1,"6/6/2023","8/6/2023", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.HUESPED, Reserva.pension.MEDIA, Reserva.formaPago.EFECTIVO);
        Reserva reserva2 = new Reserva("maty", "striker", "3456657653","2235456567","2@gmail.com","123",22,2,"10/6/2023","14/6/2023", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.VIP, Reserva.pension.ALLINCLUSIVE, Reserva.formaPago.TARJETA);

        reservas.agregar(reserva1);
        reservas.agregar(reserva2);

        reservas.listar().forEach(System.out::println);
        */
        MenuAdmin menuAdmin = new MenuAdmin();

        menuAdmin.suuitchAdmin();

    }
}