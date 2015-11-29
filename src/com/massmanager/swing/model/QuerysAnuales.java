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
        Statement st;
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
    public ResultSet ExtraerAtencionAnualExtremidad(String extremidad, String ano) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, "
                    + "jefe_area, fecha, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual WHERE extremidad = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, extremidad);
            pst.setString(2, ano);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionAnualTipo(String incidente, String ano) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, "
                    + "jefe_area, fecha, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual WHERE incidente = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, incidente);
            pst.setString(2, ano);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionAnualArea(String area, String ano) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area,"
                    + " jefe_area, fecha, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual WHERE area = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, area);
            pst.setString(2, ano);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionAnualSector(String sector, String ano) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area,"
                    + " jefe_area, fecha, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_anual WHERE sector = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, sector);
            pst.setString(2, ano);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    //QUERYS GRAFICOS
    //Query para armar el grafico Anual

    public ResultSet graficoAnualActual(String variable, String ano, String where) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_anual\n"
                    + "WHERE " + where + " = ? AND ano = ? ;");
            pst.setString(1, variable);
            pst.setString(2, ano);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }

    public ResultSet graficoAnualAnterior(String variable, String ano, String where) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_anual\n"
                    + "WHERE " + where + " = ? AND ano = ? ;");
            pst.setString(1, variable);
            pst.setString(2, ano);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }
}
