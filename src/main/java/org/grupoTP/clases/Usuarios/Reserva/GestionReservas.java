package org.grupoTP.clases.Usuarios.Reserva;


import org.grupoTP.Repositorios.RepoHotel;
import org.grupoTP.Repositorios.RepoReserva;
import org.grupoTP.clases.Hotel.Habitacion;
import org.grupoTP.clases.Hotel.GestionHotel;
import org.grupoTP.clases.Login.LoginUsuarios;
import org.grupoTP.clases.Usuarios.Admin.Caja;
import org.grupoTP.clases.Usuarios.Admin.GestionCaja;
import org.grupoTP.clases.Usuarios.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class GestionReservas {

    RepoReserva reservas= new RepoReserva();
    List<Reserva> listaReservas = reservas.listar();
    GestionHotel gestionHotel = new GestionHotel();

    RepoHotel hotel = new RepoHotel();
    List<Habitacion> listaHabitaciones = hotel.listar();

    //CONSTRUCTOR
    public GestionReservas() {}

    //region 1. Mostrar Reservas
    public void mostrarReservasEnv() {
        gestionHotel.hotelASCIIEstado(listaHabitaciones);
        listarReservas();
    }

    void listarReservas() {
        for (Reserva res : listaReservas) {
            System.out.println(res);
        }
    }
    //endregion

    //region 2. Agregar Reserva
    public void agregarReservaEnv(){
        Reserva res;
        Scanner scan = new Scanner(System.in);
        gestionHotel.hotelASCIIEstado(listaHabitaciones);

        res = crearReserva(); // tengo que saber que no existe.
        if(agregarAListaReserva(res)){
            reservas.agregar(res);
            System.out.println("Desea usar la cochera? (1-Si, 2-No)");
            int opcion = scan.nextInt();

            //cambio Estado de la habitación
            int num= res.getNroHabitacion();
            Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
            hab.setEstado(Habitacion.EstadoHabitacion.RESERVADA);
            hab.setCochera(opcion == 1);

            gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);
            System.out.println(res);
            System.out.println("Reserva agregada con éxito");
            System.out.println("--------------------------");
        }else{
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  La reserva ya existe  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
    }

    Reserva crearReserva(){
        Scanner scan = new Scanner(System.in);
        String dni;
        String password;
        String mail;
        String nombre;
        String apellido;
        Persona.TipoCuenta tipoCuenta= Persona.TipoCuenta.CLIENTE;
        int numRes;
        int numHab;
        String fechaIngreso;
        String fechaEgreso;
        Reserva.clienteEstado estado = Reserva.clienteEstado.RESERVADO;
        Reserva.clienteTipo clienteTipo = null;
        int tipo;
        Pension pension = null;
        int pensionTipo;
        Reserva.formaPago formaPago = null;
        int pagoTipo;


        System.out.println("Ingrese el numero de reserva: ");
        numRes = scan.nextInt();
        if(devuelveReserva(numRes) != null)
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  Ya existe reserva ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
            return null;
        }
        gestionHotel.mostrarHabitacionesEnv();
        System.out.println("Ingrese el numero de habitacion: ");
        numHab = scan.nextInt();
        if(gestionHotel.buscadorDeHabitaciones(numHab) != null)
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  La habitación ya esta ocupada ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            return null;
        }
        System.out.println("-------Datos Personales------- ");
        scan.nextLine(); //limpia el buffer
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

        System.out.println("dd-MM-yyyy HH:mm:ss");//es cierto que no controlamos el calendario de las habitaciones
        System.out.println("Ingrese fecha de ingreso : ");  //pero no tuvimos más tiempo para hacerlo
        fechaIngreso = scan.nextLine();
        System.out.println("Ingrese fecha de egreso : ");
        fechaEgreso = scan.nextLine();

        System.out.println("\n Ingrese el tipo de cliente 1.HUESPED, 2.CONVENCIÓN, 3.VIP, 4.TOUR, 5.JUBILADO: ");
        do{
            tipo=scan.nextInt();
            switch (tipo) {
                case 1 -> clienteTipo = Reserva.clienteTipo.HUESPED;
                case 2 -> clienteTipo = Reserva.clienteTipo.CONVENCION;
                case 3 -> clienteTipo = Reserva.clienteTipo.VIP;
                case 4 -> clienteTipo = Reserva.clienteTipo.TOUR;
                case 5 -> clienteTipo = Reserva.clienteTipo.JUBILADO;
                default -> System.out.println("Opción invalida");
            }
        }while(!(tipo == 1 || tipo == 2 || tipo == 3 || tipo == 4 || tipo == 5));

        System.out.println("\n Ingrese el tipo de pension 1.ALLINCLUSIVE 2.COMPLETA, 3.MEDIA, 4.DESAYUNO: ");
        do{
            pensionTipo=scan.nextInt();
            switch (pensionTipo) {
                case 1 -> pension = Pension.ALLINCLUSIVE;
                case 2 -> pension = Pension.COMPLETA;
                case 3 -> pension = Pension.MEDIA;
                case 4 -> pension = Pension.DESAYUNO;
                default -> System.out.println("Opción invalida");
            }
        }while(!(pensionTipo == 1 || pensionTipo == 2 || pensionTipo == 3 || pensionTipo == 4));
        System.out.println("\n Ingrese el tipo de pago 1.EFECTIVO, 2.TARJETA, 3.PLAN: ");
        do{
            pagoTipo=scan.nextInt();
            switch (pagoTipo) {
                case 1 -> formaPago = Reserva.formaPago.EFECTIVO;
                case 2 -> formaPago = Reserva.formaPago.TARJETA;
                case 3 -> formaPago = Reserva.formaPago.PLAN;
                default -> System.out.println("Opción invalida");
            }
        }while(!(pagoTipo == 1 || pagoTipo == 2 || pagoTipo == 3));
        return new Reserva(dni, password, mail, nombre, apellido, tipoCuenta, numRes, numHab, fechaIngreso, fechaEgreso, estado, clienteTipo, pension, formaPago);
    }
    //agrego a la lista
    boolean agregarAListaReserva(Reserva res){

        if(!this.listaReservas.contains(res)){
            this.listaReservas.add(res);
            return true;
        }
        return false;
    }
    //endregion

    //region 3. Buscar Reserva

    public void buscarReservaEnv() {
        Scanner scan = new Scanner(System.in);

        gestionHotel.hotelASCIIEstado(listaHabitaciones);
        System.out.print("\nIngrese el numero de habitación:");
        int numero = scan.nextInt();
        Reserva res = devuelveReserva(numero);

        if (res == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró Reservación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            int num= res.getNroHabitacion();
            Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
            gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);
            System.out.println(hab);
        }
    }
        public Reserva devuelveReserva(int num) {
        listaReservas.sort(Comparator.comparingInt(Reserva::getNroReserva));
            for (Reserva reserva : listaReservas){
                if(reserva.getNroReserva()==num){
                    return reserva;
                }
            }
            return  null;
        }
    //endregion

    //region 4. Hacer Check-IN-OUT
    public void cambiarEstadoReservaEnv() {
        Scanner scan = new Scanner(System.in);
        int numRes;

        gestionHotel.hotelASCIIEstado(listaHabitaciones);
        listarReservas();

        System.out.print("\nIngrese el numero de reserva: ");
        numRes = scan.nextInt();
        Reserva res = devuelveReserva(numRes);

        if (res == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la reserva ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            cambiarClienteEstado(res);
            int num= res.getNroHabitacion();
            Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
            gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);
            //cambio Estado de habitación
            gestionHotel.cambiarEstado(hab);
            hotel.modificar(hab);
            gestionHotel.hotelASCIIEstado(listaHabitaciones);
            System.out.println("Estado de la reserva cambiado con éxito");
            System.out.println("---------------------------------------");
        }
    }
    void cambiarClienteEstado(Reserva res){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do{
            System.out.println("0. Reservada 1. Check-IN, 2. Check-OUT");
            opcion=scan.nextInt();

            switch (opcion) {
                case 0 -> res.setEstado(Reserva.clienteEstado.RESERVADO);
                case 1 -> res.setEstado(Reserva.clienteEstado.INGRESADO);
                case 2 -> res.setEstado(Reserva.clienteEstado.EGRESADO);
                default -> System.out.println("Opción invalida");
            }
        }while(!(opcion == 0 || opcion == 1 || opcion == 2));
    }

    //endregion

    //region 5. Modificar Reserva
    public void modificarReservaEnv() {
        Scanner scan = new Scanner(System.in);
        int num;

        gestionHotel.hotelASCIIBuscar(listaHabitaciones, null);
        listarReservas();

        System.out.print("\nIngrese el numero de reserva:");
        int numero = scan.nextInt();
        Reserva res = devuelveReserva(numero);

        if (res == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró Reservación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            num= res.getNroHabitacion();
            Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
            gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);
            System.out.println(hab);

            modificarReserva(res);
            reservas.modificar(res);
            System.out.println("Reserva modificada con éxito");
            System.out.println("----------------------------");

        }
    }
    public void modificarReserva(Reserva reservacion){
        Scanner scan=new Scanner(System.in);
        System.out.println("Gestion de Reservas");
        int opcion;
        do{
            opcionesMenuModificarReserva();
            opcion=scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Modificación del numero de Habitacion");
                    System.out.println("Ingrese el nuevo numero de habitacion: ");
                    int num = scan.nextInt();
                    scan.nextLine();
                    reservacion.setNroHabitacion(num);
                }
                case 2 -> {
                    System.out.println("Modificación de la Fecha de Ingreso");
                    System.out.println("dd-MM-yyyy HH:mm:ss");
                    System.out.println("Ingrese la nueva fecha de ingreso: ");
                    String fecha = scan.nextLine();
                    reservacion.setFechaIngreso(fecha);

                }
                case 3 -> {
                    System.out.println("Modificación de la Fecha de Egreso");
                    System.out.println("dd-MM-yyyy HH:mm:ss");
                    System.out.println("Ingrese la nueva fecha de egreso: ");
                    String fecha1 = scan.nextLine();
                    reservacion.setFechaEgreso(fecha1);
                }
                case 4 -> cambiarEstadoCliente(reservacion);

                case 5 -> cambiarTipoCliente(reservacion);

                case 6 -> cambiarTipoPension(reservacion);

                case 7 -> cambiarTipoPago(reservacion);

                case 0 -> {
                    System.out.println("Volviendo al Menu Reservas");
                    LoginUsuarios.retraso();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
    }
    public void opcionesMenuModificarReserva()
    {
        System.out.println("1. Modificar numero de habitacion");
        System.out.println("2. Modificar fecha de ingreso");
        System.out.println("3. Modificar fecha de egreso");
        System.out.println("4. Modificar tipo de cliente");
        System.out.println("5. Modificar estado de cliente");
        System.out.println("6. Modificar tipo de pension");
        System.out.println("7. Modificar forma de pago");
        System.out.println("0. Volver a Menu Principal");
        System.out.println("Seleccione una opcion: ");
    }

    //MENU 1 ---DE CAMBIO DE ESTADO DEL CLIENTE
    public void cambiarEstadoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Modificación del Estado del Cliente");
            System.out.println("Ingrese el estado actual del Cliente 1- Ingresado 2- Reservado 3- Egresado");
            System.out.println("Seleccione una opcion: ");
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

    //MENU 2--- DEL CAMBIO DE TIPO DE CLIENTE
    public void cambiarTipoCliente(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Modificación del Tipo del Cliente");
            System.out.println("Ingrese el tipo de Cliente 1- Huesped 2- Convencion 3- Vip 4- Tour 5- Jubilado");
            System.out.println("Seleccione una opcion: ");
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

    //MENU 3--- CAMBIO DE TIPO DE PENSION
    public void cambiarTipoPension(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Modificación del Tipo de Pension");
            System.out.println("Ingrese el estado tipo de Pension del Cliente 1- All Inclusive 2- Completa 3- Media 4- Desayuno");
            System.out.println("Seleccione una opcion: ");
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

    //MENU 4--- CAMBIO DE FORMA DE PAGO
    public void cambiarTipoPago(Reserva reservacion){
        Scanner scan = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Modificación del Tipo de Pago");
            System.out.println("Ingrese el estado tipo de Pago a realizar 1- Efectivo 2- Tarjeta 3- Plan");
            System.out.println("Seleccione una opcion: ");
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

    //endregion

    //region 6. Borrar Reserva
    public void borrarReservaEnv() {
        Scanner scan = new Scanner(System.in);
        int num;

        gestionHotel.hotelASCIIBuscar(listaHabitaciones, null);
        listarReservas();

        System.out.print("\nIngrese el numero de reserva: ");
        int numRes = scan.nextInt();
        Reserva res = devuelveReserva(numRes);

        if (res == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la reserva ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            num = res.getNroHabitacion();
            Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
            gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);

            scan.nextLine();
            System.out.println("Precione 'b' para borrar o cualquier letra para cancelar");
            String opcion = scan.nextLine();
            if (opcion.equals("b") || opcion.equals("B")) {

                listaReservas.remove(res);
                reservas.eliminar(res.getNroReserva());
                System.out.println("<<(BORRADO)>>");
                //cambio Estado de habitación
                hab.setEstado(Habitacion.EstadoHabitacion.DISPONIBLE);
                hotel.modificar(hab);
                gestionHotel.hotelASCIIEstado(listaHabitaciones);
                System.out.println("Habitación liberada");
                System.out.println("-------------------");
            } else {
                System.out.println("Cambio cancelado");
                System.out.println("----------------");
            }
        }
    }
    //endregion

    //region 7. Cobrar habitacion

    void cobrarHabitacionEnv() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el numero de reserva");
        int numReserva = scan.nextInt();

        Reserva res = devuelveReserva(numReserva);
        int num = res.getNroHabitacion();
        Habitacion hab = gestionHotel.buscadorDeHabitaciones(num);
        gestionHotel.hotelASCIIBuscar(listaHabitaciones, hab);
        cobrarHabitacion(res);

        //una vez cobrada la habitacion se desocupara la habitacion
        System.out.println("------------------------------");
        System.out.println("Cambiando estado de habitación");
        System.out.println("------------------------------");
        hab.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
        gestionHotel.hotelASCIIEstado(listaHabitaciones);
        hotel.modificar(hab);
        //y elimino la reserva
        listaReservas.remove(res);
        reservas.eliminar(res.getNroReserva());
    }

     void cobrarHabitacion(Reserva reservacion) {
        Caja cajita = GestionCaja.abrirCaja();
         //deserializo la caja aca y cobro las reservas.

        int num= reservacion.getNroHabitacion();
        Habitacion habitacion = gestionHotel.buscadorDeHabitaciones(num);
        //traigo habitacion para ver el tipo y el valor
        int coche=0;
         if (habitacion.getCochera())
             coche=20;
         //veo si uso cochera
        int noches= CalcularNoches(reservacion);
        float total=(CalcularNoches(reservacion) * (habitacion.getTipo().getValor() + reservacion.getPension().getValor()+coche));

        System.out.println(" ");
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
                    facturarReserva(reservacion, habitacion);
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

    int CalcularNoches(Reserva reservacion) {
        LocalDateTime fechaIngreso = GestionCaja.stringALocalDate(reservacion.getFechaIngreso());
        LocalDateTime fechaEgreso = GestionCaja.stringALocalDate(reservacion.getFechaEgreso());

        Duration duration = Duration.between(fechaIngreso, fechaEgreso);
        long noches = duration.toDays(); // Duracion en días

        return (int) noches;
    }

    void facturarReserva(Reserva res, Habitacion hab){
        LocalDate fechaLocal = LocalDate.now();
            String rutaArchivo = "src/main/resources/FacturasHotel/Factura " + res.getApellido() + "-" + res.getNombre() + "-" + fechaLocal + ".txt";
            imprimirFactura(rutaArchivo,res, hab);
    }


    void imprimirFactura(String rutaArchivo, Reserva res, Habitacion hab) {

        int noches= CalcularNoches(res);
        int coche=0;
        if (hab.getCochera())
            coche=20;
        float total=(CalcularNoches(res) * (hab.getTipo().getValor() + res.getPension().getValor()+coche));

        File file = new File(rutaArchivo);
        try {
            PrintWriter buffer = new PrintWriter(new FileWriter(file, true));

            buffer.printf(" \n");
            buffer.printf("     Factura del Hotel\n");
            buffer.printf("----------------------------------\n");
            buffer.printf("     Habitacion nº: " + res.getNroHabitacion() + "\n");
            buffer.printf("Tipo de Habitacion: " + hab.getTipo().getTipo() + "\n");
            buffer.printf("           Cochera: " + hab.getCochera() + "\n");
            buffer.printf("           Pension: " + res.getPension() + "\n");
            buffer.printf("           Incluye: " + res.getPension().getPension() + "\n");
            buffer.printf("----------------------------------\n");
            buffer.printf("valor de habitacion " + hab.getTipo().getTipo() +": " + hab.getTipo().getValor()+"$\n");
            buffer.printf("valor de pension "+res.getPension().getPension()+": " + res.getPension().getValor()+"$\n");
            if(hab.getCochera())
                buffer.printf("valor de cochera: 20$\n");
            buffer.printf("Cantidad de noches: " + noches + "\n");
            buffer.printf("a pagar por noche: " + (hab.getTipo().getValor() + res.getPension().getValor()) +coche+ "$\n");
            buffer.printf("----------------------------------\n");
            buffer.printf("TOTAL: " + total + "$\n");
            buffer.printf("Medio de pago : " + res.getFormaPago() + "\n");

            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
