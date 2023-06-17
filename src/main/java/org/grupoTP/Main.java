package org.grupoTP;

import org.grupoTP.Repositorios.RepoHotel;
import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.clases.Hotel.Habitacion;
import org.grupoTP.clases.Hotel.TipoHabitacion;

import org.grupoTP.clases.Usuarios.Admin.MenuAdmin;
import org.grupoTP.clases.Usuarios.Empleados.Area;
import org.grupoTP.clases.Usuarios.Empleados.Empleado;
import org.grupoTP.clases.Usuarios.Persona;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;

import java.util.List;


public class Main {
    public static void main(String[] args) {




        // Empleado empleado = new Empleado("34561223", "1234", "guille@gmail.com", "Guille", "Laurencio", , 1, Area.mozos, "10 a 22", Empleado.Estado.ACTIVO, true);
        MenuAdmin menuAdmin = new MenuAdmin();

         menuAdmin.suuitchAdmin();

    }
}