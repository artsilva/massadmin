/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class Conexion{

    
    public Conexion() {
       
    }
    
    public Connection Conectar(){
        Connection cn = null;
        try{
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VL_SANTIAGO", "postgres", "skate");
            
    }catch(Exception e){
    
    }
        return cn;
    }
    
    public void InsertarDatos(int id, String nombre, String email){
        Connection cn = Conectar();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO mass_admin.prueba (id,nombre,email) VALUES (?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, email);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet ExtraerTrabajador(String rut){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT trab.nombre, trab.apellido,sec.nombre_sector,ars.nombre_area,jef.nombre AS jefe_area FROM mass_admin.rel_atenciones aten "
            + "JOIN mass_admin.rel_sectores sec ON ((sec.id_sector = aten.id_sector)) JOIN mass_admin.rel_trabajadores trab ON ((trab.rut = aten.rut)) "
            + "JOIN mass_admin.rel_areas ars ON ((ars.id_area = aten.id_area)) JOIN mass_admin.rel_jefes_area jef ON ((jef.id_jefe_area = aten.id_jefe_area)) "
            + "JOIN mass_admin.rel_tipo_lesion lesi ON ((lesi.id_lesion = aten.id_lesion)) JOIN mass_admin.rel_tipo_atencion tip_aten ON ((tip_aten.id_incidente = aten.id_incidente)) "
            + "JOIN mass_admin.rel_extremidad ext ON ((ext.id_extremidad = aten.id_extremidad)) JOIN mass_admin.rel_paramedicos para ON ((para.id_paramedico = aten.id_paramedico)) "
            + "WHERE aten.rut='"+ rut +"'");
            pst.setString(1, rut);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionesDiarias(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
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
    
    public ResultSet ExtraerAtencionesMensual(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_mensual ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //EXTRAE ATENCIONES MENSUALES
    public ResultSet ExtraerAtencionMensualExtremidad(String extremidad, String mes){
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_mensual WHERE extremidad = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, extremidad);
            pst.setString(2, mes);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionMensualTipo(String tipo, String mes){
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_mensual WHERE incidente = ? AND mes = ? ORDER BY fecha; ");
            pst.setString(1, tipo);
            pst.setString(2, mes);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionMensualArea(String area, String mes){
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_mensual WHERE area = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, area);
            pst.setString(2, mes);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionMensualSector(String sector, String mes){
        //Muestra reportes mensuales con filtro 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, mes, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_mensual WHERE sector = ? AND mes= ? ORDER BY fecha; ");
            pst.setString(1, sector);
            pst.setString(2, mes);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
   
    //EXTRAE ATENCIONES ANUAL 
    public ResultSet ExtraerAtencionesAnual(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, ano, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_anual ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //EXTRAE ATENCIONES POR AÑO 
    public ResultSet ExtraerAtencionAnualExtremidad(String extremidad, String ano){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, ano, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_anual WHERE extremidad = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, extremidad);
            pst.setString(2, ano);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionAnualTipo(String incidente, String ano){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, ano, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_anual WHERE incidente = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, incidente);
            pst.setString(2, ano);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionAnualArea(String area, String ano){ 
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, ano, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_anual WHERE area = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, area);
            pst.setString(2, ano);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    public ResultSet ExtraerAtencionAnualSector(String sector, String ano){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, ano, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_anual WHERE sector = ? AND ano = ? ORDER BY fecha; ");
            pst.setString(1, sector);
            pst.setString(2, ano);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return rs;
    }
    
    //EXTRAE PERIODICOS
    
    public ResultSet ExtraerAtencionesPeriodico(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(" SELECT id_atencion, nombre, apellido, rut, sector, area, jefe_area, fecha, periodo_del_anio, periodo_del_mes, trimestre, semestre, lugarincidente, detalles, lesion, incidente, extremidad, paramedico, tratamiento, comentario "
            + "FROM mass_dim.dim_rep_periodico ORDER BY fecha; ");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //EXTRAE DATOS PARA LLENAR LOS COMBOBOX
    public ResultSet ExtraerLesion(){
        Connection cn =Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT lesion FROM mass_admin.rel_tipo_lesion ORDER BY lesion");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerIncidente(){
        Connection cn =Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT tipo FROM mass_admin.rel_tipo_atencion ORDER BY tipo");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerParamedico(){
        Connection cn =Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_paramedico FROM mass_admin.rel_paramedicos ORDER BY nombre_paramedico");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerExtremidad(){
        Connection cn =Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre FROM mass_admin.rel_extremidad ORDER BY nombre");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerArea(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_area FROM mass_admin.rel_areas ORDER BY nombre_area");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerSector(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre_sector FROM mass_admin.rel_sectores ORDER BY nombre_sector");   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerMes(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT mes, mes_msg FROM mass_dim.dim_tiempo WHERE mes BETWEEN '1' AND '12' GROUP BY mes, mes_msg ORDER BY mes, mes_msg");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ExtraerAno(){
        Connection cn = Conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT ano FROM mass_dim.dim_tiempo WHERE ano BETWEEN '2014' AND '2015' GROUP BY ano");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    //EXTRAE MENSAJE TRIMESTRE PARA MOSTRAR EN COMBOBOX
    public ResultSet ExtraerTrimestreMsg(){
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
    public ResultSet ExtraerPeriodosTrimestre(String trimestre){
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
    
    //EXTRAE MENSAJE SEMESTRE PARA MOSTRAR EN COMBOBOX
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
    public ResultSet ExtraerPeriodosSemestre(String semestre){
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
    
}
