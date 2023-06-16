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
        System.out.println("0- cancelar modificacion");
        opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                case 2 -> habitacion.setEstado(Habitacion.EstadoHabitacion.OCUPADA);
                case 3 -> habitacion.setEstado(Habitacion.EstadoHabitacion.RESERVADA);
                case 4 -> habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                case 5 -> habitacion.setEstado(Habitacion.EstadoHabitacion.FUERA_SERVICIO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
        gestion.modificar(habitacion);

    }

    public void opcionesMenuEstado()
    {
        System.out.println("1. Listar Habitaciones");
        System.out.println("2. Agregar Habitacion");
        System.out.println("3. Buscar Habitacion");
        System.out.println("4. Cambiar Estado de Habitacion");
        System.out.println("5. Modificar Habitacion");
        System.out.println("6. Eliminar Habitacion");
        System.out.println("0. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }

    // la creacion de el hotel en crear arreglo de habitaciones.

    //cambiar estados SE DEBERIAN CAMBIAR DESDE LAS RESERVAS
    //PORCENTAJE DE HABITACIONES OCUPADAS
}
