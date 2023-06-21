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

    //region 1. CheckUsuario
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
    //endregion

    //region 2. CheckContrasena
    boolean checkContrasenaEmpleado(Empleado empleadoEncontrado, String contrasena) {
        return empleadoEncontrado.getPassword().equals(contrasena);
    }
    boolean checkContrasenaReserva(Reserva reservaEncontrada, String contrasena) {
        return reservaEncontrada.getPassword().equals(contrasena);
    }
    //endregion

    //region 3. SwitchUsuario
    void suuitchUsuario(Empleado emp){
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuReservas menuReservas = new MenuReservas();
        switch (emp.getTipoCuenta()) {
            case ADMINISTRADOR -> menuAdmin.suuitchAdmin();
            case RECEPCION -> menuReservas.suuitchReservas();
            case EMPLEADO -> System.out.println(emp);
        }
    }
    //endregion

    //region 4. Retraso
    public static void retraso(){
        try{
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println(" ");
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    //endregion
}



