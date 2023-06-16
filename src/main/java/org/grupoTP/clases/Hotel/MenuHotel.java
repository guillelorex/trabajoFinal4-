package org.grupoTP.clases.Hotel;

import java.util.Scanner;
import org.grupoTP.clases.Login.MenuLogueo;

public class MenuHotel {

    public MenuHotel() {}

    public void suuitchHotel(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Hotel");
        int opcion;
        do{
            opcionesMenuHotel();
            opcion=scan.nextInt();
            switch (opcion){

                case 1:
                    System.out.println("Mostrando Habitaciones");
                    MenuLogueo.retraso();
                    break;
                case 2:
                    System.out.println("Cargando Constructor de Habitaciones");
                    MenuLogueo.retraso();
                    break;
                case 3:
                    System.out.println("Buscando Habitaciones");
                    MenuLogueo.retraso();
                    break;
                case 4:
                    System.out.println("LLamando a Equipo de Mantenimiento");
                    MenuLogueo.retraso();
                    break;
                case 5:
                    System.out.println("Cargando Equipo de Reformas");
                    MenuLogueo.retraso();
                    break;
                case 6:
                    System.out.println("Preparando cargas Explosivas");
                    MenuLogueo.retraso();
                    break;
                case 0:
                    System.out.println("Volviendo al Menu Administracion");
                    MenuLogueo.retraso();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcion!=0);
        scan.close();
    }

    public void opcionesMenuHotel()
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
}
