package org.grupoTP.clases.Hotel;

import java.io.Serializable;
import java.util.Objects;

public class Habitacion implements Serializable{

    private int numero;
    private int piso;

    private TipoHabitacion tipo;
    private boolean cochera;
    public enum EstadoHabitacion {DISPONIBLE, OCUPADA, RESERVADA, MANTENIMIENTO, FUERA_SERVICIO};
    private EstadoHabitacion estado;

    //region Constructores
    public Habitacion(){}
    public Habitacion(int numero, int piso, TipoHabitacion tipo, boolean cochera, EstadoHabitacion estado) {
        this.numero = numero;
        this.piso = piso;
        this.tipo = tipo;
        this.cochera = cochera;
        this.estado = estado;
    }
    //endregion

    //region Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public boolean getCochera() {
        return cochera;
    }

    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    //endregion

    //region toString
    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", piso=" + piso +
                ", tipo=" + tipo +
                ", cochera=" + cochera +
                ", estado=" + estado +
                '}';
    }

    //endregion

    //region Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return numero == that.numero && piso == that.piso && cochera == that.cochera && tipo == that.tipo && estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    //endregion
}

