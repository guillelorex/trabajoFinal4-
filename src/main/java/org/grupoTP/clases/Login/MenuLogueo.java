package org.grupoTP.clases.Login;

import org.grupoTP.clases.Usuarios.Empleados.Empleado;
import org.grupoTP.clases.Usuarios.Reserva.Reserva;

import java.util.Scanner;

public class MenuLogueo {

    public MenuLogueo(){}

    LoginUsuarios login = new LoginUsuarios();
    public void inicioPrograma() {
        Scanner scan = new Scanner(System.in);

        boolean usuarioValido=false;
        boolean contrasenaCorrecta;
        String contrasena;
        String mail;

        do {
            System.out.println("----Inicio de sesión----");
            System.out.print("\nIngrese su mail de Usuario o '0' para salir: ");
            mail = scan.nextLine();
            if (mail.equals("0"))
                break; // Salir del bucle si se ingresa '0'

            Empleado empleadoEncontrado = login.checkUsuarioEmpleado(mail);
            Reserva reservaEncontrada = login.checkUsuarioReserva(mail);

            if (empleadoEncontrado != null) {
                usuarioValido = true;
                do {
                    System.out.print("\nIngrese su contraseña o '0' para salir: ");
                    contrasena = scan.nextLine();
                    if (contrasena.equals("0"))
                        break; // Salir del bucle si se ingresa '0'
                    contrasenaCorrecta = login.checkContrasenaEmpleado(empleadoEncontrado, contrasena);

                    if (!contrasenaCorrecta) {
                        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("┃  Contraseña Incorrecta  ┃");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    }else{
                        System.out.print("Contraseña correcta. Ingresando al sistema");
                        LoginUsuarios.retraso();
                        login.suuitchUsuario(empleadoEncontrado);
                    }
                } while (!contrasenaCorrecta);
            } else if (reservaEncontrada != null) {
                usuarioValido = true;
                do {
                    System.out.print("\nIngrese su contraseña  o '0' para salir: ");
                    contrasena = scan.nextLine();
                    contrasenaCorrecta = login.checkContrasenaReserva(reservaEncontrada, contrasena);

                    if (!contrasenaCorrecta && !contrasena.equals("0")) {
                        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("┃  Contraseña Incorrecta  ┃");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                        System.out.println("  ");
                    }else{
                        System.out.println("  ");
                        System.out.print("Contraseña correcta. Ingresando al sistema");
                        LoginUsuarios.retraso();
                        System.out.println(reservaEncontrada);
                    }
                } while (!contrasenaCorrecta || !contrasena.equals("0"));
            } else {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  Usuario Incorrecto  ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("  ");
                System.out.println("  ");
            }
        } while (!usuarioValido);
        System.out.print("Saliendo del Sistema");
        LoginUsuarios.retraso();
    }








}

