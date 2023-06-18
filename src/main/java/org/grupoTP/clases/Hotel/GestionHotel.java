package org.grupoTP.clases.Hotel;

import org.grupoTP.Repositorios.RepoHotel;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class GestionHotel {

    RepoHotel hotel = new RepoHotel();

    List<Habitacion> listaHabitaciones = hotel.listar();

    //region 1. Mostrar habitaciones
    public void mostrarHabitacionesEnv() {
        hotelASCIIEstado(listaHabitaciones);
        for (Habitacion hab : listaHabitaciones) {
            System.out.println(hab);
        }
    }
    //endregion

    //region 2. Agregar habitacion
    public void agregarHabitacionEnv(){
        Habitacion hab;
        hotelASCIIBuscar(listaHabitaciones, null);
        hab = crearHabitacion();
        agregarAListaHabitacion(hab);
        hotel.agregar(hab);
        hotelASCIIBuscar(listaHabitaciones, hab);
        System.out.println("Habitación agregada con éxito");

    }

    Habitacion crearHabitacion() {
        Scanner scan = new Scanner(System.in);
        int numero;
        int piso;
        int tipo;
        TipoHabitacion tipoHabitacion = null;
        String coche;
        boolean cochera = false;
        Habitacion.EstadoHabitacion estadoHabitacion;

        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        System.out.print("\n Ingrese el piso: ");
        piso = scan.nextInt();

        System.out.print("\n Ingrese el tipo de habitación 1.simple 2.doble 3.triple 4.suite:");
        do{
            tipo=scan.nextInt();
            switch (tipo) {
                case 1 -> tipoHabitacion = TipoHabitacion.SIM;
                case 2 -> tipoHabitacion = TipoHabitacion.DOB;
                case 3 -> tipoHabitacion = TipoHabitacion.TRI;
                case 4 -> tipoHabitacion = TipoHabitacion.SUI;
                default -> System.out.println("Opción invalida");
            }
        }while(tipo==1 || tipo==2 || tipo==3 || tipo==4);

        System.out.print("\n La habitación tendrá cochera?¿: s/n");
        do{
            coche=scan.next();
            switch (coche) {
                case "s" -> cochera = true;
                case "n" -> cochera = false;
                default -> System.out.println("Opción invalida");
            }
        }while(coche.equals("s") ||coche.equals("n"));

        estadoHabitacion = Habitacion.EstadoHabitacion.DISPONIBLE; //por defecto (nadie va a crear una habitacion fuera de servicio en vida real)
        return new Habitacion(numero, piso, tipoHabitacion, cochera, estadoHabitacion);
    }

    //agrego a la lista
    void agregarAListaHabitacion(Habitacion hab){

        if(!this.listaHabitaciones.contains(hab)){
            this.listaHabitaciones.add(hab);
        }

    }
    //endregion

    //region 3. Buscar habitacion

    public void buscarHabitacionEnv(){
        Scanner scan = new Scanner(System.in);
        int numero;
        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        Habitacion hab=buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones,hab);
        if(hab==null) {
            System.out.println("No se encontró la habitación");
        }else{
            System.out.println(hab);
        }
    }
    Habitacion buscadorDeHabitaciones(int numero){
        for (Habitacion hab : listaHabitaciones) {
            if(hab.getNumero()==numero){
                return hab;
            }
        }
        return null;
    }

    //endregion

    //region 4. Cambiar estado de habitacion

    public void cambiarEstadoHabitacionEnv() {
        Scanner scan = new Scanner(System.in);
        int numero;
        hotelASCIIEstado(listaHabitaciones);
        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        Habitacion hab = buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones, hab);
        if (hab == null) {
            System.out.println("No se encontró la habitación");

        }else {
            cambiarEstado(hab);
            hotelASCIIEstado(listaHabitaciones);
            System.out.println(hab);
        }
    }
     void cambiarEstado(Habitacion habitacion){

       Scanner scan = new Scanner(System.in);
       int opcion;
        do{
            opcionesMenuEstado();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> habitacion.setEstado(Habitacion.EstadoHabitacion.DISPONIBLE);
                case 2 -> habitacion.setEstado(Habitacion.EstadoHabitacion.OCUPADA);
                case 3 -> habitacion.setEstado(Habitacion.EstadoHabitacion.RESERVADA);
                case 4 -> habitacion.setEstado(Habitacion.EstadoHabitacion.MANTENIMIENTO);
                case 5 -> habitacion.setEstado(Habitacion.EstadoHabitacion.FUERA_SERVICIO);
                default -> System.out.println("Opción invalida");
            }
        }while(opcion==1 || opcion==2 || opcion==3 || opcion==4 || opcion==5);
    }

    void opcionesMenuEstado()
    {
        System.out.println("Ingrese el estado actual de la habitacion");
        System.out.println("1- Disponible");
        System.out.println("2- Ocupada");
        System.out.println("3- Reservada");
        System.out.println("4- Mantenimiento");
        System.out.println("5- Fuera de servicio");
        System.out.println("Seleccione una opción: ");
    }
    //endregion

    //region 5. Modificar habitacion
    public void modificarHabitacionEnv(){
        Scanner scan = new Scanner(System.in);
        int numero;
        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        Habitacion hab=buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones,hab);
        if(hab==null) {
            System.out.println("No se encontró la habitación");
        }else{
            hab=crearHabitacion();
            agregarAListaHabitacion(hab);
            hotel.agregar(hab);
            System.out.println("Habitación modificada con éxito");
        }
    }

    //endregion

    //region 6. Eliminar habitacion
    public void eliminarHabitacionEnv(){
        Scanner scan = new Scanner(System.in);
        int numero;
        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        Habitacion hab=buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones,hab);
        if(hab==null) {
            System.out.println("No se encontró la habitación");
        }else{
            eliminarDeListaHabitacion(hab);
            hotel.eliminar(hab.getNumero());
            hotelASCIIBuscar(listaHabitaciones,hab);
            System.out.println("Habitación eliminada con éxito");
        }
    }
    void eliminarDeListaHabitacion(Habitacion habitacion){
        listaHabitaciones.remove(habitacion);
    }

    //endregion

    //region 7. Estadísticas del hotel
    public void estadisticasHotelEnv(){
        System.out.println("Estadísticas del Hotel");
        System.out.println("------------------------------------------------");
        hotelASCIIBuscar(listaHabitaciones,null);
        System.out.println("Cantidad de pisos: "        + contarPisos(listaHabitaciones));
        int cant = contarHabitaciones(listaHabitaciones);
        System.out.println("Cantidad de habitaciones: " + cant);
        System.out.println("------------------------------------------------");
        hotelASCIIEstado(listaHabitaciones);
        int dis = contarHabitacionesPorEstado(listaHabitaciones,Habitacion.EstadoHabitacion.DISPONIBLE);
        int ocu = contarHabitacionesPorEstado(listaHabitaciones,Habitacion.EstadoHabitacion.OCUPADA);
        int res = contarHabitacionesPorEstado(listaHabitaciones,Habitacion.EstadoHabitacion.RESERVADA);
        int man = contarHabitacionesPorEstado(listaHabitaciones,Habitacion.EstadoHabitacion.MANTENIMIENTO);
        int fue = contarHabitacionesPorEstado(listaHabitaciones,Habitacion.EstadoHabitacion.FUERA_SERVICIO);
        System.out.println("Cantidad de habitaciones disponibles "     + ((dis/cant)*100) +"%: " + dis);
        System.out.println("Cantidad de habitaciones ocupadas"         + ((ocu/cant)*100) +"%: " + ocu);
        System.out.println("Cantidad de habitaciones reservadas"       + ((res/cant)*100) +"%: " + res);
        System.out.println("Cantidad de habitaciones en mantenimiento" + ((man/cant)*100) +"%: " + man);
        System.out.println("Cantidad de habitaciones fuera de servicio"+ ((fue/cant)*100) +"%: " + fue);
        System.out.println("------------------------------------------------");
    }
    //endregion

    //region Contadores
    int contarPisos(List<Habitacion> listaHabitaciones){
        int cont = 0;
        for (Habitacion hab : listaHabitaciones) {
            if(hab.getPiso() > cont){
                cont = hab.getPiso();
            }
        }
        return cont;
    }

    int contarHabitaciones(List<Habitacion> listaHabitaciones){
        int cont = 0;
        for (Habitacion hab : listaHabitaciones) {
            cont++;
        }
        return cont;
    }

    int contarHabitacionesPorPiso(List<Habitacion> listaHabitaciones, int piso){
        int cont = 0;
        for (Habitacion hab : listaHabitaciones) {
            if(hab.getPiso() == piso){
                cont++;
            }
        }
        return cont;
    }

    int contarHabitacionesPorEstado(List<Habitacion> listaHabitaciones, Habitacion.EstadoHabitacion estado){
        int cont = 0;
        for (Habitacion hab : listaHabitaciones) {
            if(hab.getEstado() == estado){
                cont++;
            }
        }
        return cont;
    }
    //endregion

    //region Dibujar Hotel
    public void hotelASCIIEstado(List<Habitacion> Habitaciones) {

        char izqTecho = '┏';
        char techo = '━';
        char derTecho = '┓';
        char pared = '┃';
        char ventana;

        int pisos = contarPisos(Habitaciones);
        int ultimoPiso = contarHabitacionesPorPiso(Habitaciones, contarPisos(Habitaciones));

        // Dibujar techo del Hotel
        System.out.printf("%c", izqTecho);
        System.out.printf("%c", techo);
        for (int i = 0; i < ultimoPiso; i++) {
            System.out.printf("%c", techo);
            System.out.printf("%c", techo);
        }
        System.out.printf("%c", derTecho);

        System.out.println(); // Salto de línea

        // Invertir el orden de los pisos
        Collections.reverse(Habitaciones);

        // Dibujar pared del hotel
        int habitacionIndex = 0; // Índice de habitación en la lista
        for (int i = 1; i <= pisos; i++) {
            System.out.printf("%c", pared); // Borde izquierdo pared
            // Habitaciones por piso
            int habPorPiso = contarHabitacionesPorPiso(Habitaciones, i);
            for (int j = 0; j < habPorPiso; j++) {
                Habitacion habitacion = Habitaciones.get(habitacionIndex); // Obtener la habitación correcta
                switch (habitacion.getEstado()) {
                    case DISPONIBLE -> {
                        ventana = '░';
                        System.out.printf(" %c", ventana);
                    }
                    case OCUPADA -> {
                        ventana = '█';
                        System.out.printf(" %c", ventana);
                    }
                    case RESERVADA -> {
                        ventana = '▒';
                        System.out.printf(" %c", ventana);
                    }
                    case FUERA_SERVICIO -> {
                        ventana = '■';
                        System.out.printf(" %c", ventana);
                    }
                    case MANTENIMIENTO -> {
                        ventana = '▌';
                        System.out.printf(" %c", ventana);
                    }
                }
                habitacionIndex++; // Incrementar el índice de habitación
            }
            System.out.print(" ");
            System.out.printf("%c", pared); // Borde derecho pared
            System.out.println(); // Salto de línea
        }

        // Última línea <gracias chatGPT esta última línea era imposible de sacar bien sin tu ayuda>
        System.out.printf("%c", pared); // Borde izquierdo pared
        for (int i = 0; i < ultimoPiso * 2 + 1; i++) {
            System.out.print(" "); // Espacio en blanco
        }
        System.out.printf("%c", pared); // Borde derecho pared
        System.out.println(); // Salto de línea
    }

    public void hotelASCIIBuscar(List<Habitacion> Habitaciones, Habitacion habitacionBuscada) {
        char izqTecho = '┏';
        char techo = '━';
        char derTecho = '┓';
        char pared = '┃';
        char ventana;

        int pisos = contarPisos(Habitaciones);
        int ultimoPiso = contarHabitacionesPorPiso(Habitaciones, contarPisos(Habitaciones));

        // Dibujar techo del Hotel
        System.out.printf("%c", izqTecho);
        System.out.printf("%c", techo);
        for (int i = 0; i < ultimoPiso; i++) {
            System.out.printf("%c", techo);
            System.out.printf("%c", techo);
        }
        System.out.printf("%c", derTecho);

        System.out.println(); // Salto de línea

        // Invertir el orden de los pisos
        Collections.reverse(Habitaciones);

        // Dibujar pared del hotel
        int habitacionIndex = 0; // Índice de habitación en la lista
        for (int i = 1; i <= pisos; i++) {
            System.out.printf("%c", pared); // Borde izquierdo pared
            // Habitaciones por piso
            int habPorPiso = contarHabitacionesPorPiso(Habitaciones, i);
            for (int j = 0; j < habPorPiso; j++) {
                Habitacion habitacion = Habitaciones.get(habitacionIndex); // Obtener la habitación correcta
                if (habitacion.getNumero() != habitacionBuscada.getNumero()) {
                    ventana = '░';
                    System.out.printf(" %c", ventana);
                } else {
                    ventana = '█';
                    System.out.printf(" %c", ventana);
                }
                habitacionIndex++; // Incrementar el índice de habitación
            }
            System.out.print(" ");
            System.out.printf("%c", pared); // Borde derecho pared
            System.out.println(); // Salto de línea
        }

        System.out.printf("%c", pared); // Borde izquierdo pared
        for (int i = 0; i < ultimoPiso * 2 + 1; i++) {
            System.out.print(" "); // Espacio en blanco
        }
        System.out.printf("%c", pared); // Borde derecho pared
        System.out.println(); // Salto de línea
    }
    //endregion



    // la creación del hotel es crear una lista de habitaciones.

    //cambiar estados SE DEBERÍAN CAMBIAR DESDE LAS RESERVAS
    //PORCENTAJE DE HABITACIONES OCUPADAS
}
