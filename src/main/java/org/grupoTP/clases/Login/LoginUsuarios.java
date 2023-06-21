package org.grupoTP.clases.Login;

import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.Repositorios.RepoReserva;

import org.grupoTP.clases.Usuarios.Reserva.MenuReservas;
import org.grupoTP.clases.Usuarios.Admin.MenuAdmin;

import org.grupoTP.clases.Usuarios.Empleados.Empleado;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;


import java.util.List;


public class LoginUsuarios {

    RepoPersonal repoPersonal = new RepoPersonal();
    RepoReserva repoReserva = new RepoReserva();

    List<Empleado> listaEmpleados = repoPersonal.listar();
    List<Reserva> listaReservas = repoReserva.listar();

    public LoginUsuarios() {}

     Empleado checkUsuarioEmpleado(String email) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getMail().equals(email)) {
                return emp;
            }
        }
        return null;
    }
         Reserva checkUsuarioReserva(String email) {
        for (Reserva res : listaReservas) {
            if (res.getMail().equals(email)) {
                return res;
            }
        }
        return null;
    }
    boolean checkContrasenaEmpleado(Empleado empleadoEncontrado, String contrasena) {
        return empleadoEncontrado.getPassword().equals(contrasena);
    }
    boolean checkContrasenaReserva(Reserva reservaEncontrada, String contrasena) {
        return reservaEncontrada.getPassword().equals(contrasena);
    }

    void suuitchUsuario(Empleado emp){
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuReservas menuReservas = new MenuReservas();
        switch (emp.getTipoCuenta()) {
            case ADMINISTRADOR -> menuAdmin.suuitchAdmin();
            case RECEPCION -> menuReservas.suuitchReservas();
            case EMPLEADO -> System.out.println(emp);
        }
    }

}
    // lo que hay que hacer es si es valida la cuenta es decir busco el usuario en la lista si lo encuentro, tengo que saber si la contraseña ingresada
    // es la misma que la que esta en el repositorio, SI ES ASI, tengo que saber si es admin, reserva o empleado, si es admin, lo mando al menu admin, si es empleado




