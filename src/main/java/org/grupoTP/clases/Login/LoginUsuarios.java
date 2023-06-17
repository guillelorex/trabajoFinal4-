package org.grupoTP.clases.Login;

import org.grupoTP.Repositorios.RepoPersonal;
import org.grupoTP.clases.Usuarios.Admin.MenuAdmin;
import org.grupoTP.clases.Usuarios.Empleados.Empleado;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;

import java.util.List;

public class LoginUsuarios {

   /*construcotr


    RepoEmpleado repoEmpleado = new RepoEmpleado();
    RepoPersonal repoPersonal = new RepoPersonal();

    List<Empleado> listaEmpleados = repoEmpleado.listar();
    List<Reserva> listaReservas = repoPersonal.listar();



    METODOS

    String mail= scanf
    String contraseña = scanf


        for (Empleado empleado : listaEmpleados) {
        if (empleado.getMail().equals(cuenta)) {
            return empleado;
        }
    }
    void verificarContrasena(String contraseña, Persona personita){
        if (personita.getContraseña().equals(contraseña)) {
            if (personita.getTipoCuenta().equals(tipoCuenta.ADMINISTRACION)) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.suuitchAdmin();
            } else if (personita.getArea().equals(tipoCuenta.RECEPCION)) {
                menuRecepcion.suuitchRecepcion();
            } else {
                mostrarficha();
            }
        }
    }

    contraseña equals(empleado.getPassword()) */

    // lo que hay que hacer es si es valida la cuenta es decir busco el usuario en la lista si lo encuentro, tengo que saber si la contraseña ingresada
    // es la misma que la que esta en el repositorio, SI ES ASI, tengo que saber si es admin, reserva o empleado, si es admin, lo mando al menu admin, si es empleado


}


