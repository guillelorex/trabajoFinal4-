package org.grupoTP.clases.Usuarios;

import java.util.Objects;

public abstract class Persona {

    protected String dni;
    protected String password;
    protected String mail;
    protected String nombre;
    protected String apellido;


    protected enum tipoCuenta {ADMINISTRADOR, EMPLEADO, CLIENTE};

    protected tipoCuenta tipoCuenta;

    //region Constructores
    public Persona() {}

    public Persona(String dni, String password, String mail, String nombre, String apellido, Persona.tipoCuenta tipoCuenta) {
        this.dni = dni;
        this.password = password;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCuenta = tipoCuenta;
    }

    //endregion

    //region Getters and Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Persona.tipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Persona.tipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }


    //endregion

    //region ToString

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }

    //endregion

    //region Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni) && Objects.equals(password, persona.password) && Objects.equals(mail, persona.mail) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && tipoCuenta == persona.tipoCuenta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    //endregion
}
