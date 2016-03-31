/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.controller.Atencion;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import java.sql.Connection;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class Conexion{

    
    public Conexion() {
       
    }
    Connection cn = Conectar();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public Connection Conectar()  {
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VL_SANTIAGO", "postgres", "skate");

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return cn;
    }
    /*
    public ResultSet convierteAtenciones (List<Atencion> listaAtenciones) {
        try {
            ps = cn.prepareStatement("");
            for (Atencion atencion : atenciones) {                           
            ps.setInt(1, atencion.getRut());
            ps.setInt(2, atencion.getSector());
            ps.setInt(3, atencion.getArea());
            ps.setInt(4, atencion.getJefearea());
            ps.setDate(5, atencion.getFecha());
            ps.setString(6, atencion.getRut());
            ps.setString(7, atencion.getRut());
            ps.setInt(8, atencion.getRut());
            ps.setInt(9, atencion.getRut());
            ps.setInt(10, atencion.getRut());
            ps.setInt(11, atencion.getRut());
            ps.setString(12, atencion.getRut());
            ps.setString(13, atencion.getRut());
            ps.setString(14, atencion.getRut());
            ps.setString(15, atencion.getRut());
            
            ps.execute();
        } catch (Exception e) {
        }
        return rs;
    }
    
    public void InsertarDatos(List<Atencion> atenciones) {
        try {
            ps = cn.prepareStatement("INSERT INTO mass_admin.rel_atenciones "
                    + "(rut, id_sector, id_area, id_jefe_area, fecha, lugarincidente, detalles, id_lesion, "
                    + "id_incidente, id_extremidad, id_paramedico, tratamiento, comentario, deriva, control) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            for (Atencion atencion : atenciones) {                           
            ps.setInt(1, atencion.getRut());
            ps.setInt(2, atencion.getSector());
            ps.setInt(3, atencion.getRut());
            ps.setInt(4, atencion.getRut());
            ps.setDate(5, atencion.getRut());
            ps.setString(6, atencion.getRut());
            ps.setString(7, atencion.getRut());
            ps.setInt(8, atencion.getRut());
            ps.setInt(9, atencion.getRut());
            ps.setInt(10, atencion.getRut());
            ps.setInt(11, atencion.getRut());
            ps.setString(12, atencion.getRut());
            ps.setString(13, atencion.getRut());
            ps.setString(14, atencion.getRut());
            ps.setString(15, atencion.getRut());
            
            ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    */
    public ResultSet ExtraerTrabajador(Integer rut) {
        try {
            ps = cn.prepareStatement("SELECT trab.nombre, trab.apellido, sec.nombre_sector, area.nombre_area, jefe.nombre AS jefe_area\n"
                    + "FROM mass_admin.rel_trabajadores trab\n"
                    + "JOIN mass_admin.rel_sectores sec ON (sec.id_sector = trab.id_sector)\n"
                    + "JOIN mass_admin.rel_areas area ON (area.id_area = trab.id_area)\n"
                    + "JOIN mass_admin.rel_jefes_area jefe ON (jefe.id_jefe_area = trab.id_jefe_area)\n"
                    + "WHERE trab.rut = ?");
            ps.setInt(1, rut);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionesDiarias() {        
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT aten.id_atencion, aten.rut AS rut_trabajador, sec.nombre_sector AS sector, ars.nombre_area AS area, jef.nombre AS jefe_area, aten.fecha, "
            + "lesi.lesion, tip_aten.tipo AS incidente, ext.nombre AS etremidad_afectada, para.nombre_paramedico AS paramedico FROM ((((((((mass_admin.rel_atenciones aten "
            + "JOIN mass_admin.rel_sectores sec ON ((sec.id_sector = aten.id_sector)))JOIN mass_admin.rel_trabajadores trab ON ((trab.rut = aten.rut)))JOIN mass_admin.rel_areas ars ON ((ars.id_area = aten.id_area)))"
            + "JOIN mass_admin.rel_jefes_area jef ON ((jef.id_jefe_area = aten.id_jefe_area)))JOIN mass_admin.rel_tipo_lesion lesi ON ((lesi.id_lesion = aten.id_lesion)))"
            + "JOIN mass_admin.rel_tipo_atencion tip_aten ON ((tip_aten.id_incidente = aten.id_incidente)))JOIN mass_admin.rel_extremidad ext ON ((ext.id_extremidad = aten.id_extremidad)))"
            + "JOIN mass_admin.rel_paramedicos para ON ((para.id_paramedico = aten.id_paramedico)))ORDER BY aten.id_atencion");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    //EXTRAE DATOS PARA LLENAR LOS COMBOBOX
    public ResultSet ExtraerLesion() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT lesion FROM mass_admin.rel_tipo_lesion ORDER BY lesion");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerIncidente() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT tipo FROM mass_admin.rel_tipo_atencion ORDER BY tipo");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerParamedico() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_paramedico FROM mass_admin.rel_paramedicos ORDER BY nombre_paramedico");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerExtremidad() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre FROM mass_admin.rel_extremidad ORDER BY nombre");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerArea() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_area FROM mass_admin.rel_areas ORDER BY nombre_area");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerSector() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_sector FROM mass_admin.rel_sectores ORDER BY nombre_sector");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerMes() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT mes, mes_msg FROM mass_dim.dim_tiempo WHERE mes BETWEEN '1' AND '12' GROUP BY mes, mes_msg ORDER BY mes, mes_msg");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet ExtraerAno() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT ano FROM mass_dim.dim_tiempo WHERE ano BETWEEN '2014' AND '2015' GROUP BY ano");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet extraeUsuarios() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_usuario, usuario, password, email, id_permiso, nombre_usuario FROM mass_security.users");
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    public void cerrarConexion(Object obj) {
        try {
            if (obj instanceof Connection) {
                ((Connection) obj).close();
            } else if (obj instanceof ResultSet) {
                ((ResultSet) obj).close();
            } else if (obj instanceof Statement) {
                ((Statement) obj).close();
            } else if (obj instanceof PreparedStatement) {
                ((PreparedStatement) obj).close();
            }
        } catch (SQLException e) {
            Logger.getLogger("Error in closeSQLNegotiator method: " + e.getMessage());
        }
    }
}
