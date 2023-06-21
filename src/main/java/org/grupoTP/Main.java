package org.grupoTP;


import org.grupoTP.clases.Login.MenuLogueo;


public class Main {
    public static void main(String[] args) {

        //RepoReserva repoReserva = new RepoReserva();
        MenuLogueo menuLogueo = new MenuLogueo();

        //Reserva cliente1 = new Reserva("22345123", "1234", "guille@gmail.com", "Guillermo", "Perez", Persona.TipoCuenta.CLIENTE, 22, 11,"2020-12-12", "2020-12-15", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.JUBILADO, Reserva.pension.DESAYUNO, Reserva.formaPago.EFECTIVO);

        //repoReserva.agregar(cliente1);

        menuLogueo.inicioPrograma();

    }
}