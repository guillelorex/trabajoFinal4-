package org.grupoTP.clases.Hotel;

import java.util.Scanner;

import org.grupoTP.clases.Login.MenuLogueo;

public class MenuHotel {

    public MenuHotel() {}

    GestionHotel gestionHotel = new GestionHotel();

    public void suuitchHotel(){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do{
            System.out.println(" ");
            System.out.println("Gestion de Hotel");
            System.out.println("----------------");

            opcionesMenuHotel();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Mostrando Habitaciones");
                    MenuLogueo.retraso();
                    gestionHotel.mostrarHabitacionesEnv();
                }
                case 2 -> {
                    System.out.print("Cargando Constructor de Habitaciones");
                    MenuLogueo.retraso();
                    gestionHotel.agregarHabitacionEnv();
                }
                case 3 -> {
                    System.out.print("Buscando Habitaciones");
                    MenuLogueo.retraso();
                    gestionHotel.buscarHabitacionEnv();
                }
                case 4 -> {
                    System.out.print("Llamando a Equipo de Mantenimiento");
                    MenuLogueo.retraso();
                    gestionHotel.cambiarEstadoHabitacionEnv();
                }
                case 5 -> {
                    System.out.print("Cargando Equipo de Reformas");
                    MenuLogueo.retraso();
                    gestionHotel.modificarHabitacionEnv();
                }
                case 6 -> {
                    System.out.print("Preparando cargas Explosivas");
                    MenuLogueo.retraso();
                    gestionHotel.eliminarHabitacionEnv();
                }
                case 7 -> {
                    System.out.print("Calculando datos");
                    MenuLogueo.retraso();
                    gestionHotel.estadisticasHotelEnv();
                }
                case 0 -> {
                    System.out.print("Volviendo al Menu Administración");
                    MenuLogueo.retraso();
                }
                default -> System.out.println("Opción invalida");
            }
        }while(opcion!=0);
    }

    public void opcionesMenuHotel()
    {
        System.out.println("1. Listar Habitaciones");
        System.out.println("2. Agregar Habitacion");
        System.out.println("3. Buscar Habitacion");
        System.out.println("4. Cambiar Estado de Habitacion");
        System.out.println("5. Modificar Habitacion");
        System.out.println("6. Eliminar Habitacion");
        System.out.println("7. Ver estadísticas del hotel");
        System.out.println("0. Volver a Menu Principal");
        System.out.print("Seleccione una opción: ");
    }
}
