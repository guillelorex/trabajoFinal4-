package org.grupoTP.clases.Usuarios.Admin;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Caja implements Serializable{

    @Serial
    private static final long serialVersionUID = 8799656478674716638L;
    private float saldo;
    private float ingreso;
    private float egreso;

    private LocalDateTime Fecha;

    //region Constructores

    public Caja() {}

    public Caja(float saldo, float ingreso, float egreso, LocalDateTime fecha) {
        this.saldo = saldo;
        this.ingreso = ingreso;
        this.egreso = egreso;
        Fecha = fecha;
    }
//endregion

    //region Getters and Setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float balance) {
        this.saldo = balance;
    }

    public float getIngreso() {
        return ingreso;
    }

    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    }

    public float getEgreso() {
        return egreso;
    }

    public void setEgreso(float egreso) {
        this.egreso = egreso;
    }

    public LocalDateTime getFecha() {return Fecha;}

    public void setFecha(LocalDateTime fecha) {Fecha = fecha;}

    //endregion

    //region toString

    @Override
    public String toString() {
        return "Caja{" +
                "saldo=" + saldo +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                ", Fecha=" + Fecha +
                '}';
    }

    //endregion
}
