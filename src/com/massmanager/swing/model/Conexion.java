/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.controller.Atencion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artsk
 */
public class Conexion {

    public Conexion() {

    }
    Connection cn = Conectar();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public Connection Conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VL_SANTIAGO", "postgres", "skate");

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public Integer obtenerLastId() {
        Integer ultimoId = null;
        try {
            ps = cn.prepareStatement("SELECT MAX(id_atencion) FROM mass_admin.rel_atenciones;");
            rs = ps.executeQuery();
            while (rs.next()) {
                ultimoId = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimoId;
    }

    //Este método recibe la lista de atenciones ingresada por el paramédico y los transforma en IDs 
    public List<Atencion> convierteAtenciones(List<Atencion> listaAtenciones) {
        List<Atencion> listaIdsAtencion = new ArrayList<>();
        try {
            ps = cn.prepareStatement("SELECT sec.id_sector, "
                    + "area.id_area, jefe.id_jefe_area, "
                    + "les.id_lesion, ate.id_incidente, "
                    + "ext.id_extremidad, par.id_paramedico "
                    + "FROM "
                    + "mass_admin.rel_sectores sec, "
                    + "mass_admin.rel_areas area, "
                    + "mass_admin.rel_jefes_area jefe, "
                    + "mass_admin.rel_tipo_lesion les, "
                    + "mass_admin.rel_tipo_atencion ate, "
                    + "mass_admin.rel_extremidad ext, "
                    + "mass_admin.rel_paramedicos par "
                    + "WHERE "
                    + "sec.nombre_sector = ? AND "
                    + "area.nombre_area = ? AND "
                    + "jefe.nombre = ? AND "
                    + "les.lesion = ? AND "
                    + "ate.tipo = ? AND "
                    + "ext.nombre = ? AND "
                    + "par.nombre_paramedico = ?;");
            for (Atencion atencion : listaAtenciones) {
                ps.setString(1, atencion.getSector());
                ps.setString(2, atencion.getArea());
                ps.setString(3, atencion.getJefearea());
                ps.setString(4, atencion.getLesion());
                ps.setString(5, atencion.getIncidente());
                ps.setString(6, atencion.getExtremidad());
                ps.setString(7, atencion.getParamedico());
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                Atencion atencionId = new Atencion();
                atencionId.setSectorId(rs.getInt("id_sector"));
                atencionId.setAreaId(rs.getInt("id_area"));
                atencionId.setJefeAreaId(rs.getInt("id_jefe_area"));
                atencionId.setLesionId(rs.getInt("id_lesion"));
                atencionId.setIncidenteId(rs.getInt("id_incidente"));
                atencionId.setExtremidadId(rs.getInt("id_extremidad"));
                atencionId.setParamedicoId(rs.getInt("id_paramedico"));
                listaIdsAtencion.add(atencionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo convertir a IDs las atenciones ingresadas");
        }
        return listaIdsAtencion;
    }

    public void InsertarDatos(List<Atencion> atenciones, List<Atencion> listaIdAtencion) {
        int ultimoId = obtenerLastId();
        try {
            ps = cn.prepareStatement("INSERT INTO mass_admin.rel_atenciones "
                    + "(id_atencion, rut, id_sector, id_area, id_jefe_area, fecha, lugarincidente, detalles, id_lesion, "
                    + "id_incidente, id_extremidad, id_paramedico, tratamiento, comentario, deriva, control) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            for (Atencion atencion : atenciones) {
                ps.setInt(1, ultimoId);
                ps.setInt(2, atencion.getRut());
                ps.setString(6, atencion.getFecha());
                ps.setString(7, atencion.getLugar());
                ps.setString(8, atencion.getDetalles());
                ps.setString(13, atencion.getTratamiento());
                ps.setString(14, atencion.getComentario());
                ps.setString(15, atencion.getDeriva());
                ps.setString(16, atencion.getControl());
            }
            for (Atencion listaAtencionesId : listaIdAtencion) {
                ps.setInt(3, listaAtencionesId.getSectorId());
                ps.setInt(4, listaAtencionesId.getAreaId());
                ps.setInt(5, listaAtencionesId.getJefeAreaId());
                ps.setInt(9, listaAtencionesId.getLesionId());
                ps.setInt(10, listaAtencionesId.getIncidenteId());
                ps.setInt(11, listaAtencionesId.getExtremidadId());
                ps.setInt(12, listaAtencionesId.getParamedicoId());
            }
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No se pudieron ingresar a BD las atenciones convertidas a IDs");
        }
    }

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
