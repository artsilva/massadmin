/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Artsk
 */
public final class FechaHora { 
    
    /**
     *
     */
    private Integer Anio;
    private Integer Mes;
    private Integer Dia;
    private String Hora;
    private String Fecha;
    
    public FechaHora(){
        Date fechaActual = new Date();
        Calendar date = Calendar.getInstance();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        setDia(date.get(Calendar.DAY_OF_MONTH));
        setMes(date.get(Calendar.MONTH)+1);
        setAnio(date.get(Calendar.YEAR));
        setFecha(formatoFecha.format(fechaActual));
        setHora(formatoHora.format(fechaActual));
    }
    
    public String obtenerMes(Integer mes) {
        String mesResult = "";
        if (mes == 1) {
            mesResult = "Enero";
        } else if (mes == 2) {
            mesResult = "Febrero";
        } else if (mes == 3) {
            mesResult = "Marzo";
        } else if (mes == 4) {
            mesResult = "Abril";
        } else if (mes == 5) {
            mesResult = "Mayo";
        } else if (mes == 6) {
            mesResult = "Junio";
        } else if (mes == 7) {
            mesResult = "Julio";
        } else if (mes == 8) {
            mesResult = "Agosto";
        } else if (mes == 9) {
            mesResult = "Septiembre";
        } else if (mes == 10) {
            mesResult = "Octubre";
        } else if (mes == 11) {
            mesResult = "Noviembre";
        } else if (mes == 12) {
            mesResult = "Diciembre";
        }
        return mesResult;
    }
    
    public Integer getAnio() {
        return Anio;
    }

    public void setAnio(Integer Anio) {
        this.Anio = Anio;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer Mes) {
        this.Mes = Mes;
    }

    public Integer getDia() {
        return Dia;
    }

    public void setDia(Integer Dia) {
        this.Dia = Dia;
    }  

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        this.Hora = hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
}
