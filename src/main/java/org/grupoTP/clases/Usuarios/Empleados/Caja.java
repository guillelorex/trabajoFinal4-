package org.grupoTP.clases.Usuarios.Empleados;

public class Caja {
    private float balance;
    private float ingreso;
    private float egreso;

    //region Constructores
    public Caja(float balance, float ingreso, float egreso) {
        this.balance = balance;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }
    //endregion

    //region Getters and Setters
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
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
                "balance=" + balance +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                '}';
    }
    //endregion
}
