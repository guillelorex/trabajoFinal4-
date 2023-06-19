package org.grupoTP.clases.Usuarios.Empleados;

import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.clases.Usuarios.Persona;


import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Random;

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
        personalASCIIBuscar(listaEmpleados, null);

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
        Empleado.Horario horario=null;
        int hora;
        //Estado siempre sera ACTIVO

        System.out.print("\n Ingrese el Legajo: ");
        legajo = scan.nextInt();
        System.out.print("\n Ingrese el DNI: ");
        dni = scan.nextLine();
        System.out.print("\n Ingrese el mail: ");
        mail = scan.nextLine();
        System.out.print("\n Ingrese el password: ");
        password = scan.nextLine();
        System.out.print("\n Ingrese el nombre: ");
        nombre = scan.nextLine();
        System.out.print("\n Ingrese el apellido: ");
        apellido = scan.nextLine();
        System.out.println("\n Ingrese el tipo de cuenta 1.ADMINISTRADOR 2.RECEPCIÓN 3.EMPLEADO: ");
        do{
            tipo=scan.nextInt();
            switch (tipo) {
                case 1 -> tipoCuenta = Persona.TipoCuenta.ADMINISTRADOR;
                case 2 -> tipoCuenta = Persona.TipoCuenta.RECEPCION;
                case 3 -> tipoCuenta = Persona.TipoCuenta.EMPLEADO;
                default -> System.out.println("Opción invalida");
            }
        }while(!(tipo == 1 || tipo == 2 || tipo == 3));

        System.out.println("Ingrese el Area de cuenta:");
        System.out.println("1. Administración");
        System.out.println("2. Limpieza");
        System.out.println("3. Seguridad");
        System.out.println("4. Cocina");
        System.out.println("5. Mozo");
        System.out.println("6. Valet parking");
        System.out.println("7. Recepción");
        do{
            rubro=scan.nextInt();
            switch (rubro) {
                case 1 -> area = Area.MANTENIMIENTO;
                case 2 -> area = Area.ADMINISTRACION;
                case 3 -> area = Area.LIMPIEZA;
                case 4 -> area = Area.SEGURIDAD;
                case 5 -> area = Area.COCINA;
                case 6 -> area = Area.MOZOS;
                case 7 -> area = Area.VALETPARKING;
                case 8 -> area = Area.RECEPCION;
                default -> System.out.println("Opción invalida");
            }
        }while(!(rubro == 1 || rubro == 2 || rubro == 3 || rubro == 4 || rubro == 5 || rubro == 6 || rubro == 7 || rubro == 8));

        System.out.print("\n Ingrese un horario de entrada 1.MAÑANA 2.TARDE 3.NOCHE: ");
        do{
            hora=scan.nextInt();
            switch (hora) {
                case 1 -> horario = Empleado.Horario.MANANA;
                case 2 -> horario = Empleado.Horario.TARDE;
                case 3 -> horario = Empleado.Horario.NOCHE;
                default -> System.out.println("Opción invalida");
            }
        }while(!(hora == 1 || hora == 2 || hora == 3));
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

        personalASCIIEstado(listaEmpleados);
        System.out.print("\nIngrese el Legajo del empleado a buscar:");
        int legajo = scan.nextInt();
        Empleado emp = buscardorDeEmpleado(legajo);

        if(emp == null){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la empleado  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }else{
            personalASCIIBuscar(listaEmpleados, emp);
            System.out.println(emp);
        }
    }

    Empleado buscardorDeEmpleado(int legajo){
        listaEmpleados.sort(Comparator.comparing(Empleado::getLegajo));
        for (Empleado emp : listaEmpleados) {
            if(emp.getLegajo()==legajo){
                return emp;
            }
        }
        return null;
    }
    //endregion

    //region 4. Cambiar el Estado de un Empleado

    public void cambiarEstadoEmpleadoEnv() {
        Scanner scan = new Scanner(System.in);
        int legajo;
        Empleado emp;

        personalASCIIEstado(listaEmpleados);

        System.out.println("Ingrese el Legajo del empleado a buscar:");
        legajo = scan.nextInt();
        emp = buscardorDeEmpleado(legajo);

        personalASCIIBuscar(listaEmpleados, emp);

        if (emp == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró el empleado  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {

            cambiarEstado(emp);

            personal.modificar(emp);

            personalASCIIEstado(listaEmpleados);
            System.out.println(emp);
            System.out.println("Estado cambiado con éxito");
            System.out.println("-------------------------");
        }
    }
    void cambiarEstado(Empleado emp) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            opcionesMenuEstado();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> emp.setEstado(Empleado.Estado.ACTIVO);
                case 2 -> emp.setEstado(Empleado.Estado.BAJA);
                case 3 -> emp.setEstado(Empleado.Estado.VACACIONES);
                default -> System.out.println("Opción invalida");
            }
        }while(!(opcion==1 || opcion==2 || opcion==3));
    }

    void opcionesMenuEstado(){
        System.out.println("Ingrese el nuevo estado actual del empleado:");
        System.out.println("1- Activo");
        System.out.println("2- Baja");
        System.out.println("3- Vacaciones");
        System.out.println("Seleccione una opción: ");
    }
    //endregion

    //region 5. Modificar datos de un empleado
    public void modificarEmpleadoEnv() {
        Scanner scan = new Scanner(System.in);
        int legajo;
        Empleado emp;

        personalASCIIBuscar(listaEmpleados, null);
        listarEmpleados();

        System.out.println("Ingrese el Legajo del empleado a buscar:");
        legajo = scan.nextInt();

        emp = buscardorDeEmpleado(legajo);
        personalASCIIBuscar(listaEmpleados, emp);

        if (emp == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró el empleado  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }else{
            System.out.println(emp);

            personal.eliminar(emp.getLegajo()); //elimino el empleado de la lista y lo vuelvo a agregar por sí se modificó el legajo.
            emp=crearEmpleado();                //lo debo eliminar primero porque si agrego algo ya contenido, no lo agrega.
            agregarAListaEmpleado(emp);
            personal.agregar(emp);

            personalASCIIBuscar(listaEmpleados,emp);
            System.out.println(emp);
            System.out.println("Empleado modificado con éxito");
            System.out.println("-----------------------------");
        }
    }
    //endregion

    //region 6. Eliminar un empleado
    public void eliminarEmpleadoEnv() {
        Scanner scan = new Scanner(System.in);
        int legajo;

        personalASCIIBuscar(listaEmpleados, null);
        listarEmpleados();

        System.out.print("\nIngrese el Legajo del empleado a buscar:");
        legajo = scan.nextInt();
        Empleado emp = buscardorDeEmpleado(legajo);

        if (emp == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró el empleado  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            personalASCIIBuscar(listaEmpleados, emp);

            System.out.println("precione 'd' para despedir o cualquier letra para cancelar");
            String opcion = scan.nextLine();
            if (opcion.equals("d") || opcion.equals("D")) {

                listaEmpleados.remove(emp);
                personal.eliminar(emp.getLegajo());

                echarEmpleadoASCII(emp);
                personalASCIIBuscar(listaEmpleados, emp);
                System.out.println("Empleado despedido con éxito");
                System.out.println("----------------------------");
            }else{
                System.out.println("Indemnización evitada");
                System.out.println("---------------------");
            }
        }
    }
        void echarEmpleadoASCII(Empleado emp){  //totalmente necesario.
            boolean impostor;

            Random random = new Random();
            impostor = random.nextBoolean();

            System.out.println("     ▒░░░░░▒▒");
            System.out.println("   ▓░░░░▒▒▒░░░░▒");
            System.out.println("   ░░░░▓▒░░░▒▒▒▓");
            System.out.println("   ░░░░▒▓▓▓▓▓▓▒▒▒");
            System.out.println("   ▓░░░░░░░░░░░░░▒         >>Despedido al Mercado Laboral<<");
            System.out.println(" ▒░▒▓░░░░░░░░░░░░░▒   Empleado: "+emp.getNombre()+" "+emp.getApellido());
            System.out.println(" ░░░▒▓░░░░░░░░░░░░░▓    Puesto: "+emp.getArea());
            System.out.println("  ░░░▓▓▒░░░░░░░░░░░     Legajo: "+emp.getLegajo());
            System.out.println("   ░░░▓▓▒▒░░░░░░░▒▓");
            if(impostor) {
                System.out.println("    ▓▓▓  ▓▒▒▒▒▒▒▓▓      Era el impostor");
            }else{

                System.out.println("    ▓▓▓  ▓▒▒▒▒▒▒▓▓      Pero No era el impostor");
            }
            System.out.println("          ▓▒▒▒▒▓▒▒▓");
            System.out.println("        ▓▒▒▒▒▒▒▓▒▒▓");
            System.out.println("        ▓▒▒▒▓▓▓▒▒▓");
        }
    //endregion

   //region 7. Plantilla de Empleados
    public void estadisticasEmpleadosEnv() {
        System.out.println("Estadísticas del Personal");
        System.out.println("-------------------------");
        personalASCIIBuscar(listaEmpleados, null);
        System.out.println("Total de empleados: " + contarEmpleados());
        float total = contarEmpleados();

        System.out.println("--Total de empleados por área--");
        float man = contarEmpleadosPorArea(Area.MANTENIMIENTO);
        float adm = contarEmpleadosPorArea(Area.ADMINISTRACION);
        float lim = contarEmpleadosPorArea(Area.LIMPIEZA);
        float seg = contarEmpleadosPorArea(Area.SEGURIDAD);
        float coc = contarEmpleadosPorArea(Area.COCINA);
        float moz = contarEmpleadosPorArea(Area.MOZOS);
        float val = contarEmpleadosPorArea(Area.VALETPARKING);
        float rec = contarEmpleadosPorArea(Area.RECEPCION);
        System.out.printf(" Mantenimiento: %d %.2f%%%n", (int) man, ((man / total) * 100));
        System.out.printf("Administración: %d %.2f%%%n", (int) adm, ((adm / total) * 100));
        System.out.printf("      Limpieza: %d %.2f%%%n", (int) lim, ((lim / total) * 100));
        System.out.printf("     Seguridad: %d %.2f%%%n", (int) seg, ((seg / total) * 100));
        System.out.printf("        Cocina: %d %.2f%%%n", (int) coc, ((coc / total) * 100));
        System.out.printf("         Mozos: %d %.2f%%%n", (int) moz, ((moz / total) * 100));
        System.out.printf(" Valet Parking: %d %.2f%%%n", (int) val, ((val / total) * 100));
        System.out.printf("     Recepción: %d %.2f%%%n", (int) rec, ((rec / total) * 100));

        System.out.println("--Total de empleados por Horario--");
        float mam = contarEmpleadosPorHorario(Empleado.Horario.MANANA);
        float tar = contarEmpleadosPorHorario(Empleado.Horario.TARDE);
        float noc = contarEmpleadosPorHorario(Empleado.Horario.NOCHE);
        System.out.printf("Mañana: %d %.2f%%%n", (int) mam, ((mam / total) * 100));
        System.out.printf(" Tarde: %d %.2f%%%n", (int) tar, ((tar / total) * 100));
        System.out.printf(" Noche: %d %.2f%%%n", (int) noc, ((noc / total) * 100));

        System.out.println("--Total de empleados por Estado--");
        float act = contarEmpleadosPorEstado(Empleado.Estado.ACTIVO);
        float baj = contarEmpleadosPorEstado(Empleado.Estado.BAJA);
        float sus = contarEmpleadosPorEstado(Empleado.Estado.SUSPENDIDO);
        float vac = contarEmpleadosPorEstado(Empleado.Estado.VACACIONES);
        System.out.printf("    Activo: %d %.2f%%%n", (int) act, ((act / total) * 100));
        System.out.printf("      Baja: %d %.2f%%%n", (int) baj, ((baj / total) * 100));
        System.out.printf("Suspendido: %d %.2f%%%n", (int) sus, ((sus / total) * 100));
        System.out.printf("Vacaciones: %d %.2f%%%n", (int) vac, ((vac / total) * 100));


    }

    //region Contadores
    int contarEmpleados(){
        return listaEmpleados.size();
    }

    int contarEmpleadosPorArea(Area area){
        int contador=0;
        for (Empleado emp: listaEmpleados) {
            if(emp.getArea().equals(area)){
                contador++;
            }
        }
        return contador;
    }
    int contarEmpleadosPorEstado(Empleado.Estado estado){
        int contador=0;
        for (Empleado emp: listaEmpleados) {
            if(emp.getEstado().equals(estado)){
                contador++;
            }
        }
        return contador;
    }

    int contarEmpleadosPorHorario(Empleado.Horario horario){
        int contador=0;
        for (Empleado emp: listaEmpleados) {
            if(emp.getHorario().equals(horario)){
                contador++;
            }
        }
        return contador;
    }
    //endregion

    //region Dibujar Plantilla

    public void personalASCIIEstado(List<Empleado> empleados){
        System.out.println("Estado de los empleados");
        float act = contarEmpleadosPorEstado(Empleado.Estado.ACTIVO);
        for
    }
    public void personalASCIIHorario(List<Empleado> empleados){
    }
    public void personalASCIIBuscar(List<Empleado> empleados, Empleado empleadoBuscado){

    }
    //endregion

}
