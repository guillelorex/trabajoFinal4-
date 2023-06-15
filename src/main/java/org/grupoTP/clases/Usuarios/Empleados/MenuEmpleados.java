package org.grupoTP.clases.Usuarios.Empleados;

import java.util.Scanner;

public class MenuEmpleados {

    public static void gestionDeEmpleados(){
        Scanner scanSub2=new Scanner(System.in);
        System.out.println("Gestion de Personal");
        int opcionSub2;
        do{
            System.out.println("1. Modificar Empleado");
            System.out.println("2. Listar Empleado");
            System.out.println("3. Agregar Empleado");
            System.out.println("4. Buscar Empleado");
            System.out.println("5. Eliminar Empleado");
            System.out.println("6. Volver al Menu Principal");
            System.out.println("Seleccione una opcion: ");
            opcionSub2=scanSub2.nextInt();
            switch (opcionSub2){
                case 1:
                    System.out.println("Modificando Empleado....");
                    break;
                case 2:
                    System.out.println("Listando Empleado....");
                    break;
                case 3:
                    System.out.println("Agregando Empleado....");
                    break;
                case 4:
                    System.out.println("Buscando Empleado....");
                    break;
                case 5:
                    System.out.println("Eliminando Empleado....");
                    break;
                case 6:
                    System.out.println("Volviendo al Menu Principal....");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcionSub2!=6);
        scanSub2.close();
    }
}
