package org.grupoTP;

import org.grupoTP.Repositorios.RepoReserva;
import org.grupoTP.clases.Login.MenuLogueo;
import org.grupoTP.clases.Usuarios.Persona;
import org.grupoTP.clases.Usuarios.Reserva.Pension;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;


public class Main {
    public static void main(String[] args) {

        Reserva r0 = new Reserva("233554123", "1234", "guille@gmail.com", "Guillermo", "Perez", Persona.TipoCuenta.CLIENTE, 12, 1, "21-06-2023 08:08:12", "25-06-2023 09:10:10", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.JUBILADO, Pension.COMPLETA, Reserva.formaPago.EFECTIVO);
        Reserva r1 = new Reserva("123456789", "1234", "juan@gmail.com", "Juan", "García", Persona.TipoCuenta.CLIENTE, 22, 2, "20-06-2023 14:00:00", "26-06-2023 12:00:00", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.HUESPED, Pension.COMPLETA, Reserva.formaPago.TARJETA);
        Reserva r2 = new Reserva("987654321", "4456", "maria@gmail.com", "María", "Rodríguez", Persona.TipoCuenta.CLIENTE, 23, 3, "18-06-2023 10:00:00", "23-06-2023 09:00:00", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.JUBILADO, Pension.MEDIA, Reserva.formaPago.EFECTIVO);
        Reserva r3 = new Reserva("654321987", "3789", "carlos@gmail.com", "Carlos", "López", Persona.TipoCuenta.CLIENTE, 21, 4, "11-06-2023 18:00:00", "24-06-2023 16:00:00", Reserva.clienteEstado.INGRESADO, Reserva.clienteTipo.TOUR, Pension.ALLINCLUSIVE, Reserva.formaPago.PLAN);
        Reserva r4 = new Reserva("789456123", "3456", "laura@gmail.com", "Laura", "Martínez", Persona.TipoCuenta.CLIENTE, 34, 5, "1-07-2023 09:00:00", "10-07-2023 10:00:00", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.VIP, Pension.ALLINCLUSIVE, Reserva.formaPago.TARJETA);
        Reserva r5 = new Reserva("456123789", "2233", "pedro@gmail.com", "Pedro", "Gómez", Persona.TipoCuenta.CLIENTE, 31, 6, "2-07-2023 15:00:00", "4-07-2023 12:00:00", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.CONVENCION, Pension.COMPLETA, Reserva.formaPago.EFECTIVO);
        Reserva r6 = new Reserva("321654987", "1111", "ana@gmail.com", "Ana", "Pérez", Persona.TipoCuenta.CLIENTE, 11, 7, "2-07-2023 12:00:00", "5-07-2023 10:00:00", Reserva.clienteEstado.RESERVADO, Reserva.clienteTipo.HUESPED, Pension.MEDIA, Reserva.formaPago.PLAN);

        RepoReserva repoReserva = new RepoReserva();
        repoReserva.agregar(r0, r1, r2, r3, r4, r5, r6);
        MenuLogueo menuLogueo = new MenuLogueo();
        menuLogueo.inicioPrograma();

    }
}