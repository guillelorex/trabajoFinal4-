package org.grupoTP;

import org.grupoTP.Menu.MenuLogueo;


public class Main {
    public static void main(String[] args) {



        /*
        RepoReserva reservas = new RepoReserva();

        Reserva reserva1 = new Reserva("guille", "laurencio", "34561223","2235454567","1@gmail.com","123",11,1,"6/6/2023","8/6/2023", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.HUESPED, Reserva.pension.MEDIA, Reserva.formaPago.EFECTIVO);
        Reserva reserva2 = new Reserva("maty", "striker", "3456657653","2235456567","2@gmail.com","123",22,2,"10/6/2023","14/6/2023", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.VIP, Reserva.pension.ALLINCLUSIVE, Reserva.formaPago.TARJETA);

        reservas.agregar(reserva1);
        reservas.agregar(reserva2);

        reservas.listar().forEach(System.out::println);
        */

        MenuLogueo menuLogueo = new MenuLogueo();
        menuLogueo.menuPrincipal();

    }
}