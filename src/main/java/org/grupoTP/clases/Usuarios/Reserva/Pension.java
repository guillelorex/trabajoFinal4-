package org.grupoTP.clases.Usuarios.Reserva;

public enum Pension {
   ALLINCLUSIVE ("todo incluido", 100),
    COMPLETA ("cena, almuerzo y desayuno", 60),
    MEDIA("almuerzo y desayuno", 40),
    DESAYUNO("desayuno", 20);

   private final String pension;
   private final float valor;

    Pension(String pension, float valor){
         this.pension = pension;
         this.valor = valor;
    }

    public String getPension() {return pension;}

    public float getValor() {return valor;}

    @Override
    public String toString() {
        return "Pension{" + '\'' +
                "pension='" + pension + '\'' +
                ", valor=" + valor + '\'' +
                '}';
    }
}
