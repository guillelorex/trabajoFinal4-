package org.grupoTP.clases.Usuarios.Admin;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class GestionCaja {

    public GestionCaja() {}

   // aca debo tener funciones de serializar, deserializar, crear una nueva caja y modificarla y verla

    //region 1. Ver Caja
    public void mostrarCajaEnv() {
        File archivoCaja = new File("src/main/resources/caja.bin");

        if (archivoCaja.exists()) {
            try {
                Caja caja = deserializarCaja(archivoCaja);
                mostrarCaja(caja);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            archivoNoExiste();
        }
    }
    void mostrarCaja(Caja caja) {
        System.out.println("-----------Caja Actual------------ ");
        System.out.println("Saldo actual: " + caja.getSaldo());
        System.out.println("Ingresos: " + caja.getIngreso());
        System.out.println("Egresos: " + caja.getEgreso());
        System.out.println("Fecha de último cambio: " + caja.getFecha());
        System.out.println("----------------------------------");
    }

    //endregion

    //region 2. Crear Caja
    public void crearCajaEnv() {
        File archivoCaja = new File("src/main/resources/caja.bin");

        if (!archivoCaja.exists()) {
            Caja caja = crearCaja();
            serializarCaja(caja);
            imprimirCaja(caja);
        } else {
            System.out.println("Ya existe una caja.");
        }
    }
     Caja crearCaja() {
         //si no hay objeto caja crea uno nuevo
        LocalDateTime fecha = LocalDateTime.now();
        String fechaString = localDateAString(fecha);
        System.out.println("Fecha de creación de esta caja: "+fechaString);

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("\nIngrese el monto inicial de la caja: ");
        float montoInicial = scan.nextFloat();

         return new Caja(montoInicial,0,0,fechaString);
    }
    //endregion

    //region 3. Modificar Caja
    void modificarCajaEnv(){
        File archivoCaja = new File("src/main/resources/caja.bin");

        if (archivoCaja.exists()) {
            try {
                Caja caja = deserializarCaja(archivoCaja);
                Caja cajita = modificarCaja(caja);
                serializarCaja(cajita);
                imprimirCaja(cajita);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo de la caja no existe.");
        }
    }
    Caja modificarCaja(Caja caja){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("\nIngrese el monto de ingreso: ");
        float ingreso = scan.nextFloat();
        System.out.print("\nIngrese el monto de egreso: ");
        float egreso = scan.nextFloat();

        LocalDateTime fecha = LocalDateTime.now();
        String fechaString = localDateAString(fecha);

        float saldo = caja.getSaldo() + ingreso - egreso;

        return new Caja(saldo,ingreso,egreso,fechaString);
    }
    //endregion

    //region 4. Imprimir Caja
     void imprimirCajaEnv(){
        File archivoCaja = new File("src/main/resources/caja.bin");

        if (archivoCaja.exists()) {
            try {
                Caja caja = deserializarCaja(archivoCaja);
                //saco una foto de la caja actual por eso la hora actual
                caja.setFecha(localDateAString(LocalDateTime.now()));
                imprimirCaja(caja);
                serializarCaja(caja);
                System.out.println(" ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  Se ha impreso la caja actual  ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            archivoNoExiste();
        }
    }
    public static void imprimirCaja(Caja caja){

        File file = new File("src/main/resources/Libros/caja.txt");
        try {
            PrintWriter buffer = new PrintWriter(new FileWriter(file, true));

            buffer.printf("-----------Caja Actual------------ \n");
            buffer.printf("Saldo actual: " + caja.getSaldo() + "\n");
            buffer.printf("Ingresos: " + caja.getIngreso()+ "\n");
            buffer.printf("Egresos: " + caja.getEgreso()+ "\n");
            buffer.printf("Fecha de último cambio: " + caja.getFecha()+ "\n");
            buffer.printf("----------------------------------\n");
            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //endregion

    //region 01. Serialización y deserialización de caja
      static void serializarCaja(Caja caja) {
        //aca se serializa la caja
        File file = new File("src/main/resources/caja.bin");
        try {
           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(caja);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       static Caja deserializarCaja(File file) throws IOException, ClassNotFoundException {
        //aca se deserializa la caja
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object aux = ois.readObject();
            return (Caja) aux;
        }
    }

    public static Caja abrirCaja(){
        File file = new File("src/main/resources/caja.bin");
        if (file.exists()) {
        try {
            return deserializarCaja(file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }} else {
            archivoNoExiste();
        }
        return null;
    }

    public static void cerrarCaja(Caja caja){
        try {
            serializarCaja(caja);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //endregion

    //region 0. Auxiliares Localdate a String y viceversa

    public static String localDateAString(LocalDateTime fecha) {

        // Define el formato deseado para la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Convierte el objeto LocalDateTime a una cadena de texto
        //y devuelvo la cadena de texto
        return(fecha.format(formatter));
    }
    public static LocalDateTime stringALocalDate(String fechaString) {

        // Define el formato correspondiente para la cadena de texto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Convierte la cadena de texto a un objeto LocalDateTime
        //y devuelvo el objeto LocalDateTime
        return(LocalDateTime.parse(fechaString, formatter));
    }
    //endregion
   static void archivoNoExiste() {
       System.out.println(" ");
       System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
       System.out.println("┃  El archivo de la caja no existe  ┃");
       System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
   }

}
