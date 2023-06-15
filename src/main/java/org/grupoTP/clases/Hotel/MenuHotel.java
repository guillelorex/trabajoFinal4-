package org.grupoTP.clases.Hotel;

import java.util.Scanner;

public class MenuHotel {

    public static void gestionDeHotel(){
        Scanner scanSub1=new Scanner(System.in);
        System.out.println("Gestion de Hotel");
        int opcionSub1;
        do{

            System.out.println("1. Listar Habitacion");
            System.out.println("2. Agregar Habitacion");
            System.out.println("3. Buscar Habitacion");
            System.out.println("4. Eliminar Habitacion");
            System.out.println("5. Volver a Menu Principal");
            System.out.println("Seleccione una opcion: ");

            opcionSub1=scanSub1.nextInt();
            switch (opcionSub1){

                case 1:
                    System.out.println("Listando.......");
                    break;
                case 2:
                    System.out.println("Agregando.......");

                    break;
                case 3:
                    System.out.println("Buscando.........");
                    break;
                case 4:
                    System.out.println("Eliminando..........");
                    break;
                case 5:
                    System.out.println("Volviendo al Menu Principal......");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcionSub1!=6);
        scanSub1.close();
    }
}
