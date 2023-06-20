package org.grupoTP.clases.Usuarios.Reserva;

import java.util.Scanner;

public class MenuReservas {
    public void suuitchReservas(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Reservas");
        int opcion;
        do{
            opcionesMenuReservas();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Guardando.....");
                case 2 -> System.out.println("Listando.......");
                case 3 -> System.out.println("Agregando.......");
                case 4 -> System.out.println("Buscando.........");
                case 5 -> System.out.println("Eliminando..........");
                case 6 -> System.out.println("Volviendo al Menu Principal......");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=6);
    }

    public void opcionesMenuReservas()
    {
        System.out.println("1. Guardar Reserva");
        System.out.println("2. Listar Reserva");
        System.out.println("3. Agregar Reserva");
        System.out.println("4. Buscar Reserva");
        System.out.println("5. Eliminar Reserva");
        System.out.println("6. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }
}
