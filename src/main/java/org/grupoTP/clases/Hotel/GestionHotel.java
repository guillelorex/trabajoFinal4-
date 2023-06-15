package org.grupoTP.clases.Hotel;

import org.grupoTP.Repositorios.RepoHotel;

import java.util.Scanner;

public class GestionHotel {

    RepoHotel gestion = new RepoHotel();

    public void cambiarEstado(Habitacion habitacion){

       Scanner scan = new Scanner(System.in);
       int opcion;
        do{

        System.out.println("Ingrese el estado actual de la habitacion");
        System.out.println("1- Disponible");
        System.out.println("2- Ocupada");
        System.out.println("3- Reservada");
        System.out.println("4- Mantenimiento");
        System.out.println("5- Fuera de servicio");
        System.out.println("6- Volver al menu anterior");
        opcion = scan.nextInt();

        switch (opcion){
            case 1:
                habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                break;
            case 2:
                habitacion.setEstado(Habitacion.EstadoHabitacion.OCUPADA);
                break;
            case 3:
                habitacion.setEstado(Habitacion.EstadoHabitacion.RESERVADA);
                break;
            case 4:
                habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                break;
            case 5:
                habitacion.setEstado(Habitacion.EstadoHabitacion.FUERA_SERVICIO);
                break;
            case 6:
                System.out.println("Volver al menu anterior");;
                break;
            default:
                System.out.println("Opcion invalida");
                break;
           }
        }while(opcion!=6);
        scan.close();
        gestion.modificar(habitacion);

    }

    // la creacion de el hotel en crear arreglo de habitaciones.

    //cambiar estados SE DEBERIAN CAMBIAR DESDE LAS RESERVAS
    //PORCENTAJE DE HABITACIONES OCUPADAS
}
