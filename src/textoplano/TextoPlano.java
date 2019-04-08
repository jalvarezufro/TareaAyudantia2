/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textoplano;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author JAVIER
 */
public class TextoPlano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(leerTxt("D:\\Descargas\\texto.txt"));
        escribirTxt("D:\\Descargas\\texto.txt");
        System.out.print(leerTxt("D:\\Descargas\\texto.txt"));

    }

    public static String leerTxt(String direccion) { //direccion del archivo

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + "\n" + bfRead; //guardado el texto del archivo
            }

            texto = temp;

        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }

        return texto;

    }

    public static String escribirTxt(String direccion){
        FileWriter EscribirFichero = null;
        PrintWriter Escribirlinea = null;
        try {
            String linea = "\n" + "The first man who stepped on the moon.";
            EscribirFichero = new FileWriter(direccion, true);
            Escribirlinea = new PrintWriter(EscribirFichero);
            Escribirlinea.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("archivo no encontrado");
        } finally {
            if (EscribirFichero != null) {
                try {
                    EscribirFichero.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        String escrito= leerTxt(direccion);
        return escrito;

    }
}
