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
    
    private Integer Anio;
    private Integer Mes;
    private Integer Dia;
    private String Hora;
    private String horaMinutos;
    private String Fecha;
    private String saludoHorario;
    
    public FechaHora(String formato){
        Date fechaActual = new Date();
        //Formatos:
        //Hora: "HH:mm:ss"
        //Fecha: "dd:MM:yyyy"
        Calendar date = Calendar.getInstance();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoHora2 = new SimpleDateFormat("HH:mm");
        DateFormat formatoFecha = new SimpleDateFormat(formato);
        
        setDia(date.get(Calendar.DAY_OF_MONTH));
        setMes(date.get(Calendar.MONTH)+1);
        setAnio(date.get(Calendar.YEAR));
        setFecha(formatoFecha.format(fechaActual));
        setHora(formatoHora.format(fechaActual)); 
        setHoraMinutos(formatoHora2.format(fechaActual));
        //  
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
    
    public String obtenerSaludoHorario(String hora) {
        String saludo = null;
        String[] parte = hora.split(":");
        Integer hour = Integer.parseInt(parte[0]);
        
        if (hour < 6 ){
           saludo = "Buenas noches"; 
        } else if (hour < 12 ) {
            saludo = "Buenos dias";
        } else if (hour < 19 ) {
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }
        return saludo;
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

    public String getHoraMinutos() {
        return horaMinutos;
    }

    public void setHoraMinutos(String horaMinutos) {
        this.horaMinutos = horaMinutos;
    }

    public String getSaludoHorario() {
        return saludoHorario;
    }

    public void setSaludoHorario(String saludoHorario) {
        this.saludoHorario = saludoHorario;
    }
}
