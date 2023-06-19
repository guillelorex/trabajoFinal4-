package org.grupoTP.clases.Usuarios.Empleados;

import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.clases.Usuarios.Persona;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Comparator;

public class GestionEmpleados {

    RepoPersonal personal = new RepoPersonal();

    List<Empleado> listaEmpleados = personal.listar();

    //region 1. Mostrar Empleados
    public void mostrarEmpleadosEnv() {
        personalASCIIEstado(listaEmpleados);
        listarEmpleados();
    }

    void listarEmpleados() {
        for (Empleado emp : listaEmpleados) {
            System.out.println(emp);
        }
    }
    //endregion

    //region 2. Agregar empleado
    public void agregarEmpleadoEnv(){
        Empleado emp;
        personalASCIIEstado(listaEmpleados, null);

        emp = crearEmpleado();

        agregarAListaEmpleado(emp);
        personal.agregar(emp);

        System.out.println(emp);
        System.out.println("Empleado inscripto con éxito");
        System.out.println("----------------------------");
    }

    Empleado crearEmpleado() {
        Scanner scan = new Scanner(System.in);
        String dni;
        String password;
        String mail;
        String nombre;
        String apellido;
        Persona.TipoCuenta tipoCuenta=null;
        int tipo;
        int legajo;
        Area area=null;
        int rubro;
        String entrada;
        String salida;   //los localdate se rompen en los json por eso usamos este formato
        String horario;
        //Estado siempre sera ACTIVO

        System.out.println("Ingrese el Legajo:");
        legajo = scan.nextInt();
        System.out.print("\n Ingrese el DNI:");
        dni = scan.nextLine();
        System.out.print("\n Ingrese el mail: ");
        mail = scan.nextLine();
        System.out.print("\n Ingrese el password: ");
        password = scan.nextLine();
        System.out.print("\n Ingrese el nombre: ");
        nombre = scan.nextLine();
        System.out.print("\n Ingrese el apellido: ");
        apellido = scan.nextLine();
        System.out.println("\n Ingrese el tipo de cuenta 1.ADMINISTRADOR 2.RECEPCION 3.EMPLEADO");
        do{
            tipo=scan.nextInt();
            switch (tipo) {
                case 1 -> tipoCuenta = Persona.TipoCuenta.ADMINISTRADOR;
                case 2 -> tipoCuenta = Persona.TipoCuenta.RECEPCION;
                case 3 -> tipoCuenta = Persona.TipoCuenta.EMPLEADO;
                default -> System.out.println("Opción invalida");
            }
        }while(!(tipo == 1 || tipo == 2 || tipo == 3));

        System.out.println("\n Ingrese el Area de cuenta:");
        System.out.println("1. Administración");
        System.out.println("2. Limpieza");
        System.out.println("3. Seguridad");
        System.out.println("4. Cocina");
        System.out.println("5. Mozo");
        System.out.println("6. Valetparking");
        System.out.println("7. Recepción");
        do{
            rubro=scan.nextInt();
            switch (rubro) {
                case 1 -> area = Area.administracion;
                case 2 -> area = Area.limpieza;
                case 3 -> area = Area.seguridad;
                case 4 -> area = Area.cocina;
                case 5 -> area = Area.mozos;
                case 6 -> area = Area.valetparking;
                case 7 -> area = Area.recepcion;
                default -> System.out.println("Opción invalida");
            }
        }while(!(rubro == 1 || rubro == 2 || rubro == 3 || rubro == 4 || rubro == 5 || rubro == 6 || rubro == 7));

        System.out.print("Ingrese un horario de entrada (formato HH:mm): ");
        entrada = scan.nextLine();
        System.out.print("Ingrese un horario de salida (formato HH:mm): ");
        salida = scan.nextLine();
        horario = entrada + " " + salida;
        return new Empleado(dni, password, mail, nombre, apellido, tipoCuenta, legajo, area, horario, Empleado.Estado.ACTIVO);
    }

    //agrego a la lista
    void agregarAListaEmpleado(Empleado emp){

        if(!this.listaEmpleados.contains(emp)){
            this.listaEmpleados.add(emp);
        }

    }
    //endregion

    //region 3. Buscar empleado
    public void buscarEmpleadoEnv(){
        Scanner scan = new Scanner(System.in);
        int legajo;
        Empleado emp;

        personalASCIIEstado(listaEmpleados, null);

        System.out.println("Ingrese el DNI del empleado a buscar:");
        legajo = scan.nextInt();

        emp = buscardorEmpleado(legajo);

        if(emp != null){
            System.out.println(emp);
        }else{
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la empleado  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
    }

    Empleado buscardorEmpleado(int legajo){
        for (Empleado emp : listaEmpleados) {
            if(emp.getLegajo()==legajo){
                return emp;
            }
        }
        return null;
    }
    //endregion

    //region 4. Cambiar el horario de un Empleado

    //endregion
}
