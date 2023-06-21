package org.grupoTP.clases.Usuarios.Reserva;

import java.util.Scanner;

public class MenuReservas {
    GestionReservas gestion=new GestionReservas();

    public void suuitchReservas(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Reservas");
        int opcion;
        int num;
        Reserva reserva;
        do{
            opcionesMenuReservas();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Guardando.....");
                case 2 -> System.out.println("Listando.......");
                case 3 -> System.out.println("Agregando.......");
                case 4 -> {
                    System.out.println("Ingrese el numero de reserva que desea Visualizar: ");
                    num = scan.nextInt();
                    System.out.println("Buscando.........");
                    gestion.devuelveReserva(num);
                }
                case 5 -> {
                    System.out.println("Ingrese el numero de reserva que desea Eliminar: ");
                    num = scan.nextInt();
                    System.out.println("Eliminando..........");
                    gestion.cancelarReserva(num);
                }
                case 6 -> {
                    System.out.println("Ingrese el numero de reserva que desea Modificar: ");
                    num = scan.nextInt();
                    reserva = gestion.devuelveReserva(num);
                    gestion.modificarReserva(reserva);
                    System.out.println("Modificando.......");
                }
                case 7 -> System.out.println("Volviendo al Menu Principal......");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=7);
    }

    public void opcionesMenuReservas()
    {
        System.out.println("1. Guardar Reserva");
        System.out.println("2. Listar Reserva");
        System.out.println("3. Agregar Reserva");
        System.out.println("4. Visualizar Reserva");
        System.out.println("5. Eliminar Reserva");
        System.out.println("6. Modificar Reserva");
        System.out.println("7. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }
}
