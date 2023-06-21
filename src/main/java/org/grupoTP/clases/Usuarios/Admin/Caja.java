package org.grupoTP.clases.Usuarios.Admin;

import java.io.Serial;
import java.io.Serializable;

public class Caja implements Serializable{

    @Serial
    private static final long serialVersionUID = 8799656478674716638L;
    private float saldo;
    private float ingreso;
    private float egreso;

    private String fecha;

    //region Constructores

    public Caja() {}

    public Caja(float saldo, float ingreso, float egreso, String fecha) {
        this.saldo = saldo;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.fecha = fecha;
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

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}

    //endregion

    //region toString

    @Override
    public String toString() {
        return "Caja{" +
                "saldo=" + saldo +'\'' +
                ", ingreso=" + ingreso +'\'' +
                ", egreso=" + egreso +'\'' +
                ", Fecha=" + fecha +'\'' +
                '}';
    }

    //endregion
}
