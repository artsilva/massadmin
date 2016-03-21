/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.swing.view.MassGraficos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class DatosGraficos extends MassGraficos {

    public static String ObtieneVariableAnterior(String variable) {
        String variableAnterior = "";
        if (variable.equals("Enero")) {
            variableAnterior = "Diciembre";
        } else if (variable.equals("Febrero")) {
            variableAnterior = "Enero";
        } else if (variable.equals("Marzo")) {
            variableAnterior = "Febrero";
        } else if (variable.equals("Abril")) {
            variableAnterior = "Marzo";
        } else if (variable.equals("Mayo")) {
            variableAnterior = "Abril";
        } else if (variable.equals("Junio")) {
            variableAnterior = "Mayo";
        } else if (variable.equals("Julio")) {
            variableAnterior = "Junio";
        } else if (variable.equals("Agosto")) {
            variableAnterior = "Julio";
        } else if (variable.equals("Septiembre")) {
            variableAnterior = "Agosto";
        } else if (variable.equals("Octubre")) {
            variableAnterior = "Septiembre";
        } else if (variable.equals("Noviembre")) {
            variableAnterior = "Octubre";
        } else if (variable.equals("Diciembre")) {
            variableAnterior = "Noviembre";
        } else if (variable.equals("2015")) {
            variableAnterior = "2014";
        } else if (variable.equals("Semestre 1")) {
            variableAnterior = "Semestre 2";
        } else if (variable.equals("Semestre 2")) {
            variableAnterior = "Semestre 1";
        } else if (variable.equals("Trimestre 1")) {
            variableAnterior = "Trimestre 4";
        } else if (variable.equals("Trimestre 2")) {
            variableAnterior = "Trimestre 1";
        } else if (variable.equals("Trimestre 3")) {
            variableAnterior = "Trimestre 2";
        } else if (variable.equals("Trimestre 4")) {
            variableAnterior = "Trimestre 3";
        }
        return variableAnterior;
    }

    //Datos Mensuales
    public static Integer DatosGraficosActual(String ext, String variable, String where) {

        QuerysMensuales query = new QuerysMensuales();
        ResultSet rs = null;
        Integer filtro = null;

        rs = query.graficoMensualActual(ext, variable, where);
        try {
            while (rs.next()) {
                filtro = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return filtro;
    }

    public static Integer DatosGraficosAnterior(String ext, String variable, String where) {

        QuerysMensuales query = new QuerysMensuales();

        if (variable.equals("Enero")) {
            ResultSet rs = null;
            Integer filtro = null;

            rs = query.graficoMensualAnterior(ext, ObtieneVariableAnterior(variable), where);
            try {
                while (rs.next()) {
                    filtro = rs.getInt("count");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return filtro;
        } else {
            ResultSet rs = null;
            Integer filtro = null;

            rs = query.graficoMensualActual(ext, ObtieneVariableAnterior(variable), where);
            try {
                while (rs.next()) {
                    filtro = rs.getInt("count");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return filtro;
        }
    }

    //Datos Anuales
    public static Integer DatosGraficosAñoActual(String ext, String variable, String where) {

        QuerysAnuales query = new QuerysAnuales();
        ResultSet rs = null;
        Integer filtro = null;

        rs = query.graficoAnualActual(ext, variable, where);
        try {
            while (rs.next()) {
                filtro = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filtro;
    }

    public static Integer DatosGraficosAñoAnterior(String ext, String variable, String where) {

        QuerysAnuales query = new QuerysAnuales();

        ResultSet rs = null;
        Integer filtro = null;

        rs = query.graficoAnualAnterior(ext, ObtieneVariableAnterior(variable), where);
        try {
            while (rs.next()) {
                filtro = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filtro;
    }
    
    //Datos Periodicos
    public static Integer DatosGraficosPeriodoActual(String variable, String periodo, String where, String semTrim) {

        QuerysPeriodicas query = new QuerysPeriodicas();
        ResultSet rs = null;
        Integer filtro = null;

        rs = query.graficoPeriodoActual(variable, periodo, where, semTrim);
        try {
            while (rs.next()) {
                filtro = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return filtro;
    }

    public static Integer DatosGraficosPeriodoAnterior(String variable, String periodo,String where, String semTrim ) {

        QuerysPeriodicas query = new QuerysPeriodicas();
        ResultSet rs = null;
        Integer filtro = null;

        rs = query.graficoPeriodoAnterior(variable, ObtieneVariableAnterior(periodo), where, semTrim);
        try {
            while (rs.next()) {
                filtro = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MassGraficos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filtro;
    }
}
