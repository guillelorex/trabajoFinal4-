package org.grupoTP.clases.Usuarios.Reserva;

import org.grupoTP.clases.Usuarios.Persona;
import java.io.Serializable;
import java.util.Objects;

public class Reserva extends Persona implements Serializable{

    private int nroHabitacion;
    private int nroReserva;
    private String fechaIngreso;
    private String fechaEgreso;
    public enum clienteEstado {RESERVADO, INGRESADO, EGRESADO} ;
    private clienteEstado estado;
    public enum clienteTipo {HUESPED, CONVENCION, VIP, TOUR, JUBILADO};
    private clienteTipo tipo;
    public enum pension{ALLINCLUSIVE, COMPLETA, MEDIA, DESAYUNO};
    private pension pension;
    public enum formaPago{EFECTIVO, TARJETA, PLAN};     //PUEDE IR EN FACTURACION?
    private formaPago formaPago;

    //region constructores

    public Reserva(){}

    public Reserva(String nombre, String apellido, String dni, String telefono, String mail, String password, int nroHabitacion, int nroReserva, String fechaIngreso, String fechaEgreso, clienteEstado estado, clienteTipo tipo, Reserva.pension pension, Reserva.formaPago formaPago) {
        super(nombre, apellido, dni, telefono, mail, password);
        this.nroHabitacion = nroHabitacion;
        this.nroReserva = nroReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.tipo = tipo;
        this.pension = pension;
        this.formaPago = formaPago;
    }

    //endregion

    //region getters and setters

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getNroReserva() {
        return nroReserva;
    }

    public void setNroReserva(int nroReserva) {
        this.nroReserva = nroReserva;
    }

    public String getFechaIngreso() {return fechaIngreso;}

    public void setFechaIngreso(String fechaIngreso) {this.fechaIngreso = fechaIngreso;}

    public String getFechaEgreso() {return fechaEgreso;}

    public void setFechaEgreso(String fechaEgreso) {this.fechaEgreso = fechaEgreso;}

    public clienteEstado getEstado() {
        return estado;
    }

    public void setEstado(clienteEstado estado) {
        this.estado = estado;
    }

    public clienteTipo getTipo() {
        return tipo;
    }

    public void setTipo(clienteTipo tipo) {
        this.tipo = tipo;
    }

    public Reserva.pension getPension() {
        return pension;
    }

    public void setPension(Reserva.pension pension) {
        this.pension = pension;
    }

    public Reserva.formaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Reserva.formaPago formaPago) {
        this.formaPago = formaPago;
    }

    //endregion

    //region toString

    @Override
    public String toString() {
        return "Cliente{" +
                ", nroReserva=" + nroReserva + '\'' +
                ", nroHabitacion=" + nroHabitacion + '\'' +
                ", fechaIngreso=" + fechaIngreso + '\'' +
                ", fechaEgreso=" + fechaEgreso + +'\'' +
                ", estado=" + estado + '\''+
                ", tipo=" + tipo + '\'' +
                ", pension=" + pension + '\'' +
                ", formaPago=" + formaPago + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    //endregion

    //region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reserva reserva = (Reserva) o;
        return nroHabitacion == reserva.nroHabitacion && nroReserva == reserva.nroReserva && Objects.equals(fechaIngreso, reserva.fechaIngreso) && Objects.equals(fechaEgreso, reserva.fechaEgreso) && estado == reserva.estado && tipo == reserva.tipo && pension == reserva.pension && formaPago == reserva.formaPago;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nroReserva);
    }
    //endregion
}


