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
        if (variable.equals("ENERO")) {
            variableAnterior = "DICIEMBRE";
        } else if (variable.equals("FEBRERO")) {
            variableAnterior = "ENERO";
        } else if (variable.equals("MARZO")) {
            variableAnterior = "FEBRERO";
        } else if (variable.equals("ABRIL")) {
            variableAnterior = "MARZO";
        } else if (variable.equals("MAYO")) {
            variableAnterior = "ABRIL";
        } else if (variable.equals("JUNIO")) {
            variableAnterior = "MAYO";
        } else if (variable.equals("JULIO")) {
            variableAnterior = "JUNIO";
        } else if (variable.equals("AGOSTO")) {
            variableAnterior = "JULIO";
        } else if (variable.equals("SEPTIEMBRE")) {
            variableAnterior = "AGOSTO";
        } else if (variable.equals("OCTUBRE")) {
            variableAnterior = "SEPTIEMBRE";
        } else if (variable.equals("NOVIEMBRE")) {
            variableAnterior = "OCTUBRE";
        } else if (variable.equals("DICIEMBRE")) {
            variableAnterior = "NOVIEMBRE";
        } else if (variable.equals("2015")) {
            variableAnterior = "2014";
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

        if (variable.equals("ENERO")) {
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
}
