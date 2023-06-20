package org.grupoTP.clases.Usuarios.Empleados;

import java.util.Scanner;

import org.grupoTP.clases.Login.MenuLogueo;

public class MenuEmpleados {

    public MenuEmpleados() {}

    GestionEmpleados gestionEmpleados = new GestionEmpleados();

    public void suuitchEmpleados(){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do{
            System.out.println(" ");
            System.out.println("Gestion de Empleados");
            System.out.println("--------------------");

            opcionesMenuEmpleados();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Mostrando Empleados");
                    MenuLogueo.retraso();
                    gestionEmpleados.mostrarEmpleadosEnv();
                }
                case 2 -> {
                    System.out.print("Inscribiendo Nuevo Empleado");
                    MenuLogueo.retraso();
                    gestionEmpleados.agregarEmpleadoEnv();
                }
                case 3 -> {
                    System.out.print("Buscando Empleados");
                    MenuLogueo.retraso();
                    gestionEmpleados.buscarEmpleadoEnv();
                }
                case 4 -> {
                    System.out.print("Buscando fechas y plantillas");
                    MenuLogueo.retraso();
                    gestionEmpleados.cambiarEstadoEmpleadoEnv();
                }
                case 5 -> {
                    System.out.print("Mirando el calendario");
                    MenuLogueo.retraso();
                    gestionEmpleados.modificarEmpleadoEnv();
                }
                case 6 -> {
                    System.out.print("Buscando escusas");
                    MenuLogueo.retraso();
                    gestionEmpleados.eliminarEmpleadoEnv();
                }
                case 7 -> {
                    System.out.print("Calculando datos");
                    MenuLogueo.retraso();
                    gestionEmpleados.estadisticasEmpleadosEnv();
                }
                case 8 -> {
                    System.out.print("Chequeando Caja");
                    MenuLogueo.retraso();
                    gestionEmpleados.liquidarSueldosEnv();
                }
                case 0 -> {System.out.print("Volviendo al Menu Principal");
                    MenuLogueo.retraso();}
                default -> System.out.println("Opción invalida");
            }
        }while(opcion!=0);
    }

    public void opcionesMenuEmpleados()
    {
        System.out.println("1. Listar Empleados");
        System.out.println("2. Agregar Empleado");
        System.out.println("3. Buscar Empleado");
        System.out.println("4. cambiar Estado de un Empleado");
        System.out.println("5. Modificar Empleado");
        System.out.println("6. Despedir Empleado");
        System.out.println("7. Estadísticas del Personal");
        System.out.println("8. Liquidar sueldos");
        System.out.println("0. Volver a Menu Principal");
        System.out.print("Seleccione una opción: ");
    }
}
