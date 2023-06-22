package org.grupoTP.clases.Usuarios.Empleados;

public enum Area {
    MANTENIMIENTO ("mantenimiento", 2000),
    ADMINISTRACION ("administracion", 3500),
    LIMPIEZA ("limpieza", 1800),
    SEGURIDAD ("seguridad", 2000),
    COCINA ("cocina", 2300),
    MOZOS ("mozos", 1500),
    VALETPARKING ("valetParking", 1500),
    RECEPCION ("recepcion", 2500);

    private final String cargo;
    private final float sueldo;

    Area(String cargo, int sueldo){
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSueldo() {
        return sueldo;
    }

    @Override
    public String toString(){
        return "Area (" +
                "cargo='" + cargo + '\'' +
                ", sueldo=" + sueldo +'\'' +
                ')';
    }

}
