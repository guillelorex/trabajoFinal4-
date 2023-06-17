package org.grupoTP.clases.Hotel;

import java.util.List;
import java.util.Scanner;

import org.grupoTP.clases.Login.MenuLogueo;
import org.grupoTP.Repositorios.RepoHotel;

public class MenuHotel {

    public MenuHotel() {}

    GestionHotel gestionHotel = new GestionHotel();

    public void suuitchHotel(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Hotel");
        int opcion;
        do{
            opcionesMenuHotel();
            opcion=scan.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Mostrando Habitaciones");
                    MenuLogueo.retraso();
                    gestionHotel.mostrarHabitaciones();
                }
                case 2 -> {
                    System.out.print("Cargando Constructor de Habitaciones");
                    MenuLogueo.retraso();
                }
                case 3 -> {
                    System.out.print("Buscando Habitaciones");
                    MenuLogueo.retraso();
                }
                case 4 -> {
                    System.out.print("Llamando a Equipo de Mantenimiento");
                    MenuLogueo.retraso();
                }
                case 5 -> {
                    System.out.print("Cargando Equipo de Reformas");
                    MenuLogueo.retraso();
                }
                case 6 -> {
                    System.out.print("Preparando cargas Explosivas");
                    MenuLogueo.retraso();
                }
                case 7 -> {
                    System.out.print("Calculando datos");
                    MenuLogueo.retraso();
                }
                case 0 -> {
                    System.out.print("Volviendo al Menu Administracion");
                    MenuLogueo.retraso();
                }
                default -> System.out.println("Opcion invalida");
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
        System.out.println("Seleccione una opcion: ");
    }
}
