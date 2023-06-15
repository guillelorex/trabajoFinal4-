package org.grupoTP.clases.Usuarios.Reserva;

import java.util.Scanner;

public class GestionReservas {

    public GestionReservas() {}
    public void menuReservas(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Reservas");
        int opcion;
        do{
            System.out.println("1. Guardar Reserva");
            System.out.println("2. Listar Reserva");
            System.out.println("3. Agregar Reserva");
            System.out.println("4. Buscar Reserva");
            System.out.println("5. Eliminar Reserva");
            System.out.println("6. Volver a Menu Principal");
            System.out.println("Seleccione una opcion: ");
            opcion=scan.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Guardando.....");
                    break;
                case 2:
                    System.out.println("Listando.......");
                    break;
                case 3:
                    System.out.println("Agregando.......");
                    break;
                case 4:
                    System.out.println("Buscando.........");
                    break;
                case 5:
                    System.out.println("Eliminando..........");
                    break;
                case 6:
                    System.out.println("Volviendo al Menu Principal......");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcion!=6);
    }

    public void guardarReserva(Reserva r){

        Scanner scan = new Scanner(System.in);
        System.out.println("");

    }

    public void tomarReserva(Reserva r){

        Scanner scan = new Scanner(System.in);
        System.out.println("");

    }

    //tomo reserva, cancelo una reserva, modifico una reserva ( alargar estadia) .

    // comparar fechas para saber si esta ocupada una habitacion.

    //siempre que elijo habitacion


    //comprobacion de si otro cliente tiene misma habitacion->true preguntar si para fecha entra y fecha sale esta ocupada? (comparacion de los dates)
    //generar factura.
    //esto tiene que interactuar obligatoriamente con las habitaciones.


    //voy a reservar la 5, 1. reviso todas las reservas si ya esta reservada. No esta reservada le doy.. ESTA RESERVADA (en la reseva 2334) 2. consulto las fechas.
    // mis dates con las de la otra reserva+MANTENIMIENTO (+3HORAS).
    //puedo hacer la reserva si no dan los dates no la puedo hacer.
}
