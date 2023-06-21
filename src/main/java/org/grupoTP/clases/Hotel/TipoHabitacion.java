package org.grupoTP.clases.Hotel;

public enum TipoHabitacion {

    SIM("simple",1,50),
    DOB("doble",2, 70),
    TRI("triple",3, 100),
    SUI("suite",4, 120);


    private final String tipo;
    private final int capacidad;
    private  final float valor;

    TipoHabitacion(String tipo, int capacidad, float valor) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.valor = valor;
    }

    public String getTipo() {return tipo;}
    public int getCapacidad() {return capacidad;}

    public float getValor() {return valor;}

    @Override
    public String toString() {
        return "TipoHabitacion{" +
                "tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +'\'' +
                ", valor=" + valor +'\'' +
                '}';
    }
}

