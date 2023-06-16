package org.grupoTP.clases.Usuarios.Admin;

import java.sql.SQLOutput;
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
                    retraso();
                }
                case 2 -> {
                    System.out.print("Cargando Gestion de Empleados");
                    retraso();
                }
                case 3 -> {
                    System.out.print("Abriendo Balances");
                    retraso();
                }
                case 0 -> {
                    System.out.print("Saliendo del Sistema");
                    retraso();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
    }

    public void opcionesMenuAdmin()
    {
        System.out.println("1. Gestion de Hotel");
        System.out.println("2. Gestion de Empleados");
        System.out.println("3. Balances");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    public void retraso(){
       try{
        for (int i = 0; i < 5; i++) {
            Thread.sleep(300);
            System.out.print(".");
            }
           System.out.println(" ");
        }catch(Exception e) {
        System.out.println(e);
        }
    }
}
