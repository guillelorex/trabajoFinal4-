package org.grupoTP;

import org.grupoTP.Repositorios.RepoHotel;
import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.Repositorios.RepoReserva;

import org.grupoTP.clases.Hotel.Habitacion;
import org.grupoTP.clases.Hotel.TipoHabitacion;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;
import org.grupoTP.clases.Usuarios.Empleados.Area;
import org.grupoTP.clases.Usuarios.Empleados.Empleado;
import org.grupoTP.clases.Usuarios.Persona;

import org.grupoTP.clases.Usuarios.Admin.MenuAdmin;


public class Main {
    public static void main(String[] args) {


        System.out.println("     ▒░░░░░▒▒");
        System.out.println("   ▓░░░░▒▒▒░░░░▒");
        System.out.println("   ░░░░▓▒░░░▒▒▒▓");
        System.out.println("   ░░░░▒▓▓▓▓▓▓▒▒▒");
        System.out.println("   ▓░░░░░░░░░░░░░▒         >>Despedido al Mercado Laboral<<");
        System.out.println(" ▒░▒▓░░░░░░░░░░░░░▒          Empleado: Guillermo Lorenzo");
        System.out.println(" ░░░▒▓░░░░░░░░░░░░░▓           Puesto: Mozo");
        System.out.println("  ░░░▓▓▒░░░░░░░░░░░            Legajo: 3");
        System.out.println("   ░░░▓▓▒▒░░░░░░░▒▓");



            System.out.println("    ▓▓▓  ▓▒▒▒▒▒▒▓▓      Pero No era el impostor");

        System.out.println("          ▓▒▒▒▒▓▒▒▓");
        System.out.println("        ▓▒▒▒▒▒▒▓▒▒▓");
        System.out.println("        ▓▒▒▒▓▓▓▒▒▓");


        MenuAdmin menuAdmin = new MenuAdmin();

         menuAdmin.suuitchAdmin();

    }
}