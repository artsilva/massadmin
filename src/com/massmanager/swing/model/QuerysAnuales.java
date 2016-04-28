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
public class QuerysAnuales extends Conexion {

    //EXTRAE ATENCIONES ANUAL 
    public ResultSet ExtraerAtencionesAnual() {   
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
    
    //CUENTA ATENCIONES POR AÑO
    public ResultSet countAtencionAnualVariable(String variable, String anio, String where) {
        try {
            ps = cn.prepareStatement(" SELECT count(*) \n"
                    + "FROM mass_dim.dim_rep_anual \n"
                    + "WHERE " + where + " = ?\n"
                    + "AND ano = ?; ");
            ps.setString(1, variable);
            ps.setString(2, anio);
            rs = ps.executeQuery();
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    public Integer countLesionAnual(String lesion, String anio) {
        Integer resultado = 0;
        try {
            ps = cn.prepareStatement(" SELECT count(*) "
                    + "FROM mass_dim.dim_rep_anual "
                    + "WHERE lesion = ? "
                    + "AND ano = ?; ");
            ps.setString(1, lesion);
            ps.setString(2, anio);
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("count");
            }
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }
    
    public Integer countLesionAnualVariable(String lesion, String anio, String where, String variable) {
        Integer resultado = 0;
        try {
            ps = cn.prepareStatement(" SELECT count(*)\n"
                    + "FROM mass_dim.dim_rep_anual\n"
                    + "WHERE lesion = ? AND ano = ? AND " + where + " = ? ");
            ps.setString(1, lesion);
            ps.setString(2, anio);
            ps.setString(3, variable);
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("count");
            }
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }
}
