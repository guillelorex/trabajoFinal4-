package org.grupoTP.clases.Usuarios.Reserva;


import org.grupoTP.Repositorios.RepoReserva;
import org.grupoTP.clases.Hotel.GestionHotel;
import org.grupoTP.clases.Hotel.Habitacion;
import org.grupoTP.clases.Usuarios.Admin.Caja;
import org.grupoTP.clases.Usuarios.Admin.GestionCaja;
import org.grupoTP.clases.Usuarios.Empleados.Empleado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
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
                case 1 -> reservacion.setPension(Pension.ALLINCLUSIVE);
                case 2 -> reservacion.setPension(Pension.COMPLETA);
                case 3 -> reservacion.setPension(Pension.MEDIA);
                case 4 -> reservacion.setPension(Pension.DESAYUNO);
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


    //region 8. Cobrar habitacion
    int CalcularNoches(Reserva reservacion) {
        LocalDateTime fechaIngreso = GestionCaja.stringALocalDate(reservacion.getFechaIngreso());
        LocalDateTime fechaEgreso = GestionCaja.stringALocalDate(reservacion.getFechaEgreso());

        Duration duration = Duration.between(fechaIngreso, fechaEgreso);
        long noches = duration.toDays(); // Duracion en días

        return (int) noches;
    }



     void cobrarHabitacionEnv(Reserva reservacion) {
        Caja cajita = GestionCaja.abrirCaja();
         //deserializo la caja aca y cobro las reservas.
        GestionHotel gestionHotel = new GestionHotel();
        int num= reservacion.getNroHabitacion();
        Habitacion habitacion = gestionHotel.buscadorDeHabitaciones(num);
        //traigo habitacion para ver el tipo y el valor
        int coche=0;
         if (habitacion.getCochera())
             coche=20;
         //veo si uso cochera
        int noches= CalcularNoches(reservacion);
        float total=(CalcularNoches(reservacion) * (habitacion.getTipo().getValor() + reservacion.getPension().getValor()+coche));

        System.out.println("     Factura del Hotel");
        System.out.println("----------------------------------");
        System.out.println("     Habitacion nº: " + reservacion.getNroHabitacion());
        System.out.println("Tipo de Habitacion: " + habitacion.getTipo().getTipo());
        System.out.println("           Cochera: " + habitacion.getCochera());
        System.out.println("           Pension: " + reservacion.getPension());
        System.out.println("           Incluye: " + reservacion.getPension().getPension());
        System.out.println("----------------------------------");
        System.out.println("valor de habitacion " + habitacion.getTipo().getTipo() +": " + habitacion.getTipo().getValor()+"$");
        System.out.println("valor de pension "+reservacion.getPension().getPension()+": " + reservacion.getPension().getValor()+"$");
        if(habitacion.getCochera())
            System.out.println("valor de cochera: 20$");
        System.out.println("Cantidad de noches: " + noches);
         System.out.println();
         System.out.println("a pagar por noche: " + (habitacion.getTipo().getValor() + reservacion.getPension().getValor()) +coche+ "$");
         System.out.println("----------------------------------");
         System.out.println("TOTAL: " + total + "$");
         System.out.println("Medio de pago : " + reservacion.getFormaPago());
        try{
                    cajita.setIngreso(cajita.getIngreso() + total);
                    cajita.setSaldo(cajita.getSaldo() + cajita.getIngreso());
                    cajita.setFecha(GestionCaja.localDateAString(LocalDateTime.now()));
                    GestionCaja.cerrarCaja(cajita);
                    ImprimirFacturacion(reservacion, habitacion);
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃  Factura impresa Gracias por su visita  ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    //serializar la caja aca

        } catch (NullPointerException e) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No hay caja donde abonar  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
        System.out.println(" ");
    }
    void FacturarReserva(){
        LocalDate fechaLocal = LocalDate.now();
        for (Empleado emp: listaEmpleados) {
            String rutaArchivo = "src/main/resources/RecibosDeSueldo/Sueldo " + emp.getApellido() + "-" + emp.getNombre() + "-" + fechaLocal + ".txt";
            imprimirReciboDeSueldo(rutaArchivo,emp);
        }
    }

    void imprimirFactura(String rutaArchivo, Empleado empleado) {

        File file = new File(rutaArchivo);
        try {
            PrintWriter buffer = new PrintWriter(new FileWriter(file, true));

            buffer.printf("Recibo de Sueldo \n");
            buffer.printf("-----------------\n");
            buffer.printf("Nombre: " + empleado.getNombre() + "\n");
            buffer.printf("Apellido: " + empleado.getApellido() + "\n");
            buffer.printf("DNI: " + empleado.getDni() + "\n");
            buffer.printf("Area: " + empleado.getArea() + "\n");
            buffer.printf("Horario: " + empleado.getHorario() + "\n");
            buffer.printf("Sueldo: " + empleado.getArea().getSueldo() + "\n");

            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //endregion
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
