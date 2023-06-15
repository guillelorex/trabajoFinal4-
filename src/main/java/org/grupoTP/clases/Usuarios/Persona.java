package org.grupoTP.clases.Usuarios;

import java.util.Objects;

public abstract class Persona extends Cuenta{


    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String telefono;



    //region Constructores

    public Persona(String nombre, String apellido, String dni, String telefono, String mail, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.mail = mail;
        this.password = password;
    }

    public Persona() {
    }
    //endregion

    //region Getters and Setters
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", mail= '" + mail + '\''+
                ", password= '" + password + '\'' +
                '}';
    }
    //endregion

    //region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    //endregion
}
