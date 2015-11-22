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
public class QuerysPeriodicas extends Conexion {

    //Extrae full dim_rep_periodico
    public ResultSet ExtraerAtencionesPeriodico() {
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
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
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
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
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT per.periodo_del_anio FROM mass_dim.dim_tiempo_periodico per JOIN mass_dim.dim_tiempo ti ON ti.mes = per.mes "
                    + "WHERE ti.trimestre_msg = ? GROUP BY per.periodo_del_anio ORDER BY per.periodo_del_anio; ");
            pst.setString(1, trimestre);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    //EXTRAE MENSAJE SEMESTRE PARA MOSTRAR EN COMBOBOX PERIODICO
    public ResultSet ExtraerSemestreMsg() {
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" select semestre_msg from mass_dim.dim_tiempo GROUP BY semestre_msg ORDER BY semestre_msg; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //EXTRAE SEMANAS DEL AÑO POR SEMESTRES
    public ResultSet ExtraerPeriodosSemestre(String semestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT per.periodo_del_anio FROM mass_dim.dim_tiempo_periodico per JOIN mass_dim.dim_tiempo ti ON ti.mes = per.mes "
                    + "WHERE ti.semestre_msg = ? GROUP BY per.periodo_del_anio ORDER BY per.periodo_del_anio; ");
            pst.setString(1, semestre);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    /*
     * Querys TRIMESTRALES sin filtro por semanas
     */

    public ResultSet ExtraerAtencionTrimestreExtremidad(String extremidad, String trimestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE extremidad = ? AND trimestre = ? ; ");
            pst.setString(1, extremidad);
            pst.setString(2, trimestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreArea(String area, String trimestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE area = ? AND trimestre = ? ; ");
            pst.setString(1, area);
            pst.setString(2, trimestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreTipo(String tipo, String trimestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE incidente = ? AND trimestre = ? ; ");
            pst.setString(1, tipo);
            pst.setString(2, trimestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreSector(String sector, String trimestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE sector = ? AND trimestre = ? ; ");
            pst.setString(1, sector);
            pst.setString(2, trimestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    /*
     * Querys TRIMESTRALES por filtro semana
     */
    public ResultSet ExtraerAtencionTrimestreSemanaExtremidad(String extremidad, String trimestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE extremidad = ? AND trimestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, extremidad);
            pst.setString(2, trimestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreSemanaArea(String area, String trimestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE area = ? AND trimestre = ? AND periodo_del_anio = ?; ");
            pst.setString(1, area);
            pst.setString(2, trimestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreSemanaTipo(String tipo, String trimestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE incidente = ? AND trimestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, tipo);
            pst.setString(2, trimestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionTrimestreSemanaSector(String sector, String trimestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, trimestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE sector = ? AND trimestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, sector);
            pst.setString(2, trimestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    /*
     * Querys SEMESTRALES sin filtro por semanas
     */
    public ResultSet ExtraerAtencionSemestreExtremidad(String extremidad, String semestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE extremidad = ? AND semestre = ? ; ");
            pst.setString(1, extremidad);
            pst.setString(2, semestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreArea(String area, String semestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE area = ? AND semestre = ? ; ");
            pst.setString(1, area);
            pst.setString(2, semestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreTipo(String tipo, String semestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, "
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE incidente = ? AND semestre = ? ; ");
            pst.setString(1, tipo);
            pst.setString(2, semestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreSector(String sector, String semestre) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE sector = ? AND semestre = ?; ");
            pst.setString(1, sector);
            pst.setString(2, semestre);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    /*
     * Querys SEMESTRALES con filtro por semanas
     */
    public ResultSet ExtraerAtencionSemestreSemanaExtremidad(String extremidad, String semestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE extremidad = ? AND semestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, extremidad);
            pst.setString(2, semestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreSemanaArea(String area, String semestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE area = ? AND semestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, area);
            pst.setString(2, semestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreSemanaTipo(String tipo, String semestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE incidente = ? AND semestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, tipo);
            pst.setString(2, semestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

    public ResultSet ExtraerAtencionSemestreSemanaSector(String sector, String semestre, String semana) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, \n"
                    + "periodo_del_mes, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario\n"
                    + "FROM mass_dim.dim_rep_periodico\n"
                    + "WHERE sector = ? AND semestre = ? AND periodo_del_anio = ? ; ");
            pst.setString(1, sector);
            pst.setString(2, semestre);
            pst.setString(3, semana);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }

}
