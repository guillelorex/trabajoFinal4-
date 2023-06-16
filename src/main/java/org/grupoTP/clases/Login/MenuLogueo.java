package org.grupoTP.clases.Login;

import java.util.Scanner;

public class MenuLogueo {

    public MenuLogueo(){}


    public static void retraso(){
        try{
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println(" ");
        }catch(Exception e) {
            System.out.println(e);
        }
    }







}

