package org.grupoTP.clases.Usuarios.Empleados;

import java.util.Scanner;

import org.grupoTP.clases.Login.LoginUsuarios;

public class MenuEmpleados {

    public MenuEmpleados() {}

    GestionEmpleados gestionEmpleados = new GestionEmpleados();
    //deserializar la caja aca y en reserva
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
                    LoginUsuarios.retraso();
                    gestionEmpleados.mostrarEmpleadosEnv();
                }
                case 2 -> {
                    System.out.print("Inscribiendo Nuevo Empleado");
                    LoginUsuarios.retraso();
                    gestionEmpleados.agregarEmpleadoEnv();
                }
                case 3 -> {
                    System.out.print("Buscando Empleados");
                    LoginUsuarios.retraso();
                    gestionEmpleados.buscarEmpleadoEnv();
                }
                case 4 -> {
                    System.out.print("Buscando fechas y plantillas");
                    LoginUsuarios.retraso();
                    gestionEmpleados.cambiarEstadoEmpleadoEnv();
                }
                case 5 -> {
                    System.out.print("Mirando el calendario");
                    LoginUsuarios.retraso();
                    gestionEmpleados.modificarEmpleadoEnv();
                }
                case 6 -> {
                    System.out.print("Buscando escusas");
                    LoginUsuarios.retraso();
                    gestionEmpleados.eliminarEmpleadoEnv();
                }
                case 7 -> {
                    System.out.print("Calculando datos");
                    LoginUsuarios.retraso();
                    gestionEmpleados.estadisticasEmpleadosEnv();
                }
                case 8 -> {
                    System.out.print("Chequeando Caja");
                    LoginUsuarios.retraso();
                    gestionEmpleados.liquidarSueldosEnv();
                }
                case 0 -> {System.out.print("Volviendo al Menu Principal");
                    LoginUsuarios.retraso();}
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
