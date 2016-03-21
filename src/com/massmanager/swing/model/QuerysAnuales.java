/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class QuerysAnuales extends Conexion {

    //EXTRAE ATENCIONES ANUAL 
    public ResultSet ExtraerAtencionesAnual() {
        Connection cn = Conectar();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, lugarincidente, "
                    + "detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }

    //EXTRAE ATENCIONES POR AÑO 
    public ResultSet ExtraerAtencionAnualVariable(String variable, String anio, String where) {
        Connection cn = Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, "
                    + "jefe_area, fecha, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual WHERE " + where + " = ? AND ano = ? ORDER BY fecha; ");
            ps.setString(1, variable);
            ps.setString(2, anio);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }

    //QUERYS GRAFICOS
    //Query para armar el grafico Anual
    
    public ResultSet graficoAnualActual(String variable, String ano, String where) {
        Connection cn = Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder graficos = new StringBuilder();
            graficos.append("SELECT COUNT(id_atencion)\n");
            graficos.append("FROM mass_dim.dim_rep_anual\n");
            graficos.append("WHERE ");
            graficos.append(where);
            graficos.append("= ? AND ano = ? ;");
        try {
            ps = cn.prepareStatement(graficos.toString());        
            ps.setString(1, variable);
            ps.setString(2, ano);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } 
        return rs;
    }

    public ResultSet graficoAnualAnterior(String variable, String ano, String where) {
        Connection cn = Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_anual\n"
                    + "WHERE " + where + " = ? AND ano = ? ;");
            ps.setString(1, variable);
            ps.setString(2, ano);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } 
        return rs;
    }
}
