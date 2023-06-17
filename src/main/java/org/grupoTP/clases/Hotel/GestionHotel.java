package org.grupoTP.clases.Hotel;

import org.grupoTP.Repositorios.RepoHotel;
import org.grupoTP.clases.Usuarios.Empleados.MenuEmpleados;


import java.util.List;
import java.util.Scanner;

public class GestionHotel {

    RepoHotel hotel = new RepoHotel();

    List<Habitacion> listaHabitaciones = hotel.listar();

    void mostrarHabitaciones() {
        hotelASCII(listaHabitaciones);
        for (Habitacion hab : listaHabitaciones) {
            System.out.println(hab);
        }
    }

    //region cambiar estado de habitacion
    public void cambiarEstado(Habitacion habitacion){

       Scanner scan = new Scanner(System.in);
       int opcion;
        do{
            opcionesMenuEstado();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> habitacion.setEstado(Habitacion.EstadoHabitacion.DISPONIBLE);
                case 2 -> habitacion.setEstado(Habitacion.EstadoHabitacion.OCUPADA);
                case 3 -> habitacion.setEstado(Habitacion.EstadoHabitacion.RESERVADA);
                case 4 -> habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                case 5 -> habitacion.setEstado(Habitacion.EstadoHabitacion.FUERA_SERVICIO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }

    public void opcionesMenuEstado()
    {
        System.out.println("Ingrese el estado actual de la habitacion");
        System.out.println("1- Disponible");
        System.out.println("2- Ocupada");
        System.out.println("3- Reservada");
        System.out.println("4- Mantenimiento");
        System.out.println("5- Fuera de servicio");
        System.out.println("0- cancelar modificacion");
        System.out.println("Seleccione una opcion: ");
    }
    //endregion

    //region Contadores

    public int contarHabitaciones(List<Habitacion> listaHabitaciones){
        int contador = 0;
        for (Habitacion habitacion : listaHabitaciones) {
            contador++;
        }
        return contador;
    }

    public int contarHabitacionesPorPiso(List<Habitacion> listaHabitaciones, int piso){
        int contador = 0;
        for (Habitacion habitacion : listaHabitaciones) {
            if(habitacion.getPiso() == piso){
                contador++;
            }
        }
        return contador;
    }

    public int contarPisos(List<Habitacion> listaHabitaciones){
        int contador = 0;
        for (Habitacion habitacion : listaHabitaciones) {
            if(habitacion.getPiso() > contador){
                contador = habitacion.getPiso();
            }
        }
        return contador;
    }

    //endregion

    //region Dibujar Hotel
    public void hotelASCII(List<Habitacion> Habitaciones){

        char izqTecho = 201;
        char techo = 61;
        char derTecho = 187;
        char pared = 186;
        char ventana;

        int pisos = contarPisos(Habitaciones);
        int ultimoPiso = contarHabitacionesPorPiso(Habitaciones, contarPisos(Habitaciones));

        // Dibujar techo del Hotel
        System.out.printf("%c",izqTecho);
        System.out.printf("%c",techo);
        for (int i = 0; i < ultimoPiso; i++) {
            System.out.printf("%c",techo);
            System.out.printf("%c",techo);
        }
        System.out.printf("%c",derTecho);

        System.out.println(); // Salto de línea

        // Dibujar pared del hotel
        for (int i = pisos; i > 0; i--) {
            System.out.printf("%c",pared); // Borde izquierdo pared
            // Habitaciones por piso
            int habPorPiso = contarHabitacionesPorPiso(Habitaciones, i);
            for (int j = 0; j < habPorPiso; j++) {
                switch (Habitaciones.get(j).getEstado()){
                    case DISPONIBLE ->
                        {ventana=176;
                        System.out.printf(" %c",ventana);}
                    case OCUPADA ->
                        {ventana=178;
                        System.out.printf(" %c",ventana);}
                    case RESERVADA ->
                        {ventana=177;
                        System.out.printf(" %c",ventana);}
                    case MANTENIMIENTO ->
                        {ventana=219;
                        System.out.printf(" %c",ventana);}
                    case FUERA_SERVICIO ->
                        {ventana=244;
                        System.out.printf(" %c",ventana);}
                }
            }
            System.out.print(" ");
            System.out.printf("%c",pared); // Borde derecho pared
        }
        System.out.println(); // Salto de línea
    }
    //endregion

    // la creación del hotel es crear arreglo de habitaciones.

    //cambiar estados SE DEBERÍAN CAMBIAR DESDE LAS RESERVAS
    //PORCENTAJE DE HABITACIONES OCUPADAS
}
