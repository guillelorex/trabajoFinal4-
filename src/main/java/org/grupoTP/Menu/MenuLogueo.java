package org.grupoTP.Menu;

import java.util.Scanner;

public class MenuLogueo {

    public MenuLogueo(){}

    public void menuPrincipal(){

        Scanner scanMenu=new Scanner(System.in);
        int opcion;
        do{
            opcionesMenuPrincipal();
            opcion=scanMenu.nextInt();

            switch (opcion){
                case 1:
                    gestionDeHotel();
                    break;
                case 2:
                    gestionDeEmpleados();
                    break;
                case 3:
                {
                    gestionReservas=new GestionReservas();
                    gestionReservas.menuReservas();
                }
                    break;
                case 4:
                    System.out.println("Saliendo... ");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        }while(opcion!=4);
        scanMenu.close();
    }

    public void opcionesMenuPrincipal(){
        System.out.println("1. Gestion del Hotel");
        System.out.println("2. Gestion de Personal");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opcion: ");
    }







}

