package org.grupoTP.clases.Usuarios.Admin;

import org.grupoTP.clases.Login.LoginUsuarios;

import org.grupoTP.clases.Hotel.MenuHotel;
import org.grupoTP.clases.Usuarios.Empleados.MenuEmpleados;
import org.grupoTP.clases.Usuarios.Reserva.MenuReservas;

import java.util.Scanner;

public class MenuAdmin {

    public MenuAdmin() {}

    MenuHotel menuHotel = new MenuHotel();
    MenuEmpleados menuEmpleados = new MenuEmpleados();
    MenuReservas menuReservas = new MenuReservas();
    MenuCaja menuCaja = new MenuCaja();

    public void suuitchAdmin(){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do{
            System.out.println(" ");
            System.out.println("Gestion de Administrativa");
            System.out.println("-------------------------");

            opcionesMenuAdmin();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Cargando Gestion de Hotel");
                    LoginUsuarios.retraso();
                    menuHotel.suuitchHotel();
                }
                case 2 -> {
                    System.out.print("Cargando Gestion de Empleados");
                    LoginUsuarios.retraso();
                    menuEmpleados.suuitchEmpleados();
                    //menuEmpleados.suuitchEmpleados();
                }
                case 3 -> {
                    System.out.print("Abriendo Reservas");
                    LoginUsuarios.retraso();
                    menuReservas.suuitchReservas();
                }
                case 4 -> {
                    System.out.print("Abriendo Balances");
                    LoginUsuarios.retraso();
                    menuCaja.suuitchCaja();
                }
                case 0 ->{
                    System.out.print("Nos vemos Jefe");
                    LoginUsuarios.retraso();
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
        System.out.println("3. Gestion de Reservas");
        System.out.println("4. Gestion de Caja");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

}

