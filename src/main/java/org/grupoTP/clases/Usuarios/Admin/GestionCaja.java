package org.grupoTP.clases.Usuarios.Admin;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GestionCaja {

    GestionCaja() {}

   // aca debo tener funciones de serializar, deserializar, crear una nueva caja y modificarla y verla
     Caja crearCaja() {
        //si no hay objeto caja crea uno nuevo
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el monto inicial de la caja");
        float montoInicial = scan.nextFloat();
        LocalDateTime fecha = LocalDateTime.now();
         return new Caja(montoInicial,0,0,fecha);
    }

    void serializarCaja(String rutaArchivo,Caja caja) {
        //aca se serializa la caja
        File file = new File(rutaArchivo);
        try {
           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(caja);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Caja deserializarCaja (File file) throws IOException, ClassNotFoundException {
        //aca deserealizo la caja
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object aux = ois.readObject();
        Caja caja = (Caja) aux;
        ois.close();
        return caja;
    }
}
