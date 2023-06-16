package org.grupoTP.clases.Usuarios.Admin;

import org.grupoTP.clases.Hotel.MenuHotel;
import org.grupoTP.clases.Login.MenuLogueo;
import java.util.Scanner;

public class MenuAdmin {

    public MenuAdmin() {}

    public void suuitchAdmin(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion Administrativa");
        int opcion;
        do{
            opcionesMenuAdmin();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Cargando Gestion de Hotel");
                    MenuLogueo.retraso();
                    MenuHotel menuHotel = new MenuHotel();
                    menuHotel.suuitchHotel();
                }
                case 2 -> {
                    System.out.print("Cargando Gestion de Empleados");
                    MenuLogueo.retraso();
                }
                case 3 -> {
                    System.out.print("Abriendo Balances");
                    MenuLogueo.retraso();
                }
                case 4 -> {
                    System.out.print("Chequeando Habitaciones");
                    MenuLogueo.retraso();
                }
                case 0 -> {
                    System.out.print("Saliendo del Sistema");
                    MenuLogueo.retraso();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }

    public void opcionesMenuAdmin()
    {
        System.out.println("1. Gestion de Hotel");
        System.out.println("2. Gestion de Empleados");
        System.out.println("3. Balances");
        System.out.println("4. Ver Porcentajes de habitaciones");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion: ");
    }

}
