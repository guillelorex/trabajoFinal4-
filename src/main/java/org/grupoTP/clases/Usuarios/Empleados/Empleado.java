package org.grupoTP.clases.Usuarios.Empleados;

import org.grupoTP.clases.Usuarios.Persona;

import java.io.Serializable;
import java.util.Objects;

public class Empleado extends Persona implements Serializable{


    private int legajo;             ///HACERLO STATIC
    private Area area;
    private String horario;
    public enum Estado {ACTIVO, BAJA, VACACIONES}
    private Estado estado;
  //luego miramos si sirve o lo sacamos

    //region constructores

    public Empleado(){}

    public Empleado(String dni, String password, String mail, String nombre, String apellido, Persona.tipoCuenta tipoCuenta, int legajo, Area area, String horario, Estado estado, boolean fichaje) {
        super(dni, password, mail, nombre, apellido, tipoCuenta);
        this.legajo = legajo;
        this.area = area;
        this.horario = horario;
        this.estado = estado;
    }

    //endregion

    //region getters and setters
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "Empleado{" +
                "legajo=" + legajo +
                ", area=" + area +
                ", horario=" + horario +
                ", estado=" + estado +
                ", dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
    //endregion

    //region equals and hashCode
        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Empleado empleado = (Empleado) o;
            return legajo == empleado.legajo && area == empleado.area && Objects.equals(horario, empleado.horario) && estado == empleado.estado;
        }

        @Override
        public int hashCode () {
            return Objects.hash(super.hashCode(), legajo);
        }

        //endregion

        //falta hacer un atributo contraseña que se encripte

    }
