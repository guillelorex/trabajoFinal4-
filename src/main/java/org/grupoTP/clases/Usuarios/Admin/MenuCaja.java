package org.grupoTP.clases.Usuarios.Admin;

import org.grupoTP.clases.Login.MenuLogueo;

import java.util.Scanner;

public class MenuCaja {

    public MenuCaja() {}
    GestionCaja gestionCaja = new GestionCaja();

    public void suuitchCaja(){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do{
            System.out.println(" ");
            System.out.println("Gestion de Caja");
            System.out.println("---------------");

            opcionesMenuAdmin();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Abriendo Libros");
                    MenuLogueo.retraso();
                    gestionCaja.mostrarCajaEnv();
                }
                case 2 -> {
                    System.out.print("Buscando Caja de Zapatos vacía");
                    MenuLogueo.retraso();
                    gestionCaja.crearCajaEnv();
                }
                case 3 -> {
                    System.out.print("Modificando Caja");
                    MenuLogueo.retraso();
                    gestionCaja.modificarCajaEnv();
                }
                case 4 -> {
                    System.out.print("Buscando hojas A4");
                    MenuLogueo.retraso();
                    gestionCaja.imprimirCajaEnv();
                }
                case 0 -> {
                    System.out.print("Saliendo del Sistema");
                    MenuLogueo.retraso();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
    }

    public void opcionesMenuAdmin()
    {
        System.out.println("1. Ver Caja");
        System.out.println("2. Crear Caja");
        System.out.println("3. Modificar Caja");
        System.out.println("4. imprimir Balance mensual");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

}



