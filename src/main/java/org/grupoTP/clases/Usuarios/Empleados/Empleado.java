package org.grupoTP.clases.Usuarios.Empleados;

import org.grupoTP.clases.Usuarios.Persona;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Empleado extends Persona implements Serializable{


    private int legajo;             ///HACERLO STATIC
    private Area area;
    private Date horario;
    public enum Estado {ACTIVO, BAJA, VACACIONES}
    private Estado estado;
    private boolean fichaje;

    //region constructores

    public Empleado(){}
    public Empleado(String nombre, String apellido, String dni, String telefono, String mail, String password, int legajo, Area area, Date horario, Estado estado, boolean fichaje) {
        super(nombre, apellido, dni, telefono, mail, password);
        this.legajo = legajo;
        this.area = area;
        this.horario = horario;
        this.estado = estado;
        this.fichaje = fichaje;
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

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public boolean isFichaje() {
        return fichaje;
    }

    public void setFichaje(boolean fichaje) {
        this.fichaje = fichaje;
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
                ", fichaje=" + fichaje +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\''; //endregion
    }
        //region equals and hashCode
        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Empleado empleado = (Empleado) o;
            return legajo == empleado.legajo && fichaje == empleado.fichaje && area == empleado.area && Objects.equals(horario, empleado.horario) && estado == empleado.estado;
        }

        @Override
        public int hashCode () {
            return Objects.hash(super.hashCode(), legajo);
        }

        //endregion

        //falta hacer un atributo contraseña que se encripte

    }
