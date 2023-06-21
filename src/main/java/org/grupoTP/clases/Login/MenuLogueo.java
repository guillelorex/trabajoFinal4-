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

            Empleado empleadoEncontrado = login.checkUsuarioEmpleado(mail);
            Reserva reservaEncontrada = login.checkUsuarioReserva(mail);

            if (empleadoEncontrado != null) {
                usuarioValido = true;
                do {
                    System.out.print("\nIngrese su contraseña o '0' para salir: ");
                    contrasena = scan.nextLine();
                    contrasenaCorrecta = login.checkContrasenaEmpleado(empleadoEncontrado, contrasena);

                    if (!contrasenaCorrecta && !contrasena.equals("0")) {
                        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("┃  Contraseña Incorrecta  ┃");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    }else{
                        System.out.print("Contraseña correcta. Ingresando al sistema");
                        retraso();
                        login.suuitchUsuario(empleadoEncontrado);
                    }
                } while (!contrasenaCorrecta || contrasena.equals("0"));
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
                        System.out.print("Contraseña correcta. Ingresando al sistema");
                        retraso();
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
        } while (!usuarioValido || mail.equals("0"));
    }
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







}

