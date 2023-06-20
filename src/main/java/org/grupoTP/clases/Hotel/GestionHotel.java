package org.grupoTP.clases.Hotel;

import org.grupoTP.Repositorios.RepoHotel;

import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class GestionHotel {

    RepoHotel hotel = new RepoHotel();

    List<Habitacion> listaHabitaciones = hotel.listar();

    //region 1. Mostrar habitaciones
    public void mostrarHabitacionesEnv() {
        hotelASCIIEstado(listaHabitaciones);
        listarHabitaciones();
    }

    void listarHabitaciones() {
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
        System.out.println(hab);
        System.out.println("Habitación agregada con éxito");
        System.out.println("-----------------------------");
    }

    Habitacion crearHabitacion() {
        Scanner scan = new Scanner(System.in);
        int numero;
        int piso;
        int tipo;
        TipoHabitacion tipoHabitacion = null;
        String coche;
        boolean cochera=false;
        Habitacion.EstadoHabitacion estadoHabitacion;

        System.out.print("\n Ingrese el numero de habitación: ");
        numero = scan.nextInt();
        if(buscadorDeHabitaciones(numero) != null){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  La habitación ya existe ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            return null;
        }
        System.out.print("\n Ingrese el piso: ");
        piso = scan.nextInt();

        System.out.print("\n Ingrese el tipo de habitación 1.simple 2.doble 3.triple 4.suite: ");
        do{
            tipo=scan.nextInt();
            switch (tipo) {
                case 1 -> tipoHabitacion = TipoHabitacion.SIM;
                case 2 -> tipoHabitacion = TipoHabitacion.DOB;
                case 3 -> tipoHabitacion = TipoHabitacion.TRI;
                case 4 -> tipoHabitacion = TipoHabitacion.SUI;
                default -> System.out.println("Opción invalida");
            }
        }while(!(tipo == 1 || tipo == 2 || tipo == 3 || tipo == 4));

        System.out.print("\n La habitación tendrá cochera?¿: s/n ");
        do{
            coche=scan.next();
            switch (coche) {
                case "s" -> cochera = true;
                case "n" -> cochera = false;
                default -> System.out.println("Opción invalida");
            }
        }while(!coche.equals("s") && !coche.equals("n"));

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

        hotelASCIIEstado(listaHabitaciones);
        System.out.print("\nIngrese el numero de habitación:");
        int numero = scan.nextInt();
        Habitacion hab=buscadorDeHabitaciones(numero);

        if(hab==null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la habitación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }else{
            hotelASCIIBuscar(listaHabitaciones,hab);
            System.out.println(hab);
        }
    }
    Habitacion buscadorDeHabitaciones(int numero){
        listaHabitaciones.sort(Comparator.comparingInt(Habitacion::getNumero));
        for (Habitacion hab : listaHabitaciones) {
            if (hab.getNumero() == numero) {
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

        System.out.print("\nIngrese el numero de habitación:");
        numero = scan.nextInt();
        Habitacion hab = buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones, hab);
        if (hab == null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la habitación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        }else {
            cambiarEstado(hab);

            hotel.modificar(hab);

            hotelASCIIEstado(listaHabitaciones);
            System.out.println(hab);
            System.out.println("Habitación modificada con éxito");
            System.out.println("-------------------------------");
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
        }while(!(opcion==1 || opcion==2 || opcion==3 || opcion==4 || opcion==5));
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

        hotelASCIIBuscar(listaHabitaciones,null);
        listarHabitaciones();

        System.out.print("\n Ingrese el numero de habitación:");
        numero = scan.nextInt();
        scan.nextLine(); //limpio el buffer

        Habitacion hab=buscadorDeHabitaciones(numero);
        hotelASCIIBuscar(listaHabitaciones,hab);

        if(hab==null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la habitación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }else{
            System.out.println(hab);

            hotel.eliminar(hab.getNumero());  //elimino la habitacion de la lista y la vuelvo a agregar por si se modificó el número.
            hab=crearHabitacion();            //la debo eliminar primero porque si agrego algo ya contenido, no lo agrega.
            agregarAListaHabitacion(hab);
            hotel.agregar(hab);

            hotelASCIIBuscar(listaHabitaciones,hab);
            System.out.println(hab);
            System.out.println("Habitación modificada con éxito");
            System.out.println("-------------------------------");
        }
    }

    //endregion

    //region 6. Eliminar habitacion
    public void eliminarHabitacionEnv(){
        Scanner scan = new Scanner(System.in);
        int numero;

        hotelASCIIBuscar(listaHabitaciones,null);
        listarHabitaciones();

        System.out.print("\nIngrese el numero de habitación:");
        numero = scan.nextInt();
        scan.nextLine(); //limpio el buffer
        Habitacion hab=buscadorDeHabitaciones(numero);

        if(hab==null) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  No se encontró la habitación ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }else{
            hotelASCIIBuscar(listaHabitaciones,hab);
            System.out.println("precione 'b' para borrar o cualquier letra para cancelar");
            String opcion=scan.nextLine();
            if(opcion.equals("b") || opcion.equals("B")) {

                listaHabitaciones.remove(hab);
                hotel.eliminar(hab.getNumero());

                System.out.println("<<(KABOOOOMM)>>");
                hotelASCIIBuscar(listaHabitaciones,hab);
                System.out.println("Habitación eliminada con éxito");
                System.out.println("------------------------------");
            }else{
                System.out.println("Cargas desactivadas");
                System.out.println("-------------------");
            }
        }
    }

    //endregion

    //region 7. Estadísticas del hotel
    public void estadisticasHotelEnv() {
        System.out.println("Estadísticas del Hotel");
        System.out.println("---------------------------");
        hotelASCIIBuscar(listaHabitaciones, null);
        System.out.println("       Cantidad de pisos: " + contarPisos(listaHabitaciones));
        float cant = contarHabitaciones();
        System.out.println("Cantidad de habitaciones: " + cant);
        System.out.println("------------------------------------------------");
        hotelASCIIEstado(listaHabitaciones);
        float dis = contarHabitacionesPorEstado(listaHabitaciones, Habitacion.EstadoHabitacion.DISPONIBLE);
        float ocu = contarHabitacionesPorEstado(listaHabitaciones, Habitacion.EstadoHabitacion.OCUPADA);
        float res = contarHabitacionesPorEstado(listaHabitaciones, Habitacion.EstadoHabitacion.RESERVADA);
        float man = contarHabitacionesPorEstado(listaHabitaciones, Habitacion.EstadoHabitacion.MANTENIMIENTO);
        float fue = contarHabitacionesPorEstado(listaHabitaciones, Habitacion.EstadoHabitacion.FUERA_SERVICIO);
        System.out.printf("      Cantidad de habitaciones disponibles: %d  %.2f%%%n", (int) dis, ((dis / cant) * 100));
        System.out.printf("         Cantidad de habitaciones ocupadas: %d  %.2f%%%n", (int) ocu, ((ocu / cant) * 100));
        System.out.printf("       Cantidad de habitaciones reservadas: %d  %.2f%%%n", (int) res, ((res / cant) * 100));
        System.out.printf(" Cantidad de habitaciones en mantenimiento: %d  %.2f%%%n", (int) man, ((man / cant) * 100));
        System.out.printf("Cantidad de habitaciones fuera de servicio: %d  %.2f%%%n", (int) fue, ((fue / cant) * 100));
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

    int contarHabitaciones(){
        return listaHabitaciones.size();
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
    public void hotelASCIIEstado(List<Habitacion> habitaciones) {
        char izqTecho = '┏';
        char techo = '━';
        char derTecho = '┓';
        char pared = '┃';
        char ventana;

        habitaciones.sort(Comparator.comparing(Habitacion::getNumero));
        int pisos = contarPisos(habitaciones);
        int ultimoPiso = contarHabitacionesPorPiso(habitaciones, pisos);

        // Dibujar techo del Hotel
        System.out.printf("   %c", izqTecho);
        for (int i = 0; i < ultimoPiso * 2 + 1; i++) {
            System.out.printf("%c", techo);
        }
        System.out.printf("%c", derTecho);
        System.out.println(); // Salto de línea

        // Dibujar pared del hotel
        int habitacionIndex = habitaciones.size() - 1; // Índice de habitación en la lista
        for (int i = pisos; i >= 1; i--) {
            System.out.printf("   %c", pared); // Borde izquierdo pared
            // Habitaciones por piso
            int habPorPiso = contarHabitacionesPorPiso(habitaciones, i);
            for (int j = 0; j < habPorPiso; j++) {
                Habitacion habitacion = habitaciones.get(habitacionIndex); // Obtener la habitación correcta
                ventana = switch (habitacion.getEstado()) {
                    case DISPONIBLE -> '░';
                    case OCUPADA -> '█';
                    case RESERVADA -> '▒';
                    case FUERA_SERVICIO -> 'X';
                    case MANTENIMIENTO -> '¶';
                };
                System.out.printf(" %c", ventana);
                habitacionIndex--; // Decrementar el índice de habitación
            }
            System.out.print(" ");
            System.out.printf("%c", pared); // Borde derecho pared
            System.out.println(); // Salto de línea
        }

        // Dibujar última línea
        System.out.printf("   %c", pared); // Borde izquierdo pared
        for (int i = 0; i < contarHabitacionesPorPiso(habitaciones, 1) * 2; i++) {
            System.out.print(" "); // Espacio en blanco
        }
        System.out.printf(" %c", pared); // Borde derecho pared
        System.out.println(); // Salto de línea
        System.out.println("Referencia: ░ Disponible | █ Ocupada | ▒ Reservada | X Fuera de servicio | ¶ Mantenimiento ");
        System.out.println(" ");
    }

    public void hotelASCIIBuscar(List<Habitacion> habitaciones, Habitacion habitacionBuscada) {
        char izqTecho = '┏';
        char techo = '━';
        char derTecho = '┓';
        char pared = '┃';
        char ventana;

        habitaciones.sort(Comparator.comparing(Habitacion::getNumero));
        int pisos = contarPisos(habitaciones);
        int ultimoPiso = contarHabitacionesPorPiso(habitaciones, pisos);

        // Dibujar techo del Hotel
        System.out.printf("   %c", izqTecho);
        for (int i = 0; i < ultimoPiso * 2 + 1; i++) {
            System.out.printf("%c", techo);
        }
        System.out.printf("%c", derTecho);
        System.out.println(); // Salto de línea

        // Dibujar pared del hotel
        int habitacionIndex = habitaciones.size() - 1; // Índice de habitación en la lista
        for (int i = pisos; i >= 1; i--) {
            System.out.printf("   %c", pared); // Borde izquierdo pared
            // Habitaciones por piso
            int habPorPiso = contarHabitacionesPorPiso(habitaciones, i);
            for (int j = 0; j < habPorPiso; j++) {
                Habitacion habitacion = habitaciones.get(habitacionIndex); // Obtener la habitación correcta
                if (habitacionBuscada == null || !habitacion.equals(habitacionBuscada)) {
                    ventana = '░';
                    System.out.printf(" %c", ventana);
                } else {
                    ventana = '█';
                    System.out.printf(" %c", ventana);
                }
                habitacionIndex--; // Decrementar el índice de habitación
            }
            System.out.print(" ");
            System.out.printf("%c", pared); // Borde derecho pared
            System.out.println(); // Salto de línea
        }

        // Dibujar última línea
        System.out.printf("   %c", pared); // Borde izquierdo pared
        for (int i = 0; i < contarHabitacionesPorPiso(habitaciones, 1) * 2; i++) {
            System.out.print(" "); // Espacio en blanco
        }
        System.out.printf(" %c", pared); // Borde derecho pared
        System.out.println(); // Salto de línea
    }
    //endregion



    // la creación del hotel es crear una lista de habitaciones.

    //cambiar estados SE DEBERÍAN también CAMBIAR DESDE LAS RESERVAS

}
