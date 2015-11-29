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
public class QuerysMensuales extends Conexion {

    public ResultSet ExtraerAtencionesMensual() {
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area,"
                    + " fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_mensual ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //EXTRAE ATENCIONES MENSUALES
    public ResultSet ExtraerAtencionMensualExtremidad(String extremidad, String mes) {
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area,"
                    + " fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_mensual WHERE extremidad = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, extremidad);
            pst.setString(2, mes);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionMensualTipo(String tipo, String mes) {
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area,"
                    + " fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_mensual WHERE incidente = ? AND mes = ? ORDER BY fecha; ");
            pst.setString(1, tipo);
            pst.setString(2, mes);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionMensualArea(String area, String mes) {
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area,"
                    + " fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_mensual WHERE area = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, area);
            pst.setString(2, mes);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionMensualSector(String sector, String mes) {
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area,"
                    + " fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_mensual WHERE sector = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, sector);
            pst.setString(2, mes);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    //QUERYS GRAFICOS
    //Query para armar el grafico mensual

    public ResultSet graficoMensualActual(String variable, String mes, String where) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_mensual\n"
                    + "WHERE " + where + " = ? AND mes = ? AND fecha::TEXT LIKE '2015%'");
            pst.setString(1, variable);
            pst.setString(2, mes);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }

    public ResultSet graficoMensualAnterior(String variable, String mes, String where) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_mensual\n"
                    + "WHERE " + where + " = ? AND mes = ? AND fecha::TEXT LIKE '2014%'");
            pst.setString(1, variable);
            pst.setString(2, mes);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }

}
