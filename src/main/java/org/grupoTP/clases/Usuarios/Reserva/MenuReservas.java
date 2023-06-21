package org.grupoTP.clases.Usuarios.Reserva;

import org.grupoTP.clases.Hotel.GestionHotel;
import org.grupoTP.clases.Login.LoginUsuarios;

import java.util.Scanner;

public class MenuReservas {

    GestionReservas gestionReservas = new GestionReservas();
    GestionHotel gestionHotel = new GestionHotel();

    public void suuitchReservas(){
        Scanner scan=new Scanner(System.in);
        int opcion;

        do{
            System.out.println(" ");
            System.out.println("Gestion de Reservas");
            System.out.println("-------------------");

            opcionesMenuReservas();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Mirando el llavero");
                    LoginUsuarios.retraso();
                    gestionReservas.mostrarReservasEnv();
                }
                case 2 -> {
                    System.out.println("Abriendo los libros");
                    LoginUsuarios.retraso();
                    gestionReservas.agregarReservaEnv();
                }
                case 3 -> {
                    System.out.println("Buscando en los libros");
                    LoginUsuarios.retraso();
                    gestionReservas.buscarReservaEnv();
                }
                case 4 -> {
                    System.out.println("Salude al cliente antes antes de continuar");
                    LoginUsuarios.retraso();
                    gestionReservas.cambiarEstadoReservaEnv();
                }
                case 5 -> {
                    System.out.println("Buscando datos de la reserva");
                    LoginUsuarios.retraso();
                    gestionReservas.modificarReservaEnv();
                }
                case 6 -> {
                    System.out.println("Buscando datos de la reserva y el borrador");
                    LoginUsuarios.retraso();
                    gestionReservas.borrarReservaEnv();
                }
                case 7 -> {
                    System.out.println("Calculando datos");
                    LoginUsuarios.retraso();
                    gestionHotel.estadisticasHotelEnv();
                }
                case 8 -> {
                    System.out.println("Buscando la Caja");
                    LoginUsuarios.retraso();
                    gestionReservas.cobrarHabitacionEnv();
                }
                case 0 -> {
                    System.out.print("Volviendo al Menu Administración");
                    LoginUsuarios.retraso();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=7);
    }

    public void opcionesMenuReservas()
    {
        System.out.println("1. Listar Reservaciones");
        System.out.println("2. Agregar Reservacion");
        System.out.println("3. Buscar Reservacion");
        System.out.println("4. Cambiar Estado CHECK-IN CHECK-OUT");
        System.out.println("5. Modificar Reservacion");
        System.out.println("6. Eliminar Reservacion");
        System.out.println("7. Ver estadísticas del hotel");
        System.out.println("8. Cobrar Reservacion");
        System.out.println("0. Volver al Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }
}
