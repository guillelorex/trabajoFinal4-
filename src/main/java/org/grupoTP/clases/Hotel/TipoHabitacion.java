package org.grupoTP.clases.Hotel;

public enum TipoHabitacion {

    SIM("simple",1),
    DOB("doble",2),
    TRI("triple",3),
    SUI("suite",4);

    private final String tipo;
    private final int capacidad;

    TipoHabitacion(String tipo, int capacidad) {
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }
    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Tipohabitacion{" +
                "tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}

