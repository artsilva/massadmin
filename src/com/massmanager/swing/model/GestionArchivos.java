/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;
import java.io.*;

/**
 *
 * @author Artsk
 */
public class GestionArchivos {
    FileOutputStream salida;
    File archivo;
    
    public GestionArchivos(){    
    }
    
    /*
    * Guarda Archivo
    */
    public String guardarArchivo (File archivo, String contenido){
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "El archivo se guardo correctamente";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;   
    }
    
    public String guardarImagen(File archivo, byte[] bytesImg) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "El grafico se guardo correctamente";
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public void verificaDirectorio() {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("explorer.exe D:\\Graficos");
        } catch (Exception e) {
            System.out.println("No existe la carpeta D:/Graficos");
        }
    }
}
