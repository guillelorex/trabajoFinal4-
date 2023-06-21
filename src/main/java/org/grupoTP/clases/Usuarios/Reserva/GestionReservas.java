package org.grupoTP.clases.Usuarios.Reserva;

import org.grupoTP.Repositorios.RepoReserva;

import java.util.List;
import java.util.Scanner;

public class GestionReservas {

    RepoReserva reservas= new RepoReserva();
    List<Reserva> listaReserva=reservas.listar();

    //CONSTRUCTOR
    public GestionReservas() {}

    //MENU---MODIFICACION DE RESERVA
    public void modificarReserva(Reserva reservacion){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Reservas");
        int opcion;
        do{
            opcionesMenuModiReserv();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Modificacion del numero de Haitacion");
                    System.out.println("Ingrese el nuevo numero de habitacion: ");
                    int num = scan.nextInt();
                    scan.nextLine();
                    reservacion.setNroHabitacion(num);
                }
                case 2 -> {
                    System.out.println("Modificacion del Numero de Reserva");
                    System.out.println("Ingrese el nuevo numero de reserva: ");
                    int num1 = scan.nextInt();
                    scan.nextLine();
                    reservacion.setNroReserva(num1);
                }
                case 3 -> {
                    System.out.println("Modificacion de la Fecha de Ingreso");
                    System.out.println("Ingrese la nueva fecha de ingreso: ");
                    String fecha = scan.nextLine();
                    scan.nextLine();
                    reservacion.setFechaIngreso(fecha);

                }
                case 4 -> {
                    System.out.println("Modificacion de la Fecha de Egreso");
                    System.out.println("Ingrese la nueva fecha de egreso: ");
                    String fecha1 = scan.nextLine();
                    scan.nextLine();
                    reservacion.setFechaEgreso(fecha1);
                    reservas.modificar(reservacion);

                }

                case 5 -> {
                    cambiarEstadoCliente(reservacion);
                    reservas.modificar(reservacion);
                }
                case 6 -> {
                    cambiarTipoCliente(reservacion);
                    reservas.modificar(reservacion);
                }
                case 7 -> {
                    cambiarTipoPension(reservacion);
                    reservas.modificar(reservacion);
                }
                case 8 -> {
                    cambiarTipoPago(reservacion);
                    reservas.modificar(reservacion);
                }
                case 9 -> System.out.println("Volviendo al Menu Principal......");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=9);
    }
    public void opcionesMenuModiReserv()
    {
        System.out.println("1. Modificar numero de habitacion");
        System.out.println("2. Modificar numero de reserva");
        System.out.println("3. Modificar fecha de ingreso");
        System.out.println("4. Modificar fecha de egreso");
        System.out.println("5. Modificar tipo de cliente");
        System.out.println("6. Modificar estado de cliente");
        System.out.println("7. Modificar tipo de pension");
        System.out.println("8. Modificar forma de pago");
        System.out.println("9. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU 1 ---DE CAMBIO DE ESTADO DEL CLIENTE
    public void cambiarEstadoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        System.out.println("Modificación del Estado del Cliente");
        int opcion;
        do{
            opcionesMenuEstado();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setEstado(Reserva.clienteEstado.INGRESADO);
                case 2 -> reservacion.setEstado(Reserva.clienteEstado.RESERVADO);
                case 3 -> reservacion.setEstado(Reserva.clienteEstado.EGRESADO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionesMenuEstado()
    {
        System.out.println("Ingrese el estado actual del Cliente");
        System.out.println("1- Ingresado");
        System.out.println("2- Reservado");
        System.out.println("3- Egresado");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU 2--- DEL CAMBIO DE TIPO DE CLIENTE
    public void cambiarTipoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        System.out.println("Modificación del Tipo del Cliente");
        int opcion;
        do{
            opcionesMenuTipoCliente();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setTipo(Reserva.clienteTipo.HUESPED);
                case 2 -> reservacion.setTipo(Reserva.clienteTipo.CONVENCION);
                case 3 -> reservacion.setTipo(Reserva.clienteTipo.VIP);
                case 4 -> reservacion.setTipo(Reserva.clienteTipo.TOUR);
                case 5 -> reservacion.setTipo(Reserva.clienteTipo.JUBILADO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionesMenuTipoCliente()
    {
        System.out.println("Ingrese el estado tipo de Cliente");
        System.out.println("1- Huesped");
        System.out.println("2- Convencion");
        System.out.println("3- Vip");
        System.out.println("4- Tour");
        System.out.println("5- Jubilado");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU 3--- CAMBIO DE TIPO DE PENSION
    public void cambiarTipoPension(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        System.out.println("Modificación del Tipo de Pension");
        int opcion;
        do{
            opcionesMenuTipoPension();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setPension(Reserva.pension.ALLINCLUSIVE);
                case 2 -> reservacion.setPension(Reserva.pension.COMPLETA);
                case 3 -> reservacion.setPension(Reserva.pension.MEDIA);
                case 4 -> reservacion.setPension(Reserva.pension.DESAYUNO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionesMenuTipoPension()
    {
        System.out.println("Ingrese el estado tipo de Pension del Cliente");
        System.out.println("1- All Inclusive");
        System.out.println("2- Completa");
        System.out.println("3- Media");
        System.out.println("4- Desayuno");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU 4--- CAMBIO DE FORMA DE PAGO
    public void cambiarTipoPago(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        System.out.println("Modificación del Tipo de Pago");
        int opcion;
        do{
            opcionesMenuTipoPago();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setFormaPago(Reserva.formaPago.EFECTIVO);
                case 2 -> reservacion.setFormaPago(Reserva.formaPago.TARJETA);
                case 3 -> reservacion.setFormaPago(Reserva.formaPago.PLAN);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionesMenuTipoPago()
    {
        System.out.println("Ingrese el estado tipo de Pago a realizar");
        System.out.println("1- Efectivo");
        System.out.println("2- Tarjeta");
        System.out.println("3- Plan");
        System.out.println("Seleccione una opcion: ");
    }
    ///////////////////////////////////////////////////////////////

    public void guardarNuevaReserva(Reserva r){
        reservas.agregar(r);
    }

    public Reserva cargaReserva(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Generar Nueva Reserva");
        int opcion
        Reserva reserva = null;
        do{
            opcionesMenuReservas();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese numero de habitacion:");
                    int nroHab= scan.nextInt();
                    scan.nextLine();
                    reserva.setNroHabitacion(nroHab);
                    break;
                case 2:
                    System.out.println("Ingrese numero de reserva:");
                    int nroReser= scan.nextInt();
                    scan.nextLine();
                    reserva.setNroReserva(nroReser);
                    break;
                case 3:
                    System.out.println("Ingrese fecha de ingreso: ");
                    String ingreso= scan.nextLine();
                    scan.nextLine();
                    reserva.setFechaIngreso(ingreso);
                    break;
                case 4:
                    System.out.println("Ingrese fecha de egreso: ");
                    String egreso = scan.nextLine();
                    scan.nextLine();
                    reserva.setFechaEgreso(egreso);
                    break;
                case 5:
                    System.out.println("Estado del cliente");
                    estadoCliente(reserva);
                    break;
                case 6:
                    System.out.println("Tipo de cliente");
                    tipoCliente(reserva);
                    break;
                case 7:
                    System.out.println("Tipo de pension");
                    tipoPension(reserva);
                    break;
                case 8:
                    System.out.println("Forma de pago");
                    tipoPago(reserva);
                    break;
                case 9:
                    System.out.println("Volviendo al Menu Principal......");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcion!=9);
        scan.close();
        listaReserva.add(reserva);
    }

    public void opcionesMenuReservas()
    {
        System.out.println("1. Numero de habitacion");
        System.out.println("2. Numero de reserva");
        System.out.println("3. Fecha de ingreso");
        System.out.println("4. Fecha de egreso");
        System.out.println("5. Estado de cliente");
        System.out.println("6. Tipo de cliente");
        System.out.println("7. Tipo de pension");
        System.out.println("8. Forma de pago");
        System.out.println("9. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU CARGA ESTADO DE CLIENTE
    public void estadoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            opcionMenuEstado();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setEstado(Reserva.clienteEstado.INGRESADO);
                case 2 -> reservacion.setEstado(Reserva.clienteEstado.RESERVADO);
                case 3 -> reservacion.setEstado(Reserva.clienteEstado.EGRESADO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionMenuEstado()
    {
        System.out.println("Seleccione el estado del Cliente");
        System.out.println("1- Ingresado");
        System.out.println("2- Reservado");
        System.out.println("3- Egresado");
        System.out.println("Seleccione una opcion: ");
    }
    //MENU CARGA TIPO DE CLIENTE
    public void tipoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            opcionMenuTipoCliente();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setTipo(Reserva.clienteTipo.HUESPED);
                case 2 -> reservacion.setTipo(Reserva.clienteTipo.CONVENCION);
                case 3 -> reservacion.setTipo(Reserva.clienteTipo.VIP);
                case 4 -> reservacion.setTipo(Reserva.clienteTipo.TOUR);
                case 5 -> reservacion.setTipo(Reserva.clienteTipo.JUBILADO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionMenuTipoCliente()
    {
        System.out.println("Seleccione el tipo de Cliente");
        System.out.println("1- Huesped");
        System.out.println("2- Convencion");
        System.out.println("3- Vip");
        System.out.println("4- Tour");
        System.out.println("5- Jubilado");
        System.out.println("Seleccione una opcion: ");
    }
    //MENU CARGA TIPO DE PENSION
    public void tipoPension(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            opcionMenuTipoPension();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setPension(Reserva.pension.ALLINCLUSIVE);
                case 2 -> reservacion.setPension(Reserva.pension.COMPLETA);
                case 3 -> reservacion.setPension(Reserva.pension.MEDIA);
                case 4 -> reservacion.setPension(Reserva.pension.DESAYUNO);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionMenuTipoPension()
    {
        System.out.println("Seleccione el tipo de Pension del Cliente");
        System.out.println("1- All Inclusive");
        System.out.println("2- Completa");
        System.out.println("3- Media");
        System.out.println("4- Desayuno");
        System.out.println("Seleccione una opcion: ");
    }
    //MENU CARGA  FORMA DE PAGO
    public void tipoPago(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            opcionMenuTipoPago();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> reservacion.setFormaPago(Reserva.formaPago.EFECTIVO);
                case 2 -> reservacion.setFormaPago(Reserva.formaPago.TARJETA);
                case 3 -> reservacion.setFormaPago(Reserva.formaPago.PLAN);
                case 0 -> System.out.println("Volver al menu anterior");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
        scan.close();
    }
    public void opcionMenuTipoPago()
    {
        System.out.println("Seleccione el tipo de Pago a realizar");
        System.out.println("1- Efectivo");
        System.out.println("2- Tarjeta");
        System.out.println("3- Plan");
        System.out.println("Seleccione una opcion: ");
    }



    /////////////////////////////////////////////////////////////
    public Reserva devuelveReserva(int numReserv) {
        for (Reserva reserv : listaReserva){
            if(reserv.getNroReserva()==numReserv){
                return reserv;
            }
            else {
                System.out.println("Numero de reserva inexistente");
            }
        }
        return  null;
    }
    public void cancelarReserva(int numReserv) {
        for (Reserva reserv : listaReserva){
            if(reserv.getNroReserva()==numReserv){
                listaReserva.remove(reserv);
                break;
            }
        }
    }
    //tomo reserva, cancelo una reserva, modifico una reserva ( alargar estadia) .

    // comparar fechas para saber si esta ocupada una habitacion.

    //siempre que elijo habitacion


    //comprobacion de si otro cliente tiene misma habitacion->true preguntar si para fecha entra y fecha sale esta ocupada? (comparacion de los dates)
    //generar factura.
    //esto tiene que interactuar obligatoriamente con las habitaciones.


    //voy a reservar la 5, 1. reviso todas las reservas si ya esta reservada. No esta reservada le doy.. ESTA RESERVADA (en la reseva 2334) 2. consulto las fechas.
    // mis dates con las de la otra reserva+MANTENIMIENTO (+3HORAS).
    //puedo hacer la reserva si no dan los dates no la puedo hacer.
}
