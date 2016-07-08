/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class QuerysPeriodicas extends Conexion {

    //Extrae full dim_rep_periodico
    public ResultSet ExtraerAtencionesPeriodico() {    
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, periodo_del_mes, trimestre, "
                    + "semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_periodico ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //EXTRAE MENSAJE TRIMESTRE PARA MOSTRAR EN COMBOBOX
    public ResultSet ExtraerTrimestreMsg() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" select trimestre_msg from mass_dim.dim_tiempo GROUP BY trimestre_msg ORDER BY trimestre_msg; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //EXTRAE SEMANAS DEL AÑO POR TRIMESTRES
    public ResultSet ExtraerPeriodosTrimestre(String trimestre) {
        try {
            cn = Conectar();
            ps = cn.prepareStatement(" SELECT per.periodo_del_anio FROM mass_dim.dim_tiempo_periodico per JOIN mass_dim.dim_tiempo ti ON ti.mes = per.mes "
                    + "WHERE ti.trimestre_msg = ? GROUP BY per.periodo_del_anio ORDER BY per.periodo_del_anio; ");
            ps.setString(1, trimestre);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    //EXTRAE MENSAJE SEMESTRE PARA MOSTRAR EN COMBOBOX PERIODICO
    public ResultSet ExtraerSemestreMsg() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT semestre_msg from mass_dim.dim_tiempo GROUP BY semestre_msg ORDER BY semestre_msg; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //EXTRAE SEMANAS DEL AÑO POR SEMESTRES
    public ResultSet ExtraerPeriodosSemestre(String semestre) {
        try {
            ps = cn.prepareStatement(" SELECT per.periodo_del_anio FROM mass_dim.dim_tiempo_periodico per JOIN mass_dim.dim_tiempo ti ON ti.mes = per.mes "
                    + "WHERE ti.semestre_msg = ? GROUP BY per.periodo_del_anio ORDER BY per.periodo_del_anio; ");
            ps.setString(1, semestre);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    /*
     * Querys TRIMESTRALES sin filtro por semanas
     */
    public ResultSet ExtraerAtencionPeriodicaVariable(String extremidad, String periodo, String where, String semTrim) {
        try {
            ps = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes," + semTrim + ",lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE " + where + " = ? AND " + semTrim + " = ? ; ");
            ps.setString(1, extremidad);
            ps.setString(2, periodo);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    /*
     * Querys TRIMESTRALES por filtro semana
     */
    public ResultSet ExtraerAtencionPeriodicaSemanaVariable(String extremidad, String periodo, String semana, String where, String variable) {
        try {
            ps = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, " + variable + ", lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
                    + "FROM mass_dim.dim_rep_periodico "
                    + "WHERE " + where + " = ? AND " + variable + " = ? AND periodo_del_anio = ? ; ");
            ps.setString(1, extremidad);
            ps.setString(2, periodo);
            ps.setString(3, semana);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    //QUERYS GRAFICOS
    //Query para armar el grafico periodico
    public ResultSet graficoPeriodoActual(String variable, String periodo, String where, String semTrim) {
        try {
            ps = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE " + where + " = ? AND " + semTrim + " = ? AND fecha::TEXT LIKE '2015%'");
            ps.setString(1, variable);
            ps.setString(2, periodo);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet graficoPeriodoAnterior(String variable, String periodo, String where, String semTrim) {
        try {
            ps = cn.prepareStatement("SELECT COUNT(id_atencion)\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE " + where + " = ? AND " + semTrim + " = ? AND fecha::TEXT LIKE '2014%'");
            ps.setString(1, variable);
            ps.setString(2, periodo);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }

    public Integer countAtencionesPeriodicas(String lesion, String periodo, String where) {
        Integer resultado = 0;
        try {
            ps = cn.prepareStatement("SELECT count(*) "
                    + "FROM mass_dim.dim_rep_periodico "
                    + "WHERE lesion  = ? AND "
                    + where + " = ? "
                    + "AND fecha::TEXT LIKE '2015%';");
            ps.setString(1, lesion);
            ps.setString(2, periodo);
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public Integer countAtencionesPeriodicasVariable(String lesion, String periodo, String where, String variable , String areaSector) {
        Integer resultado = 0;
        try {
            ps = cn.prepareStatement("SELECT count(*) "
                    + "FROM mass_dim.dim_rep_periodico "
                    + "WHERE lesion  = ? AND "
                    + where + " = ? AND "
                    + variable + " = ? "
                    + "AND fecha::TEXT LIKE '2015%'");
            ps.setString(1, lesion);
            ps.setString(2, periodo);
            ps.setString(3, areaSector);
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
