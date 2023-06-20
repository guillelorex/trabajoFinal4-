package org.grupoTP.clases.Usuarios.Admin;

import java.io.Serializable;

public class Caja implements Serializable{
    private float saldo;
    private float ingreso;
    private float egreso;

    //region Constructores

    public Caja() {}
    public Caja(float saldo, float ingreso, float egreso) {
        this.saldo = saldo;
        this.ingreso = ingreso;
        this.egreso = egreso;
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
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Caja{" +
                "balance=" + saldo +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                '}';
    }
    //endregion
}
